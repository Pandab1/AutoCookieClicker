package eu.pandab.autocookieclicker.game;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeManager {

    static WebDriver startCookieClicker() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("load-extension=/Users/paul1/AppData/Local/Google/Chrome/User Data/Default/Extensions/cjpalhdlnbpafiamejdnhcphjbkeiagm/1.56.0_0");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://orteil.dashnet.org/cookieclicker/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement googleCookieCheck = driver.findElement(By.className("fc-button-label"));
        googleCookieCheck.click();
        WebElement languageSelector = driver.findElement(By.id("langSelect-EN"));
        languageSelector.click();
        WebElement otherCookieCheck = driver.findElement(By.className("cc_btn_accept_all"));
        try {
            otherCookieCheck.click();
        } catch (StaleElementReferenceException e) {
            otherCookieCheck = driver.findElement(By.className("cc_btn_accept_all"));
            otherCookieCheck.click();
        }
        WebElement backupPopup = driver.findElement(By.cssSelector("#note-1 a"));
        backupPopup.click();
        return driver;
    }
}
