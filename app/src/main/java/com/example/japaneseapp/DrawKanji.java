package com.example.japaneseapp;

import static com.example.japaneseapp.Drawing.paintlist;
import static com.example.japaneseapp.Drawing.pathlist;

import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class DrawKanji extends AppCompatActivity {
    public static Path path = new Path();

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_kanji);

        button=findViewById(R.id.clear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathlist.clear();
                paintlist.clear();
                path.reset();
            }
        });
    }
}