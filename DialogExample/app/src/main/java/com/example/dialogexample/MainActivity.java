package com.example.dialogexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_dialog;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("제목");
                ad.setMessage("종료하시겠습니까?");

                //다이얼로그에 edittext 추가
                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String result = et.getText().toString();
                        tv_result.setText(result);
                        dialogInterface.dismiss(); //다이얼로그 종료

                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                ad.show();

            }
        });

    }
}