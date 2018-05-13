package com.deloitte.springmvc.controller;

import com.deloitte.springmvc.model.Item;
import com.deloitte.springmvc.model.WalMart;
import com.deloitte.springmvc.service.IRestTemplate;
import com.deloitte.springmvc.service.IWalMart;
import com.deloitte.springmvc.service.RestTemplateService;
import com.deloitte.springmvc.service.WalMartApiService;
import com.deloitte.springmvc.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IRestTemplate restTemplateService;

    @Autowired
    private IWalMart walMartApiService;

    @RequestMapping("/")
    public String index(Model model) {
        return "home";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, produces = {
            "application/json; charset=UTF-8"})
    @ResponseBody
    public String getProductList(@RequestParam("query") String query, Model model) {
        WalMart walMartPage1 = restTemplateService.getObject(walMartApiService.getSearchRequestURL(query, 1), WalMart.class);
        WalMart walMartPage2 = restTemplateService.getObject(walMartApiService.getSearchRequestURL(query, 11), WalMart.class);

        List<Item> items = new ArrayList<>();
        items.addAll(walMartPage1.getItems());
        items.addAll(walMartPage2.getItems());

        return JsonUtil.convertObjectToJsonString(items);
    }


}
