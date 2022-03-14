package com.example.japaneseapp;

public class Music {

    String questao;
    int imagem;
    int audioSource;

    public Music(String questao, int imagem, int audioSource) {
        this.questao = questao;
        this.imagem = imagem;
        this.audioSource = audioSource;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getAudioSource() {
        return audioSource;
    }

    public void setAudioSource(int audioSource) {
        this.audioSource = audioSource;
    }
}