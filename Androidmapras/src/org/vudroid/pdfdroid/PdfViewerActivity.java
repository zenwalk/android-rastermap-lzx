package org.vudroid.pdfdroid;

import com.example.androidrastermap.document.BaseViewerActivity;
import com.example.androidrastermap.document.DecodeService;
import com.example.androidrastermap.document.DecodeServiceBase;

import org.vudroid.pdfdroid.codec.PdfContext;

public class PdfViewerActivity extends BaseViewerActivity
{
    @Override
    protected DecodeService createDecodeService()
    {
        return new DecodeServiceBase(new PdfContext());
    }
}
