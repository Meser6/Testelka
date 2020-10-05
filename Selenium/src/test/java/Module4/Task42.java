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

public class Task42 {

    /*
Zlokalizuj zaznaczone elementy.
Pamiętaj, że nie możesz ich zlokalizować po tekście (nie bezpośrednio, ale rodzica jeżeli to ma sens, już możesz!).
Skorzystaj ze strony: https://fakestore.testelka.pl/cwiczenia-z-selektorow-xpath/.
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fakestore.testelka.pl/cwiczenia-z-selektorow-xpath/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void findAddress() {
        List<WebElement> list = driver.findElements(By.xpath(".//div[@class='entry-content']//td[2]"));
        WebElement address = list.get(0);
        Assertions.assertNotEquals(0, list.size());
    }

    @Test
    public void findQuantityForSelfAdhesivePads() {
        List<WebElement> list = driver.findElements(By.xpath(".//div[@class='entry-content']//td[2]"));
        WebElement quantity = list.get(1);
        Assertions.assertNotEquals(0, list.size());
    }

    @Test
    public void findPricePerItemForSelfAdhesivePads() {
        WebElement price = driver.findElement(By.xpath(".//div[@class='entry-content']//td[3]"));
    }

    @Test
    public void findSelfAdhesivePadsCost() {
        List<WebElement> list = driver.findElements(By.xpath(".//div[@class='entry-content']//td[4]"));
        WebElement cost = list.get(0);
        Assertions.assertNotEquals(0, list.size());
    }


}
