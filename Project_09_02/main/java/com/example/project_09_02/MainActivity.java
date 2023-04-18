package com.example.project_09_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar rating1, rating2, rating3;
        Button btnInc, btnDec;

        rating1 = (RatingBar) findViewById(R.id.ratingBar1);
        rating2 = (RatingBar) findViewById(R.id.ratingBar2);
        rating3 = (RatingBar) findViewById(R.id.ratingBar3);
        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 getRating() 메소드로 레이팅바에 채워진 개수와 getStepSize() 메소드로
                 레이팅바에 설정된 stepSize 속성의 증가 크기를 더하거나 뺌
                 */
                rating1.setRating(rating1.getRating() + rating1.getStepSize());
                rating2.setRating(rating2.getRating() + rating2.getStepSize());
                rating3.setRating(rating3.getRating() + rating3.getStepSize());
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 getRating() 메소드로 레이팅바에 채워진 개수와 getStepSize() 메소드로
                 레이팅바에 설정된 stepSize 속성의 증가 크기를 더하거나 뺌
                 */
                rating1.setRating(rating1.getRating() - rating1.getStepSize());
                rating2.setRating(rating2.getRating() - rating2.getStepSize());
                rating3.setRating(rating3.getRating() - rating3.getStepSize());
            }
        });


    }
}