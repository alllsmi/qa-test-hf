package com.hellofresh.challenge.tests.login;

import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.pages.login.HomePage;
import com.hellofresh.challenge.pages.login.MyAccountPage;
import com.hellofresh.challenge.pages.login.SignInPage;
import com.hellofresh.challenge.tests.BaseTest;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test(dataProvider = "getAccountInfo")
    public void logInTest(AccountInfo accountInfo) {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.enterRegisteredAccount(accountInfo).clickSubmitLogin();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyPage(accountInfo);
    }
}
