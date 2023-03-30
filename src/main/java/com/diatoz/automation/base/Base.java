package com.diatoz.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.diatoz.automation.config.ConfigurationReader;
import com.diatoz.automation.config.PropertyFileReader;
import com.diatoz.automation.framework.Browser;
import com.diatoz.automation.util.PathHelper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Base {

	public static Logger log = Logger.getLogger(Base.class);
	public static WebDriver driver;
	public static ConfigurationReader reader;

	public static void setDriver(ChromeDriver chromeDriver) {
		Base.driver = driver;

	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}
