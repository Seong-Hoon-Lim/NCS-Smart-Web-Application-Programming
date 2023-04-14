package com.example.project_07_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    MyPictureView myPictureView;
    int curNum = 1; //index 번호를 지정
    File[] imageFiles;  //폴더에서 파일을 읽어옴
    String imageFileName;
    final String PICTURES_PATH = "/Pictures";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPictureView = (MyPictureView) findViewById(R.id.myPictureView);

        //파일 읽어오기
        imageFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + PICTURES_PATH)
                .listFiles();
        imageFileName = imageFiles[1].toString();   //0번은 .thumbnails 파일
        myPictureView.imagePath = imageFileName;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 1) {
                    Toast.makeText(getApplicationContext(),
                            "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    curNum--;
                    imageFileName = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFileName;
                    myPictureView.invalidate();;
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length -1) {
                    Toast.makeText(getApplicationContext(),
                            "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    curNum++;
                    imageFileName = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFileName;
                    myPictureView.invalidate();;
                }
            }
        });

    }
}