package com.nopcommerce.utils;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.util.*;

public class OptionsManager {

    private Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;

    public OptionsManager(Properties prop){
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions(){
        co = new ChromeOptions();
        if(prop.getProperty("headless").equals("true"))
            co.addArguments("--headless");

        if(prop.getProperty("incognito").equals("true"))
            co.addArguments("--incognito");

        return co;
    }

    public FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if (prop.getProperty("headless").equals("true"))
            fo.addArguments("--headless");

        if (prop.getProperty("incognito").equals("true"))
            fo.addArguments("--incognito");
        return fo;
    }
}
