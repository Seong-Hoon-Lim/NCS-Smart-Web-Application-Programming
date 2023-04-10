package com.example.project_06_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);
        button1 = (Button)findViewById(R.id.button1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu1, menu);

        //Java 코드로 생성
        menu.add(0, 1, 0, "배경색 (노랑)");
        menu.add(0, 2, 0, "배경색 (검정)");
        menu.add(0, 3, 0, "배경색 (회색)");

        SubMenu subMenu = menu.addSubMenu("버튼 변경 >> ");
        subMenu.add(0, 4, 0, "버튼 90도 회전");
        subMenu.add(0, 5, 0, "버튼 2배 확대");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
//            case R.id.itemRed:
//                baseLayout.setBackgroundColor(Color.RED);
//                return true;
//            case R.id.itemGreen:
//                baseLayout.setBackgroundColor(Color.GREEN);
//                return true;
//            case R.id.itemBlue:
//                baseLayout.setBackgroundColor(Color.BLUE);
//                return true;
//            case R.id.subRotate:
//                button1.setRotation(45);
//                return true;
//            case R.id.subSize:
//                button1.setScaleX(2);
//                return true;

            //Java 코드로 생성
            case 1:
                baseLayout.setBackgroundColor(Color.YELLOW);
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.BLACK);
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.GRAY);
                return true;
            case 4:
                button1.setRotation(90);
                return true;
            case 5:
                button1.setScaleX(2);
                return true;

        }
        return false;
    }
}