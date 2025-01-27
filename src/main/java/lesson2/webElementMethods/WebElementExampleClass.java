package lesson2.webElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

public class WebElementExampleClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.driverInit();

        //sendKeys, click, clear
/*        WebElement searchHeaderIcon = driver.findElement(By.id("search"));
        searchHeaderIcon.click();*/
/*        driver.get(URL.GUINNESS_SEARCH.getUrl());
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("publicSearchBar"));
        searchField.sendKeys("Handstand");
        Thread.sleep(2000);
        searchField.clear();
        Thread.sleep(2000);*/

        //GET
        System.out.println("============GET FROM ELEMENT============");
        driver.get(URL.GUINNESS.getUrl());
        Thread.sleep(2000);
        WebElement applyNowButton = driver.findElement(By.cssSelector(".btn.btn-icon"));
        System.out.println("Text from element: " + applyNowButton.getText());
        System.out.println("Tag name from element: " + applyNowButton.getTagName());
        System.out.println("Attribute name: " + applyNowButton.getAttribute("target"));
        System.out.println("Css value from element:" + applyNowButton.getCssValue("background-color"));

        System.out.println("============Coordinates============");
        System.out.println("Location is:" + applyNowButton.getLocation());
        System.out.println("X coordinate is:" + applyNowButton.getLocation().x);
        System.out.println("Y coordinate is:" + applyNowButton.getLocation().y);

        System.out.println("============Size============");
        System.out.println("Size is:" + applyNowButton.getSize());
        System.out.println("Width coordinate is:" + applyNowButton.getSize().width);
        System.out.println("Height coordinate is:" + applyNowButton.getSize().height);
        driver.quit();
    }
}
