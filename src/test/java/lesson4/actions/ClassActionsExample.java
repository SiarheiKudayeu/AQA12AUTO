package lesson4.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import utils.driver.constants.URL;

import java.time.Duration;

public class ClassActionsExample {

    private static class Locators {
        private static final By techStack = By.xpath("//div[@tabindex=\"Tech Stack\"]");
        private static final By javaOption = By.xpath("(//a[text()=\"Java\"])[1]");
        private static final By rustOption = By.xpath("(//a[text()=\"Rust\"])[1]");
        private static final By phpOption = By.xpath("(//a[text()=\"PHP\"])[1]");
        private static final By acceptCookies = By.xpath("//button[text()='Accept']");
        private static final By menuButton = By.id("menu-btn");
        private static final By ouverture = By.xpath("//div[@data-title=\"Ouverture\"]");
        private static final By projets = By.xpath("//div[@data-title=\"Projets\"]");
        private static final By contextButton = By.xpath("//span[text()='right click me']");
        private static final By doubleButton = By.xpath("//button[@ondblclick=\"myFunction()\"]");
        private static final By closeButton = By.xpath("//span[text()='Quit']");
    }

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void driverInit() {
        driver = DriverSetUp.driverInit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    public enum Stack {
        JAVA, PHP, RUST
    }

    public static void openStack(Stack stack) {
        By locator = null;
        switch (stack) {
            case PHP: locator = Locators.phpOption;
            break;
            case JAVA : locator = Locators.javaOption;
            break;
            case RUST : locator = Locators.rustOption;
            break;
        }

        driver.get(URL.ANDERSEN_MAIN_PAGE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.techStack));
        actions.moveToElement(driver.findElement(Locators.techStack)).pause(Duration.ofSeconds(1))
                .moveToElement(driver.findElement(locator))
                .click().build().perform();
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
    }

    @Test
    public void openTechStack() {
        driver.get(URL.ANDERSEN_MAIN_PAGE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.acceptCookies)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.techStack));
        Actions actions = new Actions(driver);

 /*     actions.moveToElement(driver.findElement(Locators.techStack)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.javaOption)).click();*/
        actions.moveToElement(driver.findElement(Locators.techStack)).pause(Duration.ofSeconds(1))
                .moveToElement(driver.findElement(Locators.javaOption))
                .click().build().perform();
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }
    }

    @Test
    public void checkOpenMethod() {
        openStack(Stack.RUST);
        openStack(Stack.JAVA);
    }

    @Test
    public void keyUpAndDown() {
        driver.get(URL.ANDERSEN_MAIN_PAGE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.techStack));
        actions.moveToElement(driver.findElement(Locators.techStack)).pause(Duration.ofSeconds(1))
                .moveToElement(driver.findElement(Locators.javaOption))
                .keyDown(Keys.CONTROL)
                .click()
                .keyUp(Keys.CONTROL)
                .build().perform();

        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get(URL.DRAG_PRACTICE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.menuButton)).click();
       /* driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.menuButton)).click();
        Thread.sleep(2000);
        driver.findElement(Locators.ouverture).click();*/
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(Locators.ouverture))
                .clickAndHold()
                .moveToElement(driver.findElement(Locators.menuButton))
                .release()
                .build().perform();

        Thread.sleep(3000);

        driver.get(URL.DRAG_PRACTICE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.menuButton)).click();
        Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(Locators.projets), driver.findElement(Locators.menuButton)).perform();
        Thread.sleep(3000);
    }

    @Test
    public void testClick(){
        driver.get(URL.CONTEXT_AND_DOUBLE.getUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.contextButton));
        actions.contextClick(driver.findElement(Locators.contextButton)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.closeButton)).click();
        //Alert alert = driver.switchTo().alert();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();

        wait.until(ExpectedConditions.elementToBeClickable(Locators.doubleButton));
        actions.doubleClick(driver.findElement(Locators.doubleButton)).perform();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public static void frameExample(){
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        By text = By.xpath("//p[text()='You can use the height and width attributes to specify the size of the iframe:']");
        //driver.switchTo().frame("iframeResult");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='iframeResult']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        System.out.println(driver.findElement(text).getText());
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@title=\"Iframe Example\"]")));
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    @Test
    public void javaScriptInjection() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(URL.GUINNESS_SEARCH.getUrl());

        //scroll
        js.executeScript("window.scrollBy(0, 500)");

        //Thread.sleep(3000);

        //scroll to Element

        driver.get(URL.GUINNESS.getUrl());
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@alt=\"Officially Amazing - Guinness World Records footer\"]")));
        Thread.sleep(3000);

        String pageTitle = (String) js.executeScript("return document.title;");
        String pageURL = (String) js.executeScript("return document.URL;");

        Assert.assertEquals(pageTitle, driver.getTitle());
        Assert.assertEquals(pageURL, driver.getCurrentUrl());
    }
}
