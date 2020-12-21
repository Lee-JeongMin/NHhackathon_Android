package com.example.zaego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TypeActivity0 extends AppCompatActivity {

    ImageButton back_btn;
    Button bnt_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type0);

        // 툴바 글씨 설정
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_text);
        Log.d(this.getClass().getName(), (String)toolbar_text.getText());
        toolbar_text.setText("성향 테스트");

        back_btn = (ImageButton) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });
        bnt_start = (Button)findViewById(R.id.bnt_start);
        bnt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TypeActivity1.class);
                startActivity(intent);
            }
        });
    }
}