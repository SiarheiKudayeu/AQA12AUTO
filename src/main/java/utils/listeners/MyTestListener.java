package utils.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.driver.DriverSetUp;

import java.io.File;
import java.io.IOException;

public class MyTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " successes!!");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot(result.getMethod().getMethodName());
    }

    private static void makeScreenshot(String method){
        File screenshotFile = ((TakesScreenshot)DriverSetUp.driverInit()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots/" + method + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
