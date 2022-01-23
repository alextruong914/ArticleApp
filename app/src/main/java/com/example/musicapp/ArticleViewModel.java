package com.example.musicapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class ArticleViewModel extends AndroidViewModel {
    private ArticleDao articleDao;

    private ArticleRepository mRepository;

    private final LiveData<List<ArticleEntity>> mAllArticles;

    public ArticleViewModel (Application application) {
        super(application);
        mRepository = new ArticleRepository(application);
        mAllArticles = mRepository.getAllArticles();
    }

    LiveData<List<ArticleEntity>> getAllWords() { return mAllArticles; }

    public void insert(ArticleEntity article) { mRepository.insert(article); }
    public LiveData<List<ArticleEntity>> allArticles() {
        return articleDao.getAll();
    }

    public LiveData<ArticleEntity> articleForId(int id) {
        return articleDao.getById(id);
    }

}
//
//class ArticleViewModelFactory implements ViewModelProvider.Factory {
//    //<T : ViewModel> create(modelClass: Class<T>): T
//    private ArticleDao articleDao;
//    public ArticleViewModelFactory(ArticleDao articleDao) {
//        this.articleDao = articleDao;
//    }
//
//
//
//    public <T extends ViewModel> T create(Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
////            @Suppress("UNCHECKED_CAST")
//            return (T) new ArticleViewModel(articleDao);
//        }
//        throw new IllegalArgumentException("Unknown ViewModel class");
//    };
//}
