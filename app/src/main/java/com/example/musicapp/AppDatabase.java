package com.example.musicapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ArticleEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "article_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ArticleDao dao = INSTANCE.articleDao();
//                dao.deleteAll();

                ArticleEntity article = new ArticleEntity(1,
                        "Test Heading",
                        "2021-11-12",
                        "Test Content",
                        "https://google.com",
                        "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimage.shutterstock.com%2Fimage-photo%2Fexample-word-written-on-wooden-260nw-1765482248.jpg&imgrefurl=https%3A%2F%2Fwww.shutterstock.com%2Fsearch%2Fexamples&tbnid=CdvratQTtn-B3M&vet=12ahUKEwifloX-o8f1AhVoJrcAHcgbARkQMygAegUIARCtAQ..i&docid=Q4lhnQGW7V_P3M&w=571&h=280&itg=1&q=example%20image&ved=2ahUKEwifloX-o8f1AhVoJrcAHcgbARkQMygAegUIARCtAQ" );
                dao.insert(article);
                article = new ArticleEntity(2,
                        "Test Heading 2",
                        "2022-11-12",
                        "Test Content 2",
                        "https://google.com/2",
                        "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimage.shutterstock.com%2Fimage-photo%2Fexample-word-written-on-wooden-260nw-1765482248.jpg&imgrefurl=https%3A%2F%2Fwww.shutterstock.com%2Fsearch%2Fexamples&tbnid=CdvratQTtn-B3M&vet=12ahUKEwifloX-o8f1AhVoJrcAHcgbARkQMygAegUIARCtAQ..i&docid=Q4lhnQGW7V_P3M&w=571&h=280&itg=1&q=example%20image&ved=2ahUKEwifloX-o8f1AhVoJrcAHcgbARkQMygAegUIARCtAQ" );

                dao.insert(article);
            });
        }
    };
}