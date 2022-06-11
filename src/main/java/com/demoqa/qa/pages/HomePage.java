package com.demoqa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    private By headerImage = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    private By homeBanner = By.xpath("//div[@class='home-banner']");
    private By elements = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]/div[1]");
    private By forms = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[2]");
    private By allContainers = By.xpath("//div[@class='card mt-4 top-card']");

    public HomePage(WebDriver webdriver){

        driver = webdriver;
    }
    public String getHomeTitle(){
        return driver.getTitle();
    }

    public String homeBannerHref(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homeBanner));
        WebElement link = driver.findElement(homeBanner);
        return link.getAttribute("href");
    }
    public ElementsPage clickElementsContainer(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(elements));
        // now execute query which actually will scroll until that element is not appeared on page.
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
        driver.findElement(elements).click();
        return new ElementsPage(driver);

    }
    public void clickFormContainer(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(forms));
        driver.findElement(forms);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forms);
    }

    public String headerImageHref(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(headerImage));
        WebElement link = driver.findElement(headerImage);
        return link.getAttribute("href");
    }

}
