package com.deloitte.springmvc.service;


import com.deloitte.springmvc.config.RestTemplateConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class RestTemplateService implements IRestTemplate{

    @Resource(name = RestTemplateConfig.INSTANCE_BEAN)
    public RestTemplate restTemplate;


    @Override
    public <T> T getObject(String url , Class<T> clazz){
        return restTemplate.getForObject(url,clazz);
    }
}
