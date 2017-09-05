package com.aut.pages;

import com.thoughtworks.gauge.Step;


public class LogoutSpec {

    @Step("Logout from the application")
    public void visit() {
        PageFactory.logoutPage.visit();
    }

}
