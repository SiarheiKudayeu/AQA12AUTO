package lesson2.webElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

public class WebElementExampleClassBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.driverInit();

        //isDisplayed, isSelected, isEnabled
        driver.get(URL.AUTO_PRACTICE_BOX.getUrl());
        Thread.sleep(2000);
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='layered_category_4']"));
        System.out.println("Before click:");
        System.out.println("isDisplayed(): " + checkBox.isDisplayed());
        System.out.println("isSelected(): " + checkBox.isSelected());
        System.out.println("isEnabled(): " + checkBox.isEnabled());
        checkBox.click();
        System.out.println("After click:");
        System.out.println("isDisplayed(): " + checkBox.isDisplayed());
        System.out.println("isSelected(): " + checkBox.isSelected());
        System.out.println("isEnabled(): " + checkBox.isEnabled());

        driver.manage().window().setSize(new Dimension(800, 600));

        System.out.println("====================IS DISPLAYED CHECK================");
        System.out.println(driver.findElement
                (By.xpath("//a[@href=\"http://www.automationpractice.pl/index.php?id_category=3&controller=category#categories-tops\"]")).isDisplayed());
        driver.quit();
    }
}
