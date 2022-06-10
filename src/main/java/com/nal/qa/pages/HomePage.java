package com.nal.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver webDriver;
    private By headerImage = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    private By homeBanner = By.xpath("//img[@alt='Selenium Online Training']");
    private By elements = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]/div[1]");
    private By containers = By.xpath("//div[@class='card mt-4 top-card']");

    public HomePage(WebDriver webdriver){
        webdriver = this.webDriver;
    }
    public String getHomeTitle(){
        return webDriver.getTitle();
    }

}
