package com.example.project_09_03_ex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnActivity = (Button) findViewById(R.id.btnNewActivity);
    RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);
    Intent intent;
    String calc = (intent.getStringExtra("Calc"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");



        switch (rdoGroup.getCheckedRadioButtonId()) {
            case R.id.rdoAdd:
                intent.putExtra("Clac", "+");
                break;
            case R.id.rdoSub:
                intent.putExtra("Clac", "-");
                break;
            case R.id.rdoMul:
                intent.putExtra("Clac", "*");
                break;
            case R.id.rdoDiv:
                intent.putExtra("Clac", "/");
                break;
        }

        int calValue = 0;
        if (calc.equals("+")) {
            calValue = intent.getIntExtra("Num1", 0)
                    + intent.getIntExtra("Num2", 0);
        }
        else if (calc.equals("-")) {
            calValue = intent.getIntExtra("Num1", 0)
                    - intent.getIntExtra("Num2", 0);
        }
        else if (calc.equals("*")) {
            calValue = intent.getIntExtra("Num1", 0)
                    * intent.getIntExtra("Num2", 0);
        }
        else if (calc.equals("/")) {
            calValue = intent.getIntExtra("Num1", 0)
                    / intent.getIntExtra("Num2", 0);
        }


        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText editNum2 = (EditText) findViewById(R.id.edtNum2);

                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                intent.putExtra("Num1",
                        Integer.parseInt(editNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(editNum2.getText().toString()));
                /*
                 값을 돌려 받기 위해 startActivityForResult 사용
                 두번째 파라미터에는 돌려받을 값이 있는 경우에 0이상을 사용.
                 */
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}