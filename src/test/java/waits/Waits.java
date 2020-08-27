package waits;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

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
        driver.get("http://www.webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test
    public void nowWaitAtAll() {
        driver.findElement(By.cssSelector("#button1 > p")).click();
    }

    @Test
    public void threadSleep(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("#button1 > p")).click();
    }

    @Test
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#button1 > p")).click();
    }

    @Test
    public void explicitlyWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button1 > p"))).click();

        //WebElement button = driver.findElement(By.cssSelector("#button1 > p"));
        //wait.until(ExpectedConditions.elementToBeClickable(button));
        //button.click();
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
