package com.aut.pages;

import com.thoughtworks.gauge.Step;

public class LoginSpec {

    @Step("On Login page")
    public void visit() {
        PageFactory.loginPage.visit();
    }

    @Step("Login as <username> using <password>")
    public void loginAs(String username, String password){
        PageFactory.loginPage.login(username, password);
    }
}
