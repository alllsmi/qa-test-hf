package com.hellofresh.challenge.pages.login;


import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class SignInPage extends PageObject {

    private static final String EMAIL_CREATE_ID = "email_create";
    private static final String SUBMIT_CREATE_ID = "SubmitCreate";
    private static final String EMAIL_ID = "email";
    private static final String PASSWORD_ID = "passwd";
    private static final String SUBMIT_LOGIN_ID = "SubmitLogin";

    private static final String EMAIL_PATTERN = "hf_challenge_%s@hf%s.com";

    public SignInPage(WebDriver extDriver){
        super(extDriver);
    }

    public SignInPage enterGeneratedEmail() {
        String email = generateEmail();
        log.info("Entering email: " + email);
        enterText(By.id(EMAIL_CREATE_ID), email);
        return this;
    }

    public void clickCreateAccount() {
        log.info("Click create account.");
        click(By.id(SUBMIT_CREATE_ID));
    }

    public SignInPage enterRegisteredAccount(AccountInfo accountInfo){
        log.info("Entering email: " + accountInfo.email);
        enterText(By.id(EMAIL_ID), accountInfo.email);
        log.info("Entering password: " + accountInfo.password);
        enterText(By.id(PASSWORD_ID), accountInfo.password);
        return this;
    }

    public void clickSubmitLogin() {
        log.info("Click submit login.");
        click(By.id(SUBMIT_LOGIN_ID));
    }


    private String generateEmail(){
        String timestamp = String.valueOf(new Date().getTime());
        return String.format(EMAIL_PATTERN, timestamp, timestamp.substring(7));
    }
}
