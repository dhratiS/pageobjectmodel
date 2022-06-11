package com.demoqa.qa.test;

import com.demoqa.qa.base.Base;
import com.demoqa.qa.pages.ElementsPage;
import com.demoqa.qa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    WebDriver driver;
    HomePage homePage;
    ElementsPage elementsPage;
    @BeforeClass
    public void init(){
        driver = setWebDriverProperties(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePageTitle(){
        String title = homePage.getHomeTitle();
        Assert.assertEquals(title,"ToolsQA");
    }

    @Test
    public void verifyClickElement(){
        elementsPage = homePage.clickElementsContainer();
        Assert.assertEquals(elementsPage.getHomeTitle(), "ToolsQA");
    }

    @Test
    public void verifyHeaderImage(){
        String href = homePage.headerImageHref();
        Assert.assertEquals(href, "https://demoqa.com");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
