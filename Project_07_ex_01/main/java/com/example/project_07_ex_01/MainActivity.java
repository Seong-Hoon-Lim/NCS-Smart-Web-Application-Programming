package com.example.project_07_ex_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("토스트 연습");

        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast tMsg = Toast.makeText(MainActivity.this, "토스트 연습", Toast.LENGTH_SHORT);

                //random 을 사용할 경우 화면 밖으로 벗어날 수 있기 때문에 현재 창에서 벗어나지 않도록 설정
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                tMsg.show();

            }
        });


    }
}