package com.epam.training.arturs_ziemelis.pages;

import com.epam.training.arturs_ziemelis.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SavedPastePage {
    private static final By TOP_LEFT_BUTTON = By.xpath("(//a[@class='btn -small h_800'])[1]");
    private static final By CODE_TEXT_BOX = By.xpath("//ol[@class='bash']");
    private WebDriver driver;

    public SavedPastePage(WebDriver driver) {
        this.driver = driver;
    }

    public SavedPastePage checkPageTitle(String expectedTitle) {
        WebDriverUtils.waitForElementToBeVisible(driver, CODE_TEXT_BOX, 10);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        System.out.println(actualTitle);
        System.out.println(actualTitle);
        if (!actualTitle.contains(expectedTitle)) {
            throw new RuntimeException("Expected title: " + expectedTitle + ", but got: " + actualTitle);
        }
        return this;
    }

    public SavedPastePage checkTopButtonText(String expectedName) {
        WebElement actualName = driver.findElement(TOP_LEFT_BUTTON);
        String actualNameText = actualName.getText();
        if (!actualNameText.equals(expectedName)) {
            throw new RuntimeException("Expected top left button name: " + expectedName + ", but got: " + actualName);
        }
        return this;
    }

    public SavedPastePage checkCodeText(String expectedCodeText) {
        WebElement actualCode = driver.findElement(CODE_TEXT_BOX);
        String actualCodeText = actualCode.getText();
        if (!actualCodeText.equals(expectedCodeText)) {
            throw new RuntimeException("Expected code: " + expectedCodeText + ", but got: " + actualCodeText);
        }
        return this;
    }
}