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
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String pasteName = "how to gain dominance among developers";

        pastebinPage.openPage("https://pastebin.com/")
                .clickAgreeBlockerButton()
                .enterCode(code)
                .setDropdownOption("Syntax Highlighting", "Bash")
                .setDropdownOption("Paste Expiration", "10 Minutes")
                .setPasteName(pasteName)
                .clickSavePaste();

        SavedPastePage savedPastePage = new SavedPastePage(driver);
        savedPastePage.checkPageTitle(pasteName)
                .checkTopButtonText("Bash")
                .checkCodeText(code);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}