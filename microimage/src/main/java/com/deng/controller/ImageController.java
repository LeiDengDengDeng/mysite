package com.deng.controller;

import com.deng.bean.Image;
import com.deng.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by deng on 2018/5/18.
 */
@Controller
@RequestMapping(value = "/images")
@PropertySource(value = {"classpath:application.properties"}, encoding = "utf-8")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Value("${config.image.path}")
    private String imagesPath;
    @Value("${config.code}")
    private String code;

    @RequestMapping(value = "/{fileName:[a-zA-Z0-9\\.\\-\\_]+}/get", method = RequestMethod.GET)
    public void getImage(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imgPath = imagesPath + "/" + fileName;
        String imgType = fileName.substring(fileName.indexOf('.') + 1, fileName.length());
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");

        response.setContentType("image/" + imgType);

        BufferedImage bi = null;
        ServletOutputStream out = response.getOutputStream();

        try {
            bi = ImageIO.read(new File(imgPath));
            ImageIO.write(bi, imgType, out);
        } catch (IIOException e) {
            e.printStackTrace();
//            ImageIO.write(bi, "png", out);  // TODO:返回一个404图片
        } finally {
            try {
                out.flush();
            } finally {
                out.close();
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Image> getAll() {
        return imageService.getAllImages();
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("code") String code, @RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty() || !code.equals(this.code)) {
            return "true"; // 不允许返回boolean
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = "images_" + UUID.randomUUID() + "." + suffixName;
        String completePath = imagesPath + "/" + newFileName;

        imageService.addImage(new Image(description, newFileName));

        File dest = new File(completePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return "true";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "false";
    }
}
