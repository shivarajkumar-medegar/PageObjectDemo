package library;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class BaseClass {
    public static WebDriver driver;
  //  public static String baseUrl;
   // public static String browser = "chrome";

    public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
   // PropertyConfigurator.configure("c:\\path\\log4j.properties");

    public static void openBrowser(String browsername, String baseUrl) {



        if(browsername.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            // Create the driver object
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            logger.info("firefox browser launched successfully");
        }

        // If the browser is Chrome
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            // Create the driver object
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        // If the browser is IE
        else if(browsername.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            // Create the driver object
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info(browsername + "Edge browser launched successfully");
        driver.get(baseUrl);
    }

    public static void takeScreenshot(String screenshotName) throws Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshots/" + screenshotName + ".png"));
        logger.info("Screenshot taken for test: "+screenshotName);
    }

    public static void closeBrowser()
    {
        driver.close();
        driver.quit();
        logger.info("Browser closed successfully");
    }
}
