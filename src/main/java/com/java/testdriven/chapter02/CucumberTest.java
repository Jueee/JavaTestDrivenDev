package com.java.testdriven.chapter02;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:bdd/cucumber/features"},
                    format = {"pretty", "html:build/reports/cucumber"},
                    glue = {"com.java.testdriven.chapter02"})
public class CucumberTest {

}
