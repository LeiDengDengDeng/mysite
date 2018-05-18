package com.deng.dao;

import com.deng.bean.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by deng on 2018/5/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageDaoTest {
    @Autowired
    private ImageDao imageDao;

    @Test
    public void addImage() throws Exception {
        for (int i = 1; i <= 9; i++) {
            imageDao.addImage(new Image("示例图片" + i, i + ".jpg"));
        }
    }

}