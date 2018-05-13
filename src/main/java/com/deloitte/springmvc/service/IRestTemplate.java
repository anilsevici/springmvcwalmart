package com.deloitte.springmvc.service;

public interface IRestTemplate {
    public <T> T getObject(String url , Class<T> clazz);
}
