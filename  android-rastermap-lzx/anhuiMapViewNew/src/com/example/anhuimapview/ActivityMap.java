package com.example.anhuimapview;


import java.io.File;

import android.R.string;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.FloatMath;
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
import android.widget.RelativeLayout;
import android.support.v4.app.NavUtils;

public class ActivityMap extends Activity {
	
	private static final int NONE = 0;
	private static final int DRAG = 1;
	private static final int ZOOM = 2;
	
	private int mode = NONE;
	private float oldDist;
	int flag=0;
	private Matrix matrix = new Matrix();
	private Matrix savedMatrix = new Matrix();
	private PointF start = new PointF();
	private PointF mid = new PointF();
	Button bt1=null;
	String path=null;
	String value=null;
	RelativeLayout rl=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_activity_map);
        
        bt1=(Button)findViewById(R.id.button1);
        rl=(RelativeLayout)findViewById(R.id.rl);
        bt1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
			    intent.setClass(ActivityMap.this,ActivityConfig.class);
			    startActivity(intent);
			}
        	
        });
        
        final ImageView view = (ImageView) findViewById(R.id.imageView1);
        
   /* 从Sd卡中掉图片 */ 
        Intent intent=getIntent();         
        value=intent.getStringExtra("diqu");
        
        path = Environment.getExternalStorageDirectory().toString() ; //获得SDCard目录 
        Bitmap bmpDefaultPic = null;
        bmpDefaultPic = BitmapFactory.decodeFile(path+File.separator+"anhuimap"+File.separator+value+"zs.jpg",null);
        view.setImageBitmap(bmpDefaultPic);
        
        view.setOnClickListener(new OnClickListener()
        {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(flag==0)
				{
					Intent intent=new Intent();
				    intent.putExtra("flag", value+"z");//水利
				    intent.setClass(ActivityMap.this,Activitymapchoose.class);
				    startActivity(intent);	
				}
				if(flag==1)
				{
					Intent intent=new Intent();
				    intent.putExtra("flag", value+"zt");//水利
				    intent.setClass(ActivityMap.this,Activitymapchoose.class);
				    startActivity(intent);	
				}
			}
        		
        });
        
        rl.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				if(arg1.getX()>512 && flag==0)
				{
					flag=1;
					Bitmap bmpDefaultPic = BitmapFactory.decodeFile(path+File.separator+"anhuimap"+File.separator+value+"zts.jpg",null);
			        view.setImageBitmap(bmpDefaultPic);
				}
				
				if(arg1.getX()<512 && flag==1)
				{
					flag=0;
					Bitmap bmpDefaultPic = BitmapFactory.decodeFile(path+File.separator+"anhuimap"+File.separator+value+"zs.jpg",null);
			        view.setImageBitmap(bmpDefaultPic);
				}
				return false;
			}
        	
        });
        /*
        
        
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
			}});*/
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity_map, menu);
        return true;
    }

    
}
