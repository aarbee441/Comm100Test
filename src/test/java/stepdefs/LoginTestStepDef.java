package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import util.JsonReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTestStepDef {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp(){
        driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        loginPage = new LoginPage(driver);
    }

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() throws InterruptedException, IOException {
        driver.get("https://www.comm100.com/");
        synchronized (driver)
        {
            driver.wait(5000);
        }

        loginPage.loginLink.click();
        Assert.assertEquals(loginPage.loginHeader.getText(),"User Sign In");
    }

    @When("User enters the email address as {string}")
    public void user_enters_the_email_address_as(String email) {
        loginPage.emailField.sendKeys(email);
    }
    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.passwordField.sendKeys(password);
    }

    @When("User clicks on Sign In button")
    public void user_clicks_on_Sign_In_button() {
        loginPage.signInButton.click();
    }
    @Then("User should see error message on Login screen")
    public void user_should_see_error_message_on_Login_screen() throws InterruptedException {

        synchronized (driver)
        {
            driver.wait(5000);
        }
        Assert.assertTrue(loginPage.errorTitle.getText().contains(JsonReader.getValue("errorTitle")));
        Assert.assertEquals(loginPage.errorMessage.getText(),JsonReader.getValue("errorMessage"));
    }

    @When("User clicks on Forgot your password link")
    public void user_clicks_on_Forgot_your_password_link() {
        loginPage.forgotPasswordLink.click();
    }
    @Then("User should navigate to Forgot your password page")
    public void user_should_navigate_to_Forgot_your_password_page() {

        Assert.assertEquals(driver.getTitle(), JsonReader.getValue("forgotPasswordPageTitle"));
    }

    @When("User enters email address as {string}")
    public void user_enters_email_address_as(String email) {
        loginPage.emailField.sendKeys(email);
        
    }
    
    @Then("User should see inline error messages for password field")
    public void user_should_see_inline_error_messages_for_password_field() throws InterruptedException {

        synchronized (driver)
        {
            driver.wait(5000);
        }
        Assert.assertEquals(loginPage.inlinePasswordError.getText(),JsonReader.getValue("errorPasswordEmpty"));
    }

    @Then("User should see inline error messages for invalid email")
    public void user_should_see_inline_error_messages_for_invalid_email() throws InterruptedException {

        synchronized (driver)
        {
            driver.wait(5000);
        }
        Assert.assertEquals(loginPage.inlineEmailError.getText(),JsonReader.getValue("errorEmailInvalid"));
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
