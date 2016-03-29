package com.example.downloadimage.gsonparsor.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by NovoInvent2 on 3/29/2016.
 */
public class Post {
    public String body;
    public String date;
    private String preview;
    public String title;
    public String url;
    public String author;
    public int id;

    //public List tags;

    public Post() {

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
