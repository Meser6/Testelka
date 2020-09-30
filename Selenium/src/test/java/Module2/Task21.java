package Module2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task21 {

    /*
Korzystając ze znanych Ci metod, spróbuj znaleźć na kilka sposobów poniższe elementy na stronie
fakestore.testelka.pl/moje-konto/
szukajka w prawym górnym rogu,
pole do wpisania nazwy użytkownika,
pole do wpisania hasła,
przycisk logowania,
checkbox do zapamiętania hasła,
link do odzyskiwania hasła,
link do kategorii “Żeglarstwo”.
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
    public void findSearchArea(){
        driver.findElement(By.id("woocommerce-product-search-field-0"));
    }

    @Test
    public void findUsersNameArea(){
        driver.findElement(By.name("username"));
    }

    @Test
    public void findPasswordArea(){
        driver.findElement(By.id("password"));
    }

    @Test
    public void findLoginButton(){
        driver.findElement(By.name("login"));
    }

    @Test
    public void findRememberLoginCheckBox(){
        driver.findElement(By.id("rememberme"));
    }

    @Test
    public void findLinkToRecoveryPassword(){
        driver.findElement(By.partialLinkText("pamiętasz"));
    }

    @Test
    public void findLinkToCategorySailing(){
        driver.findElement(By.partialLinkText("Żeglarstwo"));
    }

}
