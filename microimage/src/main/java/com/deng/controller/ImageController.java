package com.deng.controller;

import com.deng.bean.Image;
import com.deng.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by deng on 2018/5/18.
 */
@RestController
@RequestMapping(value = "/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Image> generate() {
        return imageService.getAllImages();
    }
}
