package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends PageObject {

    public AddressesPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String PROCEED_NAME = "processAddress";

    public ShippingPage proceedToCheckout() {
        log.info("Click proceed.");
        click(By.name(PROCEED_NAME));
        return new ShippingPage(driver);
    }
}
