package com.hellofresh.challenge.infrastructure;

public class AccountInfo {

    public int gender;
    public String firstNamePersonal;
    public String lastNamePersonal;
    public String email;
    public String password;
    public String day;
    public String month;
    public String year;
    public String firstNameAddress;
    public String lastNameAddress;
    public String company;
    public String address;
    public String address2;
    public String city;
    public String state;
    public String zip;
    public String country;
    public String additional;
    public String homePhone;
    public String mobilePhone;
    public String alias;

    public AccountInfo(String[] info){
        if (info.length == 21){
            int i = 0;
            gender = Integer.parseInt(info[i]);
            firstNamePersonal = info[++i];
            lastNamePersonal = info[++i];
            email = info[++i];
            password = info[++i];
            day = info[++i];
            month = info[++i];
            year = info[++i];
            firstNameAddress = info[++i];
            lastNameAddress = info[++i];
            company = info[++i];
            address = info[++i];
            address2 = info[++i];
            city = info[++i];
            state = info[++i];
            zip = info[++i];
            country = info[++i];
            additional = info[++i];
            homePhone = info[++i];
            mobilePhone = info[++i];
            alias = info[++i];
        }
    }

}
