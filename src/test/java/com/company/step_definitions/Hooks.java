package com.company.step_definitions;


import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

//    @Before
//    public void setUpScenario(){
//        Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));
//    }

    @After
    public void tearDownScenario(Scenario scenario) throws InterruptedException {

        if( scenario.isFailed() ){
            byte[] screenshot =  ( (TakesScreenshot)Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "img/jpeg", scenario.getName());
        }
        Driver.closeDriver();
    }
}
