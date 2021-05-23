package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='menu-item-9004111222094893']/a[contains(@href,'login')]")
    public WebElement loginLink;

    @FindBy(xpath = "//*[@id='divLogin']/h1")
    public WebElement loginHeader;

    @FindBy(id = "txtEmail")
    public WebElement emailField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "lblLogin")
    public WebElement signInButton;

    @FindBy(id = "ajaxErrorMsg")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id='ajaxError']//div[@class='dialogtitle']")
    public WebElement errorTitle;

    @FindBy(xpath = "//*[@id='loginContent']//label[@class='error' and @for='txtEmail']")
    public WebElement inlineEmailError;

    @FindBy(xpath = "//*[@id='loginContent']//label[@class='error' and @for='txtPassword']")
    public WebElement inlinePasswordError;

    @FindBy(xpath = "//a[@class = 'aforgotpassword comm100-global-ui-link']")
    public WebElement forgotPasswordLink;

}
