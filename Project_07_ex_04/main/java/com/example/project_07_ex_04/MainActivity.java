package com.example.project_07_ex_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    TextView textViewCnt;
    MyPictureView myPictureView;
    int curNum = 1; //index 번호를 지정
    File[] imageFiles;  //폴더에서 파일을 읽어옴
    String imageFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        textViewCnt = (TextView) findViewById(R.id.textViewCnt);
        myPictureView = (MyPictureView) findViewById(R.id.myPictureView);

        //파일 읽어오기
        imageFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/Pictures").listFiles();
        imageFileName = imageFiles[1].toString();   //0번은 .thumbnails 파일
        myPictureView.imagePath = imageFileName;

        textViewCnt.setText("1" + "/" + (imageFiles.length -1));

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 1) {
                    curNum = imageFiles.length - 1;
                }
                else {
                    curNum--;
                }
                    imageFileName = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFileName;
                    myPictureView.invalidate();;
                    textViewCnt.setText((curNum) + "/" + (imageFiles.length - 1));

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length -1) {
                    curNum = 1;
                }
                else {
                    curNum++;
                }
                    imageFileName = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFileName;
                    myPictureView.invalidate();
                    textViewCnt.setText((curNum) + "/" + (imageFiles.length - 1));

            }
        });


    }
}