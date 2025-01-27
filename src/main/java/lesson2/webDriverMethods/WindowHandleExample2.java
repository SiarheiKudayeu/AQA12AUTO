package lesson2.webDriverMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

import java.util.Set;

public class WindowHandleExample2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.driverInit();
        driver.get(URL.GUINNESS.getUrl());
        Set<String> windowHandle = driver.getWindowHandles();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> windowHandle2 = driver.getWindowHandles();
        windowHandle2.removeAll(windowHandle);
        String newWindowHandle = windowHandle2.iterator().next();
        driver.switchTo().window(newWindowHandle);

        driver.get(URL.AUTO_PRACTICE.getUrl());
        Thread.sleep(3000);
        driver.quit();
    }
}
