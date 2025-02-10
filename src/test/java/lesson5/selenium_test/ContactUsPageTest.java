package lesson5.selenium_test;

import lesson5.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import utils.listeners.MyTestListener;

@Listeners({MyTestListener.class})
public class ContactUsPageTest {
    private static WebDriver driver;
    private static ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.driverInit();
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void sendMessagePositive() {
        contactUsPage.openContactUsPage()
                .selectHeading(ContactUsPage.SubjectHeading.SERVICE)
                .setEmail("mail@mail.mail")
                .setOrderReference(124353)
                .setMessage("Test Message")
                .clickSendButton()
                .checkSuccessMessage();
    }

    @Test
    public void sendMessageNegative() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectHeading(ContactUsPage.SubjectHeading.SERVICE);
        contactUsPage.setEmail("mail@mail.mail");
        contactUsPage.setOrderReference(124353);
        contactUsPage.clickSendButton();
        Assert.assertEquals(contactUsPage.getAlertMessage(), "The message cannot be blank.");
    }

    @Test
    public void sendMessageNegativeWithFailure() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectHeading(ContactUsPage.SubjectHeading.SERVICE);
        contactUsPage.setEmail("mail@mail.mail");
        contactUsPage.setOrderReference(124353);
        contactUsPage.clickSendButton();
        Assert.assertEquals(contactUsPage.getAlertMessage(), "The message cannot be blank!");
    }
}
