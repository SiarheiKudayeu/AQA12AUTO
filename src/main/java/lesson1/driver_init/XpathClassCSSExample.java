package lesson1.driver_init;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathClassCSSExample {
    public static void main(String[] args) throws InterruptedException {
        //    //tagName[@nameAttribute = 'valueAttribute']

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/records");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@alt='APPLICATION PROCESS']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='search']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("publicSearchBar")).sendKeys("Handstand");

        //xpath using text
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(2000);

        //поиск по части атрибута -> //a[contains(@alt,'TION ')]
        //поиск по части текста -> //a[contains(text(),'TION ')]
        //xpath и несколько атрибутов //a[@id="search"][@title='Search']


                /*
        /.. вверх по дереву
        /tag_name вниз к указанному тегу
        /parent::tag_name переход на родительский тег
        /child::tag_name переход на дочерний тег
        //following-sibling::tag_name перход на параллельный тег
         */

        // /html/body/main/section[1]/div/div[3]/a

        // //*[@id='main']//a[contains(text(), 'Apply')]

        //CSS SELECTOR
        //tagName
        By tagName = By.cssSelector("h2");
        //id
        By idName = By.cssSelector("#main");
        //className
        By className = By.cssSelector(".btn.btn-icon");
        //attribute - value
        By attributeValue = By.cssSelector("a[alt='APPLICATION PROCESS']");

        driver.quit();
    }
}
