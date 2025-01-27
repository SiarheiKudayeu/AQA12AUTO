package lesson2.webDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

public class WindowHandleExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.driverInit();
        driver.get(URL.GUINNESS.getUrl());

        Thread.sleep(2000);
        String guinnessWindowHandle = driver.getWindowHandle();
        System.out.println(guinnessWindowHandle);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(URL.AUTO_PRACTICE.getUrl());

        String autoWindowHandle = driver.getWindowHandle();
        System.out.println(autoWindowHandle);

        driver.switchTo().window(guinnessWindowHandle);
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.close();
        Thread.sleep(2000);



        driver.quit();
    }
}
