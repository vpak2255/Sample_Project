package com.company.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Browser_Utils {

    public static void urlAssertion(String expectedUrl) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.urlContains(expectedUrl));

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    public static void titleAssertion(String expectedTitle) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        String actualTitle = Driver.getDriver().getTitle();

        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /**
     * Assertion for Table Header Names
     */

    public static void listAssertionByText(List<String> expectedList, List<WebElement> actualElement) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        List<String> actualList = Browser_Utils.getElementsText(actualElement);

        wait.until(ExpectedConditions.visibilityOfAllElements(actualElement));

        Assert.assertEquals(expectedList, actualList);

    }

    public static List<String> getElementsText(List<WebElement> list) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(list));

        List<String> elemText = new ArrayList<>();
        for (WebElement eachElem : list) {
            elemText.add(eachElem.getText());
        }
        return elemText;
    }

    public static void click(WebElement element) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public static void sendKeys(WebElement element, String string) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.sendKeys(string);
    }

    public static void selectDropdown(WebElement element, String string) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        Select select = new Select(element);
        select.selectByVisibleText(string);

    }

    public static boolean isDisplayed(String name) {

        return Driver.getDriver().findElement(By.xpath("//td[.='" + name + "']")).isDisplayed();
    }

    /**
     * Assertion for select dropdown using GetOptions method
     * Select dropdown : to see text all available options in the dropdown list
     */
    public static void assertionSelectDropdownText(List<String> expectedDropdownList, WebElement dropdown) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        Select select = new Select(dropdown);
        wait.until(ExpectedConditions.visibilityOf(dropdown));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> actualDropdownList = getElementsText(select.getOptions());
        Assert.assertTrue(expectedDropdownList.equals(actualDropdownList));

    }

    /**
     * select a WebElement from SELECT dropdown by Visible Text
     */
    public static void selectByVisibleText(WebElement selectDropdown, String name) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        wait.until(ExpectedConditions.visibilityOf(selectDropdown));

        Select select = new Select(selectDropdown);
        select.selectByVisibleText(name);
    }
}
