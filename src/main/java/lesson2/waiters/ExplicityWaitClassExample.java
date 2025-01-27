package lesson2.waiters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.constants.URL;

import java.time.Duration;

public class ExplicityWaitClassExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));


/*        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        WebElement searchHeaderIcon = driver.findElement(By.id("search"));*/

        driver.get(URL.GUINNESS_LOGIN.getUrl());
        By password = By.name("password");
        By email = By.name("email");
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(email), "AQA12"));
        driver.findElement(password).sendKeys("Password!!!");
        Thread.sleep(4000);
        driver.quit();
    }
}
