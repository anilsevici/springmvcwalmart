package com.deloitte.springmvc.service;

public interface IWalMart {
    public String getSearchRequestURL(String query, Integer start);
    public String getApiRequestUrl(Enum endpoint , Long id);
}
