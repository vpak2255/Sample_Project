package com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources_features/regression",
        glue = "com/company/step_definitions"
)
public class RegressionRunner {
}
