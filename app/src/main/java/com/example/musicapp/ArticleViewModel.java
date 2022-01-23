package com.example.musicapp;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class ArticleViewModel extends ViewModel {
    private ArticleDao articleDao;
    public ArticleViewModel(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<Article> allArticles() {
        return articleDao.getAll();
    }

    public List<Article> articleForId(int id) {
        return articleDao.getById(id);
    }

}

class ArticleViewModelFactory implements ViewModelProvider.Factory {
    //<T : ViewModel> create(modelClass: Class<T>): T
    private ArticleDao articleDao;
    public ArticleViewModelFactory(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }



    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
//            @Suppress("UNCHECKED_CAST")
            return (T) new ArticleViewModel(articleDao);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    };
}
