package com.example.threadexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;
    Thread thread;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //버튼을 클릭했을 때 종료 버튼 클릭 전까지 5초마다 핸들러에서 만든 toast 메시지 띄움
                isThread = true;
                thread = new Thread(){
                  public void run(){
                      while(isThread){
                          try {
                              sleep(5000);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                          handler.sendEmptyMessage(0);
                      }
                  }
                };

                thread.start();
            }
        });

        //종료누르면서 while문 무력화시킴
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                isThread = false;
                
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(getApplicationContext(), "안드로이드 강의", Toast.LENGTH_SHORT).show();
        }
    };
}