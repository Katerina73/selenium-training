package ru.litecart.market;

import org.junit.Assert;
import ru.stqa.training.selenium.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Arrays;

public class ProductTest extends TestBase {

    //на главной странице и на странице товара совпадает текст названия товара
    @Test
    public void ProductNameTest () {
        driver.get("http://localhost/litecart/");

        //получение наименования товара - главная страница
        String productNameMainPage = driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//div[@class = \"name\"][1]")).getText().toString();
        driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//a[@class = \"link\"]")).click();

        //получение наименования товара - страница товара
        String productNameProductPage = driver.findElement(By.xpath("//h1")).getText().toString();

        //сравнение наименований товара на разных страницах
        Assert.assertTrue(productNameMainPage.compareTo(productNameProductPage) == 0);
    }


    //на главной странице и на странице товара совпадают цены (обычная и акционная)
    @Test
    public void ProductPriceTest () {
        driver.get("http://localhost/litecart/");

        //получение обычной цены товара - главная страница
        String productRegularPriceMainPage = driver.findElement(By.xpath("//div[@id =\"box-campaigns\"]//s")).getText().toString();

        //получение акционной цены товара - главная страница
        String productCampaignPriceMainPage = driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//div/strong\n")).getText().toString();

        driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s/ancestor::a")).click();

        //получение обычной цены товара - страница товара
        String productRegularPriceProductPage = driver.findElement(By.xpath("//div[@id = \"box-product\"]//s")).getText().toString();

        //получение акционной цены товара - страница товара
        String productCampaignPriceProductPage = driver.findElement(By.xpath("//div[@id = \"box-product\"]//strong[@itemprop=\"price\"]")).getText().toString();

        Assert.assertTrue(productRegularPriceMainPage.compareTo(productRegularPriceProductPage) == 0);
        Assert.assertTrue(productCampaignPriceMainPage.compareTo(productCampaignPriceProductPage) == 0);

    }

    //обычная цена зачёркнутая и серая на главной странице
    @Test
    public void RegularPriceColourTestMainPage () {
        driver.get("http://localhost/litecart/");

        //получение цвета обычной цены - главная страница
        String regularPriceColor = driver.findElement(By.xpath("//div[@id =\"box-campaigns\"]//s")).getCssValue("color").toString();

        //получение массива строк из одной строки с цветом в формате RGBa
        String[] rGB = regularPriceColor.split("\\s+|, +|\\(+|\\)+");

        /*
        for (String rgb : rGB) {
            System.out.println(rgb);
        }
        */

        //сравнение значений R, G и B
        boolean gray = ((rGB[1] == rGB[2]) && (rGB[2] == rGB[3]));

        //получение типа форматирования текста обычной цены
        String regularPriceTextStyle = driver.findElement(By.xpath("//div[@id =\"box-campaigns\"]//s")).getCssValue("text-decoration").toString();

        //получение массива строк из одной строки с типом форматирования текста (в разных браузерах передаётся разное количество параметров)
        String[] textStyle = regularPriceTextStyle.split(" ");

        /*
        for (String ts : textStyle) {
            System.out.println(ts);
        }
        */

        //определение того, что шрифт зачёркнутый
        boolean lineThrough = Arrays.asList(textStyle).contains("line-through");
        Assert.assertTrue((gray = true) && (lineThrough = true));
    }


    //обычная цена зачёркнутая и серая на странице товара
    @Test
    public void RegularPriceColourTestProductPage () {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s/ancestor::a")).click();

        //получение цвета обычной цены - страница продукта
        String regularPriceColor = driver.findElement(By.xpath("//div[@id =\"box-product\"]//s")).getCssValue("color").toString();

        //получение массива строк из одной строки с цветом в формате RGBa
        String[] rGB = regularPriceColor.split("\\s+|, +|\\(+|\\)+");

        /*
        for (String rgb : rGB) {
            System.out.println(rgb);
        }
        */

        //сравнение значений R, G и B
        boolean gray = ((rGB[1] == rGB[2]) && (rGB[2] == rGB[3]));
        Assert.assertTrue(gray = true);


        //получение типа форматирования текста обычной цены
        String regularPriceTextStyle = driver.findElement(By.xpath("//div[@id =\"box-product\"]//s")).getCssValue("text-decoration").toString();

        //получение массива строк из одной строки с типом форматирования текста (в разных браузерах передаётся разное количество параметров)
        String[] textStyle = regularPriceTextStyle.split(" ");


        /*
        for (String ts : textStyle) {
            System.out.println(ts);
        }
        */

        //определение того, что шрифт зачёркнутый
        boolean lineThrough = Arrays.asList(textStyle).contains("line-through");
        Assert.assertTrue(lineThrough = true);
    }

