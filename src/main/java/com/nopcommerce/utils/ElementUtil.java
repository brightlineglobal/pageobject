package com.nopcommerce.utils;

import com.nopcommerce.base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.security.*;
import java.util.*;


public class ElementUtil {

    private WebDriver driver;
    private JavaScriptUtil jsUtil;

    public ElementUtil(WebDriver driver){
        this.driver = driver;
        jsUtil = new JavaScriptUtil(this.driver);
    }

    public WebElement getElement(By locator){
        WebElement element = driver.findElement(locator);
        if(BasePage.highlight.equals("true")){
            jsUtil.flash(element);
        }
        return element;
    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public void doSendKeys(By locator, String value){
        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator){
        getElement(locator).click();
    }

    public boolean doIsDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator){
        return getElement(locator).getText();
    }

    public void waitForElementTobeVisible(By locator, int timeOut){
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementPresent(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public boolean compareDropdownOptions(By locator, String[] expected){
        List<WebElement> options = getAllDropDownOptions(locator);
        int i=0;
        for(WebElement opt: options){
            if(!opt.getText().equals(expected[i])){
                return false;
            }
            i=i+1;
        }
        return true;
    }

    public List<WebElement> getAllDropDownOptions(By locator){
        Select select = new Select(getElement(locator));
        List<WebElement> op = select.getOptions();
        return op;
    }

    public String randomString(int len){
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i=0; i<len; i++){
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }
}
