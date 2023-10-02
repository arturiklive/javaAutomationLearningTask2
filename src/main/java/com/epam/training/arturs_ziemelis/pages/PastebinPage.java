package com.epam.training.arturs_ziemelis.pages;

import com.epam.training.arturs_ziemelis.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinPage {
    private static final By TEXT_AREA = By.id("postform-text");
    private static final By DROPDOWN_EXPIRATION = By.id("select2-postform-expiration-container");
    private static final By DROPDOWN_SYNTAX_HIGHLIGHTING = By.id("select2-postform-format-container");
    private static final String DROPDOWN_OPTION_TEMPLATE = "//li[text()='%s']";
    private static final By PASTE_NAME_INPUT = By.id("postform-name");
    private static final By AGREE_BUTTON = By.xpath("//button[@class=' css-47sehv']");
    private static final By SAVE_PASTE_BUTTON = By.xpath("(//button[@type='submit'])[2]");
    private WebDriver driver;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public PastebinPage clickAgreeBlockerButton() {
        WebDriverUtils.waitForElementToBeVisible(driver, AGREE_BUTTON, 10);
        driver.findElement(AGREE_BUTTON).click();
        return this;
    }

    public PastebinPage enterCode(String code) {
        driver.findElement(TEXT_AREA).sendKeys(code);
        return this;
    }

    public PastebinPage setDropdownOption(String dropdown, String option) {
        By dropdownLocator;

        if ("Syntax Highlighting".equals(dropdown))
            dropdownLocator = DROPDOWN_SYNTAX_HIGHLIGHTING;
        else if ("Paste Expiration".equals(dropdown))
            dropdownLocator = DROPDOWN_EXPIRATION;
        else
            throw new IllegalArgumentException("Dropdown title not correct");

        WebElement dropdownElement = driver.findElement(dropdownLocator);
        WebDriverUtils.scrollToElement(driver, dropdownElement);
        dropdownElement.click();

        String xpath = String.format(DROPDOWN_OPTION_TEMPLATE, option);
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return this;
    }

    public PastebinPage setPasteName(String pasteName) {
        driver.findElement(PASTE_NAME_INPUT).sendKeys(pasteName);
        return this;
    }

    public PastebinPage clickSavePaste() {
        driver.findElement(SAVE_PASTE_BUTTON).click();
        return this;
    }
}