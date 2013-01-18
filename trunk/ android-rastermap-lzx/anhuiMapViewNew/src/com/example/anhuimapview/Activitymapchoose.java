package com.example.anhuimapview;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import android.R.string;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.FloatMath;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Activitymapchoose extends Activity {
	
	private static final int NONE = 0;
	private static final int DRAG = 1;
	private static final int ZOOM = 2;
	private boolean waitDouble = true;

	private static final int DOUBLE_CLICK_TIME = 500;//���ε�����ʱ����
	private int mode = NONE;
	private float oldDist;
	private Matrix matrix = new Matrix();
	private Matrix savedMatrix = new Matrix();
	private PointF start = new PointF();
	private PointF mid = new PointF();
	Intent intent=null;
	Button bt1=null;
	  Bitmap bmpDefaultPic = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_activity_mapchoose);
        
        
        ImageView view = (ImageView) findViewById(R.id.imageView1);
        
   /* ��Sd���е�ͼƬ */ 
         intent=getIntent();         
        String value=intent.getStringExtra("flag");
        String path = Environment.getExternalStorageDirectory().toString() ; //���SDCardĿ¼ 
      
        bmpDefaultPic = readBitmapAutoSize(path+File.separator+"anhuimap"+File.separator+value+".jpg",1024,768);
        view.setImageBitmap(bmpDefaultPic);
        
        InputStream is = this.getResources().openRawResource(R.drawable.ic_launcher); 
    
        view.setOnClickListener(listener);
        /**/ 
		view.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				ImageView view = (ImageView) v;
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:
					savedMatrix.set(matrix);
					start.set(event.getX(), event.getY());
					mode = DRAG;
					break;
				case MotionEvent.ACTION_UP:
				    float xchange=start.x-event.getX();
				    float ychange=start.y-event.getY();
					if(xchange>=-5&&xchange<=5 &&ychange>=-5&&ychange<=5)
					{
						//Toast.makeText(Activitymapchoose.this, "hehe", Toast.LENGTH_SHORT).show();
						Activitymapchoose.this.setResult(RESULT_OK, intent);
						Activitymapchoose.this.finish();
					}
				case MotionEvent.ACTION_POINTER_UP:
					mode = NONE;
					break;
				case MotionEvent.ACTION_POINTER_DOWN:
					oldDist = spacing(event);
					if (oldDist > 10f) {
						savedMatrix.set(matrix);
						midPoint(mid, event);
						mode = ZOOM;
					}
					break;
				case MotionEvent.ACTION_MOVE:
					if (mode == DRAG) {
						matrix.set(savedMatrix);
						matrix.postTranslate(event.getX() - start.x, event.getY()
								- start.y);
					} else if (mode == ZOOM) {
						float newDist = spacing(event);
						if (newDist > 10f) {
							matrix.set(savedMatrix);
							float scale = newDist / oldDist;
							matrix.postScale(scale, scale, mid.x, mid.y);
						}
					}
					break;
				}

				view.setImageMatrix(matrix);
				return true;
			}
			
			private float spacing(MotionEvent event) {
				float x = event.getX(0) - event.getX(1);
				float y = event.getY(0) - event.getY(1);
				return FloatMath.sqrt(x * x + y * y);
			}

			private void midPoint(PointF point, MotionEvent event) {
				float x = event.getX(0) + event.getX(1);
				float y = event.getY(0) + event.getY(1);
				point.set(x / 2, y / 2);
			}});
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity_map, menu);
        return true;
    }

    public static Bitmap readBitmapAutoSize(String filePath, int outWidth, int outHeight) {    
        //outWidth��outHeight��Ŀ��ͼƬ������Ⱥ͸߶ȣ���������  
			FileInputStream fs = null;  
			BufferedInputStream bs = null;  
			try {  
			    fs = new FileInputStream(filePath);  
			    bs = new BufferedInputStream(fs);  
			    BitmapFactory.Options options = setBitmapOption(filePath, outWidth, outHeight);  
			    return BitmapFactory.decodeStream(bs, null, options);  
			} catch (Exception e) {  
			    e.printStackTrace();  
			} finally {  
			    try {  
			        bs.close();  
			        fs.close();  
			    } catch (Exception e) {  
			        e.printStackTrace();  
			    }  
			}  
			return null;  
    	}  
    
    private static BitmapFactory.Options setBitmapOption(String file, int width, int height) {  
        BitmapFactory.Options opt = new BitmapFactory.Options();  
        opt.inJustDecodeBounds = true;            
                //����ֻ�ǽ���ͼƬ�ı߾࣬�˲���Ŀ���Ƕ���ͼƬ��ʵ�ʿ�Ⱥ͸߶�  
        BitmapFactory.decodeFile(file, opt);  
  
        int outWidth = opt.outWidth; //���ͼƬ��ʵ�ʸߺͿ�  
        int outHeight = opt.outHeight;  
        opt.inDither = false;  
        opt.inPreferredConfig = Bitmap.Config.RGB_565;      
                //���ü���ͼƬ����ɫ��Ϊ16bit��Ĭ����RGB_8888����ʾ24bit��ɫ��͸��ͨ������һ���ò���  
        opt.inSampleSize = 1;                            
                //�������ű�,1��ʾԭ������2��ʾԭ�����ķ�֮һ....  
                //�������ű�  
        if (outWidth != 0 && outHeight != 0 && width != 0 && height != 0) {  
            int sampleSize = (outWidth / width + outHeight / height) / 2;  
            opt.inSampleSize = sampleSize;  
        }  
  
        opt.inJustDecodeBounds = false;//���ѱ�־��ԭ  
        return opt;  
    }  
    
    OnClickListener listener = new OnClickListener(){
    	public void onClick(View v) {

 
    	
    	}    		
      };
}
