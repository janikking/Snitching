package com.example.mysnitch;

import java.util.ArrayList;

public class Thread {

    private User user;

    private String title;
    private String content;
    private Media media;

    private int likes;
    private ArrayList<Comment> comments;

    public Thread(User user, String title, String content, Media media){
        this.setUser(user);
        this.setTitle(title);
        this.setContent(content);
        this.setMedia(media);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
