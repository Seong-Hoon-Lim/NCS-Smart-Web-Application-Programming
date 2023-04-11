package com.example.project_06_ex_03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*
     .setSingleChoiceItems 라디오 버튼 형식 대화상자
     .setMultiChoiceItems 체크박스 형식 대화 상자
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] versionArray = new String[] {"파이", "큐(10)", "알(11)"};
                //.setMultiChoiceItems 사용할 때 지정해줘야 함, 문자열 배열과 요소의 수가 같아야 됨.
                final boolean[] checkArray = new boolean[] {true, false, false};

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                //checkedItem 은 최초에 체크 될 인덱스를 지정
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {  //목록 출력
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean b) {
                        button1.setText(versionArray[i]);   //버튼의 텍스트를 선택한 항목으로 변경
                    }
                });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        final Button button1 = (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//                dlg.setTitle("제목입니다");
//                dlg.setMessage("이곳이 내용입니다");
//                dlg.setIcon(R.mipmap.ic_launcher);
//                dlg.setPositiveButton("확인", null);
//                dlg.show();
//            }
//        });
//
//    }

}