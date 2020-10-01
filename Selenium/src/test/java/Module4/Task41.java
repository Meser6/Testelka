package Module4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task41 {

    /*
Zlokalizuj za pomocą selektorów XPath poniższe obiekty.
Skorzystaj ze strony: https://fakestore.testelka.pl/cwiczenia-z-selektorow-atrybuty-w-xpath.

Zestawy obiektów do zlokalizowania jednym selektorem:
Przyciski 1, 2, 5, 6.
Przyciski 3 i 7.
Przyciski 3, 4, 7.
Przyciski 1, 2, 5.
Przyciski 2, 6, 7.
Przyciski 1, 3, 4, 5.
Przyciski 1, 3, 5.
Przyciski 1 i 5.
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fakestore.testelka.pl/cwiczenia-z-selektorow-atrybuty-w-xpath.");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void one() {
        List<WebElement> list = driver.findElements(By.xpath(".//*[contains(@id,'button')]"));
        Assertions.assertEquals(4, list.size());
    }

    @Test
    public void two() {
        List<WebElement> list = driver.findElements(By.xpath(".//*[contains(@Style,'db456f')]"));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void three() {
        List<WebElement> list = driver.findElements(By.xpath(".//*[contains(text(),'Btn')]"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void four() {
        List<WebElement> list = driver.findElements(By.xpath(".//*[contains(@id,'button-')]"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void five() {
        List<WebElement> list = driver.findElements(By.xpath(".//div/*[contains(@class,'primary')]"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void six() {
        List<WebElement> list = driver.findElements(By.xpath(".//div/*[contains(@class,'accent')]"));
        Assertions.assertEquals(4, list.size());
    }

    @Test
    public void seven() {
        List<WebElement> list = driver.findElements(By.xpath(".//*[not(contains(@class,'test'))  and contains(@class,'accent')]"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void eight() {
        List<WebElement> list = driver.findElements(By.xpath(".//*[contains(@class,'accent') and contains(@id,'button')]"));
        Assertions.assertEquals(2, list.size());
    }


}
