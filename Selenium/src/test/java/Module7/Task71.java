package Module7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Task71 { // TODO

    /*
Napisz test potwierdzający działanie wiadomości i alertów przy dodawaniu i usuwaniu pojedynczego kuponu na stronie.
Użyj przypadków pozytywnych i negatywnych.
Test może się rozpocząć już na stronie konkretnego produktu.
Uwzględnij przypadek z dodaniem prawidłowego kuponu dwa razy do koszyka.
Użyj kuponu „10procent”.
     */

    WebDriver driver;
    WebDriverWait wait;

    String coupon;

    @BeforeEach
    public void chromeSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fakestore.testelka.pl");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        addSomethingToCart();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    public void addSomethingToCart(){
        driver.findElement(By.cssSelector("*[alt=\"Wspinaczka\"]")).click();
        By productsCategory = By.cssSelector("*[data-product_id=\"40\"]");
        WebElement clickProductCategory = wait.until(ExpectedConditions.presenceOfElementLocated(productsCategory));
        clickProductCategory.click();
        By lookItCart = By.cssSelector("a[title=\"Zobacz koszyk\"]");
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(lookItCart));
        cart.click();
    }

    public void addCoupon(String coupon){
        this.coupon = coupon;
        driver.findElement(By.cssSelector("#coupon_code")).sendKeys(coupon);
        driver.findElement(By.cssSelector("button[value=\"Zastosuj kupon\"]")).click();
    }

    public String AlertAfterAddCoupon(){
        return driver.findElement(By.cssSelector(".woocommerce-message")).getText();
    }

    @Test
    public void AddCorrectCoupon(){
        addCoupon("10procent");
        String expected = "Kupon został pomyślnie użyty.";
        Assertions.assertEquals(expected, AlertAfterAddCoupon(), "Coupon: " + coupon +  ". Alert is not correct" );
    }
}
