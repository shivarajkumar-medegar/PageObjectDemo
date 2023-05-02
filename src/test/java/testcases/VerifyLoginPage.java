package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.Browser;
import library.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.TestLoginPage;

import java.time.Duration;

public class VerifyLoginPage{

    WebDriver driver;
    int i=0;

    public VerifyLoginPage(WebDriver driver) {
        this.driver = driver;
    }
/*
    @BeforeTest
    void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }*/


    @Test
    public void loginTest()
    {
        driver.get("https://practicetestautomation.com/practice-test-login/");
       // loginPage = new TestLoginPage(driver);

        TestLoginPage.enterUsername("student");
        TestLoginPage.enterPassword("Password123");
        TestLoginPage.clickLoginButton();

    }

    @AfterMethod
    public void screenshot(ITestResult result)
    {
        i = i+1;
        String name = "ScreenShot";
        String x = name+String.valueOf(i);
        if(ITestResult.FAILURE == result.getStatus())
        {
            ScreenShot.captureScreenShot(driver, x);
        }
    }
}
