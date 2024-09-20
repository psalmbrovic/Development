package ecomm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    /*These locators are encapsulated within the ProductPage class, making them reusable and easy to 
    maintain in the test suite. The selectProduct and addToCart methods utilize these 
    locators to perform the corresponding actions on the product page.
     */
    private static final By PRODUCT_LINK = By.xpath("//a[text()='Product']");
    private static final By ADD_TO_CART_BUTTON = By.id("addToCart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;

    }
/*This method encapsulates the functionality of selecting a product on the e-commerce website, 
making it reusable and easy to maintain in the test suite.This method is responsible for locating and 
clicking on the product link on the webpage.

 */    public void selectProduct() {
        driver.findElement(PRODUCT_LINK).click();
    }

    public void addToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
}

