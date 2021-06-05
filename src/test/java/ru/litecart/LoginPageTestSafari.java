package ru.litecart;
import org.junit.Test;
import org.openqa.selenium.By;


public class LoginPageTestSafari extends TestBase {

    @Test
    public void loginPageTestSafari() {
        driver.get("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
