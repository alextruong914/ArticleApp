package com.example.musicapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicapp.databinding.ArticleScrollingBinding;
import com.example.musicapp.databinding.Page1Binding;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class PageActivity extends AppCompatActivity {

    private Page1Binding binding;
//    private ContentScrollingBinding contentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Tag", "Test print");
        binding = Page1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");


        TextView title = (TextView) findViewById(R.id.title1);
        title.setText(article.heading);
        title.setMovementMethod(new ScrollingMovementMethod());
        TextView heading = binding.articleHeading;
        heading.setText(article.heading);

        new DownloadImageTask((ImageView) findViewById(R.id.articleImage))
                .execute(article.image);
        Button backButton = binding.backButton;

        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v) {
                if (v==backButton) {
                    Intent intentPage = new Intent(PageActivity.this, ArticleActivity.class);


                    PageActivity.this.startActivity(intentPage);
                    Log.i("Content", "Started page layout -> article");
                }
            }
        };
        backButton.setOnClickListener(handler);

//        contentBinding = ContentScrollingBinding.inflate(getLayoutInflater());
//        setContentView(contentBinding.getRoot());
//        TextView textview = contentBinding.textview;
        //Toolbar toolbar = binding.toolbar;
        //setSupportActionBar(toolbar);
        //CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        //toolBarLayout.setTitle(getTitle());

        //FloatingActionButton fab = binding.fab;
//        ScrapeWebsiteTask runTask = new ScrapeWebsiteTask();
//        runTask.execute();
//
//        ArrayList<Article> articles = null;
//        try {
//            articles = runTask.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for (Article a:articles){
//            System.out.println("--------------=------------");
//            System.out.println(a);
////                    textview.setText(a.toString());
//        }
        //new DownloadImageTask((ImageView) findViewById(R.id.imageView)).execute(articles.get(2).image);
//        Snackbar.make(view, articles.get(0).toString(), Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
        // On create, setup the first box to have some data in it
        // First lets just get one, in the future we can make it do all of them automatically
        // Then, we can make it click to another view after clicking on this one.
//        TextView heading = binding.articleHeading;
        //heading.setText(article.heading);
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

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}