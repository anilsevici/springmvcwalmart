package com.deloitte.springmvc.controller;


import com.deloitte.springmvc.model.Item;
import com.deloitte.springmvc.model.Reviews;
import com.deloitte.springmvc.service.IRestTemplate;
import com.deloitte.springmvc.service.IWalMart;
import com.deloitte.springmvc.service.RestTemplateService;
import com.deloitte.springmvc.service.WalMartApiService;
import com.deloitte.springmvc.util.WalMartApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private IRestTemplate restTemplateService;

    @Autowired
    private IWalMart walMartApiService;

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET, produces = {
            "application/json; charset=UTF-8"})
    public String getProduct(@PathVariable("id") Long id, Model model) {
        Map productDetails = new HashMap();

        Item item = restTemplateService.getObject(walMartApiService.getApiRequestUrl(WalMartApiConstants.LOOKUP, id), Item.class);
        Reviews reviews = restTemplateService.getObject(walMartApiService.getApiRequestUrl(WalMartApiConstants.REVIEW, id), Reviews.class);

        productDetails.put("product", item);
        productDetails.put("reviews", reviews);

        model.addAttribute("productDetails", productDetails);

        return "product";

    }

}
