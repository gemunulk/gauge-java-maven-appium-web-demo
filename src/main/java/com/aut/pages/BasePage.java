package com.aut.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static String Url = System.getenv("APP_ENDPOINT");
    public final WebDriver driver;

    public BasePage(){
        //this.driver = DriverFactory.getDriver();
        this.driver = PageFactory.driver;
    }


}
