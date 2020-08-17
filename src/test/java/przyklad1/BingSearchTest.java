package przyklad1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        //Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Bing
        driver.get("https://www.bing.com/");
    }

    @Test
    public void bingSearchTest(){

        String phrase = "Mistrzostwa Europy w pilce noznej 2021";

        // znajdz pole do wpisywania tekstu do wyszukania
        WebElement phraseInputElement = driver.findElement(By.name("q"));
        phraseInputElement.clear();
        phraseInputElement.sendKeys(phrase);
        phraseInputElement.submit();

        String title = driver.getTitle();

        Assert.assertTrue(title.contains(phrase));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
