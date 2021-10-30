package com.example.musicapp;

import com.example.musicapp.Article;

import org.apache.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

//Change this so that we implement the Parser interface

/*
public class OperateBMW760i implements OperateCar {

    // the OperateCar method signatures, with implementation --
    // for example:
    public int signalTurn(Direction direction, boolean signalOn) {
       // code to turn BMW's LEFT turn indicator lights on
       // code to turn BMW's LEFT turn indicator lights off
       // code to turn BMW's RIGHT turn indicator lights on
       // code to turn BMW's RIGHT turn indicator lights off
    }

    // other members, as needed -- for example, helper classes not
    // visible to clients of the interface
}
*/
public class RegexParser implements Parser {
    private HttpResponse response;

    private ArrayList<String> extractHeadings() throws IOException {


        URL url = new URL("https://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Document document = Jsoup.parse(in, "UTF-8", this.url);
            String htmlString = document.toString();
//            readStream(in);
            ArrayList<String> headings = new ArrayList<String>();
//        String str1 = response.body();
            String pattern1 = "<td class=\"title\"><a[^>]*>([^<]*)<\\/a>";


            Pattern p1 = Pattern.compile(pattern1);
            Matcher m1 = p1.matcher(htmlString);
            boolean b1 = m1.find();
            while (m1.find())
            {
                headings.add(m1.group(1));
            }
            return headings;
            //System.out.println("extractHeading");
            //System.out.println(m1.group(1)); // +1 is required because the first group is always the entire match.
        } finally {
            urlConnection.disconnect();
            return new ArrayList<>();
        }
        // using the parsed respsonse
    }

    private ArrayList<String> extractLinks() throws IOException {
        // using the parsed response
        URL url = new URL("http://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Document document = Jsoup.parse(in, "UTF-8", this.url);
            String htmlString = document.toString();
//            readStream(in);
            ArrayList<String> links = new ArrayList<String>();
            String pattern2 = "<td class=\\\"title\\\"><a href=\"([^\"]*).*\">[^<]*<\\/a>";

            Pattern p2 = Pattern.compile(pattern2);
            Matcher m2 = p2.matcher(htmlString);
            boolean b2 = m2.find();

            while (m2.find())
            {
                links.add(m2.group(1));
            }
            return links;
            //System.out.println("extractHeading");
            //System.out.println(m1.group(1)); // +1 is required because the first group is always the entire match.
        } finally {
            urlConnection.disconnect();
            return new ArrayList<>();
        }
        // using the parsed respsonse

        //System.out.println("extractHeading");
        //System.out.println(m1.group(1)); // +1 is required because the first group is always the entire match
    }

    private ArrayList<String> extractTimePosteds() throws IOException {
        // using the parsed respsonse
        URL url = new URL("http://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Document document = Jsoup.parse(in, "UTF-8", this.url);
            String htmlString = document.toString();
//            readStream(in);
            ArrayList<String> timePosted = new ArrayList<String>();

            // Do this for homework
            //System.out.println("Not Implemented");
            String pattern3 = "<span class=\\\"age\\\" title=\\\"([^\\\"]*).*\\\"><a href=\\\"([^\\\"]*).*\\\">[^<]*<\\/a><\\/span>";

            Pattern p3 = Pattern.compile(pattern3);
            Matcher m3 = p3.matcher(htmlString);
            boolean b3 = m3.find();

            while (m3.find())
            {
                timePosted.add(m3.group(1));
            }
            return timePosted;
            //System.out.println("extractHeading");
            //System.out.println(m1.group(1)); // +1 is required because the first group is always the entire match.
        } finally {
            urlConnection.disconnect();
            return new ArrayList<>();
        }

    }

