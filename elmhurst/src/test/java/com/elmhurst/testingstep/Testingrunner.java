package com.elmhurst.testingstep;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources",
		glue= {"com.elmhurst.testingstep"},
		tags= {"@smoketest"},
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber reports/report.html"},
				//"json:target/cucumber.json"},
		monochrome=true,
		strict=true
		

		
		
		)
public class Testingrunner {

	
	
}
