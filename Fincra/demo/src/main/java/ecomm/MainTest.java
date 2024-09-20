package ecomm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*The selected code snippet is the declaration of instance variables within the MainTest class. 
These variables are used to store references to the WebDriver instance, as well as instances of the LoginPage, 
ProductPage, and CartPage classes. These classes represent different web pages in the e-commerce application and 
encapsulate the functionality related to interacting with those pages. 
 */
public class MainTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;


    /* This setup method is essential for initializing the WebDriver, setting up the necessary page objects, and 
    preparing the test environment before executing the test methods.
    This method is executed once before all test methods in the class*/
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.example-ecommerce-site.com");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    /* This test method ensures that the login functionality of the e-commerce application is working correctly by 
    verifying that the account page is displayed after a successful login.*/
    @Test
    public void testLogin() {
        loginPage.login("user", "pass");
        assert loginPage.isAccountPageDisplayed() : "Account page not displayed after login";
    }

    /*This test method ensures that the add to cart functionality of the e-commerce application is working correctly 
    by verifying that the cart item is displayed after adding a product to the cart.
    */
    @Test
    public void testAddToCart() {
        productPage.selectProduct();
        productPage.addToCart();
        cartPage.openCart();
        assert cartPage.isCartItemDisplayed() : "Cart item not displayed after adding to cart";
    }

    /* The teardown() method is crucial for ensuring that the test environment remains stable and 
    reliable, as it allows for proper cleanup and resource management. It is essential for preventing memory leaks,
    closing open browser windows, and ensuring that the WebDriver instance is properly terminated.*/
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

