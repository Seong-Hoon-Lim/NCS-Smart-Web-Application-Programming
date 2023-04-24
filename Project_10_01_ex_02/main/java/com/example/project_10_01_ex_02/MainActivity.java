package com.example.project_10_01_ex_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 동적 관리 테스트");

        final List<String> midList = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listView1);

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);

        listView.setAdapter(adapter);

        final EditText editItem = (EditText) findViewById(R.id.editItem);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(editItem.getText().toString());
                adapter.notifyDataSetChanged(); //실행 되지 않으면 리스트에 담겨도 뷰가 보이지 않음
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                midList.remove(i);
                adapter.notifyDataSetChanged(); //실행 되지 않으면 리스트에 담겨도 뷰가 보이지 않음
                return false;
            }
        });

    }
}