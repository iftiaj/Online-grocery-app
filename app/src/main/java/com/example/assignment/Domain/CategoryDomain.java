package com.example.assignment.Domain;

public class CategoryDomain {
    private String title;
    private String pics;

    public CategoryDomain(String title, String pics) {
        this.title = title;
        this.pics = pics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getpics() {
        return pics;
    }

    public void setpics(String pics) {
        this.pics = pics;
    }
}
