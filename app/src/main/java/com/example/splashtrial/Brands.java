package com.example.splashtrial;

public class Brands {
    private String BrandName;
    private String Category;
    private String Description;
    private int Thumbnail;

    public Brands() {
    }

    public Brands(String brandName, String category, String description, int thumbnail) {
        BrandName = brandName;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getBrandName() {
        return BrandName;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
