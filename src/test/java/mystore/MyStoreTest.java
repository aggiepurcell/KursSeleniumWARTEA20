package mystore;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class MyStoreTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Otworz strone sklepu my store
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void searchTest() {
        WebElement searchBox = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        String[] products = {"tshirt", "mug", "notebook", "bag"};
        System.out.println("Length is: " + products.length);
        Random rand = new Random(products.length);

        // Ustawienie seed'a zeby za kazdym razem sekwencja losowych liczb byla inna
        rand.setSeed(System.currentTimeMillis());

        // Dla sprawdzenia dzialania losowania:
        for (int i = 0; i < 20; ++i) {
            System.out.println("Index: " + rand.nextInt(products.length));
            System.out.println("Value: " + products[rand.nextInt(products.length)]);
        }
        // Losowanie produktu i wyszukanie go w sklepie
        String product = products[rand.nextInt(products.length)];
        searchBox.sendKeys(product);
        searchBox.submit();
    }
}