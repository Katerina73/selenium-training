package ru.litecart.admin;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;
import java.util.List;


public class GeoTest extends TestBase {
    private WebElement table;
    private List<WebElement> rows;

    private void createContriesTable() {
        table = driver.findElement(By.xpath("//table[@class=\"dataTable\"]"));
        rows = table.findElements(By.xpath("//tr[@class=\"row\"]"));
    }

    @Test
    public void CountriesTest() {
        int countryColumn = 4;
        int zoneColumn = 5;

        login("admin", "admin");
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        //создание таблицы со списком стран, чтобы в дальнейшем получить из неё наименование страны и количество зон в ней
        createContriesTable();

        for (int i = 0; i < rows.size() - 1; i++) {
            String actualCountry = rows.get(i).findElements(By.tagName("td")).get(countryColumn).getText();
            String nextCountry = rows.get(i + 1).findElements(By.tagName("td")).get(countryColumn).getText();
            //System.out.println("Country name is " + actualCountry);
            Assert.assertTrue((nextCountry.compareTo(actualCountry)) > 0);

            int zonesCount = Integer.parseInt(rows.get(i).findElements(By.tagName("td")).get(zoneColumn).getText());
            if (zonesCount > 0) {
                driver.findElement(By.linkText(actualCountry)).click();
                List<WebElement> allZones = driver.findElements(By.xpath("//td/input[contains(@name,\"zones\") and contains(@name, \"[name]\")]"));
                for (int j = 0; j < allZones.size() - 1; j++) {
                    String actualZone = (allZones.get(j).getAttribute("value"));
                    String nextZone = (allZones.get(j + 1).getAttribute("value"));
                    //System.out.println("Zone name is " + actualZone);
                    Assert.assertTrue(nextZone.compareTo(actualZone) > 0);
                }
                driver.navigate().back();
                createContriesTable();
            }
        }
    }

    @Test
    public void GeoZonesTest() {
        login("admin", "admin");
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> countries = driver.findElements(By.xpath("//form[@name = \"geo_zones_form\"]//td[3]/a"));
        for (int i = 0; i < countries.size(); i++) {
            countries.get(i).click();

            List<WebElement> geoZones = driver.findElements(By.cssSelector("select[name*='zone_code'] option:checked"));
            for (int j = 0; j < geoZones.size() - 1; j++) {
                String actualZone = (geoZones.get(j).getText());
                String nextZone = (geoZones.get(j + 1).getText());
                System.out.println("Zone name is " + actualZone);
                Assert.assertTrue(nextZone.compareTo(actualZone) > 0);
            }
            driver.navigate().back();
            countries = driver.findElements(By.xpath("//form[@name = \"geo_zones_form\"]//td[3]/a"));
        }
    }
}

