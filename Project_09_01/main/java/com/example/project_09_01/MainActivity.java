package com.example.project_09_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity = (Button) findViewById(R.id.buttonActivity);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 Intent 의 첫번째 파라미터 getApplicationContext() 는 메인 클래스의 컨텍스트를 반환.
                 두번째 파라미터로 이 Intent 에 포함될 Activity 로 SecondActivity 를 반환.
                 */

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}