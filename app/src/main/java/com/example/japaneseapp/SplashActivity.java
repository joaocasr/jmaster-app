package com.example.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler;
    private  Runnable mRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mRunnable= new Runnable() {
            @Override
            public void run() {

                Intent i =new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        };
    mHandler = new Handler();
    mHandler.postDelayed(mRunnable,3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler!=null && mRunnable !=null)
            mHandler.removeCallbacks(mRunnable);
    }
}