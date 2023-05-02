package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.ActionsClassExample;
import library.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class ActionTests extends BaseClass {

    int i=0;

    @BeforeMethod
    public void setUp()
    {
        openBrowser("chrome", "https://www.google.com");
    }

    @Test
    public void actionTests() throws InterruptedException {
        ActionsClassExample actionsExample = new ActionsClassExample(driver);

        WebElement searchBox = driver.findElement(By.xpath("//div[@aria-label='Search by voice']"));

        actionsExample.hoverOverElement(searchBox);

        String tooltiptext = searchBox.getAttribute("aria-label");


        Assert.assertEquals(tooltiptext,"Search by voice");

        logger.info("tooltip text is:: "+tooltiptext);

        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        i = i+1;
        String screenshotName = "login_failed";

        String x = screenshotName+String.valueOf(i);
        if(ITestResult.FAILURE == result.getStatus())
        {
            takeScreenshot(screenshotName);
        }
        closeBrowser();
    }
}
