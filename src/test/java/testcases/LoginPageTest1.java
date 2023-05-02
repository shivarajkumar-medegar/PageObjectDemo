package testcases;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import library.BaseClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class LoginPageTest1 extends BaseClass {
    LoginPage lp;
    int i=0;

    @BeforeMethod
    public void setUp()
    {
        openBrowser("edge", "https://practicetestautomation.com/practice-test-login/");
        lp = new LoginPage(driver);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login functionality test")
    @Story("Story name: to check login feature")
    public void loginTest() throws Exception
    {
        lp.enterUsername("username");
        logger.info("username entered");
        lp.enterPassword("password");
        logger.info("password entered");
        lp.clickLoginButton();
        logger.info("Login button clicked");
        String screenshotName = "login_success";
        takeScreenshot(screenshotName);
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
