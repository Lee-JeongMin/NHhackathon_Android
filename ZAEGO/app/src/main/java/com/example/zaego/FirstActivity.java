package com.example.zaego;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ImageView detailProduct = (ImageView)findViewById(R.id.nike1);
        detailProduct.setClickable(true);
        detailProduct.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
                startActivity(intent);
            }
        });
//        ImageView hotProduct = (ImageView)findViewById(R.id.hotitem);
//        hotProduct.setClickable(true);
//        hotProduct.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
//                startActivity(intent);
//            }
//        });
        Button product_btn = (Button)findViewById(R.id.product_btn);
        product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                startActivity(intent);
            }
        });
        Button mypage_btn = (Button)findViewById(R.id.mypage_btn);
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });

        Button asset_btn = (Button)findViewById(R.id.asset_btn);
        asset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AssetActivity.class);
                startActivity(intent);
            }
        });
    }

}