package com.hellofresh.challenge.tests.login;

import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.pages.login.AuthenticationPage;
import com.hellofresh.challenge.pages.login.HomePage;
import com.hellofresh.challenge.pages.login.MyAccountPage;
import com.hellofresh.challenge.pages.login.SignInPage;
import com.hellofresh.challenge.tests.BaseTest;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test(dataProvider = "getNewAccountInfo")
    public void signInTest(AccountInfo accountInfo) {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.enterGeneratedEmail().clickCreateAccount();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.fillAccountInfo(accountInfo).clickSubmit();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyPage(accountInfo);
    }
}
