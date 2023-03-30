package com.diatoz.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.junit.Cucumber;
//import io.cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:FeatureFiles/Login.feature",
                           //"classpath:FeatureFiles/Jobs.feature"
},
glue={"classpath:com.diatoz.automation.stepdef"},
plugin={"html:target/cucumber_html_report","json:target/cucumber.json"})

public class Runner {
	 

}
