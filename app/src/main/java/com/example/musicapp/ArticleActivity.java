package com.example.musicapp;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicapp.databinding.ArticleScrollingBinding;
import com.example.musicapp.databinding.ContentScrollingBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ArticleActivity extends AppCompatActivity {

    private ArticleScrollingBinding binding;
//    private ContentScrollingBinding contentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Tag", "Test print");
        binding = ArticleScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        contentBinding = ContentScrollingBinding.inflate(getLayoutInflater());
//        setContentView(contentBinding.getRoot());
//        TextView textview = contentBinding.textview;
        //Toolbar toolbar = binding.toolbar;
        //setSupportActionBar(toolbar);
        //CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        //toolBarLayout.setTitle(getTitle());

        //FloatingActionButton fab = binding.fab;
        ScrapeWebsiteTask runTask = new ScrapeWebsiteTask();
        runTask.execute();

        ArrayList<Article> articles = null;
        try {
            articles = runTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Article a:articles){
            System.out.println("--------------=------------");
            System.out.println(a);
//                    textview.setText(a.toString());
        }
        //new DownloadImageTask((ImageView) findViewById(R.id.imageView)).execute(articles.get(2).image);
//        Snackbar.make(view, articles.get(0).toString(), Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
        // On create, setup the first box to have some data in it
        // First lets just get one, in the future we can make it do all of them automatically
        // Then, we can make it click to another view after clicking on this one.
        TextView textView = binding.textView47;
        textView.setText(articles.get(2).heading);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}