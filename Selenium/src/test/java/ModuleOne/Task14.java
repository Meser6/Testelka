package ModuleOne;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task14 {

    /*
Ustaw rozmiar okna przeglądarki na 854×480.
Ustaw pozycję okna przeglądarki na 445×30.
Pobierz rozmiar okna i wykonaj asercję.
Pobierz pozycję okna i wykonaj asercję.
Zmaksymalizuj okno przeglądarki.
Ustaw przeglądarkę na fullscreen.
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.onet.pl/");
    }

    @AfterEach
    public void chromeClose() {
        driver.quit();
    }

    @Test
    public void shouldGetCorrectSize() {
        driver.manage().window().setSize(new Dimension(854, 480));
        var expectedSize = new Dimension(854,480);
        var actualSize = driver.manage().window().getSize();
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldGetCorrectPosition(){
        driver.manage().window().setPosition(new Point(445, 30));
        var expectedPosition = new Point(445, 30);
        var actualPosition = driver.manage().window().getPosition();
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void itIsNotTest(){
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }
}
