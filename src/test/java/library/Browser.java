package library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Browser {

    WebDriver driver;

    public Browser(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public WebDriver StartBrowser(String browsername , String url)
    {
        // If the browser is Firefox
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.chromedriver().setup();
            // Create the driver object
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
            WebDriverManager.chromedriver().setup();
            // Create the driver object
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}