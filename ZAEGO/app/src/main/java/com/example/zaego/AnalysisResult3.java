package com.example.zaego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class AnalysisResult3 extends AppCompatActivity {
    ImageButton back_btn;
    private Button bnt_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_result3);

        // 툴바 글씨 설정
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_text);
        Log.d(this.getClass().getName(), (String)toolbar_text.getText());
        toolbar_text.setText("결과확인");

        bnt_again = findViewById(R.id.bnt_again);
        bnt_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisResult3.this, TypeActivity0.class);
                startActivity(intent);
            }
        });

        back_btn = (ImageButton) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                // 이미지 전송
//                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.woni);
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
//                intent.putExtra("image",byteArray);
                intent.putExtra("image","res/drawable/woni");

                // 텍스트 전송
                intent.putExtra("test_result","원이와 같은 안정,수익 추구형이군요!");
                startActivity(intent);
            }
        });
    }
}