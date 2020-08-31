package bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QloAccountCreate {

    private WebDriver driver;

    @Given("^user is on the authentication page$")
    public void userIsOnTheAuthenticationPage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // magiczne zaklecie
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");
    }

    @When("^user inputs (.*) into email address field$")
    public void userInputsEmailIntoEmailAddressField(String email) {
        // Znajdź element do wpisania emaila i wpisz email
        WebElement emailField = driver.findElement(By.id("email_create"));
        emailField.click();
        emailField.sendKeys(email);
    }

    @And("^user clicks Create an account button$")
    public void userClicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("^user fills (.*), (.*) and (.*)$")
    public void userFillsFirstNameLastNameAndPassword(
            String firstName,
            String lastName,
            String password) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("^user clicks Register button$")
    public void userClicksRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("^success message appears$")
    public void successMessageAppears() {
        String successMessage = driver.findElement(
                By.cssSelector("#center_column > p.alert.alert-success")).getText();

        Assert.assertTrue(successMessage.contains("Your account has been created."));

        driver.quit();
    }
}
