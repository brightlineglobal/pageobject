package com.nopcommerce.tests;

import com.nopcommerce.base.*;
import com.nopcommerce.utils.*;
import org.testng.*;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void validatePageTitleTest(){
     // String pageTitle = homePage.getPageTitle();
        Assert.assertEquals(homePage.getPageTitle(), Constants.PAGE_TITLE);
    }

    @Test(priority = 2)
    public void verifyLogoTest(){
       // boolean logoStatus = homePage.verifyLogo();
        Assert.assertTrue(homePage.verifyLogo());
    }

    @Test(priority = 3)
    public void verifyRegisterLinkTest(){
        Assert.assertTrue(homePage.verifyRegisterLink());
    }

    @Test(priority = 4)
    public void verifyLoginLinkTest(){
        Assert.assertTrue(homePage.verifyLoginLin());
    }

}
