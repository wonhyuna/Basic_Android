package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //초기화
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(false); //반복재생 false
    }


    //시작
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }


    //종료
    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
    }
}
