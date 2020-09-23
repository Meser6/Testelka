package ModuleOne;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task13 {
    private WebDriver driver;


    @BeforeEach
    public void chromeSettings() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pl.wikipedia.org/");
    }

    @AfterEach
    public void chromeClose() {
        driver.quit();
    }

    @Test
    public void cookies() {
        //1 Pobierz wszystkie ciasteczka i przy pomocy asercji sprawdź, czy jest ich tyle ile powinno.
        Assertions.assertEquals(3, driver.manage().getCookies().size(), "0");
        //2 Dodaj swoje ciasteczko i potwierdź asercją, że się dodało.
        Cookie newCookie = new Cookie("newCookie",
                "Value",
                ".pl.wikipedia.org",
                "/",
                new GregorianCalendar(2030, Calendar.NOVEMBER, 20).getTime(),
                true,
                true);
        driver.manage().addCookie(newCookie);
        Assertions.assertEquals(4, driver.manage().getCookies().size(), "1");
        //3 Pobierz swoje ciasteczko i użyj asercji, żeby porównać, że nazwa ciasteczka jest taka, jakiej oczekujesz.
        Assertions.assertEquals("Value", driver.manage().getCookieNamed("newCookie").getValue(), "2");
        //4 Usuń swoje ciasteczko używając obiektu typu Cookie jako parametru i potwierdź, że zostało usunięte.
        driver.manage().deleteCookie(newCookie);
        Assertions.assertEquals(3, driver.manage().getCookies().size(), "3");
        //5 Usuń jakieś ciasteczko używając jego nazwy jako parametru i potwierdź, że zostało usunięte.
        driver.manage().deleteCookieNamed("GeoIP");
        Assertions.assertEquals(2, driver.manage().getCookies().size(), "4");
        //6 Pobierz dowolne już istniejące ciasteczko i użyj asercji, żeby potwierdzić, że domena, ścieżka i ustawienie flagi HTTP jest takie, jak tego oczekujemy.
        Cookie cookie = driver.manage().getCookieNamed("WMF-Last-Access");
        Assertions.assertEquals("pl.wikipedia.org", cookie.getDomain(),"5");
        Assertions.assertEquals("/", cookie.getPath(),"6");
        Assertions.assertTrue(cookie.isHttpOnly(), "7");
    }

}
