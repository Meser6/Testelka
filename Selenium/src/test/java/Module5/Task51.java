package Module5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task51 {
    /*
Napisz testy logowania. Skorzystaj ze strony https://fakestore.testelka.pl/moje-konto/.
Testy powinny zawierać:

co najmniej jeden happy path (czyli przypadek poprawnego logowania),
co najmniej jeden przypadek negatywny (czyli, gdy coś pójdzie nie tak w trakcie logowania),
Pomiń użycie checkboxa „Zapamiętaj mnie” i testy przypominania hasła. Wykorzystaj poznane metody.
     */

    WebDriver driver;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fakestore.testelka.pl/moje-konto/");

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void correctLogin() {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("hibkub@vp.pl");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Kubek666!");
        driver.findElement(By.cssSelector("button[value='Zaloguj się']")).click();

        String actualUserName = driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content strong")).getText().toLowerCase();

        Assertions.assertEquals("hibkub", actualUserName);
    }

    @Test
    public void incorrectEmail() {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Test@vp.pl");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Kubek666!");
        driver.findElement(By.cssSelector("button[value='Zaloguj się']")).click();

        String actualText = driver.findElement(By.cssSelector("*[class=\"woocommerce-error\"] > li")).getText();
        String expectedText = "Nieznany adres email. Proszę sprawdzić ponownie lub wypróbować swoją nazwę użytkownika.";

        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    public void incorrectUserName() {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Test@vp.pl");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Kubek666!");
        driver.findElement(By.cssSelector("button[value='Zaloguj się']")).click();

        String actualText = driver.findElement(By.cssSelector("*[class=\"woocommerce-error\"] > li")).getText();
        String expectedText = "Nieznany adres email. Proszę sprawdzić ponownie lub wypróbować swoją nazwę użytkownika.";

        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    public void incorrectPassword() {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("hibkub@vp.pl");
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("Kubek666");
        driver.findElement(By.cssSelector("button[value='Zaloguj się']")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".woocommerce-error strong"));

        String error = list.get(0).getText();
        String email = list.get(1).getText();

        Assertions.assertEquals("BŁĄD hibkub@vp.pl", error + " " + email);
    }

    @Test
    public void emptyUsername(){
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("Kubek666!");
        driver.findElement(By.cssSelector("button[value='Zaloguj się']")).click();

        String actualError = driver.findElement(By.cssSelector(".woocommerce-error  strong")).getText();

        Assertions.assertEquals("Błąd:", actualError);

    }

    @Test
    public void emptyPassword(){ //TODO
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("hibkub@vp.pl");
        driver.findElement(By.cssSelector("button[value='Zaloguj się']")).click();

        String actualError = driver.findElement(By.xpath(".woocommerce  strong")).getText();

        Assertions.assertEquals("Błąd", actualError);

    }
}
