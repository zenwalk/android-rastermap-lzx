package com.example.androidrastermap.document.event;

public class BringUpZoomControlsEvent extends SafeEvent<BringUpZoomControlsListener>
{
    @Override
    public void dispatchSafely(BringUpZoomControlsListener listener)
    {
        listener.toggleZoomControls();
    }
}
