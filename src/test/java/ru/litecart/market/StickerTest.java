package ru.litecart.market;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;

import java.util.List;


public class StickerTest extends TestBase {
    @Test
    public void StickerTest () {
        driver.get("http://localhost/litecart");
        List<WebElement> ducks = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));
        WebElement duck = driver.findElement(By.xpath("//li[contains(@class, 'product')]"));

        for (int i=0; i< ducks.size(); i++) {
            int amountOfDucks = duck.findElements(By.xpath(".//div[contains(@class, \"sticker\")]")).size();
            if (amountOfDucks != 1)
            Assert.fail("Amount of duck stickers is not equal to 1");
        }
    }
}
