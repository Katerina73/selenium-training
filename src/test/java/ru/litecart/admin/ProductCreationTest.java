package ru.litecart.admin;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductCreationTest extends TestBase {

    @Test
    public void ProductCreationTest() {
        String productName = System.currentTimeMillis() + "RealDuck";
        long codeLong = System.currentTimeMillis();
        String code = Long.toString(codeLong);

        driver.get("http://localhost/litecart/admin/");
        login("admin", "admin");

        //заполнение вкладки "General"
        driver.findElement(By.xpath("//li[@id = \"app-\"]//span[contains(text(), \"Catalog\")]")).click();
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.xpath("//input[@name = \"status\" and @value=\"1\"]")).click();
        driver.findElement(By.xpath("//input[@name = \"name[en]\"]")).sendKeys(productName);
        driver.findElement(By.xpath("//input[@name = \"code\"]")).sendKeys(code);
        driver.findElement(By.xpath("//input[@data-name = \"Rubber Ducks\"]")).click();
        driver.findElement(By.xpath("//input[@data-name = \"Subcategory\"]")).click();

        driver.findElement(By.xpath("//td[contains(text(), \"Unisex\")]")).click();
        driver.findElement(By.xpath("//input[@name=\"quantity\"]")).sendKeys("100");

        File image = new File("src/test/resources/realduck.jpeg");
        String productImage = image.getAbsolutePath();
        driver.findElement(By.xpath("//input[@name=\"new_images[]\"]")).sendKeys(productImage);
        System.out.println(productImage);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFrom = LocalDateTime.now().format(formatter);
        String dateTo = LocalDateTime.now().plusYears(1).format(formatter);

        driver.findElement(By.xpath("//input[@name=\"date_valid_from\"]")).sendKeys(dateFrom);
        driver.findElement(By.xpath("//input[@name=\"date_valid_to\"]")).sendKeys(dateTo);

        //заполнение вкладки "Information"
        driver.findElement(By.xpath("//td[@id=\"content\"]//a[contains(text(), \"Information\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"manufacturer_id\"]")));
        driver.findElement(By.xpath("//select[@name=\"manufacturer_id\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"manufacturer_id\"]/option[contains(text(), \"ACME Corp.\")]")).click();
        driver.findElement(By.xpath("//input[@name=\"keywords\"]")).sendKeys("test duck");
        driver.findElement(By.xpath("//input[@name=\"short_description[en]\"]")).sendKeys("It's a real duck not rubber");
        driver.findElement(By.xpath("//div[@class=\"trumbowyg-editor\"]")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        driver.findElement(By.xpath("//input[@name=\"head_title[en]\"]")).sendKeys("Real duck");
        driver.findElement(By.xpath("//input[@name=\"head_title[en]\"]")).sendKeys("Test meta description");

        //заполнение вкладки "Prices"
        driver.findElement(By.xpath("//td[@id=\"content\"]//a[contains(text(), \"Prices\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"purchase_price\"]")));
        driver.findElement(By.xpath("//input[@name=\"purchase_price\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"purchase_price\"]")).sendKeys("70");
        driver.findElement(By.xpath("//select[@name=\"purchase_price_currency_code\"]")).click();
        driver.findElement(By.xpath("//select[@name=\"purchase_price_currency_code\"]/option[contains(@value, \"EUR\")]")).click();
        driver.findElement(By.xpath("//input[@name=\"prices[USD]\"]")).sendKeys("80");
        driver.findElement(By.xpath("//input[@name=\"gross_prices[USD]\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"gross_prices[USD]\"]")).sendKeys("85");
        driver.findElement(By.xpath("//input[@name=\"prices[EUR]\"]")).sendKeys("70");
        driver.findElement(By.xpath("//input[@name=\"gross_prices[EUR]\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"gross_prices[EUR]\"]")).sendKeys("75");

        //сохранение и поиск созданного продукта в каталоге
        driver.findElement(By.xpath("//button[@name=\"save\"]")).click();
        driver.findElement(By.xpath("//li[@id=\"app-\"]//span[contains(text(), \"Catalog\")]")).click();
        driver.findElement(By.xpath("//a[contains(text(), \"Rubber Ducks\")]")).click();
        String newProductLocator = "//a[contains(text(), \"" + productName + "\")]";
        Assert.assertTrue(driver.findElement(By.xpath(newProductLocator)).isDisplayed());

    }
}
