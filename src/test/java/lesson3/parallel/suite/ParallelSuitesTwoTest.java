package lesson3.parallel.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

import java.time.Duration;

public class ParallelSuitesTwoTest {
    WebDriver driver;
    @BeforeClass
    public void driverSetUp(){
        driver = DriverSetUp.driverInit();
    }

    @AfterClass
    public void stopDriver(){
        driver.quit();
    }

    @Test
    public void checkPageTitle() {
        driver.get(URL.ANDERSEN_MAIN_PAGE.getUrl());
        String expectedTitle = "Andersen: Software Development Company";
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.titleContains("Andersen"));
        Assert.assertTrue(driver.getTitle().equals(expectedTitle), "Page name is " + driver.getTitle() + ", not equals " + expectedTitle);
        By companyHeaderElement = By.xpath("//div[@tabindex=\"Company\"]");
        String actualText = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(companyHeaderElement)).getText();
        Assert.assertFalse(actualText.equals("Companies"));
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertNotEquals(actualText, "Companies");
    }

    @Test
    public void checkPageTitle2() {
        driver.get(URL.ANDERSEN_MAIN_PAGE.getUrl());
        String expectedTitle = "Andersen: Software Development Company";
        Assert.assertTrue(driver.getTitle().equals(expectedTitle), "Page name is " + driver.getTitle() + ", not equals " + expectedTitle);
        By companyHeaderElement = By.xpath("//div[@tabindex=\"Company\"]");
        String actualText = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(companyHeaderElement)).getText();
        Assert.assertFalse(actualText.equals("Companies"));
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertNotEquals(actualText, "Companies");
    }

    @Test
    public void checkPageTitle3() {
        driver.get(URL.ANDERSEN_MAIN_PAGE.getUrl());
        String expectedTitle = "Andersen: Software Development Company";
        Assert.assertTrue(driver.getTitle().equals(expectedTitle), "Page name is " + driver.getTitle() + ", not equals " + expectedTitle);
        By companyHeaderElement = By.xpath("//div[@tabindex=\"Company\"]");
        String actualText = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(companyHeaderElement)).getText();
        Assert.assertFalse(actualText.equals("Companies"));
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertNotEquals(actualText, "Companies");
    }

}
