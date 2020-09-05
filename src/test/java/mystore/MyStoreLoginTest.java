package mystore;

import helpers.ScreenshotShooter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class MyStoreLoginTest {

    private WebDriver driver;
    private ScreenshotShooter screenshotShooter = new ScreenshotShooter();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Otworz strone sklepu my store
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void loginWithProperDataNoPageObject() {
        // wpisz email
        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.sendKeys("johnd@mail.com");
        // wpisz haslo
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("qwerty");
        // zaloguj sie
        driver.findElement(By.id("submit-login")).click();

        // sprawdzenie, czy udalo sie zalogowac
        WebElement userFullNameLabel = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]//span"));
        Assert.assertEquals("John Doe", userFullNameLabel.getText());
        screenshotShooter.captureScreenshot(driver);
    }

    @Test
    public void loginWithProperDataPOP() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        String username = loginPage.getLoggedUsername();
        Assert.assertEquals("John Doe", username);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
