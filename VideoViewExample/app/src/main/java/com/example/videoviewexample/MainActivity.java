package com.example.videoviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView; //비디오 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; //재생이나 정지 같은 미디어 제어 버튼부를 담당
    private String videoURL = "https://youtu.be/OBY1jDXF8QE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videoURL);
        videoView.setMediaController(mediaController); //미디어 제어 버튼부 세팅
        videoView.setVideoURI(uri); //비디오 뷰의 주소를 설정
        videoView.start(); //비디오 실행

    }
}