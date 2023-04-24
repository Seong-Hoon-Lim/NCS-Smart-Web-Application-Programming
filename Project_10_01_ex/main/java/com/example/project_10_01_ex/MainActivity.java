package com.example.project_10_01_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        final String[] mid = {"홍콩", "타이페이", "타이난", "가오슝", "후쿠오카", "교토", "오사카",
                                "구마모토", "히로시마", "하노이", "호치민", "다낭", "하롱베이",
                                "뉴욕", "시카고"};

        ListView listView = (ListView) findViewById(R.id.listView1);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, mid);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
            }
        });


    }
}