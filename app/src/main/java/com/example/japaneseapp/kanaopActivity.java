package com.example.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kanaopActivity extends AppCompatActivity {
    private Button buttonStartQuiz,buttonStartkatakana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanaop);

        buttonStartQuiz = (Button) findViewById(R.id.button_start_quiz);
        buttonStartkatakana= (Button) findViewById(R.id.button_start_katakana);


        buttonStartkatakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startKatakanaquiz();}
        });

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });
    }

    private  void startKatakanaquiz(){
        Intent intent = new Intent(kanaopActivity.this, KatakanaquizActivity.class);
        startActivity(intent);
    }

    private void startQuiz(){
        Intent intent = new Intent(kanaopActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}