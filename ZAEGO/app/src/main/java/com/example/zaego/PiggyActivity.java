package com.example.zaego;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class PiggyActivity extends Activity {
    InputMethodManager imm;
    LinearLayout mainLayout;
    EditText entry_money;
    EditText account_number;
    EditText account_number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piggy);
        entry_money = (EditText)findViewById(R.id.entry_money);
        account_number = (EditText)findViewById(R.id.account_number);
        account_number2 = (EditText)findViewById(R.id.account_number2);

        mainLayout = (LinearLayout) findViewById(R.id.linear1);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(entry_money.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(account_number.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(account_number2.getWindowToken(), 0);
            }
        });

        ImageView back_btn = (ImageView)findViewById(R.id.back_btn);
        back_btn.setClickable(true);
        back_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), AssetActivity.class);
                startActivity(intent);
            }
        });

        Button assign_pig = (Button)findViewById(R.id.assign_pig);
        assign_pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가입되었습니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AssetActivity.class);
                int number1 = Integer.parseInt(entry_money.getText().toString()); //edittext값 가져오기(xml->java)
                intent.putExtra("pig", number1);
                startActivity(intent);
            }
        });

    }
}
