package stepDefinitionsSelenium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lesson5.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.driver.DriverSetUp;

import java.time.Duration;

public class StepDefinitionsSeleniumClass {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "id_contact")
    private static WebElement selectLocator;

    @FindBy(id = "email")
    private static WebElement emailAddress;

    @FindBy(id = "id_order")
    private static WebElement orderReference;

    @FindBy(id = "message")
    private static WebElement message;

    @FindBy(name = "submitMessage")
    private static WebElement submitButton;

    @FindBy(xpath = "//*[@class='alert alert-danger']//li")
    private static WebElement alertMessage;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    private static WebElement successMessage;

    @Given("Set up driver")
    public void set_up_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @When("I select option from subject heading")
    public void i_select_option_from_subject_heading() {
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        Select select = new Select(selectLocator);
        select.selectByVisibleText("Customer service");
    }

    @And("I set valid mail {string}")
    public void i_set_valid_mail(String text) {
        emailAddress.sendKeys(text);
    }

    @And("I set valid orderID")
    public void i_set_valid_order_id() {
        orderReference.sendKeys("12345");
    }

    @And("I set valid message")
    public void i_set_valid_message() {
        message.sendKeys("AQA MESSAGE");
    }

    @And("clicking on Send Button")
    public void clicking_on_send_button() {
        submitButton.click();
    }

    @Then("I see success alert message")
    public void iSeeSuccessAlertMessage() {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(successMessage)).getText(), "Your message has been successfully sent to our team.");
    }

    @When("open contact us page")
    public void openContactUsPage() {
        driver.get("http://www.automationpractice.pl/index.php?controller=contact");
    }
}
