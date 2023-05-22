package com.example.newsandblogsapp2;

public class NewsAndArticles {
    private int id;
    private String catagory, title, sourceName, authorName, shortDesc, longDesc, imgUrl;

    public NewsAndArticles(int id, String catagory, String title, String sourceName, String authorName, String shortDesc, String longDesc, String imgUrl) {
        this.id = id;
        this.catagory = catagory;
        this.title = title;
        this.sourceName = sourceName;
        this.authorName = authorName;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "NewsAndArticles{" +
                "id=" + id +
                ", catagory='" + catagory + '\'' +
                ", title='" + title + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
