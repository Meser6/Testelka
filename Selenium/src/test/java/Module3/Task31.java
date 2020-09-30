package Module3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task31 {

    /*
Zlokalizuj za pomocą selektorów CSS poniższe obiekty.
Skorzystaj ze strony https://fakestore.testelka.pl/moje-konto/.

http://testelka.pl/wp-content/uploads/zadanie-laczenie-warunkow.png
     */
    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fakestore.testelka.pl/moje-konto/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void findUsernameArea() {
        driver.findElement(By.cssSelector("#username"));
    }

    @Test
    public void findPasswordArea() {
        driver.findElement(By.cssSelector("input[autocomplete='current-password']"));
    }

    @Test
    public void findRememberMe() {
        driver.findElement(By.cssSelector("[name='rememberme']"));
    }

    @Test
    public void findLoginButton() {
        driver.findElement(By.cssSelector("button[name=login]"));
    }

    @Test
    public void findDoNotRememberPassword() {
        driver.findElement(By.cssSelector("p[class='woocommerce-LostPassword lost_password'] > a"));
    }

    @Test
    public void findEmailAreaToRegistry() {
        driver.findElement(By.cssSelector("#reg_email"));
    }

    @Test
    public void findPasswordAreaToRegistry() {
        driver.findElement(By.cssSelector("input[autocomplete='new-password']"));
    }

    @Test
    public void findRegistryButton() {
        driver.findElement(By.cssSelector("button[name='register']"));
    }

    @Test
    public void findClimbingCategory() {
        driver.findElement(By.cssSelector("li[class=\"cat-item cat-item-16\"] > a"));
    }
}
