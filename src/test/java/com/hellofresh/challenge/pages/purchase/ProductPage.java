package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageObject {

    public ProductPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String ADD_TO_CART_NAME = "Submit";

    public ProductAddedToCartPopup clickAddToCard() {
        log.info("Click add to cart.");
        click(By.name(ADD_TO_CART_NAME));
        return new ProductAddedToCartPopup(driver);
    }
}
