package Module1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11 {

    /*
Otworzy stronę główną Wikipedii.
Następnie otworzy stronę główną Nasa.
Cofnie się do strony Wikipedii (używając nawigacji wstecz).
Potwierdź, że driver jest na stronie Wikipedii: porównaj (Assertions.assertEquals()) tytuł strony z oczekiwanym.
Przejdź do strony Nasa (używając nawigacji naprzód).
Potwierdź, że driver jest na stronie Nasa: porównaj tytuł strony z oczekiwanym.
Zamknij okno przeglądarki.
Zamknij sesję.
     */

    WebDriver driver;
    String wikiTitle = "Wikipedia, wolna encyklopedia";
    String nasaTitle = "NASA";

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://pl.wikipedia.org/");
        driver.get("https://www.nasa.gov/");
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
        driver.quit();
    }

    @Test
    public void correctMoving() {
        driver.navigate().back();
        Assertions.assertEquals(wikiTitle, driver.getTitle(), "Page title is not" + wikiTitle);

        driver.navigate().forward();
        Assertions.assertEquals(nasaTitle, driver.getTitle(), "Page title is not" + nasaTitle);
    }

    @Test
    public void incorrectMoving() {
        driver.navigate().back();
        Assertions.assertNotEquals(nasaTitle, driver.getTitle());

        driver.navigate().forward();
        Assertions.assertNotEquals(wikiTitle, driver.getTitle());

    }
}
