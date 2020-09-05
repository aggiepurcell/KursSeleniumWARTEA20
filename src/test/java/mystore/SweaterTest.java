package mystore;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SweaterTest {

    private WebDriver driver;

    @Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Otworz strone sklepu my store
        driver.get("https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s");


        WebElement sizeDropdown = driver.findElement(By.id("group_1"));
        sizeDropdown.sendKeys("M");
        wait.until(ExpectedConditions.urlContains("2-size-m"));
        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.clear();
        quantity.sendKeys("5");


    }
}
