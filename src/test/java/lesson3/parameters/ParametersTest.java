package lesson3.parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

import java.time.Duration;

public class ParametersTest {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void driverSetUp(String browser) {
        switch (browser) {
            case "Edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
                break;
            }
            case "Chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
                break;
            }
        }

    }

    @AfterClass
    public void stopDriver() {
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
}
