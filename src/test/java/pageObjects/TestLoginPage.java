package pageObjects;

import library.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage extends Browser {



    public TestLoginPage(WebDriver driver)
    {
       super(driver);
    }

    @FindBy(id = "username")
    static
    WebElement usernameField;

    @FindBy(id = "password")
    static
    WebElement passwordField;

    @FindBy(id = "submit")
    static
    WebElement loginButton;

    public static void enterUsername(String username)
    {
        usernameField.sendKeys(username);
    }

    public static void enterPassword(String password)
    {
        passwordField.sendKeys(password);
    }

    public static void clickLoginButton()
    {
        loginButton.click();
    }


}
