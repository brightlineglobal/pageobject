package com.nopcommerce.pages;

import com.nopcommerce.base.*;
import com.nopcommerce.utils.*;
import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By loginPageName = By.xpath("//div[@class='page-title']/h1");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginBtn = By.xpath("//input[@value='Log in']");
    private By registerBtn = By.xpath("//input[@value='Register']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getLoginPageName(){
      return  driver.findElement(loginPageName).getText();
    }

    public boolean verifyLoginButton(){
        return driver.findElement(loginBtn).isDisplayed();
    }

    public boolean verifyRegisterButton(){
        return driver.findElement(registerBtn).isDisplayed();
    }

    public HomePage doLogin(String userName, String password){
        driver.findElement(emailField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }
}
