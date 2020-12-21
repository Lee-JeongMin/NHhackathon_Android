package com.example.zaego;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;

public class MypageActivity extends AppCompatActivity {
    private static final String TAG = "MypageActivity";
    Button mypage_btn;
    Button asset_btn;
    Button type_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // 툴바 글씨 설정
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_text);
        Log.d(this.getClass().getName(), (String)toolbar_text.getText());
        toolbar_text.setText("마이페이지");

        mypage_btn = (Button)findViewById(R.id.mypage_btn);
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });

        asset_btn = (Button)findViewById(R.id.asset_btn);
        asset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AssetActivity.class);
                startActivity(intent);
            }
        });

        type_btn = (Button)findViewById(R.id.type_btn);
        type_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TypeActivity0.class);
                startActivity(intent);
            }
        });
        Button product_btn = (Button)findViewById(R.id.product_btn);
        product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                startActivity(intent);
            }
        });

        // 성향 테스트 결과 보여주기
        TextView test_res_text = findViewById(R.id.test_res_text);

        Intent secondIntent = new Intent(this.getIntent());

        String message = secondIntent.getStringExtra("test_result");
        if(message!=null){
            test_res_text.setText(message);
        }else{
            test_res_text.setText("아래의 버튼을 눌러 성향을 평가해보세요!");
        }

    }
}