package com.hellofresh.challenge.tests.purchase;

import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.pages.login.HomePage;
import com.hellofresh.challenge.pages.login.MyAccountPage;
import com.hellofresh.challenge.pages.login.SignInPage;
import com.hellofresh.challenge.pages.purchase.*;
import com.hellofresh.challenge.tests.BaseTest;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private static final String TEST_PRODUCT = "Faded Short Sleeve T-shirts";

    @Test(dataProvider = "getAccountInfo")
    public void checkOut(AccountInfo accountInfo){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.enterRegisteredAccount(accountInfo).clickSubmitLogin();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ProductsListPage productsListPage = myAccountPage.selectWomenTab();
        ProductPage productPage = productsListPage.selectProduct(TEST_PRODUCT);
        ProductAddedToCartPopup productAddedToCartPopup = productPage.clickAddToCard();
        SummaryPage summaryPage = productAddedToCartPopup.proceedToCheckout();
        AddressesPage addressesPage = summaryPage.proceedToCheckout();
        ShippingPage shippingPage = addressesPage.proceedToCheckout();
        PaymentPage paymentPage = shippingPage.agreeToS().proceedToCheckout();
        paymentPage.payBankWire().confirmOrder().verifyPage();
    }
}
