package com.company.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Login_Etsy extends BasePage {

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")
    public WebElement signIn;

    @FindBy(id = "join_neu_email_field")
    public WebElement email;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='join_neu_password_field']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    public WebElement signInButton;

    @FindBy(xpath = "//ul[@class='wt-grid wt-grid--block wt-justify-content-center wt-pt-xs-1 wt-pl-xs-1 wt-pr-xs-1 wt-pt-md-0 wt-pl-md-2 wt-pr-md-2 wt-pl-lg-6 wt-pr-lg-6']/li")
    public List<WebElement> shoppingWindows;

    @FindBy(id = "global-enhancements-search-query")
    public WebElement search;

    @FindBy(xpath = "//div[@data-id]//button[@type='submit']")
    public WebElement submitSearchButton;

    @FindBy(id = "catnav-primary-link-10855")
    public WebElement jewelryAccessories;

    //homepage locators

    @FindBy(xpath = "//span[@class='wt-tooltip wt-tooltip--disabled-touch']//span[@class='etsy-icon']")
    public WebElement favorite;
}
