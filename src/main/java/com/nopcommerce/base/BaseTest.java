package com.nopcommerce.base;

import com.nopcommerce.pages.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.*;

public class BaseTest {
    public BasePage basePage;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public SearchPage searchPage;
    public Properties prop;
    public WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browserName){
        basePage = new BasePage();
        prop = basePage.init_prop();
        String browserType = prop.getProperty("browser");
        if(browserName!=null){
            browserType = browserName;
        }
        driver = basePage.init_driver(browserType);
        homePage = new HomePage(driver);
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
