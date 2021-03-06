package com.demoqa.qa.base;

import com.demoqa.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Base {

    private  ConfigReader configReader =  new ConfigReader() ;
    private  String  url = configReader.getUrl();
    private  String browser = configReader.getBrowser();
    //PageFactory pf = new PageFactory();

    public  WebDriver setWebDriverProperties(WebDriver driver){
        configReader = new ConfigReader();
        driver = BaseLogic.setDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(url);
        return driver;

    }
}
