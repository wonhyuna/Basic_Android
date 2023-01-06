package com.example.debugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String and = "안드로이드";
        Log.e("MainActivity: ", and); //에러 로그 출력

        int a = 10;
        Log.e("MainActivity: ", String.valueOf(a));
    }
}