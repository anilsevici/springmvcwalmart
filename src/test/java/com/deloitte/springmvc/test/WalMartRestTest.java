package com.deloitte.springmvc.test;


import com.deloitte.springmvc.config.RestTemplateConfig;
import com.deloitte.springmvc.model.Item;
import com.deloitte.springmvc.service.IRestTemplate;
import com.deloitte.springmvc.service.IWalMart;
import com.deloitte.springmvc.testconfig.TestConfig;
import com.deloitte.springmvc.util.WalMartApiConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class WalMartRestTest {

    @Autowired
    private IWalMart walMart;

    @Autowired
    private IRestTemplate restTemplate;


    @Test
    public void testRestTemplate() {
        System.out.println("----Start testRestTemplate----");
        Object o = restTemplate.getObject(walMart.getApiRequestUrl(WalMartApiConstants.LOOKUP, 23562858L), Item.class);

        Assert.assertTrue(o instanceof Item);

        System.out.println("----End testRestTemplate----");
    }

    @Test
    public void testResultRestTemplate() {
        System.out.println("----Start testResultRestTemplate----");
        Item item = restTemplate.getObject(walMart.getApiRequestUrl(WalMartApiConstants.LOOKUP, 23562858L), Item.class);

        Assert.assertEquals(item.getName(),"Go!Games Super Colossal Book of Sudoku : 365 Great Puzzles");

        System.out.println("----End testResultRestTemplate----");
    }
}
