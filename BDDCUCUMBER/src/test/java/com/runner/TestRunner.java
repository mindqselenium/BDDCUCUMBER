package com.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",glue = "com.stepdefinitions",monochrome = true,
 plugin = {"pretty","html:Reports//ohrmstestreport.html","json:Reports//ohrmstestreport.json"},
 dryRun = false,tags = "@login and @negative")

public class TestRunner {

}
