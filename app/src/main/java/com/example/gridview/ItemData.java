package com.example.gridview;

import java.util.List;

public class ItemData {
    private List<Integer> imageUrls; // ImageSlider için resim URL'leri
    private String description;    // Açıklama metni

    // Constructor
    public ItemData(List<Integer> imageUrls, String description) {
        this.imageUrls = imageUrls;
        this.description = description;
    }

    // Getter'lar
    public List<Integer> getImageUrls() {
        return imageUrls;
    }

    public String getDescription() {
        return description;
    }

    // Setter'lar
    public void setImageUrls(List<Integer> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString
    @Override
    public String toString() {
        return "ItemData{" +
                "imageUrls=" + imageUrls +
                ", description='" + description + '\'' +
                '}';
    }
}

