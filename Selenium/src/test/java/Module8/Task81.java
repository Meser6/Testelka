package Module8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task81 { //TODO 2-4 nie moze znaleźć frame
    /*
    Napisz poniższe testy. Skorzystaj ze strony https://fakestore.testelka.pl/cwiczenia-z-ramek/:
1. Potwierdź, że pierwszy przycisk „Strona główna” jest nieaktywny.
2. Potwierdź, że obrazek kieruje do strony głównej (sprawdź bez klikania w element).
3. Potwierdź, że ostatni przycisk „>>Strona główna” jest aktywny.
4. Kliknij w przycisk „Wspinaczka” (po wcześniejszym kliknięciu w przycisk „>>Strona główna”)  i potwierdź, że po
przejściu na stronę widoczne jest logo (w tej ramce).
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fakestore.testelka.pl/cwiczenia-z-ramek/");
        driver.findElement(By.cssSelector("a[href='#']")).click();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().frame("main-frame");
    }

    @AfterEach
    public void closeChrome() {
        driver.quit();
    }

    @Test
    public void one() {
        boolean mainPageElement = driver.findElement(By.cssSelector("input[value=\"Strona główna\"]")).isEnabled();
        Assertions.assertFalse(mainPageElement);
    }

    @Test
    public void two() {
        WebElement frame = driver.findElement(By.cssSelector("iframe#main-frame"));
        driver.switchTo().frame(frame)
                .switchTo().frame(0);
        String attribute = driver.findElement(By.cssSelector("div.entry-content>p>a")).getAttribute("href");
        Assertions.assertEquals("https://fakestore.testelka.pl", attribute);
    }

    @Test
    public void three() {
        driver.switchTo().frame("main-frame")
                .switchTo().frame("image")
                .switchTo().frame(0);
        boolean mainPageButton = driver.findElement(By.cssSelector("p>a")).isDisplayed();
        Assertions.assertTrue(mainPageButton);
    }

    @Test
    public void four() {
        driver.switchTo().frame("main-frame")
                .switchTo().frame(0)
                .switchTo().frame(0);
        driver.findElement(By.cssSelector("p>a")).click();
        driver.switchTo().parentFrame()
                .switchTo().parentFrame();
        driver.findElement(By.cssSelector("a[name='climbing']")).click();
        boolean logo = driver.findElement(By.cssSelector("img.custom-logo")).isDisplayed();
        Assertions.assertTrue(logo);
    }
}
