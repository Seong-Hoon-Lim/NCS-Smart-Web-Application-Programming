package com.example.project_07_ex_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        editDiary = (EditText) findViewById(R.id.editDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        /*
         앱 실행시 날짜를 가져옴
         */
        Calendar calendar = Calendar.getInstance();
        int calendarYear = calendar.get(Calendar.YEAR);
        int calendarMonth = calendar.get(Calendar.MONTH);
        int calendarDay = calendar.get(Calendar.DAY_OF_MONTH);

        /*
         처음 실행시에 설정할 내용
         */
        fileName = Integer.toString(calendarYear) + "-" + Integer.toString(calendarMonth + 1)
                + "-" + Integer.toString(calendarDay) + ".txt";
        String str = readDiary(fileName);
        editDiary.setText(str);
        btnWrite.setEnabled(true);  //버튼 활성화

        datePicker.init(calendarYear, calendarMonth, calendarDay,
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                        fileName = Integer.toString(year) + "-"
                                + Integer.toString(month + 1) + "-"
                                + Integer.toString(day) + ".txt";
                        String string = readDiary(fileName);    //날짜에 해당하는 일기 파일을 읽기
                        editDiary.setText(string);  //EditText 에 일기 내용을 출력
                        btnWrite.setEnabled(true);  //버튼 활성화
                    }
                });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String string = editDiary.getText().toString();
                    outputStream.write(string.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장됨", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /*
     현재 날짜의 파일(년-월-일.txt)을 읽어 일기의 내용을 반환하는 readDiary() 메소드
     */
    private String readDiary(String fileName) {
        String diaryStr = null;
        FileInputStream inputStream;
        try {
            inputStream = openFileInput(fileName);
            byte[] txt = new byte[500];
            inputStream.read(txt);
            inputStream.close();
            diaryStr = (new String(txt)).trim();

            btnWrite.setText("수정하기");
        } catch (IOException e) {
            editDiary.setHint("일기 없음");
            btnWrite.setText("일기 저장");
        }
        return diaryStr;
    }
}