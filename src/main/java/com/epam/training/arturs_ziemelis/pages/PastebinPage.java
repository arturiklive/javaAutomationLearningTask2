package com.epam.training.arturs_ziemelis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {
    private WebDriver driver;
    private static final By TEXT_AREA = By.id("postform-text");
    private static final By EXPIRATION_DROPDOWN = By.id("select2-postform-expiration-container");
    private static final By TEN_MINUTES_OPTION = By.xpath("//li[text()='10 Minutes']");
    private static final By PASTE_NAME_INPUT = By.id("postform-name");
    private static final By AGREE_BUTTON = By.xpath("//button[@class=' css-47sehv']");

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinPage openPage(String url) {
        driver.get(url);
        return this;
    }
    public PastebinPage clickAgreeBlockerButton() {
        waitForElementToBeVisible(AGREE_BUTTON);
        driver.findElement(AGREE_BUTTON).click();
        return this;
    }
    public PastebinPage enterCode(String code) {
        driver.findElement(TEXT_AREA).sendKeys(code);
        return this;
    }

    public PastebinPage setExpirationToTenMinutes() {
        WebElement expirationDropdownElement = driver.findElement(EXPIRATION_DROPDOWN);
        scrollToElement(expirationDropdownElement);
        expirationDropdownElement.click();

        WebElement tenMinutesOptionElement = driver.findElement(TEN_MINUTES_OPTION);
        scrollToElement(tenMinutesOptionElement);
        tenMinutesOptionElement.click();
        return this;
    }

    public PastebinPage setPasteName(String pasteName) {
        driver.findElement(PASTE_NAME_INPUT).sendKeys(pasteName);
        return this;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}