package com.eapl.excellence.request;

public class CreateServiceRequest {

    private String title;
    private String description;
    private String icon;
    private String color;
    private String features;

    // Constructors
    public CreateServiceRequest() {
    }

    public CreateServiceRequest(String title, String description, String icon, String color, String features) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.color = color;
        this.features = features;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "CreateServiceRequest [title=" + title + ", description=" + description + ", icon=" + icon
                + ", color=" + color + ", features=" + features + "]";
    }
}