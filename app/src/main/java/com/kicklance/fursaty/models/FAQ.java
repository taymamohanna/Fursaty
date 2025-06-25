package com.kicklance.fursaty.models;


public class FAQ {
    private final int id;
    private final String title;
    private final String description;

    public FAQ(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
