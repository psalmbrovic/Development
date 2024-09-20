package ecomm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Element locators
    /*This defines two constants, CART_ICON and CART_ITEM, which represent the locators for the cart icon and cart 
    item elements on the web page, respectively. These locators are used in the CartPage class to interact with 
    these elements. */
    private static final By CART_ICON = By.id("cartIcon");
    private static final By CART_ITEM = By.xpath("//div[@class='cart-item']");


    /*The constructor initializes the driver and wait variables used in the class.*/
    /*This line creates a new instance of WebDriverWait with the driver and a timeout of 10 seconds. 
    The WebDriverWait class provides explicit waits wait for the visibility of a cart item element on the web page */
    public CartPage(WebDriver driver) {    
    this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    /* */
    public void openCart() {
        driver.findElement(CART_ICON).click();
    }

    /*This method provides a way to verify the presence of CART_ITEM on the web page by checking its visibility. */
    /*The method returns the result of the isDisplayed() method called on the cartItemElement. 
    This method returns true if the element is displayed, and false otherwise. */

    public boolean isCartItemDisplayed() {
        WebElement cartItemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CART_ITEM));
        return cartItemElement.isDisplayed();
    }
}

