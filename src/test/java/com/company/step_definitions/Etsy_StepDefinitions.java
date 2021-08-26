package com.company.step_definitions;
import com.company.pages.Login_Etsy;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Etsy_StepDefinitions {

    Login_Etsy login = new Login_Etsy();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @Given("user is on the login page")
    public void user_is_on_the_login_page(){
        Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password){
        login.signIn.click();
        login.email.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(login.continueButton));

        login.continueButton.click();

        wait.until(ExpectedConditions.visibilityOf(login.password));
        login.password.sendKeys(password);
        login.signInButton.click();

   //     wait.until(ExpectedConditions.visibilityOf(login.favorite) );
    }
    @Then("favorite button is displayed")
    public void favorite_button_is_displayed() {

        Assert.assertTrue(login.favorite.isDisplayed());
    }

    @Then("user sees num {int} shopping windows displayed")
    public void user_sees_num_shopping_windows_displayed(int num) {

        wait.until(ExpectedConditions.visibilityOfAllElements(login.shoppingWindows));

        int count = 0;
        for (WebElement eachElem : login.shoppingWindows) {
           count ++;
        }
        Assert.assertTrue(count == num);
    }

    @When("user enters item name {string} and clicks enter")
    public void user_enters_item_name_and_clicks_enter(String itemName) {
        login.search.sendKeys(itemName);
        login.submitSearchButton.click();
    }

    @Then("user sees title contains {string}")
    public void user_sees_title_contains(String itemName) {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actual title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(itemName));
    }


}
