package lesson5.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage {
    static final Logger logger = LoggerFactory.getLogger(ContactUsPage.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

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

    @Step("openContactUsPage")
    public ContactUsPage openContactUsPage() {
        driver.get("http://www.automationpractice.pl/index.php?controller=contact");
        return this;
    }

    public enum SubjectHeading {
        SERVICE, WEBMASTER
    }

    @Step("selectHeading")
    public ContactUsPage selectHeading(SubjectHeading heading) {
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        logger.info("Selecting value from Heading");
        Select select = new Select(selectLocator);
        switch (heading) {
            case SERVICE:
                select.selectByVisibleText("Customer service");
                break;
            case WEBMASTER :
                select.selectByVisibleText("Webmaster");
                break;
        }
        return this;
    }
    @Step("setEmail")
    public ContactUsPage setEmail(String email) {
        logger.info("setting up email");
        emailAddress.sendKeys(email);
        return this;
    }
    @Step("setOrderReference")
    public ContactUsPage setOrderReference(int reference) {
        logger.info("setting up order reference");
        orderReference.sendKeys(String.valueOf(reference));
        return this;
    }
    @Step("setMessage")
    public ContactUsPage setMessage(String message1) {
        logger.info("setting up order message");
        message.sendKeys(String.valueOf(message1));
        return this;
    }
    @Step("clickSendButton")
    public ContactUsPage clickSendButton() {
        logger.info("click send button");
        submitButton.click();
        return this;
    }
    @Step("checkSuccessMessage")
    public ContactUsPage checkSuccessMessage() {
        Assert.assertEquals(getSuccessMessage(), "Your message has been successfully sent to our team.");
        return this;
    }

    @Step("checkAlertMessage")
    public ContactUsPage checkAlertMessage() {
        Assert.assertEquals(getAlertMessage(), "The message cannot be blank.");
        return this;
    }
    @Step("getSuccessMessage")
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }

    @Step("getAlertMessage")
    public String getAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(alertMessage)).getText();
    }
}
