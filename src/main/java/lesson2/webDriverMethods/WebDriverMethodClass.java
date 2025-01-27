package lesson2.webDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.DriverSetUp;

import java.util.List;

public class WebDriverMethodClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.driverInit();

        //manage - цепочка методов для настройки драйвера
        driver.manage().window().maximize();

        //get - откытие URL
        driver.get("https://www.guinnessworldrecords.com/records/");


        //findElement - возвращает WebElement
        //findElements - возвращает List WebElement

        Thread.sleep(2000);
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='columned']"));
        int counter = 1;
/*        for (WebElement element : webElementList) {
            System.out.println(counter + ") " + element.getText());
            counter++;
        }*/


        //getTitle(), getPageSource(), getCurrentUrl()
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Page URL: " + driver.getCurrentUrl());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        //System.out.println(driver.getPageSource());

        //getCookies()
/*        counter = 1;
        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println(counter + ") " + cookie);
            counter++;
        }*/
        System.out.println("=========");
        System.out.println("All count of cookies " + driver.manage().getCookies().size());
        System.out.println("Separate cookie " + driver.manage().getCookies().toArray()[2]);

        //navigate
        driver.navigate().to("http://www.automationpractice.pl/index.php");
        Thread.sleep(1000);
        System.out.println("After redirection to URL: " + driver.getTitle() + ", " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("After redirection back: " + driver.getTitle() + ", " + driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.navigate().forward();
        System.out.println("After redirection forward: " + driver.getTitle() + ", " + driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);



        driver.quit();

    }
}
