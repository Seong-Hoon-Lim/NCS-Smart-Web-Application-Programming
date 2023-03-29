package com.example.widget2application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chkAgree;

    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdaRabbit;

    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");

        text1 = (TextView)findViewById(R.id.Text1);
        text2 = (TextView)findViewById(R.id.Text2);
        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);

        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton)findViewById(R.id.RdoDog);
        rdoCat = (RadioButton)findViewById(R.id.RdoCat);
        rdaRabbit = (RadioButton)findViewById(R.id.RdoRabbit);

        btnOK = (Button)findViewById(R.id.BtnOK);
        imgPet = (ImageView)findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //"시작함" 체크가 되었을 때 보여지도록 설정
                if(chkAgree.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                //"시작함" 체크해제 되었을 때 보여지지 않도록 설정
                else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        //"선택완료" 버튼을 클릭 시에 해당되는 RadioButton 의 그림을 가져와서 보여지도록 하는 설정
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                        //앱이 처음 실행 되었을 때 RadioButton 의 요소가 하나도 선택되지 않았는 상태에서 "선택완료" 버튼을 누르면
                        //"동물을 먼저 선택하세요" 라는 Toast 메시지를 띄우도록 설정
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}