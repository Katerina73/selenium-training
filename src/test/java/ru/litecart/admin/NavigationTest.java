package ru.litecart.admin;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.TestBase;

public class NavigationTest extends TestBase {

    @Test
    public void NavigationTest() {

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Appearence")).click();
        boolean appearenceHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("appearenceHeader is " + appearenceHeader);

        driver.findElement(By.linkText("Logotype")).click();
        boolean logotypeHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("logotypeHeader is " + logotypeHeader);

        driver.findElement(By.linkText("Template")).click();
        boolean templateHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("templateHeader is " + templateHeader);

        driver.findElement(By.xpath("//span[@class=\"fa-stack fa-lg icon-wrapper\"]/following-sibling::span[contains(text(), 'Catalog')]")).click();
        boolean catalogHeader1 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("catalogHeader1 is " + catalogHeader1);

        driver.findElement(By.linkText("Product Groups")).click();
        boolean productGroupsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("productGroupsHeader is " + productGroupsHeader);

        driver.findElement(By.xpath("//ul[@class=\"docs\"]//span[contains(text(), 'Catalog')]")).click();
        boolean catalogHeader2 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("catalogHeader is " + catalogHeader2);


        driver.findElement(By.linkText("Option Groups")).click();
        boolean optionGroupsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("optionGroupsHeader is " + optionGroupsHeader);

        driver.findElement(By.linkText("Manufacturers")).click();
        boolean manufacturersHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("manufacturersHeader is " + manufacturersHeader);

        driver.findElement(By.linkText("Suppliers")).click();
        boolean suppliersHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("suppliersHeader is " + suppliersHeader);

        driver.findElement(By.linkText("Delivery Statuses")).click();
        boolean deliveryStatusesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("deliveryStatusesHeader is " + deliveryStatusesHeader);

        driver.findElement(By.linkText("Sold Out Statuses")).click();
        boolean soldOutStatusesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("soldOutStatusesHeader is " + soldOutStatusesHeader);

        driver.findElement(By.linkText("Quantity Units")).click();
        boolean quantityUnitsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("quantityUnitsHeader is " + quantityUnitsHeader);

        driver.findElement(By.linkText("CSV Import/Export")).click();
        boolean CSVHeader1 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("CSVHeader1 is " + CSVHeader1);

        driver.findElement(By.linkText("Countries")).click();
        boolean countriesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("countriesHeader is " + countriesHeader);

        driver.findElement(By.linkText("Currencies")).click();
        boolean currenciesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("currenciesHeader is " + currenciesHeader);

        driver.findElement(By.xpath("//span[@class=\"fa-stack fa-lg icon-wrapper\"]/following-sibling::span[contains(text(), 'Customers')]\n")).click();
        boolean customersHeader1 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("customersHeader1 is " + customersHeader1);

        driver.findElement(By.linkText("CSV Import/Export")).click();
        boolean CSVHeader2 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("CSVHeader2 is " + CSVHeader2);

        driver.findElement(By.xpath("//ul[@class=\"docs\"]//span[contains(text(), 'Customers')]")).click();
        boolean customersHeader2 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("customersHeader2 is " + customersHeader2);

        driver.findElement(By.linkText("Newsletter")).click();
        boolean newsletterHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("newsletterHeader is " + newsletterHeader);

        driver.findElement(By.linkText("Geo Zones")).click();
        boolean geoZonesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("geoZonesHeader is " + geoZonesHeader);

        driver.findElement(By.xpath("//span[@class=\"fa-stack fa-lg icon-wrapper\"]/following-sibling::span[contains(text(), 'Languages')]\n")).click();
        boolean languagesHeader1 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("languagesHeader1 is " + languagesHeader1);

        driver.findElement(By.linkText("Storage Encoding")).click();
        boolean storageEncodingHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("storageEncodingHeader is " + storageEncodingHeader);

        driver.findElement(By.xpath("//ul[@class=\"docs\"]//span[contains(text(), 'Languages')]")).click();
        boolean languagesHeader2 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("languagesHeader2 is " + languagesHeader2);

        driver.findElement(By.linkText("Modules")).click();
        boolean modulesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("modulesHeader is " + modulesHeader);

        driver.findElement(By.linkText("Customer")).click();
        boolean customerHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("customerHeader is " + customerHeader);

        driver.findElement(By.linkText("Background Jobs")).click();
        boolean backgroundJobsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("backgroundJobsHeader is " + backgroundJobsHeader);

        driver.findElement(By.linkText("Shipping")).click();
        boolean shippingHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("shippingHeader is " + shippingHeader);

        driver.findElement(By.linkText("Payment")).click();
        boolean paymentHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("paymentHeader is " + paymentHeader);

        driver.findElement(By.linkText("Order Total")).click();
        boolean orderTotalHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("orderTotalHeader is " + orderTotalHeader);

        driver.findElement(By.linkText("Order Success")).click();
        boolean orderSuccessHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("orderSuccessHeader is " + orderSuccessHeader);

        driver.findElement(By.linkText("Order Action")).click();
        boolean orderActionHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("orderActionHeader is " + orderActionHeader);

        driver.findElement(By.xpath("//span[@class=\"fa-stack fa-lg icon-wrapper\"]/following-sibling::span[contains(text(), 'Orders')]")).click();
        boolean ordersHeader1 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("ordersHeader1 is " + ordersHeader1);

        driver.findElement(By.linkText("Order Statuses")).click();
        boolean orderStatusesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("orderStatusesHeader is " + orderStatusesHeader);

        driver.findElement(By.xpath("//ul[@class=\"docs\"]//span[contains(text(), 'Orders')]")).click();
        boolean ordersHeader2 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("ordersHeader2 is " + ordersHeader2);

        driver.findElement(By.linkText("Pages")).click();
        boolean pagesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("pagesHeader is " + pagesHeader);

        driver.findElement(By.linkText("Reports")).click();
        boolean reportsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("reportsHeader is " + reportsHeader);

        driver.findElement(By.linkText("Most Sold Products")).click();
        boolean mostSoldProductsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("mostSoldProductsHeader is " + mostSoldProductsHeader);

        driver.findElement(By.linkText("Monthly Sales")).click();
        boolean monthlySalesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("monthlySalesHeader is " + monthlySalesHeader);

        driver.findElement(By.linkText("Most Shopping Customers")).click();
        boolean mostShoppingCustomersHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("mostShoppingCustomersHeader is " + mostShoppingCustomersHeader);

        driver.findElement(By.linkText("Settings")).click();
        boolean settingsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("settingsHeader is " + settingsHeader);

        driver.findElement(By.linkText("Defaults")).click();
        boolean defaultsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("defaultsHeader is " + defaultsHeader);

        driver.findElement(By.linkText("Store Info")).click();
        boolean storeInfoHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("storeInfoHeader is " + storeInfoHeader);

        driver.findElement(By.linkText("General")).click();
        boolean generalHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("generalHeader is " + generalHeader);

        driver.findElement(By.linkText("Listings")).click();
        boolean listingsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("listingsHeader is " + listingsHeader);

        driver.findElement(By.linkText("Images")).click();
        boolean imagesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("imagesHeader is " + imagesHeader);

        driver.findElement(By.linkText("Checkout")).click();
        boolean checkoutHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("checkoutHeader is " + checkoutHeader);

        driver.findElement(By.linkText("Advanced")).click();
        boolean advancedHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("advancedHeader is " + advancedHeader);

        driver.findElement(By.linkText("Security")).click();
        boolean securityHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("securityHeader is " + securityHeader);

        driver.findElement(By.linkText("Slides")).click();
        boolean slidesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("slidesHeader is " + slidesHeader);

        driver.findElement(By.linkText("Tax")).click();
        boolean taxHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("taxHeader is " + taxHeader);

        driver.findElement(By.linkText("Tax Rates")).click();
        boolean taxRatesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("taxRatesHeader is " + taxRatesHeader);

        driver.findElement(By.linkText("Tax Classes")).click();
        boolean taxClassesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("taxClassesHeader is " + taxClassesHeader);

        driver.findElement(By.linkText("Translations")).click();
        boolean translationsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("translationsHeader is " + translationsHeader);

        driver.findElement(By.linkText("Scan Files")).click();
        boolean scanFilesHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("scanFilesHeader is " + scanFilesHeader);

        driver.findElement(By.linkText("Search Translations")).click();
        boolean searchTranslationsHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("searchTranslationsHeader is " + searchTranslationsHeader);

        driver.findElement(By.linkText("CSV Import/Export")).click();
        boolean CSVImportExportHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("CSVImportExportHeader is " + CSVImportExportHeader);

        driver.findElement(By.linkText("Users")).click();
        boolean usersHeader = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("usersHeader is " + usersHeader);

        driver.findElement(By.xpath("//span[@class=\"fa-stack fa-lg icon-wrapper\"]/following-sibling::span[contains(text(), 'vQmods')]")).click();
        boolean vQmodsHeader1 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("vQmodsHeader1 is " + vQmodsHeader1);

        driver.findElement(By.xpath("//ul[@class=\"docs\"]//span[contains(text(), 'vQmods')]")).click();
        boolean vQmodsHeader2 = isElementPresent(driver, By.xpath("//h1"));
        System.out.println("vQmodsHeader2 is " + vQmodsHeader2);
    }
}
