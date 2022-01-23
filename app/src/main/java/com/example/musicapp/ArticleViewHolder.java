package com.example.musicapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    private final TextView articleItemView;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        articleItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text){
        articleItemView.setText(text);
    }

    static ArticleViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        return new ArticleViewHolder(view);
    }
}
