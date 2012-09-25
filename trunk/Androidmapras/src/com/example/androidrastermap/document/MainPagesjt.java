package com.example.androidrastermap.document;

import com.example.androidrastermap.R;
import com.example.androidrastermap.document.models.CurrentPageModel;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;

public  class MainPagesjt extends Activity{
	
	 public void onCreate(Bundle savedInstanceState)
	 {
		 Resources res ;
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.main);
		 
		  final LayoutInflater inflater = LayoutInflater.from ( this );
		 final TabHost tabhost = (TabHost)findViewById(R.id.v_tabhost);
	        TabWidget tw = (TabWidget)findViewById(android.R.id.tabs);
	        tabhost.setup();
	        res = getResources();
	        View tab = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image = (ImageView)tab.findViewById(R.id.icon);
	        image.setImageResource(R.drawable.bottom_image1);
	        View tab2 = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image2 = (ImageView)tab2.findViewById(R.id.icon);
	        image2.setImageResource(R.drawable.bottom_image2);
	        View tab3 = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image3 = (ImageView)tab3.findViewById(R.id.icon);
	        image3.setImageResource(R.drawable.bottom_image3);
	        View tab4 = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image4 = (ImageView)tab4.findViewById(R.id.icon);
	        image4.setImageResource(R.drawable.bottom_image4);
	        View tab5 = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image5 = (ImageView)tab5.findViewById(R.id.icon);
	        image5.setImageResource(R.drawable.bottom_image5);
	        View tab6 = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image6 = (ImageView)tab6.findViewById(R.id.icon);
	        image6.setImageResource(R.drawable.bottom_image6);
	        View tab7 = LayoutInflater.from(this).inflate(R.layout.tab_style, null);
	        ImageView image7 = (ImageView)tab7.findViewById(R.id.icon);
	        image7.setImageResource(R.drawable.bottom_image7);
	       
	        // RelativeLayout tabIndicator1 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tab_style,tw,false);
	       // ImageView image1 = (ImageView)tabIndicator1.getChildAt(0);  
	        //image1.setImageDrawable(res.getDrawable(R.drawable.bottom_image1));

	        
	        inflater.inflate(R.layout.page1 , tabhost.getTabContentView()); 



	        
	        tabhost.addTab(tabhost.newTabSpec( "tab1" ).setIndicator(tab)
	                    .setContent(R.id.tab3));
	        tabhost.addTab(tabhost.newTabSpec( "tab2" ).setIndicator(tab2)
	                    .setContent(R.id.tab3));
	        tabhost.addTab(tabhost.newTabSpec( "tab3" ).setIndicator(tab3)
	                    .setContent(R.id.tab3));
	        tabhost.addTab(tabhost.newTabSpec( "tab4" ).setIndicator(tab4)
	                	.setContent(R.id.tab3));
	        tabhost.addTab(tabhost.newTabSpec( "tab5" ).setIndicator(tab5)
	                	.setContent(R.id.tab3));
	        tabhost.addTab(tabhost.newTabSpec( "tab6" ).setIndicator(tab6)
	                	.setContent(R.id.tab3));
	        tabhost.addTab(tabhost.newTabSpec( "tab7" ).setIndicator(tab7)
	                	.setContent(R.id.tab3));
	        tabhost.setCurrentTab(0); 
	        setContentView(tabhost); 
	 tabhost.setOnTabChangedListener(new OnTabChangeListener(){

			public void onTabChanged(String arg0) {
				// TODO Auto-generated method stub
					if(arg0=="tab1")
					{
						tabhost.getTabContentView().removeAllViews();
						 inflater.inflate(R.layout.page2, tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第1页", Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab2")
					{
						tabhost.getTabContentView().removeAllViews();
						inflater.inflate(R.layout.page3 , tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第2页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab3")
					{
						tabhost.getTabContentView().removeAllViews();
						inflater.inflate(R.layout.page4 , tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第3页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab4")
					{
						tabhost.getTabContentView().removeAllViews();
						inflater.inflate(R.layout.page5 , tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第4页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab5")
					{
						tabhost.getTabContentView().removeAllViews();
						inflater.inflate(R.layout.page6 , tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第5页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab6")
					{
						tabhost.getTabContentView().removeAllViews();
						inflater.inflate(R.layout.page7 , tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第6页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab7")
					{
						tabhost.getTabContentView().removeAllViews();
						inflater.inflate(R.layout.page8 , tabhost.getTabContentView()); 
						Toast.makeText(MainPagesjt.this,"第7页",Toast.LENGTH_SHORT).show();
					}


			}});
     /*.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					bt1.setText(tabhost.getCurrentTab());
				
			}
     	
     });
     
     */
   

     	
  	}
}
