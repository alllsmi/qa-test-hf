package com.hellofresh.challenge.pages.login;

import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    private static final String LOGIN_CLASS_NAME = "login";

    public HomePage(WebDriver extDriver){
        super(extDriver);
        log.info("Navigate to home page.");
        this.driver.get("http://automationpractice.com/index.php");
    }

    public SignInPage clickSignIn(){
        log.info("Click sign in link.");
        click(By.className(LOGIN_CLASS_NAME));
        return new SignInPage(driver);
    }
}
