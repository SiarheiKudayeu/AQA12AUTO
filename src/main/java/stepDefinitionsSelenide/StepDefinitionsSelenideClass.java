package stepDefinitionsSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepDefinitionsSelenideClass {


    private static final SelenideElement selectLocator = $(By.id("id_contact"));
    private static final SelenideElement emailAddress = $(By.id("email"));
    private static final SelenideElement orderReference = $(By.id("id_order"));
    private static final SelenideElement message = $(By.id("message"));
    private static final SelenideElement submitButton = $(By.name("submitMessage"));
    private static final SelenideElement successMessage = $(By.xpath("//*[@class='alert alert-success']"));


    @Given("Set up driver Selenide")
    public void setUpDriverSelenide() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";

    }

    @When("open contact us page Selenide")
    public void openContactUsPageSelenide() {
        open("http://www.automationpractice.pl/index.php?controller=contact");
    }

    @When("I select option from subject heading Selenide")
    public void iSelectOptionFromSubjectHeadingSelenide() {
        emailAddress.should(Condition.visible);
        selectLocator.selectOptionContainingText("Customer service");
    }

    @And("I set valid mail Selenide {string}")
    public void iSetValidMailSelenide(String arg0) {
        emailAddress.setValue(arg0);
    }

    @When("I set valid orderID Selenide")
    public void iSetValidOrderIDSelenide() {
        orderReference.setValue("123345");
    }

    @And("I set valid message Selenide")
    public void iSetValidMessageSelenide() {
        message.setValue("AQA MESSAGE");
    }

    @And("clicking on Send Button Selenide")
    public void clickingOnSendButtonSelenide() {
        submitButton.click();
    }

    @Then("I see success alert message Selenide")
    public void iSeeSuccessAlertMessageSelenide() {
        successMessage.shouldBe(Condition.text("Your message has been successfully sent to our team."));
    }
}
