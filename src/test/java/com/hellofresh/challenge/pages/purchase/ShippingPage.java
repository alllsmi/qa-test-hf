package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends PageObject {

    public ShippingPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String AGREE_TOS_ID = "uniform-cgv";
    private static final String PROCEED_NAME = "processCarrier";

    public ShippingPage agreeToS() {
        log.info("Agree ToS.");
        click(By.id(AGREE_TOS_ID));
        return this;
    }

    public PaymentPage proceedToCheckout() {
        log.info("Click proceed.");
        click(By.name(PROCEED_NAME));
        return new PaymentPage(driver);
    }
}
