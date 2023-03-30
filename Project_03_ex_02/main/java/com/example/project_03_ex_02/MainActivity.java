package com.example.project_03_ex_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch swAgree;

    RadioGroup rGroup1;
    //RadioButton rdoLemon, rdoLime, rdoOrange;
    RadioButton[] radioArray = new RadioButton[3];  //배열로 선언가능
    Button btnQuit, btnReturn ;
    ImageView imgFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좋아하는 과일 고르기");

        text1 = (TextView)findViewById(R.id.Text1);
        text2 = (TextView)findViewById(R.id.Text2);

        swAgree = (Switch)findViewById(R.id.SwAgree);

        rGroup1 = (RadioGroup)findViewById(R.id.RGroup1);
        //rdoLemon = (RadioButton)findViewById(R.id.RdoLemon);
        //rdoLime = (RadioButton)findViewById(R.id.RdoLime);
        //rdoOrange = (RadioButton)findViewById(R.id.RdoOrange);

        radioArray[0] = (RadioButton)findViewById(R.id.RdoLemon);
        radioArray[1] = (RadioButton)findViewById(R.id.RdoLime);
        radioArray[2] = (RadioButton)findViewById(R.id.RdoOrange);

        btnQuit = (Button)findViewById(R.id.BtnQuit);
        btnReturn = (Button)findViewById(R.id.BtnReturn);

        imgFruit = (ImageView)findViewById(R.id.ImgFruit);

        swAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                
                //"시작함" 일 때 보여지도록 설정
                if (swAgree.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgFruit.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(View.VISIBLE);
                    btnReturn.setVisibility(View.VISIBLE);
                }
                //"시작함" off 일 때 보여지도록 설정
                else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgFruit.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(View.INVISIBLE);
                    btnReturn.setVisibility(View.INVISIBLE);
                }
            }
        });

        //배열을 이용한 방법
        final int[] draw = { R.drawable.lemon, R.drawable.lime, R.drawable.oranges };

        for (int i = 0; i < radioArray.length; i++) {
            final int index;    //꼭 필요함. 내부 클래스에서 인덱스 값을 사용함
            index = i;
            radioArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgFruit.setImageResource(draw[index]);
                }
            });
        }
        
        //개별처리 방법
//        radioArray[0].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imgFruit.setImageResource(R.drawable.lemon);
//            }
//        });
//
//        radioArray[1].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imgFruit.setImageResource(R.drawable.lime);
//            }
//        });
//
//        radioArray[2].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imgFruit.setImageResource(R.drawable.oranges);
//            }
//        });


        //"처음으로" 버튼을 클릭할 때 실행
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgFruit.setVisibility(View.INVISIBLE);
                imgFruit.setImageResource(0);
                btnQuit.setVisibility(View.INVISIBLE);
                btnReturn.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();   //라디오 버튼을 초기화 시키는 작업
                swAgree.setChecked(false);  //스위치 버튼을 off로 초기화 시키는 작업
            }
        });

        //"종료" 버튼을 클릭할 때 실행
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}