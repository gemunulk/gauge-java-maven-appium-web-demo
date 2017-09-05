package com.aut.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {

    @FindBy(how = How.XPATH, xpath = "//input[@name='userName']")
    private WebElement usernameText;

    @FindBy(how = How.XPATH, xpath = "//input[@name='password']")
    private WebElement passwordText;

    @FindBy(how = How.XPATH, xpath = "//input[@name='login']")
    private WebElement loginButton;


    public void visit(){
        driver.get(Url);
    }

    public void login(String username, String password){
        usernameText.clear();
        usernameText.sendKeys(username);
        passwordText.clear();
        passwordText.sendKeys(password);
        loginButton.click();
    }


}
