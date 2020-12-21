package com.example.zaego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class AssetActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    Button mypage_btn;
    Button asset_btn;
    Button save_btn;
    Button enter_piggy;

    // PPartasian
    private TextView mLowLabel;
    private BarView mLowBar;

    // 금액 입력 시 단위 표시(,)
    TextView now_money_et;
    EditText aim_money_et;
    TextView piggy_bank_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset);

        mLowBar = (BarView) findViewById(R.id.low_bar);
        mLowLabel = (TextView) findViewById(R.id.percent_text);

        // 툴바 글씨 설정
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_text);
        Log.d(this.getClass().getName(), (String)toolbar_text.getText());
        toolbar_text.setText("자산관리");

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

        // 금액 단위 표시(,)
        now_money_et = (TextView)findViewById(R.id.now_money_et);
        aim_money_et = (EditText)findViewById(R.id.aim_money_et);
        piggy_bank_et = (TextView)findViewById(R.id.piggy_bank_et);

        aim_money_et.addTextChangedListener(new NumberTextWatcher(aim_money_et));

        // DB에서 현재 자산 추출하기
        int money = 30000;
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String won1 = myFormatter.format(money);
        now_money_et.setText(won1);

        // DB에서 저금통 자산 추출하기
        Intent intent = new Intent(this.getIntent());
        int piggy = intent.getIntExtra("pig", 0);
//        int piggy = 10000;
        String won2 = myFormatter.format(piggy);

        piggy_bank_et.setText(won2);
        save_btn = (Button) findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(AssetActivity.this, "저장버튼이 눌려 수정이 불가합니다.", Toast.LENGTH_SHORT).show();
                aim_money_et.setEnabled(false);

                String s1 = aim_money_et.getText().toString().replaceAll("\\,",""); //edittext값 가져오기(xml->java)
                double dTemp = Double.parseDouble(s1.trim());

                // Some sample percentage values
                double cal_percent = ((money+piggy)/dTemp)*100;
                // 계산했을때 100넘으면 100으로 만들어주는 코드 추가하기

                // PPartasian
                mLowBar.set(Color.rgb(0, 177, 64), cal_percent);
                mLowLabel.setText(getPercentage(cal_percent));
            }
        });


        enter_piggy = (Button)findViewById(R.id.enter_piggy);
        enter_piggy.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //가입화면으로 연결
                Intent intent = new Intent(getApplicationContext(), PiggyActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
                startActivity(intent);
            }
        });
    }
    private String getPercentage(double per) {
        return per + "%";
    }
}