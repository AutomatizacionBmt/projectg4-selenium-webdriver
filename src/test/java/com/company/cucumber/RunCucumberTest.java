package com.company.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/json-reports/Cucumber.json",
        "junit:target/cucumber-reports/junit-reports/Cucumber.xml"},
        tags = {"@Working"},
        glue = {"com.company.cucumber"},
        features = {"src/test/resources/features"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunCucumberTest {
}
