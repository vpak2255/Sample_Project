package com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.company.utilities.ConfigurationReader.logfile;
import static com.company.utilities.NetworkLogs.printLog;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources_features/features",
        glue = "com/company/step_definitions",
        dryRun = false,
        tags = "@login_page"
)
public class CukesRunner {

        @BeforeClass
        public static void setup() {
        }

        @AfterClass
        public static void teardown() {
                try {
                        printLog.close();
                        logfile.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
