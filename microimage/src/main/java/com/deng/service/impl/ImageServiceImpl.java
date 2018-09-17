package com.deng.service.impl;

import com.deng.bean.Image;
import com.deng.dao.ImageDao;
import com.deng.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by deng on 2018/5/18.
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public List<Image> getAllImages() {
        return imageDao.getAllImages();
    }

    @Override
    public int addImage(Image image) {
        return imageDao.addImage(image);
    }
}
