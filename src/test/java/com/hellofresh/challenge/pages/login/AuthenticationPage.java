package com.hellofresh.challenge.pages.login;

import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends PageObject {

    public AuthenticationPage(WebDriver extDriver) {
        super(extDriver);
    }

    private static final String GENDER_PATTERN_ID = "id_gender%d";
    private static final String FIRST_NAME_PERSONAL_ID = "customer_firstname";
    private static final String LAST_NAME_PERSONAL_ID = "customer_lastname";
    private static final String PASSWORD_ID = "passwd";
    private static final String DAY_ID = "days";
    private static final String MONTH_ID = "months";
    private static final String YEAR_ID = "years";
    private static final String COMPANY_ID = "company";
    private static final String ADDRESS_ID = "address1";
    private static final String ADDRESS2_ID = "address2";
    private static final String CITY_ID = "city";
    private static final String STATE_ID = "id_state";
    private static final String ZIP_ID = "postcode";
    private static final String ADDITIONAL_ID = "other";
    private static final String PHONE_ID = "phone";
    private static final String PHONE_MOBILE_ID = "phone_mobile";
    private static final String ALIAS_ID = "alias";
    private static final String SUBMIT_ID = "submitAccount";

    public AuthenticationPage fillAccountInfo(AccountInfo accountInfo) {
        log.info("Entering account info.");
        click(By.id(String.format(GENDER_PATTERN_ID, accountInfo.gender)));
        enterText(By.id(FIRST_NAME_PERSONAL_ID), accountInfo.firstNamePersonal);
        enterText(By.id(LAST_NAME_PERSONAL_ID), accountInfo.lastNamePersonal);
        enterText(By.id(PASSWORD_ID), accountInfo.password);
        selectDropDownByValue(By.id(DAY_ID), accountInfo.day);
        selectDropDownByValue(By.id(MONTH_ID), accountInfo.month);
        selectDropDownByValue(By.id(YEAR_ID), accountInfo.year);
        enterText(By.id(COMPANY_ID), accountInfo.company);
        enterText(By.id(ADDRESS_ID), accountInfo.address);
        enterText(By.id(ADDRESS2_ID), accountInfo.address2);
        enterText(By.id(CITY_ID), accountInfo.city);
        selectDropDownByText(By.id(STATE_ID), accountInfo.state);
        enterText(By.id(ZIP_ID), accountInfo.zip);
        enterText(By.id(ADDITIONAL_ID), accountInfo.additional);
        enterText(By.id(PHONE_ID), accountInfo.homePhone);
        enterText(By.id(PHONE_MOBILE_ID), accountInfo.mobilePhone);
        enterText(By.id(ALIAS_ID), accountInfo.alias);
        return this;
    }

    public void clickSubmit(){
        log.info("Click Submit.");
        click(By.id(SUBMIT_ID));
    }
}
