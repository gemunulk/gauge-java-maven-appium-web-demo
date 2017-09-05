package com.aut.pages;

public class LogoutPage extends BasePage {

    public void visit(){
        driver.get(Url.concat("/mercurysignoff.php"));
    }

}
