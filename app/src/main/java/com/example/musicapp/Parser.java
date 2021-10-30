package com.example.musicapp;

import java.io.IOException;
import java.util.ArrayList;

public interface Parser {
    ArrayList<Article> parse() throws IOException, InterruptedException;
}
