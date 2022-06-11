package com.demoqa.qa.pages;

import com.demoqa.qa.base.Base;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Base {
    WebDriver driver;
    public ElementsPage(WebDriver webdriver){
        driver = webdriver;
    }
    public String getHomeTitle(){
        return driver.getTitle();
    }
}
