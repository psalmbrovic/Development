package ecomm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Element locators
    //declaration of static element locators
    private static final By LOGIN_BUTTON = By.id("loginButton");
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By SUBMIT_BUTTON = By.id("submitButton");
    private static final By ACCOUNT_PAGE = By.id("accountPage");

    /*initializes the driver and wait objects, which is used throughout the class to interact with the WebDriver 
    and wait for specific conditions and the wait time is 10 seconds.*/

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //creating a login method then calling the element locator declared in element locator, to perform the login actions.
    /*This method encapsulates the login functionality and allows the user to provide their 
    username and password as parameters. It ensures that the login process is automated and can be reused 
    throughout the application.*/

    public void login(String username, String password) {
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    /*This method uses WebDriverWait wait object to wait for ACCOUNT_PAGE locator to become visibile on the page */
    /*This method provides a way to verify that the login process has been successful 
    and the user has navigated to the account page. This is a crucial part of the login functionality in this application. 
    if the account page element is displayed, the method returns true; otherwise, it returns false.*/

    public boolean isAccountPageDisplayed() {
        WebElement accountPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_PAGE));
        return accountPageElement.isDisplayed();
    }
}