package com.example.musicapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicapp.databinding.ArticleScrollingBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ArticleActivity extends AppCompatActivity {

    private ArticleScrollingBinding binding;
//    private ContentScrollingBinding contentBinding;
    private ListView articleList;

    private ArrayList<String> arrHeadings;
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
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ArticleListAdapter adapter = new ArticleListAdapter(new ArticleListAdapter.ArticleDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ScrapeWebsiteTask runTask = new ScrapeWebsiteTask();
//        runTask.execute();
//
//        ArrayList<Article> articles = null;
//
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
//        TextView textView = binding.textView56;
//        textView.setText(articles.get(0).heading);

//        ListView articleList = binding.articleList;

        // Create an ArrayList of just the headings from articles

//        arrHeadings = new ArrayList<>();
//        for (Article arr:articles)
//        {
//            arrHeadings.add(arr.heading);
//        }
        // For loop over all of the articles
        // Use .add to add a new textView to the articleList and setup the correct onClick event below

        // articleList.addView();

//        for (Article arr:articles) {
//            TextView textView = (TextView) findViewById(R.id.tv_Heading);
//            //textView.setText(arr.heading);
//            //articleList.addView(textView);
//        }
        //
        CustomArrayAdapter itemsAdapter = new CustomArrayAdapter(this, R.layout.item_listview,arrHeadings);
//        ListView listView = (ListView) findViewById(R.id.articleList);

//        listView.setAdapter(itemsAdapter);

//        ArrayList<Article> finalArticles = articles;
//        articleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                Intent intentPage = new Intent(ArticleActivity.this, PageActivity.class);
//                // This is designed to pass specific data to one activity, however we want a general purpose cache for the whole app
//                // All of the activities should have access, and it won't change based on the application state
//                intentPage.putExtra("article", (Parcelable) finalArticles.get(position));
//
//                ArticleActivity.this.startActivity(intentPage);
//                Log.i("Content", "Started page layout");
//            }
//        });
//        View.OnClickListener handler = new View.OnClickListener(){
//            public void onClick(View v) {
//                if (v==textView) {
//                    Intent intentPage = new Intent(ArticleActivity.this, PageActivity.class);
//                    intentPage.putExtra("article", (Parcelable) finalArticles.get(0));
//
//                    ArticleActivity.this.startActivity(intentPage);
//                    Log.i("Content", "Started page layout");
//                }
//            }
//        };
//        textView.setOnClickListener(handler);
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