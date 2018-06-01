package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.infrastructure.AccountInfo;
import com.hellofresh.challenge.infrastructure.Config;
import com.hellofresh.challenge.infrastructure.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = DriverFactory.getDriverInstance(Config.isWindows);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ArrayList<AccountInfo> parseDataCsv(String fileName) {
        ArrayList<AccountInfo> result = new ArrayList<>();
        String line;
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(this
                        .getClass().getResourceAsStream("/"+ fileName)))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                result.add(new AccountInfo(values));
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    @DataProvider(name = "getNewAccountInfo")
    public Object[][] getNewAccountInfo() {
        return getAccountData("registerData.csv");
    }

    @DataProvider(name = "getAccountInfo")
    public Object[][] getAccountInfo() {
        return getAccountData("loginData.csv");
    }

    private Object[][] getAccountData(String fileName){
        ArrayList<AccountInfo> accountInfo = parseDataCsv(fileName);
        Object[][] data = new Object[accountInfo.size()][1];
        for (int i = 0; i < accountInfo.size(); i++){
            data[i][0] = accountInfo.get(i);
        }
        return data;
    }
}
