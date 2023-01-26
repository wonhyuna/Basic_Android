package com.example.lifecycleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//Activity launched -> onCreate() -> onStart() -> onResume() -> Activity running
    @Override
    //액티비티 또는 프래그먼트가 생성 되었을 때
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate", "ENTER");

        findViewById(R.id.btn_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> sub
                startActivity(new Intent(MainActivity.this, SubActivity.class));
            }
        });
    }

    @Override
    //화면에 보이기 직전에 호출
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "ENTER");
    }

    @Override
    //중지되었던 액티비티가 다시 실행할 때 OR 화면 상에 보여지고 있고 다른 작동이 없을 때
   protected void onResume() {
        super.onResume();
        Log.e("onResume", "ENTER");
    }

    @Override
    //중지 상태일 때 (홈 버튼 클릭해서 바깥으로 잠깐 빠져나갔을 때, 다른 액티비티가 활성화 되어 있을 때 -> 빠져나가고 있을 때)
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "ENTER");
    }

    @Override
    //기존 액티비티가 완전히 보여지는 상태까지 되었을 때
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "ENTER");
    }

    //onPause() -> onStop() -> onDestory() 순으로 소멸됨
    //onStop() 였던 건 다시 재개되면 onRestart() -> onStart()
    //onPause() 였던 건 다시 재개되면 onResume()

    @Override
    //화면이 파괴되어서 소멸했을 때 (A -> B로 갔다가 B에서 뒤로가기 버튼 누르면 B는 destroy됨)
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "ENTER");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "ENTER");
    }
}