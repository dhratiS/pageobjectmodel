package com.demoqa.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// this class demonstrate singleton, factory and facade pattern
@UtilityClass
public class BaseLogic {

    //This demonstrates the Singleton Pattern. Each class gets it own single threaded driver
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized WebDriver getDriver() {

        return driver.get();
    }

    @SneakyThrows
    public WebDriver setDriver(String browser){
        WebDriver webDriver;
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        else{
            throw new Exception("This browser " + browser + " not found");
        }

       driver.set(webDriver);
       return getDriver();
    }

    public void quitDriver(){
        getDriver().quit();

    }
    public void closeDriver(){
        getDriver().close();
    }

}
