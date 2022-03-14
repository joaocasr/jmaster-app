package com.example.japaneseapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private List<Music> musicList;
    MediaPlayer mediaPlayer;

    public MusicAdapter(List<Music> lista) {
        this.musicList = lista;

    }

    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.release();
            mediaPlayer = null;
        }
    };


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //método que depois que o item desaparecem da tela, recupera a view do item dessa lista ao fazer scroll

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.songs_item_listview, parent, false);//caminho do layout da lista

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //exibe a visualizaçao/ posicao da lista
        Music music = musicList.get(position);

        holder.questao.setText(music.getQuestao());
        holder.imagem.setImageResource(music.getImagem());
        holder.playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(holder.itemView.getContext(), music.getAudioSource());
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        holder.pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView questao;
        ImageView imagem;
        ImageView playbtn, pausebtn;


        public MyViewHolder(@NonNull View itemView) {//vai retornar cada um dos items da lista do ficheiro xml
            super(itemView);

            questao = itemView.findViewById(R.id.questao);
            imagem = itemView.findViewById(R.id.image_ex);
            playbtn = itemView.findViewById(R.id.imageview_play);
            pausebtn = itemView.findViewById(R.id.imageview_stop);
        }
    }
}
