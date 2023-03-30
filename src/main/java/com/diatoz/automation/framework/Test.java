package com.diatoz.automation.framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	

	public static void main(String[] args) {
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://uat.e2ehiring.com/");
	
	JavascriptExecutor exe=((JavascriptExecutor) driver);
	//exe.executeScript("arguments[0].value=\"Hello\"", driver.findElement(By.xpath("//input[@name='q']")));
	exe.executeScript("document.body.style.zoom='100%'");
	
	
	

	}

}
