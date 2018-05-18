package com.deng.dao;

import com.deng.bean.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao {
    int addImage(Image image);

    List<Image> getAllImages();
}
