package com.gaven.pattern.TemplateTest.bank;

public class BankTest {

    public static void main(String[] args) {

        BankBusiness bankBusiness = new Withdrawal();
        bankBusiness.execute();
    }
}
