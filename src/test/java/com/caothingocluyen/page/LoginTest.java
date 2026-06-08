package com.caothingocluyen.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {

        loginPage.enterCredentials(
                "standard_user",
                "secret_sauce"
        );

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginSuccessful()
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}