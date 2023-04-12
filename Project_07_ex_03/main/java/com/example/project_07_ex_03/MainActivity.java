package com.example.project_07_ex_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead;
        final EditText editText;

        btnRead = (Button) findViewById(R.id.btnRead);
        editText = (EditText) findViewById(R.id.editRaw);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.test);
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    inputStream.close();
                    editText.setText(new String(txt));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}