package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends PageObject {

    public SummaryPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String PROCEED_XPATH = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']";

    public AddressesPage proceedToCheckout() {
        log.info("Click proceed.");
        click(By.xpath(PROCEED_XPATH));
        return new AddressesPage(driver);
    }
}
