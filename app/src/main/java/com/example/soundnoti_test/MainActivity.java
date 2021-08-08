package com.example.soundnoti_test;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 변수 선언
    Button btn_rh;
    Button btn_lh;
    TextView view_txt;

    MediaPlayer mediaPlayer;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 선언
        btn_lh = (Button)findViewById(R.id.btn_left);
        btn_rh = (Button)findViewById(R.id.btn_right);
        view_txt = (TextView) findViewById(R.id.view_txt);


        // LEFT Button 눌렸을 때 동작 정의
        btn_lh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Text View 에 표시
                view_txt.setText("LEFT Pushed!!!");

//                // 다른 항목 재생 중일 때 중단
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }

                // Media Player 재생
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.tendirect);
                mediaPlayer.start();

            }
        });

        // Right Button 눌렸을 때 동작
        btn_rh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Text View 에 표시
                view_txt.setText("RIGHT pushed!!!");

//                // 다른 항목 재생 중일 때 중단
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }

                // Media Player 재생
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.twodirect);
                mediaPlayer.start();
              }
        });
    }
}