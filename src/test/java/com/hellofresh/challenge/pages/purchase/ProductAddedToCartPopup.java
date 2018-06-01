package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductAddedToCartPopup extends PageObject {

    public ProductAddedToCartPopup(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String PROCEED_XPATH = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']";

    public SummaryPage proceedToCheckout() {
        log.info("Click proceed.");
        click(By.xpath(PROCEED_XPATH));
        return new SummaryPage(driver);
    }
}
