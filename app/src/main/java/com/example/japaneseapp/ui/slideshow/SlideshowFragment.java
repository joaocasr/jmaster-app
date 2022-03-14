package com.example.japaneseapp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaneseapp.Listening_scripts_activity;
import com.example.japaneseapp.Music;
import com.example.japaneseapp.MusicAdapter;
import com.example.japaneseapp.R;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    TextView qwords;
    private List<Music> musicList =  new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.fragment_slideshow, container,
                false);


        this.criarinstancia();
        MusicAdapter musicAdapter = new MusicAdapter(musicList);

        qwords = rootView.findViewById(R.id.keywords);
        qwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Listening_scripts_activity.class);
                startActivity(intent);
            }
        });


        recyclerView = rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(musicAdapter);

        return rootView;

    }
    public void  criarinstancia(){

        Music music = new Music("a) Question 1",R.drawable.audioim1,R.raw.lex1);
        musicList.add(music);

        music = new Music("b) Question 2",R.drawable.listening2,R.raw.lex2);
        musicList.add(music);

        music = new Music("c) Question 3",R.drawable.listening3,R.raw.lex3);
        musicList.add(music);

        music = new Music("d) Question 4",R.drawable.listeningex4,R.raw.lex4);
        musicList.add(music);

        music = new Music("e) Question 5",R.drawable.listeningex5,R.raw.lex5);
        musicList.add(music);

        music = new Music("f) Question 6",R.drawable.listeningex6,R.raw.lex6);
        musicList.add(music);

        music = new Music("g) Question 7",R.drawable.listeningex7,R.raw.lex7);
        musicList.add(music);

        music = new Music("h) Question 8",R.drawable.listeningex8,R.raw.lex8);
        musicList.add(music);

        music = new Music("i) Question 9",R.drawable.listeningex9,R.raw.lex9);
        musicList.add(music);

        music = new Music("j) Question 10",R.drawable.listeningex10,R.raw.lex10);
        musicList.add(music);

        music = new Music("k) Question 11",R.drawable.listeningex11,R.raw.lex11);
        musicList.add(music);

        music = new Music("l) Question 12",R.drawable.listeningex12,R.raw.lex12);
        musicList.add(music);

        music = new Music("m) Question 13",R.drawable.listeningex13,R.raw.lex13);
        musicList.add(music);

    }
}
