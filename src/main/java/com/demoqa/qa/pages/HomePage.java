package com.demoqa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver webDriver;
    WebDriverWait wait;

    private By headerImage = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    private By homeBanner = By.xpath("//div[@class='home-banner']");
    private By elements = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]/div[1]");
    private By forms = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[2]");
    private By allContainers = By.xpath("//div[@class='card mt-4 top-card']");

    public HomePage(WebDriver webdriver){
        webdriver = this.webDriver;
    }
    public String getHomeTitle(){
        return webDriver.getTitle();
    }

    public String homeBannerHref(){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homeBanner));
        WebElement link = webDriver.findElement(homeBanner);
        return link.getAttribute("href");
    }
    public void clickElementsContainer(){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(elements));
        webDriver.findElement(elements);
        // now execute query which actually will scroll until that element is not appeared on page.
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", elements);

    }
    public void clickFormContainer(){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(forms));
        webDriver.findElement(forms);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", forms);
    }

    public String headerImageHref(){
        WebElement link = webDriver.findElement(headerImage);
        return link.getAttribute("href");
    }

}
