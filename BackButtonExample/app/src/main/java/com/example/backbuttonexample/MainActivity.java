package com.example.backbuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if(0 <= gapTime && 2000 >= gapTime){
            super.onBackPressed();
        }else{
            backBtnTime = curTime;
            Toast.makeText(this, "한 번 ㄴ더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

    }
}