package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup(); // Устанавливаем драйвер
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login"); // URL страницы входа
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));

        emailField.sendKeys("user@example.com");
        passwordField.sendKeys("password123");
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should see the welcome message")
    public void i_should_see_the_welcome_message() {
        WebElement welcomeMessage = driver.findElement(By.id("welcome-message"));
        assertTrue(welcomeMessage.isDisplayed(), "Welcome message is not displayed");
        driver.quit();

        package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

        @Suite
        @IncludeEngines("cucumber")
        @SelectClasspathResource("features") // Путь к feature-файлам
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
        public class RunCucumberTest {
        }