package com.example.project_09_ex_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button btnReturn = (Button) findViewById(R.id.btnSecond);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 /Activity 를 종료시키는 메소드, 메인을 종료시킬 경우 앱이 종료됨
                 second Activity 를 종료시키면 main Activity 를 호출하므로 메인 엑티비티가 나타남
                 */
                finish();
            }
        });

    }

}
