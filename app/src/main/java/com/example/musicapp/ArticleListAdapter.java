package com.example.musicapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ArticleListAdapter extends ListAdapter<ArticleEntity, ArticleViewHolder> {
    public ArticleListAdapter(@NonNull DiffUtil.ItemCallback<ArticleEntity> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ArticleViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        ArticleEntity current = getItem(position);
        //Update to get some more data (display image behind etc.)
        holder.bind(current.getHeading());
    }

    static class ArticleDiff extends DiffUtil.ItemCallback<ArticleEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull ArticleEntity oldItem, @NonNull ArticleEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ArticleEntity oldItem, @NonNull ArticleEntity newItem) {
            return oldItem.getHeading().equals(newItem.getHeading());
        }
    }
}
