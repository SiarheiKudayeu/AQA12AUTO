package lesson5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage {

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


    public ContactUsPage openContactUsPage(){
        driver.get("http://www.automationpractice.pl/index.php?controller=contact");
        return this;
    }

    public enum SubjectHeading{
        SERVICE, WEBMASTER
    }

    public ContactUsPage selectHeading(SubjectHeading heading){
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        Select select = new Select(selectLocator);
        switch (heading){
            case SERVICE -> select.selectByVisibleText("Customer service");
            case WEBMASTER -> select.selectByVisibleText("Webmaster");
        }
        return this;
    }

    public ContactUsPage setEmail(String email){
        emailAddress.sendKeys(email);
        return this;
    }

    public ContactUsPage setOrderReference(int reference){
        orderReference.sendKeys(String.valueOf(reference));
        return this;
    }

    public ContactUsPage setMessage(String message1){
        message.sendKeys(String.valueOf(message1));
        return this;
    }

    public ContactUsPage clickSendButton(){
        submitButton.click();
        return this;
    }

    public ContactUsPage checkSuccessMessage(){
        Assert.assertEquals(getSuccessMessage(), "Your message has been successfully sent to our team.");
        return this;
    }

    public ContactUsPage checkAlertMessage(){
        Assert.assertEquals(getAlertMessage(), "The message cannot be blank.");
        return this;
    }

    public String getSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }

    public String getAlertMessage(){
        return wait.until(ExpectedConditions.visibilityOf(alertMessage)).getText();
    }
}
