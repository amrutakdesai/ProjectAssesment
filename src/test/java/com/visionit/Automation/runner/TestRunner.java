package com.visionit.Automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features ="classpath:feature",
		glue="com.visionit.Automation.stepdefination", //  Path of step def code
		tags="@endtoend", 
		plugin = {"pretty",
				"html:target/html/htmlreport.html",
		"json:target/json/file.json",
		},
		monochrome=true,
		publish=true,
dryRun=false
		
		)
public class TestRunner {

}
