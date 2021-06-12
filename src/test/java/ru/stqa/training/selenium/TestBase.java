package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-fullscreen");
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        System.out.println(((HasCapabilities)driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        driver.findElement(locator);
        return true;
    }

    public void login(String username, String password) {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }



}
