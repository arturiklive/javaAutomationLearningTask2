package com.epam.training.arturs_ziemelis.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreateNewPaste() throws InterruptedException {
        pastebinPage.openPage("https://pastebin.com/")
                .clickAgreeBlockerButton()
                .enterCode("Hello from WebDriver")
                .setExpirationToTenMinutes()
                .setPasteName("helloweb");
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}