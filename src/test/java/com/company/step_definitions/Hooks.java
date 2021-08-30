package com.company.step_definitions;


import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import static com.company.utilities.NetworkLogs.printLog;

public class Hooks {

//    @Before
//    public void setUpScenario() throws FileNotFoundException {
//    }

    @After
    public void tearDownScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "img/jpeg", scenario.getName());
        }
        printLog.append("-----------------------------------------------------------------------");
        printLog.append("Scenario :" + scenario.getName() + " started");
        printLog.append("-----------------------------------------------------------------------");
        networkLogs();
        printLog.append("-----------------------------------------------------------------------");
        printLog.append("Scenario :" + scenario.getName() + " ended");
        printLog.append("-----------------------------------------------------------------------");
        printLog.append(System.getProperty("line.separator"));
        Driver.closeDriver();
    }

    private void networkLogs(){
        LogEntries logs = Driver.getDriver().manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry entry : logs) {
            if (entry.toString().contains("\"type\":\"XHR\"") & (entry.toString().contains(ConfigurationReader.getProperty("etsyUrl"))
                    || entry.toString().contains(ConfigurationReader.getProperty("googleUrl")))) {
                printLog.append(new Date(entry.getTimestamp()) + " " + entry.toString() + " " + System.getProperty("line.separator"));
            }
        }
    }
}
