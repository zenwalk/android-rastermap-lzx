package org.vudroid.pdfdroid.codec;

import android.content.ContentResolver;

import com.example.androidrastermap.document.VuDroidLibraryLoader;
import com.example.androidrastermap.document.codec.CodecContext;
import com.example.androidrastermap.document.codec.CodecDocument;


public class PdfContext implements CodecContext
{
    static
    {
        VuDroidLibraryLoader.load();
    }

    public CodecDocument openDocument(String fileName)
    {
        return PdfDocument.openDocument(fileName, "");
    }

    public void setContentResolver(ContentResolver contentResolver)
    {
        //TODO
    }

    public void recycle() {
    }
}
