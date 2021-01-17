package com.nopcommerce.tests;

import com.nopcommerce.base.*;
import com.nopcommerce.utils.*;
import org.testng.*;
import org.testng.annotations.*;

public class SearchPageTest extends BaseTest {

    @BeforeClass
    public void searchPageSetup(){
       searchPage =  homePage.deSearch(prop.getProperty("searchItem"));
    }

    @Test(priority = 1)
    public void verifySearchPageNameTest(){
        Assert.assertEquals(searchPage.getSearchPageName(), Constants.SEARCH_PAGE_NAME);
    }

    @Test(priority = 2)
    public void verifyManufacturerDropDownListTest() throws InterruptedException {
        Assert.assertTrue(searchPage.verifyManufactureDropdownList());
    }

    @Test(priority = 3)
    public void verifyManufacturesListTest(){
        Assert.assertEquals(searchPage.getManufactureListItems(),Constants.getManufacturesSectionList());
    }
}
