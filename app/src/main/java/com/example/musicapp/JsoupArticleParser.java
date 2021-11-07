package com.example.musicapp;

import android.util.Log;

import com.example.musicapp.Article;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.ArrayList;

//After installing JSoup, these will work
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class JsoupArticleParser implements Parser {
    String url;
    Document doc;

    public JsoupArticleParser(String url) throws IOException, MalformedURLException {
        this.url = url;
        this.doc = Jsoup.connect(this.url).get();
        Log.d("Article", this.doc.title()); // Print out "Hacker News"
    }

    private String extractImage(String link) throws IOException, MalformedURLException {
        String result = "";
        Document doc5 = Jsoup.connect(link).get();
        Elements images = doc5.select("img[src~=(?i)\\.(png|jpe?g|gif|webp)]");
        if (images.size() > 0) {
            //Homework: Change this so it only gets png, jpg, webp larger than a certain size in pixels.
            // For the next task, we may need to temporarily hardcode this image so that it gets a
            // nice png / jpg for us to use in the app.
            Element image = images.get(0);
//            result = link + "/" + image.attr("src");
            result = image.absUrl("src");
        }

        return result;
    }

    private String extractContent(String link) throws IOException, MalformedURLException {
        if (link == null) {
            throw new IOException("Link must not be null");
        }
        String result1 = "";
        try
        {
            if (link.contains(".pdf"))
                throw new MalformedURLException();
            else
            {
                Log.d("Article", link);
                Document doc4 = Jsoup.connect(link).get();
                Log.d("Article", "Got past the jsoup connect");
//                Elements content = doc4.select("meta[name=description]");
                Elements content = doc4.select("meta[property$=description]");
                Log.d("Article", String.valueOf(content));
                if (content.size() > 0) {
                    result1 = content.get(0).attr("content");
                }
            }}
        catch (MalformedURLException e) {
            System.out.println("Unable to resolve link: " + link);
            result1 = null;
        }
        return result1;
    }

    private ArrayList<String> extractTimePosteds() throws IOException {
        ArrayList<String> timePosteds = new ArrayList<String>();
        Elements timePosted = this.doc.getElementsByClass("age");
        for (Element time:timePosted)
        {
            timePosteds.add(time.attr("title"));
        }
        return timePosteds;
    }

    private ArrayList<String> extractLinks() throws IOException, MalformedURLException {
        ArrayList<String> links = new ArrayList<String>();


        Elements link = this.doc.getElementsByClass("titlelink");
        for (Element l: link) {
            links.add(l.attr("href"));
        }
        return links;
    }

    private ArrayList<String> extractHeadings() throws IOException {
        ArrayList<String> headings = new ArrayList<String>();
        Elements hd = this.doc.getElementsByClass("titlelink");

        for (Element e: hd) {

            headings.add(e.text());
        }
        return headings;
    }

    public ArrayList<Article> parse() throws IOException, InterruptedException {
        // this.doc = Jsoup.connect("https://news.ycombinator.com/").get();
        ArrayList<String> headings = extractHeadings();

        // Can you now implement the extractLinks function?
        ArrayList<String> links = extractLinks();
        // ArrayList<String> timePosteds = extractTimePosteds();

        // For Homework, complete these 3 remaining fields of the array list!
        // For content, it will be different because it only gets a single one.
        ArrayList<String> timePosted = extractTimePosteds();

        /*
         * Now we will create a for loop to create many articles, instead of printing
         * just the headings
         */
        ArrayList<Article> ar = new ArrayList<Article>();
//        for (int i = 0; i < (links.size() - 1); i++) {
        for (int i = 0; i < 5; i++) {
            String content = extractContent(links.get(i));
            String image = extractImage(links.get(i));
            Article a = new Article(headings.get(i), links.get(i), timePosted.get(i), content, image);

            ar.add(a);
        }
        return ar;
    }

}
