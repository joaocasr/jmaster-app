package com.example.japaneseapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.japaneseapp.R;
import com.example.japaneseapp.TranslationsActivity;
import com.example.japaneseapp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    ImageView story1;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_gallery, container,
                false);

        story1= (ImageView)rootView.findViewById(R.id.story1);

        story1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GalleryFragment.this.getActivity(), TranslationsActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
    }
}