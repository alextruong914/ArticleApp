package com.example.musicapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM article ORDER BY timePosted ASC")
    List<Article> getAll();
    @Query("SELECT * FROM article WHERE id = :id ORDER BY timePosted ASC")
    List<Article> getById(int id);
}



