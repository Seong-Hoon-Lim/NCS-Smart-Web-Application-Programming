package com.example.project_07_ex_03_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * 시스템 폴더의 폴더/파일 의 목록을 가져오기
         * 특정 폴더안에 파일이 있는지 없는지 확인할 때 주로 사용할 수 있음
         */
        Button btnFileList;
        final EditText editFileList;

        btnFileList = (Button) findViewById(R.id.btnFileList);
        editFileList = (EditText) findViewById(R.id.editFileList);

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                File[] sysFiles = new File(sysDir).listFiles();

                String strFileName;
                for (File sysFile : sysFiles) {
                    if (sysFile.isDirectory() == true) {
                        strFileName = "<폴더> " + sysFile.toString();
                    }
                    else {
                        strFileName = "<파일> " + sysFile.toString();
                    }
                    editFileList.setText(editFileList.getText() + "\n" + strFileName);
                }
            }
        });


        /**
         * mydir 생성 및 삭제 처리
         */
//        Button btnMkDir, btnRmDir;
//
//        btnMkDir = (Button) findViewById(R.id.btnMkDir);
//        btnRmDir = (Button) findViewById(R.id.btnRmDir);
//
//        ActivityCompat.requestPermissions(this,
//                new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
//
//        final String strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
//        final File myDir = new File(strSDPath + "/mydir");
//
//        btnMkDir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myDir.mkdir();
//            }
//        });
//
//        btnRmDir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myDir.delete();
//            }
//        });

    }
}