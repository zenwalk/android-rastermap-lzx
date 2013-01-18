package com.example.anhuimapview;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v4.app.NavUtils;


public class MainActivity extends Activity {
	private final int UPDATE_UI = 1;
	private Handler mHandler=null;
	ImageView imageV=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(new flipboardviewSrc(this));
        setContentView(R.layout.activity_main);
        
        
        
        imageV=(ImageView)findViewById(R.id.imageView1);
        imageV.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this,ActivityConfig.class);
			    startActivity(intent);
			    //overridePendingTransition(R.anim.alpha_rotate,R.anim.alpha_scale_translate_rotate);
			}});
/*  
        new Thread()
	      {
	        public void run()
	        {
	        	try {
					sleep(2500);
					mHandler.sendEmptyMessageDelayed(UPDATE_UI, 0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	      }.start();
	      mHandler = new Handler(){
	    	   
            public void handleMessage(Message msg) {
            switch (msg.what) {
            case UPDATE_UI: {
          	  		Intent intent=new Intent();
					intent.setClass(MainActivity.this,ActivityConfig.class);
				    startActivity(intent);			    
                 }
                 default:
                 break;
             }
             }
	      };
	      */
    }

    
}
