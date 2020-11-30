// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.CreatePost;

public class Post {
    private long id;
    private String userName;
    private String title;
    private String content;

    public Post(long id, String userName, String title, String content) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
