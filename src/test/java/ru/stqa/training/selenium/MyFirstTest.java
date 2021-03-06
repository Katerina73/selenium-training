package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTest {
    private WebDriver driver;
    //private WebDriverWait wait;

    @Before
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(caps);
        System.out.println(((HasCapabilities)driver).getCapabilities());
        //wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("web driver \n");

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}