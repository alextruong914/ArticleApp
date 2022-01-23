package com.example.musicapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ArticleRepository {
    private ArticleDao mArticleDao;
    private LiveData<List<ArticleEntity>> mAllArticles;

    ArticleRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mArticleDao = db.articleDao();
        mAllArticles = mArticleDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<ArticleEntity>> getAllArticles() {
        return mAllArticles;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(ArticleEntity article) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mArticleDao.insert(article);
        });
    }


}
