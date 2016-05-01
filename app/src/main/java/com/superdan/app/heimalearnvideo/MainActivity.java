package com.superdan.app.heimalearnvideo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private CheckBox mCheckBox;
    private Button mLogin;
    private EditText userName;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckBox=(CheckBox)findViewById(R.id.cb);
        mLogin=(Button)findViewById(R.id.login);
        userName=(EditText)findViewById(R.id.user_name);
        passWord=(EditText)findViewById(R.id.pass_word);
        getUseAndPass();

    }


    public void getUseAndPass(){
//        File file=new File("data/data/com.superdan.app.heimalearnvideo/info.txt");
//        File file=new File(getFilesDir(),"info.txt");

//       file=new File(getCacheDir(),"info.txt");
//
        File  file=new File("sdcard/info.txt");
//        File file=new File(Environment.getExternalStorageDirectory(),"info.txt");

        //MEDIA_REMOVED:SD卡不存在
        //MEDIA_UNMOUNTED:SD卡存在，但是没有挂载
        // MEDIA_CHECKING:SD卡正在遍历
        //MEDIA_MOUNTED_READ_ONLY:SD卡可用，但是只读（很早的卡有写保护）
        //MEDIA_MOUNTED:SD卡可用
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            if (!file.exists())return;
            FileInputStream fileInputStream=null;
            try {
                fileInputStream =new FileInputStream(file);
                BufferedReader br=new BufferedReader(new InputStreamReader(fileInputStream));
                String info=br.readLine();
                if (!TextUtils.isEmpty(info)){
                    String[]uAndp=info.split("&&");
                    userName.setText(uAndp[0]);
                    passWord.setText(uAndp[1]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fileInputStream!=null){
                        fileInputStream.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else {
            Toast.makeText(this,"亲，SD卡不可用，么么哒",Toast.LENGTH_SHORT).show();
        }



    }
    public void login(View view){
        String user=userName.getText().toString();
        String pass=passWord.getText().toString();

        if (mCheckBox.isChecked()){
//            File file=new File("data/data/com.superdan.app.heimalearnvideo/info.txt");
            //返回一个File对象，封装的路径是data/data/<应用包名>/files
//            File file=new File(getFilesDir(),"info.txt");

            //返回一个File对象，封装的路径是data/data/<应用包名>/cache
//            File file=new File(getCacheDir(),"info.txt");

            File  file=new File("sdcard/info.txt");
//            File file=new File(Environment.getExternalStorageDirectory(),"info.txt");
            FileOutputStream outputStream=null;

            try {
                outputStream=new FileOutputStream(file);
                outputStream.write((user+"&&"+pass).getBytes());
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (outputStream!=null){
                        outputStream.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }
}
