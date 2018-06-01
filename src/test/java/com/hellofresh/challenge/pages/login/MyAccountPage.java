package com.hellofresh.challenge.pages.login;

import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.pages.PageObject;
import com.hellofresh.challenge.pages.purchase.ProductsListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends PageObject {

    public MyAccountPage(WebDriver extDriver) {
        super(extDriver);
    }

    public static final String HEADER_CSS = "h1";
    private static final String ACCOUNT_NAME_CLASS = "account";
    private static final String ACCOUNT_INFO_CLASS = "info-account";
    private static final String LOGOUT_CLASS = "logout";
    private static final String URL_CONTAINS = "controller=my-account";
    private static final String HEADER_TEXT = "MY ACCOUNT";
    private static final String INFO_TEXT = "Welcome to your account.";
    private static final String WOMEN_TAB_LINK_TEXT = "Women";

    public void verifyPage(AccountInfo accountInfo){
        log.info("Verifying account page.");
        Assert.assertEquals(getElementText(By.cssSelector(HEADER_CSS)), HEADER_TEXT);
        Assert.assertEquals(getElementText(By.className(ACCOUNT_NAME_CLASS)), accountInfo.firstNamePersonal + " "
                + accountInfo.lastNamePersonal);
        Assert.assertTrue(getElementText(By.className(ACCOUNT_INFO_CLASS)).contains(INFO_TEXT));
        Assert.assertTrue(isElementDisplayed(By.className(LOGOUT_CLASS)));
        Assert.assertTrue(isUrlContains(URL_CONTAINS));
    }

    public ProductsListPage selectWomenTab() {
        log.info("Select Women tab.");
        click(By.linkText(WOMEN_TAB_LINK_TEXT));
        return new ProductsListPage(driver);
    }
}
