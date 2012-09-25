package com.example.androidrastermap.document;

import java.util.zip.Inflater;

import com.example.androidrastermap.R;
import com.example.androidrastermap.document.event.CurrentPageListener;
import com.example.androidrastermap.document.event.DecodingProgressListener;
import com.example.androidrastermap.document.models.CurrentPageModel;
import com.example.androidrastermap.document.models.DecodingProgressModel;
import com.example.androidrastermap.document.models.ZoomModel;
import com.example.androidrastermap.views.PageViewZoomControls;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
/*****
界面控制
*****/

public abstract class BaseViewerActivity extends Activity implements DecodingProgressListener, CurrentPageListener
{
    private static final int MENU_EXIT = 0;
    private static final int MENU_GOTO = 1;
    private static final int MENU_FULL_SCREEN = 2;
    private static final int DIALOG_GOTO = 0;
    private static final String DOCUMENT_VIEW_STATE_PREFERENCES = "DjvuDocumentViewState";
    private DecodeService decodeService;
    private DocumentView documentView;
    private ViewerPreferences viewerPreferences;
    private Toast pageNumberToast;
    private CurrentPageModel currentPageModel;
    private  TabHost tabHost; 
    FrameLayout frameLayout=null ;
  
    //int i=0;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	Resources res ;
        super.onCreate(savedInstanceState);
        initDecodeService();
        final ZoomModel zoomModel = new ZoomModel();
        final DecodingProgressModel progressModel = new DecodingProgressModel();
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        
       
        
        
        setContentView(R.layout.tab_demo);
        LayoutInflater inflater = LayoutInflater.from ( this );
        
        //tabhost显示设置
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

        tabhost.addTab(tabhost.newTabSpec( "tab1" ).setIndicator(tab)
                    .setContent(new Intent(this , MainPagesjt.class ) ));
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
        tabhost.setCurrentTab(3); 
  

        //加载界面PDF
        
        //TabWidget tablewidget=tabhost.getTabWidget();
       // tablewidget.getTabCount();
        tabhost.setOnTabChangedListener(new OnTabChangeListener(){

			public void onTabChanged(String arg0) {
				// TODO Auto-generated method stub
					if(arg0=="tab1")
					{

						Toast.makeText(BaseViewerActivity.this,"第1页", Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab2")
					{

						Toast.makeText(BaseViewerActivity.this,"第2页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab3")
					{

						Toast.makeText(BaseViewerActivity.this,"第3页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab4")
					{

						Toast.makeText(BaseViewerActivity.this,"第4页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab5")
					{
						Toast.makeText(BaseViewerActivity.this,"第5页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab6")
					{
						Toast.makeText(BaseViewerActivity.this,"第6页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab7")
					{
						Toast.makeText(BaseViewerActivity.this,"第7页",Toast.LENGTH_SHORT).show();
					}
					if(arg0=="tab10")
					{
						
						frameLayout=(FrameLayout)findViewById(R.id.framelayout1);
						progressModel.addEventListener(this);
			        	currentPageModel = new CurrentPageModel();
			        	currentPageModel.addEventListener(this);
			        	documentView = new DocumentView(BaseViewerActivity.this, zoomModel, progressModel, currentPageModel);
			        	zoomModel.addEventListener(documentView);
			        	documentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
			        	decodeService.setContentResolver(getContentResolver());
			        	decodeService.setContainerView(documentView);
			        	documentView.setDecodeService(decodeService);
			        	decodeService.open(getIntent().getData());
			        	viewerPreferences = new ViewerPreferences(BaseViewerActivity.this);
					    
				        frameLayout.addView(documentView);
				        frameLayout.addView(createZoomControls(zoomModel));
				        final SharedPreferences sharedPreferences = getSharedPreferences(DOCUMENT_VIEW_STATE_PREFERENCES, 0);
				        documentView.goToPage(sharedPreferences.getInt(getIntent().getData().toString(), 0));
				        documentView.showDocument();
				        viewerPreferences.addRecent(getIntent().getData());
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

    public void decodingProgressChanged(final int currentlyDecoding)
    {
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS, currentlyDecoding == 0 ? 10000 : currentlyDecoding);
            }
        });
    }

    public void currentPageChanged(int pageIndex)
    {
        final String pageText = (pageIndex + 1) + "/" + decodeService.getPageCount();
        if (pageNumberToast != null)
        {
            pageNumberToast.setText(pageText);
        }
        else
        {
            pageNumberToast = Toast.makeText(this, pageText, 300);
        }
        pageNumberToast.setGravity(Gravity.TOP | Gravity.LEFT,0,0);
        pageNumberToast.show();
        saveCurrentPage();
    }

    private void setWindowTitle()
    {
        final String name = getIntent().getData().getLastPathSegment();
        getWindow().setTitle(name);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        setWindowTitle();
    }

    private void setFullScreen()
    {
        if (viewerPreferences.isFullScreen())
        {
            getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else
        {
            getWindow().requestFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        }
    }

    private PageViewZoomControls createZoomControls(ZoomModel zoomModel)
    {
        final PageViewZoomControls controls = new PageViewZoomControls(this, zoomModel);
        controls.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
        zoomModel.addEventListener(controls);
        return controls;
    }

    private FrameLayout createMainContainer()
    {
        return new FrameLayout(this);
    }

    private void initDecodeService()
    {
        if (decodeService == null)
        {
            decodeService = createDecodeService();
        }
    }

    protected abstract DecodeService createDecodeService();

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        decodeService.recycle();
        decodeService = null;
        super.onDestroy();
    }

    private void saveCurrentPage()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences(DOCUMENT_VIEW_STATE_PREFERENCES, 0);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getIntent().getData().toString(), documentView.getCurrentPage());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, MENU_EXIT, 0, "Exit");
        menu.add(0, MENU_GOTO, 0, "Go to page");
        final MenuItem menuItem = menu.add(0, MENU_FULL_SCREEN, 0, "Full screen").setCheckable(true).setChecked(viewerPreferences.isFullScreen());
        setFullScreenMenuItemText(menuItem);
        return true;
    }

    private void setFullScreenMenuItemText(MenuItem menuItem)
    {
        menuItem.setTitle("Full screen " + (menuItem.isChecked() ? "on" : "off"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case MENU_EXIT:
                System.exit(0);
                return true;
            case MENU_GOTO:
                showDialog(DIALOG_GOTO);
                return true;
            case MENU_FULL_SCREEN:
                item.setChecked(!item.isChecked());
                setFullScreenMenuItemText(item);
                viewerPreferences.setFullScreen(item.isChecked());

                finish();
                startActivity(getIntent());
                return true;
        }
        return false;
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case DIALOG_GOTO:
                return new GoToPageDialog(this, documentView, decodeService);
        }
        return null;
    }
}
