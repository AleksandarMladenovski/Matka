package com.extremedesign.matka.model;

public class Exhibit {
    private String title;
    private int drawableImage;
    private String content;

    public Exhibit(String title, int drawableImage, String content) {
        this.title = title;
        this.drawableImage = drawableImage;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
