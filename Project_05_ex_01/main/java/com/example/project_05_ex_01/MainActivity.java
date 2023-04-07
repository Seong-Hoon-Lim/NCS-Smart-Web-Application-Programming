package com.example.project_05_ex_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer1;
    RadioButton rdoDate, rdoTime;

    DatePicker datePicker1;
    TimePicker timePicker1;

    TextView tYear, tMonth, tDay, tHour, tMinute;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        //크로노미터
        chronometer1 = (Chronometer)findViewById(R.id.Chronometer1);
        //라디오버튼
        rdoDate = (RadioButton)findViewById(R.id.RdoCal);
        rdoTime = (RadioButton)findViewById(R.id.RdoTime);
        //프레임 레이아웃 2개 위젯
        datePicker1 = (DatePicker)findViewById(R.id.datePicker1);
        timePicker1 = (TimePicker)findViewById(R.id.TimePicker1);
        //텍스트뷰 중에서 년,월,일,시,분 숫자
        tYear = (TextView)findViewById(R.id.tvYear);
        tMonth = (TextView)findViewById(R.id.tvMonth);
        tDay = (TextView)findViewById(R.id.tvDay);
        tHour = (TextView)findViewById(R.id.tvHour);
        tMinute = (TextView)findViewById(R.id.tvMinute);

        //최초에 보이지 않도록 할 위젯
        rdoDate.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        datePicker1.setVisibility(View.INVISIBLE);
        timePicker1.setVisibility(View.INVISIBLE);

        /* '날짜설정','시간설정' 각 라디오 버튼을 눌렀을 때 이벤트 실행 */
        rdoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1.setVisibility(View.VISIBLE);
                timePicker1.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1.setVisibility(View.INVISIBLE);
                timePicker1.setVisibility(View.VISIBLE);
            }
        });

        //크로노미터를 클릭하면 타이머 시작
        chronometer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);
                rdoDate.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        //년도를 롱클릭하면 타이머 중지
        tYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);

                tYear.setText(Integer.toString(datePicker1.getYear()));
                tYear.setText(Integer.toString(1 + datePicker1.getMonth()));
                tYear.setText(Integer.toString(datePicker1.getDayOfMonth()));

                tHour.setText(Integer.toString(timePicker1.getCurrentHour()));
                tMinute.setText(Integer.toString(timePicker1.getCurrentMinute()));

                rdoDate.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                datePicker1.setVisibility(View.INVISIBLE);
                timePicker1.setVisibility(View.INVISIBLE);

                return false;

            }
        });


    }
}