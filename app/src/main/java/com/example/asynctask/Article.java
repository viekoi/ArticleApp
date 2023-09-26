package com.example.asynctask;

public class Article {
    private int article_id;
    private String article_title;
    private String article_image;
    private String getArticle_description;
    public Article(int article_id, String article_title, String article_image, String getArticle_description){
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_image = article_image;
        this.getArticle_description = getArticle_description;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public String getArticle_image() {
        return article_image;
    }

    public String getGetArticle_description() {
        return getArticle_description;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public void setArticle_image(String article_image) {
        this.article_image = article_image;
    }

    public void setGetArticle_description(String getArticle_description) {
        this.getArticle_description = getArticle_description;
    }
}
