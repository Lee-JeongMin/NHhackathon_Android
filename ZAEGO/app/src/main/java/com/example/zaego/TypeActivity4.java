package com.example.zaego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TypeActivity4 extends AppCompatActivity {

    ImageButton back_btn;
    private static final String TAG = "TypeActivity4";
    int result1 ;
    private Button btn_next;

    RadioGroup radioGroup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type4);

        // 툴바 글씨 설정
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_text);
        Log.d(this.getClass().getName(), (String)toolbar_text.getText());
        toolbar_text.setText("성향 테스트");

        back_btn = (ImageButton) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TypeActivity0.class);
                startActivity(intent);
            }
        });

        btn_next = findViewById(R.id.bnt_next);
        radioGroup4 = findViewById(R.id.radioGroup4);

        Intent intent = new Intent(this.getIntent());

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup4.getCheckedRadioButtonId();
                if(checkedId == -1){
                    Message.message(getApplicationContext(),"보기를 선택해주세요.");
                }else {
                    int score = intent.getIntExtra("score", 1);
//                    Log.d(TAG, "받은 숫자:"+String.valueOf(score));
                    //One of the radio buttons is checked
                    result1 = findRadioButton(checkedId);
//                    Log.d(TAG, "더할 숫자"+String.valueOf(result1));
                    int res = score+result1;
//                    Log.d(TAG, "더한 숫자:"+String.valueOf(res));

                    Intent intent = new Intent(TypeActivity4.this, TypeActivity5.class);
                    intent.putExtra("score", res);
                    startActivity(intent);
                }

            }
        });
    }
    private int findRadioButton(int checkId){
        switch (checkId){
            case R.id.r_btn1:
                this.result1 = 1;
                break;
            case R.id.r_btn2:
                this.result1 = 2;
                break;
            case R.id.r_btn3:
                this.result1 = 3;
                break;
            case R.id.r_btn4:
                this.result1 = 4;
                break;
        }
        return this.result1;
    }
}