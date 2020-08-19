package przyklad1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Otworz strone wikipedia
        driver.get("https://pl.wikipedia.org/");
    }

    @Test
    public void wikiTest() {
        // metoda .getText()
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());

        //.getAttribute()
        final WebElement mainPageElement = driver.findElement(By.id("main-page-content"));
        String attribute = mainPageElement.getAttribute("class");
        System.out.println("Attribute is: " + attribute);

        //.getTagName()
        String tag = mainPageElement.getTagName();
        System.out.println("Tag is: " + tag);

        //.isEnabled()
        WebElement searchInputElement = driver.findElement(By.id("searchInput"));
        if (searchInputElement.isEnabled()) {
            searchInputElement.sendKeys("Selenium");
            searchInputElement.submit();
        } else {
            Assert.fail();
        }

        //.isDisplayed()
        if (searchInputElement.isDisplayed()) {
            searchInputElement.sendKeys("Selenium");
            searchInputElement.submit();
        } else {
            Assert.fail();
        }
    }
}