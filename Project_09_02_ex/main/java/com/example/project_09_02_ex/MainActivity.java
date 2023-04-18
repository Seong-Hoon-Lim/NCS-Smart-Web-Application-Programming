package com.example.project_09_02_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화 선호도 투표");

        Button btnResult = (Button) findViewById(R.id.btnResult);

        final int[] voteCount = new int[9];
        for (int i = 0; i < 9; i++) {
            voteCount[i] = 0;
        }

        //9개의 이미지 버튼 객체 배열
        ImageView[] images = new ImageView[9];
        //9개의 이미지 버튼 ID 배열
        Integer[] imageId = {R.id.iv1, R.id.iv2, R.id.iv3 ,
                R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7,
                R.id.iv8, R.id.iv9};

        final String[] imgName = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서" };

        for (int i = 0; i < imageId.length; i++) {
            final int index;    //주의! 꼭 필요
            index = i;
            images[index] = (ImageView) findViewById(imageId[index]);
            images[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //투표수 증가.
                    Log.d("index", String.valueOf(index));  //안드로이드 로그 확인
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + "표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                 인텐트를 생성하고 인텐트에 투표수 배열과 그림 제목 배열을 넣은 후
                 결과 엑티비티 호출
                 */
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);


            }
        });


    }
}