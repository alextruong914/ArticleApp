package com.example.musicapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;


public class ScrapeWebsiteTask extends AsyncTask<Void, Void, ArrayList<Article>> {


    public ScrapeWebsiteTask() {
        Log.d("Parsed Articles:", "Constructor called");
    }

    @Override
    protected ArrayList<Article> doInBackground(Void... unused) {
        ArrayList<Article> articles = null;
        try {
            Parser myParser = new JsoupArticleParser("https://news.ycombinator.com/");
            articles = myParser.parse();
        } catch (IOException | InterruptedException e) {
            Log.d("Parsing Exception: ", e.getMessage(), e);
        }
        return articles;
    }

    @Override
    protected void onPostExecute(ArrayList<Article> articles) {
        super.onPostExecute(articles);// Do something with the result.
        Log.d("Parsed Article result:", String.valueOf(articles));

    }
}