    private String extractContent(String link) throws IOException, InterruptedException {
        // Do this for homework
        // Note, this one is harder because it will require you to do another HTTP get on this.link
        if (link == null) {
            throw new IOException("Link must not be null");
        }
    	/*
    	 * HttpClient myClient = HttpClient.newHttpClient();

        HttpRequest myRequest = HttpRequest.newBuilder()
            .uri(URI.create(this.link))
            .GET()
            .build();

        this.response = myClient.send(myRequest, HttpResponse.BodyHandlers.ofString());
    	 */
        URL url = new URL(link);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Document document = Jsoup.parse(in, "UTF-8", this.url);
            String htmlString = document.toString();
//            readStream(in);
            String pattern4 = "<meta [^=]*=\"(?:og:){0,1}description\" content=\"([^\"]*)\" ?\\/>";
            Pattern p4 = Pattern.compile(pattern4);
            Matcher m4 = p4.matcher(htmlString);
            boolean b4 = m4.find();
            if (b4==false) {
                return null;
            } else
                return m4.group(1);
            //System.out.println("extractHeading");
            //System.out.println(m1.group(1)); // +1 is required because the first group is always the entire match.
        } finally {
            urlConnection.disconnect();
            return null;
        }
//        try {
//            HttpClient myClient = HttpClient.newHttpClient();
//            HttpRequest myRequest = HttpRequest.newBuilder()
//                    .uri(URI.create(link))
//                    .GET()
//                    .build();
//            this.response = myClient.send(myRequest, HttpResponse.BodyHandlers.ofString());
//            String str4 = this.response.body();
//            // System.out.println(str4);
//            // String pattern4 = "<meta name=\\\"description\;\\" content=\\\"([^\\\"]*)\\\">";
//            String pattern4 = "<meta [^=]*=\"(?:og:){0,1}description\" content=\"([^\"]*)\" ?\\/>";
//            Pattern p4 = Pattern.compile(pattern4);
//            Matcher m4 = p4.matcher(str4);
//            boolean b4 = m4.find();
//            if (b4==false) {
//                return null;
//            } else
//                return m4.group(1);
//        }
//        catch (ConnectException e) {
//            System.out.println("Unable to resolve link: " + link);
//            return null;
//        }

    }

    private String extractImage(String link) throws IOException, InterruptedException {
        /* Can be the first image on the page */
        // This also needs to use the Get above in extractContent()
        //Do this for homework
        URL url = new URL(link);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Document document = Jsoup.parse(in, "UTF-8", this.url);
            String htmlString = document.toString();
//            readStream(in);
            String pattern5 = "\\\"([^\\\"]*(?:gif|png|jpg|webp))\\\"";
            Pattern p5 = Pattern.compile(pattern5);
            Matcher m5 = p5.matcher(htmlString);
            boolean b5 = m5.find();
            if (b5==false) {
                return null;
            } else
                return m5.group(1);
            //System.out.println("extractHeading");
            //System.out.println(m1.group(1)); // +1 is required because the first group is always the entire match.
        } finally {
            urlConnection.disconnect();
            return null;
        }
//        HttpClient myClient = HttpClient.newHttpClient();
//
//        HttpRequest myRequest = HttpRequest.newBuilder()
//                .uri(URI.create(link))
//                .GET()
//                .build();
//
//        this.response = myClient.send(myRequest, HttpResponse.BodyHandlers.ofString());
//        String str5 = this.response.body();
//        String pattern5 = "\\\"([^\\\"]*(?:gif|png|jpg|webp))\\\"";
//        Pattern p5 = Pattern.compile(pattern5);
//        Matcher m5 = p5.matcher(str5);
//        boolean b5 = m5.find();
//        if (b5==false) {
//            return null;
//        } else
//            return m5.group(1);
    }

    private String url;

    public RegexParser(String url) throws InterruptedException, IOException {
        // This is a constructor
        // Handle either the input string or go get a url
        this.url = url;

        // Get the url and resolve the HTML
        URL urlFile = new URL(this.url);
        HttpURLConnection urlConnection = (HttpURLConnection) urlFile.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Document document = Jsoup.parse(in, "UTF-8", this.url);
            String htmlString = document.toString();
        }
        finally {
            urlConnection.disconnect();
        }

    }

    public ArrayList<Article> parse() throws IOException, InterruptedException {
        // Parse all of the matches we can find, until we run out
        // System.out.println(response.body());

        // We will assume that the number of matches of all these is the same
        // If there are different numbers of matches, it will create errors!
        ArrayList<String> headings = extractHeadings();

        // Can you now implement the extractLinks function?
        ArrayList<String> links = extractLinks();
        // ArrayList<String> timePosteds = extractTimePosteds();

        // For Homework, complete these 3 remaining fields of the array list!
        // For content, it will be different because it only gets a single one.
        ArrayList<String> timePosted = extractTimePosteds();

        /*
        Now we will create a for loop to create many articles, instead of printing just the headings
        */
        ArrayList<Article> ar = new ArrayList<Article>();
        for (int i = 0; i<(links.size()-1); i++) {
            String content = extractContent(links.get(i));
            String image = extractImage(links.get(i));
            Article a = new Article(headings.get(i), links.get(i), timePosted.get(i), content, image);

            ar.add(a);
        }
        return ar;
    }

}
