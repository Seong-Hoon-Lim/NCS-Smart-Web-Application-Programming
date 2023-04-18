package com.example.project_09_02_ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        //앞 화면에서 보낸 투표 결과 값을 받는다.
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");
        Button btnReturn = (Button) findViewById(R.id.btnReturn);

        if (voteResult == null || voteResult.length < 10) {
            Toast.makeText(getApplicationContext(), "투표 되지 않은 그림이 있습니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            TextView[] tviews = new TextView[9];
            Integer[] tviewId = {R.id.iv1, R.id.iv2, R.id.iv3,
                    R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8,
                    R.id.iv9};

            RatingBar[] rbars = new RatingBar[9];
            Integer[] rbarId = {R.id.rbar1, R.id.rbar2, R.id.rbar3,
                    R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8,
                    R.id.rbar9};

            //TextView 및 RatingBar 객체 찾기.
            for (int i = 0; i < voteResult.length; i++) {
                tviews[i] = (TextView) findViewById(tviewId[i]);
                rbars[i] = (RatingBar) findViewById(rbarId[i]);
            }


            //각 TextView 및 RatingBar에 넘겨 받은 값을 반영.
            for (int i = 0; i < voteResult.length; i++) {
                tviews[i].setText(imageName[i]);
                rbars[i].setRating((float) voteResult[i]);
            }
        }

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
