package com.example.project_05_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer1;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;

    CalendarView calendarView1;
    TimePicker timePicker1;

    TextView tYear, tMonth, tDay, tHour, tMinute;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        //버튼
        btnStart = (Button)findViewById(R.id.BtnStart);
        btnEnd = (Button)findViewById(R.id.BtnEnd);
        //크로노미터
        chronometer1 = (Chronometer)findViewById(R.id.Chronometer1);
        //라디오버튼
        rdoCal = (RadioButton)findViewById(R.id.RdoCal);
        rdoTime = (RadioButton)findViewById(R.id.RdoTime);
        //프레임 레이아웃 2개 위젯
        calendarView1 = (CalendarView)findViewById(R.id.CalendarView1);
        timePicker1 = (TimePicker)findViewById(R.id.TimePicker1);
        //텍스트뷰 중에서 년,월,일,시,분 숫자
        tYear = (TextView)findViewById(R.id.tvYear);
        tMonth = (TextView)findViewById(R.id.tvMonth);
        tDay = (TextView)findViewById(R.id.tvDay);
        tHour = (TextView)findViewById(R.id.tvHour);
        tMinute = (TextView)findViewById(R.id.tvMinute);
        
        //프레임 레이아웃의 위젯 보이지 않도록 설정
        calendarView1.setVisibility(View.INVISIBLE);
        timePicker1.setVisibility(View.INVISIBLE);

        /* '날짜설정','시간설정' 각 라디오 버튼을 눌렀을 때 이벤트 실행 */
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView1.setVisibility(View.VISIBLE);
                timePicker1.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView1.setVisibility(View.INVISIBLE);
                timePicker1.setVisibility(View.VISIBLE);
            }
        });

        //'예약시작' 버튼을 눌렀을 때 이벤트 실행
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);
            }
        });
        /* '예약완료' 버튼을 눌렀을 때 이벤트 실행
        *   날짜, 시간을 가져온다
        */
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);

                tYear.setText(Integer.toString(selectYear));
                tMonth.setText(Integer.toString(selectMonth));
                tDay.setText(Integer.toString(selectDay));
                tHour.setText(Integer.toString(timePicker1.getCurrentHour()));
                tYear.setText(Integer.toString(timePicker1.getCurrentMinute()));
            }
        });

        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });



    }
}