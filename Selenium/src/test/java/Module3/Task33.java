package Module3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task33 {

    /*
Skorzystaj ze strony: https://fakestore.testelka.pl/wyszukiwanie-elementow-poprzez-relacje/.
Wyszukaj poniższe elementy.
1. Znajdź pole do wpisania imienia w pierwszym formularzu.
2. Znajdź pole do wpisania adresu email w trzecim formularzu.
3. Znajdź pole do wpisania adresu email w trzecim formularzu używając selektorów pseudoklas.
4. Znajdź przycisk „Subscribe” w piątym formularzu.
5. Znajdź przycisk „Subscribe” w piątym formularzu używając selektorów pseudoklas.
6. Znajdź przycisk „Subscribe” w drugim formularzu.
7. Znajdź przycisk „Subscribe” w drugim formularzu używając selektorów pseudoklas.
     */
    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://fakestore.testelka.pl/wyszukiwanie-elementow-poprzez-relacje/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void one() {
        driver.findElement(By.cssSelector("#name"));
    }

    @Test
    public void two() {
        driver.findElement(By.cssSelector("div.second-div>#email"));
    }

    @Test
    public void three() {
        driver.findElement(By.cssSelector("div.second-div>input:first-of-type"));
    }

    @Test
    public void four() {
        driver.findElement(By.cssSelector(".second-div>.div>#submit"));
    }

    @Test
    public void five() {
        driver.findElement(By.cssSelector("div[class='second-div']:last-child #submit"));
    }

    @Test
    public void  six() {
        List<WebElement> list = driver.findElements(By.cssSelector("button#submit"));
        WebElement button = list.get(0);
    }

    @Test
    public void seven() {
        driver.findElement(By.cssSelector("div.entry-content button#submit"));
    }

}
