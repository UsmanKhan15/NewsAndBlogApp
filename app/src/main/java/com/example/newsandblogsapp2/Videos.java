package com.example.newsandblogsapp2;

public class Videos {
    private String videoCategory;
    private String videoTitle;
    private String videoURL;

    public Videos(String videoCategory, String videoTitle, String videoURL) {
        this.videoCategory = videoCategory;
        this.videoTitle = videoTitle;
        this.videoURL = videoURL;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "videoCategory='" + videoCategory + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoURL='" + videoURL + '\'' +
                '}';
    }
}
