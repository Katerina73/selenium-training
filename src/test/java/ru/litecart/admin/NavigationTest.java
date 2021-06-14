package ru.litecart.admin;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;
import java.util.List;

public class NavigationTest extends TestBase {

    @Test
    public void NavigationTest() {
        driver.get("http://localhost/litecart/admin");
        login("admin", "admin");
        driver.findElement(By.xpath("//li[@id = \"app-\"][1]")).click();
        List<WebElement> menu = driver.findElements(By.xpath("//li[@id = \"app-\"]"));
        for (int i = 0; i < menu.size(); i++) {
            menu = driver.findElements(By.xpath("//li[@id = \"app-\"]"));
            menu.get(i).click();
            boolean appearenceHeader = isElementPresent(driver, By.xpath("//h1"));
            String a = driver.findElement(By.xpath("//h1")).getText();
            System.out.println(a);

            try {
                boolean sm = isElementPresent(driver, By.xpath("//li[contains(@id, 'doc')]"));
                if (sm = true) {
                    List<WebElement> subMenu = driver.findElements(By.xpath("//li[contains(@id, 'doc')]"));
                    for (int j = 0; j < subMenu.size(); j++) {
                        subMenu = driver.findElements(By.xpath("//li[contains(@id, 'doc')]"));
                        subMenu.get(j).click();
                        String b = driver.findElement(By.xpath("//h1")).getText();
                        System.out.println(b);
                    }
                } else {
                    menu.get(i).click();
                }
            } catch (RuntimeException e) {
            }
            Assert.assertTrue(appearenceHeader = true);
        }
    }
}
