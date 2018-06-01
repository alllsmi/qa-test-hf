package com.hellofresh.challenge.pages.purchase;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage extends PageObject {

    public ProductsListPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String PRODUCT_XPATH_PATTERN = "//a[@title='%s']/ancestor::li";

    public ProductPage selectProduct(String productName) {
        log.info("Select product: " + productName);
        click(By.xpath(String.format(PRODUCT_XPATH_PATTERN, productName)));
        click(By.xpath(String.format(PRODUCT_XPATH_PATTERN, productName)));
        return new ProductPage(driver);
    }
}
