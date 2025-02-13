package lesson5.selenium_test;

import io.qameta.allure.*;
import lesson1.driver_init.DriverSetUpMain;
import lesson5.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.MyAllureListeners;

@Listeners({MyAllureListeners.class})
public class ContactUsPageTest {
    private static WebDriver driver;
    private static ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUpMain.startDriver();
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }


    @Description("This is test for checking positive sending message")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Epic 1")
    @Story("US 1.1")
    @TmsLink("https://directority.testrail.io/index.php?/cases/view/9")
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

    @Description("This is test for checking positive sending message")
    @Severity(SeverityLevel.MINOR)
    @Epic("Epic 1")
    @Story("US 1.1")
    @TmsLink("https://directority.testrail.io/index.php?/cases/view/10")
    @Test
    public void sendMessageNegative() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectHeading(ContactUsPage.SubjectHeading.SERVICE);
        contactUsPage.setEmail("mail@mail.mail");
        contactUsPage.setOrderReference(124353);
        contactUsPage.clickSendButton();
        Assert.assertEquals(contactUsPage.getAlertMessage(), "The message cannot be blank.");
    }

    @Description("This is test for checking negative sending message")
    @Severity(SeverityLevel.TRIVIAL)
    @Epic("Epic 1")
    @Story("US 1.2")
    @TmsLink("https://directority.testrail.io/index.php?/cases/view/11")
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
