package przyklad1;

//import org.apache.commons.io.IOUtils;

import helpers.ScreenshotShooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class FormTest {

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

        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void formTest() {
        final WebElement firstNameTextBox = driver.findElement(By.id("first-name"));
        WebElement firstNameHeader = driver.findElement(By.cssSelector("[for='first-name']"));
        String name = "Karolina";
        if (firstNameTextBox.isEnabled()) {
            firstNameTextBox.sendKeys(name);
            System.out.println(firstNameHeader.getText() + " : " + firstNameTextBox.getAttribute("value"));
            assertEquals(name, firstNameTextBox.getAttribute("value"));
        }
        else {
            fail("firstNameTextBox is not enabled");
        }

        final WebElement lastNameTextBox = driver.findElement(By.id("last-name"));
        WebElement lastNameHeader = driver.findElement(By.cssSelector("[for='last-name']"));
        String lastName = "Kowalski";
        if (lastNameTextBox.isDisplayed()) {
            lastNameTextBox.sendKeys(lastName);
            System.out.println(lastNameHeader.getText() + " : " + lastNameTextBox.getAttribute("value"));
            assertEquals(lastName, lastNameTextBox.getAttribute("value"));
        }
        else {
            fail("lastNameTextBox is not enabled");
        }

        // Wybieranie gender - rozwiazania:
        // 1. Najlepsze rozwiazanie: pogadac z front-end developerem zeby dodal id :)

        // 2. Odporne na zmiany kolejnosci, mniej czytelny selector
        WebElement radioButtonFemale = driver.findElement(By.xpath("//label[text()='Female']/input[@name='gender']"));
        WebElement radioButtonMale = driver.findElement(By.xpath("//label[text()='Male']/input[@name='gender']"));

        // 3. Odporne na zmiany, nieodporne na zmiany gdy istnieje wiecej niz jeden element z danym textem na tej samej stronie
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.xpath("//label[text()='In Between']")).click();

        // 4. Nieodporne na zmiany w kolejnosci wyswietlania elementow
        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click(); //Male
        genders.get(1).click(); //Female
        genders.get(2).click(); //In between

        // Sprawdzenie czy radio button jest enabled
        WebElement genderHeader = driver.findElement(By.cssSelector("[for='gender']"));
        if (radioButtonFemale.isEnabled()) {
            radioButtonFemale.click();
            System.out.println(genderHeader.getText() + " : " + radioButtonFemale.getText()); //dla radio button pusty text
            assertTrue(radioButtonFemale.isSelected());
            WebElement femaleRadioLabel = driver.findElement(By.xpath("//label[text()='Female']/input[@name='gender']/.."));
            assertEquals("Female", femaleRadioLabel.getText());
        }
        // Sprawdzanie czy radio button jest wybrany lub nie
        if (radioButtonFemale.isSelected()) {
            System.out.println("Radio Button Female is selected");
        }
        // Zwroccie uwage na zaprzeczenie "!"
        if (!radioButtonMale.isSelected()) {
            System.out.println("Radio Button Male is NOT selected");
        }

        // Dlaczego nie robilismy "jak zwykle"?
        // znajduje tylko pierwszy element - Male
        // driver.findElement(By.name("gender")).click();

        driver.findElement(By.id("dob")).sendKeys("05/22/2010");
        driver.findElement(By.id("address")).sendKeys("Prosta 51");
        driver.findElement(By.id("email")).sendKeys("karol.kowalski@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Pass123");
        driver.findElement(By.id("company")).sendKeys("Coders Lab");

        Select roles = new Select(driver.findElement(By.id("role")));
        roles.selectByVisibleText("QA");

        screenshotShooter.captureScreenshot(driver);

//        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(source_file, new File("src/Screenshots/" + screenshotName ));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(source_file, new File("path/scrsht.png"));
//            //FileUtils.copyFile(source_file, new File("C:/new_temp/scrsht.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void formTestNoFirstName() {
//        final WebElement firstNameTextBox = driver.findElement(By.id("first-name"));
//        WebElement firstNameHeader = driver.findElement(By.cssSelector("[for='first-name']"));
//        String name = "Karolina";
//        if (firstNameTextBox.isEnabled()) {
//            firstNameTextBox.sendKeys(name);
//            System.out.println(firstNameHeader.getText() + " : " + name);
//        }

        final WebElement lastNameTextBox = driver.findElement(By.id("last-name"));
        WebElement lastNameHeader = driver.findElement(By.cssSelector("[for='last-name']"));
        String lastName = "Kowalski";
        if (lastNameTextBox.isDisplayed()) {
            lastNameTextBox.sendKeys(lastName);
            System.out.println(lastNameHeader.getText() + " : " + lastName);
        }

        // Wybieranie gender - rozwiazania:
        // 1. Najlepsze rozwiazanie: pogadac z front-end developerem zeby dodal id :)

        // 2. Odporne na zmiany kolejnosci, mniej czytelny selector
        WebElement radioButtonFemale = driver.findElement(By.xpath("//label[text()='Female']/input[@name='gender']"));
        WebElement radioButtonMale = driver.findElement(By.xpath("//label[text()='Male']/input[@name='gender']"));

        // 3. Odporne na zmiany, nieodporne na zmiany gdy istnieje wiecej niz jeden element z danym textem na tej samej stronie
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.xpath("//label[text()='In Between']")).click();

        // 4. Nieodporne na zmiany w kolejnosci wyswietlania elementow
        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click(); //Male
        genders.get(1).click(); //Female
        genders.get(2).click(); //In between

        // Sprawdzenie czy radio button jest enabled
        WebElement genderHeader = driver.findElement(By.cssSelector("[for='gender']"));
        if (radioButtonFemale.isEnabled()) {
            radioButtonFemale.click();
            System.out.println(genderHeader.getText() + " : " + radioButtonFemale.getText()); //dla radio button pusty text
        }
        // Sprawdzanie czy radio button jest wybrany lub nie
        if (radioButtonFemale.isSelected()) {
            System.out.println("Radio Button Female is selected");
        }
        // Zwroccie uwage na zaprzeczenie "!"
        if (!radioButtonMale.isSelected()) {
            System.out.println("Radio Button Male is NOT selected");
        }

        // Dlaczego nie robilismy "jak zwykle"?
        // znajduje tylko pierwszy element - Male
        // driver.findElement(By.name("gender")).click();

        driver.findElement(By.id("dob")).sendKeys("05/22/2010");
        driver.findElement(By.id("address")).sendKeys("Prosta 51");
        driver.findElement(By.id("email")).sendKeys("karol.kowalski@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Pass123");
        driver.findElement(By.id("company")).sendKeys("Coders Lab");

        Select roles = new Select(driver.findElement(By.id("role")));
        roles.selectByVisibleText("QA");

        driver.findElement(By.id("submit")).click();

        WebElement firstNameValidation = driver.findElement(By.id("first-name-error"));
        assertEquals("This field is required.", firstNameValidation.getText());
        assertTrue(firstNameValidation.isDisplayed());
    }
}
