package ru.litecart.market;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.stqa.training.selenium.TestBase;

public class RegistrationTest extends TestBase {

    @Test
    public void RegistrationTest () {
        String email = System.currentTimeMillis() + "test@mail.com";
        String password = "Test123";

        //заполнение всех обязательных полей в форме регистрации
        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//form[@name = \'login_form\']//a")).click();
        driver.findElement(By.xpath("//input[@name = \"firstname\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name = \"lastname\"]")).sendKeys("Testov");
        driver.findElement(By.xpath("//input[@name = \"address1\"]")).sendKeys("Test St., 123");
        driver.findElement(By.xpath("//input[@name = \"postcode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name = \"city\"]")).sendKeys("Testcity");
        driver.findElement(By.xpath("//span[contains(@class, \"select2-selection--single\")]")).click();
        driver.findElement(By.xpath("//input[@type = \"search\"]")).sendKeys("united states", Keys.ENTER);
        driver.findElement(By.xpath("//select[@name = \"zone_code\"]")).click();
        driver.findElement(By.xpath("//select[@name = \"zone_code\"]/option[@value = \"CA\"]")).click();
        driver.findElement(By.xpath("//input[@name = \"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name = \"phone\"]")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@name = \"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name = \"confirmed_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name = \"create_account\"]")).click();

        //проверка успешной регистрации через появление алерта
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = \"notice success\"]")).getText().contains("Your customer account has been created"));
        System.out.println("Registration completed successfully");

        //проверка логаута через появление алерта
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = \"notice success\"]")).getText().contains("You are now logged out"));
        System.out.println("Logout completed successfully");

        //логин
        driver.findElement(By.xpath("//input[@name = \"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name = \"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name = \"login\"]")).click();

        //проверка логина через появление алерта
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = \"notice success\"]")).getText().contains("You are now logged in as Test Testov"));
        System.out.println("Login completed successfully");
    }

}
