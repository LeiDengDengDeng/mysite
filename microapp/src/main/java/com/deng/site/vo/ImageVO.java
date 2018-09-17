package com.deng.site.vo;

import lombok.Data;

/**
 * Created by deng on 2018/5/18.
 */
@Data
public class ImageVO {
    private String description;
    private String url;

    public ImageVO(String description, String url) {
        this.description = description;
        this.url = url;
    }
}
