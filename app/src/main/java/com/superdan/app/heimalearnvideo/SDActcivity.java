package com.superdan.app.heimalearnvideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.widget.TextView;

import java.io.File;

/**
 * Created by dsz on 16/4/30.
 */
public class SDActcivity extends Activity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd);
        mTextView=(TextView)findViewById(R.id.sd_tv);
        obtainSurPlus();
    }
    @SuppressLint("NewApi")
    public void obtainSurPlus(){
        File path= Environment.getExternalStorageDirectory();
        StatFs stat=new StatFs(path.getPath());
        long blockSize;
        long totalBlocks;
        long availableBlocks;
        //判断当前版本是否是4.3或以上
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR2){
            blockSize=stat.getBlockSizeLong();
            totalBlocks=stat.getBlockCountLong();
            availableBlocks=stat.getAvailableBlocksLong();
        }else {
            blockSize=stat.getBlockSize();
            totalBlocks=stat.getBlockCount();
            availableBlocks=stat.getAvailableBlocks();
        }


        String text=formatSize(availableBlocks*blockSize);
        mTextView.setText(text);
    }


    private String formatSize(long size){
        return android.text.format.Formatter.formatFileSize(this,size);
    }


}
