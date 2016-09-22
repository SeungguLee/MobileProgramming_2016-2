package com.example.user.tempconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int rb = 0;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.inputTemp);
        tv = (TextView)findViewById(R.id.convertedTemp);
    }

    // 변환 버튼이 클릭됐을 때 호출
    public void onButtonClick(View view) {
        // 1. edittext 에 사용자가 입력한 값을 읽는다
        // CharSequence  getText()
        // et.getText();

        // 2. 숫자 변환
        // Float.parseFloat(String s)

        // 3. 라디오 버튼이 뭐가 선택됐는지에 따라 변환식 계산
        // if (라디오 버튼 == 섭씨)
        //  C = (F - 32) * 5 / 9
        // else (라디오 버튼 == 화씨)
        //  F = C * 9 / 5 + 32

        // 4. 결과 값을 TextView 객체에 표시
        // setText(CharSequence text)
        // setText("abc")
        // tv.setText(.......)
    }

    // 라디오 버튼이 클릭됐을 때 호출
    public void onRBClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.cel:
                if(checked) {
                    // 섭씨 선택됨
                    rb = 0;
                    //Toast.makeText(getApplicationContext(), ((RadioButton) view).getText(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.fa:
                if(checked) {
                    // 화씨 선택됨
                    rb = 1;
                    //Toast.makeText(getApplicationContext(), ((RadioButton) view).getText(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
