package lesson1.driver_init;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFirstAttemptClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
/*        driver.get("https://www.guinnessworldrecords.com/records/");

        Thread.sleep(2000);
        //By locator = By.id("search");
        //LOCATORS

        //id
        driver.findElement(By.id("search")).click();
        Thread.sleep(2000);

        //name
        driver.findElement(By.name("publicSearchBar")).sendKeys("Handstand");
        Thread.sleep(2000);

        //className
        //driver.findElement(By.className("green-background")).click();

        driver.findElement(By.name("publicSearchBar")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //tagName
        System.out.println(driver.findElement(By.tagName("h2")).getText());*/

        //linkText
/*        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/records");
        Thread.sleep(3000);
        driver.findElement(By.linkText("APPLICATION PROCESS")).click();*/

        //partialLinkText
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/records");
        driver.findElement(By.partialLinkText("ION PROCESS")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
