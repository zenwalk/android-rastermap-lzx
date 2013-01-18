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
				if(MX>0 && MX<166 && MY>295 && MY<529)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "wanbei");//皖北
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				
				}
				if(MX>212 && MX<330 && MY>254 && MY<392)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "wanjiang");//皖江
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				
				}
				if(MX>356 && MX<478 && MY>219 && MY<356)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "fuping");//扶贫
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				
				}
				if(MX>489 && MX<619 && MY>191 && MY<355)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "shuili");//水利
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>626 && MX<758 && MY>151 && MY<312)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "lvyou");//旅游
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>765 && MX<1017 && MY>130 && MY<304)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "huanjing");//环境
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>136 && MX<300 && MY>426 && MY<564)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "nengyuan");//能源
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>338 && MX<715 && MY>382 && MY<534)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "jiaotong");//交通
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>0 && MX<400 && MY>590 && MY<759)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "guihua");//规划
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>715 && MX<1023 && MY>348 && MY<523)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "wenhua");//文化
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>407 && MX<600 && MY>544 && MY<735)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "zhenqu");//政区
				    intent.setClass(ActivityConfig.this,ActivityMap.class);
				    startActivity(intent);	
				}
				if(MX>609 && MX<1019 && MY>571 && MY<745)
				{
					Intent intent=new Intent();
				    intent.putExtra("diqu", "renkou");//人口
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
