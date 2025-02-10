package lesson5.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

import java.time.Duration;
import java.util.List;

public class SelectClassExample {
    @Test
    public void workWithSelect() throws InterruptedException {
        WebDriver driver = DriverSetUp.driverInit();
        driver.get(URL.SELECT_URL.getUrl());
        WebElement selectCountryWebElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("itt_country")));
        Select countrySelect = new Select(selectCountryWebElement);
        //isMultiple()
        System.out.println(countrySelect.isMultiple());
        countrySelect.selectByVisibleText("Венгрия");
        Thread.sleep(2000);
        countrySelect.selectByValue("372");
        Thread.sleep(2000);
        //Options
        List<WebElement> countriesList = countrySelect.getOptions();
        for (WebElement element: countriesList){
            System.out.println(element.getText());
        }

        Select regionList = new Select(driver.findElement(By.id("region_list")));


        System.out.println("=======================");
        System.out.println(regionList.isMultiple());
        Thread.sleep(3500);
        regionList.selectByValue("28329");
        Thread.sleep(1500);
        regionList.selectByValue("15226");
        Thread.sleep(1500);
        regionList.selectByValue("7659");

        for (WebElement element: regionList.getAllSelectedOptions()){
            System.out.println(element.getText());
        }

        Thread.sleep(1500);
        regionList.deselectByValue("15226");
        Thread.sleep(1500);
        regionList.deselectAll();
        Thread.sleep(2500);

        driver.quit();
    }
}
