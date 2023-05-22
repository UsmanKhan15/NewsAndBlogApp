package com.example.newsandblogsapp2;

public class Science {
    private int id;
    private String catagory, title, authorName, shortDesc, longDesc, imgUrl;

    public Science(int id, String catagory, String title, String authorName, String shortDesc, String longDesc, String imgUrl) {
        this.id = id;
        this.catagory = catagory;
        this.title = title;
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
        return "Science{" +
                "id=" + id +
                ", catagory='" + catagory + '\'' +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
