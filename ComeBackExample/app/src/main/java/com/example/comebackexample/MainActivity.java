package com.example.comebackexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv_comeback;
    private Button btn_go;
    private static final int REQUEST_CODE = 7; //상수값 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_comeback = findViewById(R.id.tv_comeback);
        btn_go = findViewById(R.id.btn_go);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), "수신 성공", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "수신 실패", Toast.LENGTH_SHORT).show();
        }

        if(requestCode == REQUEST_CODE){
            String resultText = data.getStringExtra("comeback");
            tv_comeback.setText(resultText);
        }
    }
}