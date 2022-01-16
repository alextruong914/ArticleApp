package com.example.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.net.URI;


public class Article implements Parcelable {
    // Here we can create the object with all the fields for an article!
    // now an article just contains the data and some very basic operations that an article can do
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
    // Heading
    public String heading;
    // Link
    public String link;
    // Time posted
    // -- What type should this be?
    public String timePosted;
    // Content
    // -- This string might have heaps and heaps of text!
    public String content;
    // An image from the page
    // -- This is just a string for now
    public String image;
    // A constructor for the class


    @Override
    public String toString() {
        return "Article{"+
                "heading: " + this.heading + "\nLink: " + link + "\nTime Posted: " + timePosted + "\nContent: " + content + "\nImage: " + image;
    }


    public Article(String heading, String link, String timePosted, String content, String image) throws IOException, InterruptedException {
        this.heading = heading;
        this.link = link;
        this.timePosted = timePosted;
        this.content = content;
        this.image = image;
    }

    public Article(Parcel in){
        this.heading = in.readString();
        this.link = in.readString();
        this.content = in.readString();
        this.image = in.readString();
        this.timePosted = in.readString();

    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.heading);
        parcel.writeString(this.link);
        parcel.writeString(this.content);
        parcel.writeString(this.image);
        parcel.writeString(this.timePosted);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
