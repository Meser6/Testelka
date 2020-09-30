package Module1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task12 {

    /*
Przejdź na stronę http://wikipedia.pl
Napisz trzy asercje:
porównaj tytuł strony z oczekiwanym;
porównaj URL strony z oczekiwanym;
znajdź w konsoli deweloperskiej (F12) w zakładce Elements jakiś fragment źródła strony, który mówi o tym w jakiej wersji językowej jest strona; użyj tego fragmentu źródła do asercji.
Zmień język strony na hiszpański (By.cssSelector("a[title='hiszpański']")).
Napisz trzy asercje:
porównaj tytuł strony z oczekiwanym;
porównaj URL strony z oczekiwanym;
znajdź w konsoli deweloperskiej (F12) w zakładce Elements jakiś fragment źródła strony, który mówi o tym w jakiej wersji językowej jest strona; użyj tego fragmentu źródła do asercji.
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pl.wikipedia.org/");
    }

    @AfterEach
    public void closeChrome() {
        driver.quit();
    }

    private void goToSpain() {
        driver.findElement(By.xpath("//*[@id=\"p-lang\"]/div/ul/li[16]/a")).click();
    }

    @Test
    public void getCorrectTitlePL() {
        String getTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(getTitle, driver.getTitle());
    }

    @Test
    public void getCorrectUrlPL() {
        String getURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        Assertions.assertEquals(getURL, driver.getCurrentUrl());
    }

    @Test
    public void getCorrectLanguagePL() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("pl"));
    }

    @Test
    public void getCorrectTitleES() {
        goToSpain();
        String getTitle = "Wikipedia, la enciclopedia libre";
        Assertions.assertEquals(getTitle, driver.getTitle());
    }

    @Test
    public void getCorrectUrlES() {
        goToSpain();
        String getURL = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        Assertions.assertEquals(getURL, driver.getCurrentUrl());
    }

    @Test
    public void getCorrectLanguageES() {
        goToSpain();
        Assertions.assertTrue(driver.getCurrentUrl().contains("es"));
    }
}
