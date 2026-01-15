package com.eapl.excellence.request;

public class UpdateServiceRequest {

    private String title;
    private String description;
    private String icon;
    private String color;
    private String features;

    // Constructors
    public UpdateServiceRequest() {
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

    // Helper method to check if any field is set
    public boolean isEmpty() {
        return title == null && description == null && 
               icon == null && color == null && features == null;
    }

    @Override
    public String toString() {
        return "UpdateServiceRequest [title=" + title + ", description=" + description + ", icon=" + icon
                + ", color=" + color + ", features=" + features + "]";
    }
}