package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import com.hellofresh.challenge.pages.login.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaymentPage extends PageObject {

    public PaymentPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String BANKWIRE_CLASS = "bankwire";
    private static final String CONFIRM_XPATH = "//*[@id='cart_navigation']/button";
    private static final String ORDER_CONFIRMATION_TEXT = "ORDER CONFIRMATION";
    private static final String SHIPPING_DONE_XPATH = "//li[@class='step_done step_done_last four']";
    private static final String PAYMENT_DONE_XPATH = "//li[@id='step_end' and @class='step_current last']";
    private static final String CUSTOMER_MESSAGE_XPATH = "//*[@class='cheque-indent']/strong";
    private static final String CUSTOMER_MESSAGE_TEXT = "Your order on My Store is complete.";
    private static final String URL_CONTAINS = "controller=order-confirmation";


    public PaymentPage payBankWire() {
        log.info("Click pay by bankwire.");
        click(By.className(BANKWIRE_CLASS));
        return this;
    }

    public PaymentPage confirmOrder() {
        log.info("Click confirm.");
        click(By.xpath(CONFIRM_XPATH));
        return this;
    }

    public void verifyPage() {
        log.info("Verifying Confirmation.");
        Assert.assertEquals(getElementText(By.cssSelector(MyAccountPage.HEADER_CSS)), ORDER_CONFIRMATION_TEXT);
        Assert.assertTrue(isElementDisplayed(By.xpath(SHIPPING_DONE_XPATH)));
        Assert.assertTrue(isElementDisplayed(By.xpath(PAYMENT_DONE_XPATH)));
        Assert.assertEquals(getElementText(By.xpath(CUSTOMER_MESSAGE_XPATH)), CUSTOMER_MESSAGE_TEXT);
        Assert.assertTrue(isUrlContains(URL_CONTAINS));
    }
}
