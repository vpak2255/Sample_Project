package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
