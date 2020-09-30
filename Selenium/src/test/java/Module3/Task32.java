package Module3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task32 {

    /*
Skorzystaj ze strony https://fakestore.testelka.pl/cwiczenia-z-selektorow-fragmenty-wartosci-atrybutow/
Zestawy obiektów do zlokalizowania jednym selektorem:
1. Button1, Button 2, Btn 3, Btn 4
2. Btn 3, Btn 4, Btn 7
3. Btn 3, Btn 7
4. Button1, Button 2, Button 5
5. Button1, Btn 3, Button 5
6. Button 2, Button6, Btn 7
7. Button1, Btn 3, Btn 4, Button 5
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://fakestore.testelka.pl/cwiczenia-z-selektorow-fragmenty-wartosci-atrybutow");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void one() {
        List<WebElement> one = driver.findElements(By.cssSelector("a[id^='b']"));
        Assertions.assertEquals(4, one.size());
    }

    @Test
    public void two() {
        List<WebElement> two = driver.findElements(By.cssSelector("[id*='btn']"));
        Assertions.assertEquals(3, two.size());
    }

    @Test
    public void three() {
        List<WebElement> three = driver.findElements(By.cssSelector("[style$='#db456f']"));
        Assertions.assertEquals(2, three.size());
    }

    @Test
    public void four() {
        List<WebElement> four = driver.findElements(By.cssSelector("[id^='button-']"));
        Assertions.assertEquals(3, four.size());
    }

    @Test
    public void five() {
        List<WebElement> five = driver.findElements(By.cssSelector("[class~='accent']"));
        Assertions.assertEquals(3, five.size());
    }

    @Test
    public void six() {
        List<WebElement> six = driver.findElements(By.cssSelector("[class$='primary test']"));
        Assertions.assertEquals(3, six.size());
    }

    @Test
    public void seven() {
        List<WebElement> seven = driver.findElements(By.cssSelector("[class^='button accent']"));
        Assertions.assertEquals(4, seven.size());
    }

}
