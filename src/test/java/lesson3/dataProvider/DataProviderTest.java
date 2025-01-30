package lesson3.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;

import java.time.Duration;

public class DataProviderTest {

    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String email, int passwd){
        WebDriver driver = DriverSetUp.driverInit();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(String.valueOf(passwd));
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"alert alert-danger\"])[1]"))).getText(),
                "There is 1 error\n" +
                        "Authentication failed.");
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] createData(){
        return new Object[][]{
                {"email1@email.email", 23723197},{"email2@email.email", 23345197},{"email3@email.email", 23537197},
        };
    }
}
