package com.deng.site.service.impl;

import com.deng.site.service.ImageService;
import com.deng.site.vo.ImageVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deng on 2018/5/18.
 */
@Service
@PropertySource(value = {"classpath:application.properties"}, encoding = "utf-8")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${gateway.url}")
    private String gateway;

    @Override
    public List<ImageVO> getAllImages() {
        List<ImageVO> imageVOs = new ArrayList<>();

        String url = "http://MICROIMAGE/images/getAll";
        String result = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonRes = objectMapper.readTree(result);
            for (int i = 0; i < jsonRes.size(); i++) {
                JsonNode jsonNode = jsonRes.get(i);
                String description = jsonNode.path("description").asText();
                String imageUrl = gateway + "/microimage/images/" + jsonNode.path("fileName").asText() + "/get";
                imageVOs.add(new ImageVO(description, imageUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageVOs;
    }
}
