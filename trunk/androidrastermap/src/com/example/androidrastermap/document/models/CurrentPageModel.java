package com.example.androidrastermap.document.models;

import com.example.androidrastermap.document.event.CurrentPageListener;
import com.example.androidrastermap.document.event.EventDispatcher;



public class CurrentPageModel extends EventDispatcher
{
    private int currentPageIndex;

    public void setCurrentPageIndex(int currentPageIndex)
    {
        if (this.currentPageIndex != currentPageIndex)
        {
            this.currentPageIndex = currentPageIndex;
            dispatch(new CurrentPageListener.CurrentPageChangedEvent(currentPageIndex));
        }
    }
}
