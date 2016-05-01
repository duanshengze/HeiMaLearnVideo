package com.superdan.app.heimalearnvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.io.FileOutputStream;

/**
 * Created by dsz on 16/4/30.
 */
public class FileAccessActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_access);
    }

    public void click1(View view){
        //路径默认为：data/data/包名、files
        try {
            FileOutputStream fileOutputStream=openFileOutput("info1.txt",MODE_PRIVATE);
            fileOutputStream.write("hahhah".getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
    public void click2(View view){
        //路径默认为：data/data/包名/files
        try {
            //全局可读权限
            FileOutputStream fileOutputStream=openFileOutput("info2.txt",MODE_WORLD_READABLE);
            fileOutputStream.write("h撒算法".getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
    public  void click3(View view){
        //路径默认为：data/data/包名/files
        try {
            //全局可读权限
            FileOutputStream fileOutputStream=openFileOutput("info2.txt",MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE);
            fileOutputStream.write("h撒算法sadsad".getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }

}
