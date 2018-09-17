package com.deng.site.controller;

import com.deng.site.service.ImageService;
import com.deng.site.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by deng on 2018/5/18.
 */
@Controller
@RequestMapping(value = "/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<ImageVO> generate() {
        return imageService.getAllImages();
    }
}
