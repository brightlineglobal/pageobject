package com.nopcommerce.pages;

import com.nopcommerce.base.*;
import com.nopcommerce.utils.*;
import org.openqa.selenium.*;

import java.util.*;

public class SearchPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By searchPageName = By.xpath("//div[@class='page-title']/h1");
    private By searchPageSearchField = By.id("q");
    private By advancedSearchCheckBox = By.id("adv");
    private By categoryDropdownList = By.id("cid");
    private By automaticallySearchCheckbox = By.id("isc");
    private By manufacturerDropDownList = By.id("mid");
    private By searchInProductCheckbox = By.id("sid");
    private By categoriesList = By.xpath("//div[@class='side-2']/div[1]/div[2]/descendant::a");
    private By manufacturessList = By.xpath("//div[@class='side-2']/div[2]/div[2]/descendant::a");

    public String getSearchPageName(){
        return elementUtil.doGetText(searchPageName);
    }

    public boolean verifyManufactureDropdownList() throws InterruptedException {
         Thread.sleep(2000);
        //elementUtil.waitForElementToBeClickable(advancedSearchCheckBox,10);
        elementUtil.doClick(advancedSearchCheckBox);
        Thread.sleep(2000);
        //elementUtil.waitForElementToBeClickable(manufacturerDropDownList,10);
        return elementUtil.compareDropdownOptions(manufacturerDropDownList,Constants.MANUFACTURE_DROPDOWN);
    }

    public List<String> getManufactureListItems(){
        List<String> manufacturesList = new ArrayList<String>();
        List<WebElement> manufactureListElements = elementUtil.getElements(manufacturessList);
        for(WebElement e : manufactureListElements){
            manufacturesList.add(e.getText());
        }
        return manufacturesList;
    }
}
