package lesson7.calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarClass {
    static By year = By.xpath("//button[text()='<']/following-sibling::select[1]");
    static By month = By.xpath("//button[text()='<']/following-sibling::select[2]");
    static By day = By.xpath("//div[contains(@aria-label,\"Choose \")]");
    static By dateOfBirth = By.xpath("//*[@name=\"dateOfBirth\"]");

    static WebDriver driver;
    static WebDriverWait wait;

    // 25/04/1989
    public static void setDate(String date, WebDriver driver) throws InterruptedException {
        String dayOf = date.split("/")[0];
        LocalDate dateOfBirthday = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String monthOf = dateOfBirthday.getMonth().name().charAt(0) + dateOfBirthday.getMonth().name().substring(1).toLowerCase();
        String yearOf = date.split("/")[2];

        wait.until(ExpectedConditions.visibilityOfElementLocated(year));
        new Select(driver.findElement(year)).selectByVisibleText(yearOf);
        new Select(driver.findElement(month)).selectByVisibleText(monthOf);
        Thread.sleep(3000);
        for (WebElement element : driver.findElements(day)) {
            if (element.getText().equals(dayOf) && element.getAttribute("aria-label").contains(monthOf)) {
                element.click();
                break;
            }
        }
    }


    @Test
    public void chooseDate() throws InterruptedException {
        driver = DriverSetUp.driverInit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qa-course-01.andersenlab.com/registration");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirth)).click();
        setDate("25/04/1989", driver);
        driver.quit();
    }
}
