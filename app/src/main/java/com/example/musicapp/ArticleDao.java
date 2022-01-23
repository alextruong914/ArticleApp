package com.example.musicapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM article_table ORDER BY timePosted ASC")
    LiveData<List<Article>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Article article);

    @Query("DELETE FROM article_table")
    void deleteAll();

    @Query("SELECT * FROM article_table WHERE id = :id ORDER BY timePosted ASC")
    LiveData<Article> getById(int id);
}