    //акционная жирная и красная на главной странице
    @Test
    public void CampaignPriceColourTestMainPage () {
        driver.get("http://localhost/litecart/");

        //получение цвета акционной цены
        String сampaignPriceColor = driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//strong")).getCssValue("color").toString();
        String[] rGB = сampaignPriceColor.split("\\s+|, +|\\(+|\\)+");
        boolean red = (((Integer.parseInt(rGB[2])) == 0) && ((Integer.parseInt(rGB[3])) == 0));

        //получение типа форматирования текста акционной цены
        //сценарий для Chrome и FireFox, где font-weight выражается в числовом значении

        int сampaignPriceTextStyle = Integer.parseInt(driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//strong")).getCssValue("font-weight"));
        boolean bold = (сampaignPriceTextStyle >= 700);
        Assert.assertTrue((red = true) && (bold = true));

        //сценарий для Safari, где font-weight выражается в текстовом значении
        /*
        String сampaignPriceTextStyle = driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//strong")).getCssValue("font-weight").toString();
        boolean bold = (сampaignPriceTextStyle == "bold");
        Assert.assertTrue((red = true) && (bold = true));
         */

    }

    //акционная жирная и красная на странице товара
    @Test
    public void CampaignPriceColourTestProductPage () {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s/ancestor::a")).click();

        //получение цвета акционной цены
        String сampaignPriceColor = driver.findElement(By.xpath("//div[@id = \"box-product\"]//strong[@itemprop=\"price\"]")).getCssValue("color").toString();
        String[] rGB = сampaignPriceColor.split("\\s+|, +|\\(+|\\)+");
        boolean red = (((Integer.parseInt(rGB[2])) == 0) && ((Integer.parseInt(rGB[3])) == 0));

        //получение типа форматирования текста акционной цены
        //сценарий для Chrome и FireFox, где font-weight выражается в числовом значении

        int сampaignPriceTextStyle = Integer.parseInt(driver.findElement(By.xpath("//div[@id = \"box-product\"]//strong[@itemprop=\"price\"]")).getCssValue("font-weight"));
        boolean bold = (сampaignPriceTextStyle >= 700);
        Assert.assertTrue((red = true) && (bold = true));

        //сценарий для Safari, где font-weight выражается в текстовом значении
        /*
        String сampaignPriceTextStyle = driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//strong")).getCssValue("font-weight").toString();
        boolean bold = (сampaignPriceTextStyle == "bold");
        Assert.assertTrue((red = true) && (bold = true));
         */

    }

    //акционная цена крупнее, чем обычная
    @Test
    public void CampaignPriceIsBigger () {
        driver.get("http://localhost/litecart/");
        String regularPriceMainPage = driver.findElement(By.xpath("//div[@id =\"box-campaigns\"]//s")).getCssValue("font-size").toString();
        String campaignPriceMainPage = driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//div/strong\n")).getCssValue("font-size").toString();
        Assert.assertTrue((campaignPriceMainPage.compareTo(regularPriceMainPage)) > 0 );

        driver.findElement(By.xpath("//div[@id = \"box-campaigns\"]//s/ancestor::a")).click();
        String regularPriceProductPage = driver.findElement(By.xpath("//div[@id = \"box-product\"]//s")).getCssValue("font-size").toString();
        String сampaignPriceProductPage = driver.findElement(By.xpath("//div[@id = \"box-product\"]//strong[@itemprop=\"price\"]")).getCssValue("font-size").toString();
        Assert.assertTrue((сampaignPriceProductPage.compareTo(regularPriceProductPage)) > 0 );

    }
}
