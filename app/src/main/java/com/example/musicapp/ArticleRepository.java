package com.example.musicapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ArticleRepository {
    private ArticleDao mArticleDao;

    ArticleRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mArticleDao = db.articleDao();
    }

}
