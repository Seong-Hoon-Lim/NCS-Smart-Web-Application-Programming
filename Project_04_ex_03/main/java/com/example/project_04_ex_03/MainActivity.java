package com.example.project_04_ex_03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    Button button1;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //1) 리니어 레이아웃 추가
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

//        setTitle("Project_04_ex_03");

        //2) 위젯 추가
        EditText editText1 = new EditText(this);
        editText1.setHint("여기에 입력하세요");
        baseLayout.addView(editText1);

        Button button1 = new Button(this);
        button1.setText("버튼입니다.");
        button1.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(button1);

        TextView textView1 = new TextView(this);
        textView1.setText("텍스트뷰입니다.");
        textView1.setTextSize(20);
        textView1.setTextColor(Color.MAGENTA);
        baseLayout.addView(textView1);

        //3) 이벤트 추가
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                textView1.setText(editText1.getText().toString());
            }
        });


    }
}