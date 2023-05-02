package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit")
    WebElement loginButton;


    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @Step("Entering user name")
    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    @Step("Entering password: {0}")
    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    @Step("Clicking on login button")
    public void clickLoginButton() {
        loginButton.click();
    }
}
