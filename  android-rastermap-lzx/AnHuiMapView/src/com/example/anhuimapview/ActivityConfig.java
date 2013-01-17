package com.example.anhuimapview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.support.v4.app.NavUtils;

public class ActivityConfig extends Activity {
	FrameLayout fl=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       
        setContentView(R.layout.activity_activity_config);
        fl=(FrameLayout)findViewById(R.id.fl);
        fl.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				float MX= event.getRawX();
				float MY= event.getRawY();
				if(MX>77 && MX<213 && MY>179 && MY<359)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "wanbei");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				
				}
				if(MX>82 && MX<202 && MY>380 && MY<518)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "wanjiang");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				
				}
				if(MX>228 && MX<334 && MY>350 && MY<478)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "fuping");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				
				}
				if(MX>369 && MX<482 && MY>318 && MY<472)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "shuili");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>500 && MX<626 && MY>282 && MY<438)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "lvyou");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>634 && MX<760 && MY>252 && MY<426)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "huanjing");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>0 && MX<552 && MY>198 && MY<880)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "nengyuan");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>206 && MX<582 && MY>510 && MY<636)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "jiaotong");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>0 && MX<278 && MY>714 && MY<878)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "guihua");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>596 && MX<762 && MY>474 && MY<642)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "wenhua");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>292 && MX<446 && MY>676 && MY<850)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "zhenqu");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>494 && MX<740 && MY>706 && MY<858)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "renkou");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				
				return false;
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity_config, menu);
        return true;
    }

    
}
