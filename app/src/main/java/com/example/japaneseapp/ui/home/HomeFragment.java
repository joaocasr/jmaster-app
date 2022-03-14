package com.example.japaneseapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.japaneseapp.DicActivity;
import com.example.japaneseapp.DrawKanji;
import com.example.japaneseapp.NotepadActivity;
import com.example.japaneseapp.R;
import com.example.japaneseapp.kanaopActivity;
import com.example.japaneseapp.newdicActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private CardView card1,card2,card3 ,card4,card5;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.fragment_home, container,
                false);

        card1 = (CardView)rootView.findViewById(R.id.kanjicard);
        card2 = (CardView)rootView.findViewById(R.id.carddic);
        card3 = (CardView)rootView.findViewById(R.id.drawkanji);
        card4= (CardView)rootView.findViewById(R.id.cardnotepad);
        card5=(CardView)rootView.findViewById(R.id.kanapratice);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.cardnotepad:
                i = new Intent(this.getActivity(),NotepadActivity.class);
                startActivity(i);
                break;

            case R.id.carddic:
                i = new Intent(this.getActivity(), DicActivity.class);
                startActivity(i);
                break;

            case R.id.drawkanji:
                i = new Intent(this.getActivity(), DrawKanji.class);
                startActivity(i);
                break;

            case R.id.kanjicard:
                i = new Intent(this.getActivity(), newdicActivity.class);
                startActivity(i);
                break;

            case R.id.kanapratice:
                i=new Intent(this.getActivity(), kanaopActivity.class);
                startActivity(i);
                break;

        }
    }
}

