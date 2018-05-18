package com.deng.bean;

import lombok.Data;

@Data
public class Image {
    private int id;
    private String description;
    private String fileName;

    public Image(String description, String fileName) {
        this.description = description;
        this.fileName = fileName;
    }

    public Image(int id, String description, String fileName) {
        this.id = id;
        this.description = description;
        this.fileName = fileName;
    }
}
