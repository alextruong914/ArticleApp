package com.example.musicapp;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ArticleEntity {
    @PrimaryKey
    int id;
    @NonNull
    @ColumnInfo(name = "heading")
    public String heading;
    @NonNull
    @ColumnInfo(name = "timePosted")
    public String timePosted;
    @NonNull
    @ColumnInfo(name = "content")
    public String content;
    @NonNull
    @ColumnInfo(name = "link")
    public String link;
    @NonNull
    @ColumnInfo(name = "image")
    public String image;

    public ArticleEntity(int id, @NonNull String heading, @NonNull String timePosted, @NonNull String content, @NonNull String link, @NonNull String image) {
        this.id = id;
        this.heading = heading;
        this.timePosted = timePosted;
        this.content = content;
        this.link = link;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getHeading() {
        return heading;
    }

    public void setHeading(@NonNull String heading) {
        this.heading = heading;
    }

    @NonNull
    public String getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(@NonNull String timePosted) {
        this.timePosted = timePosted;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    @NonNull
    public String getLink() {
        return link;
    }

    public void setLink(@NonNull String link) {
        this.link = link;
    }

    @NonNull
    public String getImage() {
        return image;
    }

    public void setImage(@NonNull String image) {
        this.image = image;
    }
}

