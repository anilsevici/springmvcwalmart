package com.deloitte.springmvc.service;

import com.deloitte.springmvc.util.WalMartApiConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WalMartApiService implements IWalMart {

    @Value("${walmart.api.search.url}")
    public String apiSearchEndPoint;

    @Value("${walmart.api.lookup.url}")
    public String apiLookupEndPoint;

    @Value("${walmart.api.review.url}")
    public String apiReviewEndPoint;

    @Value("${walmart.api.key}")
    public String apiKey;

    @Value("${walmart.api.category}")
    public String category;

    @Override
    public String getSearchRequestURL(String query, Integer start) {
        StringBuilder builder = new StringBuilder();

        builder.append(apiSearchEndPoint);
        builder.append("query=" + query);
        builder.append("&categoryId=" + category);
        builder.append("&start=" + start);
        builder.append("&apiKey=" + apiKey);

        return builder.toString();
    }

    @Override
    public String getApiRequestUrl(Enum endpoint , Long id) {
        StringBuilder builder = new StringBuilder();

        if(WalMartApiConstants.REVIEW.equals(endpoint))
            builder.append(apiReviewEndPoint);
        else{
            builder.append(apiLookupEndPoint);
        }

        builder.append(id + "?");
        builder.append("&apiKey=" + apiKey);

        return builder.toString();
    }
}
