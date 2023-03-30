package com.diatoz.automation.stepdef;

import com.diatoz.automation.base.Base;
import com.diatoz.automation.framework.Elements;
import com.diatoz.automation.pages.LoginPage;
import cucumber.api.java.en.*;

public class Login extends Base {

	LoginPage scenA = new LoginPage();

	@Given("^I launch the application$")
	public void i_launch_the_application() throws InterruptedException{
		
		Base.driver.get(Base.reader.getUrl());
		Thread.sleep(2000);
		System.out.println("Launch the application");
	}

	@When("^I enter emailid \"([^\"]*)\"$")
	public void i_enter_emailid_something(String Arg1) throws Throwable {
		Thread.sleep(2000);
		Elements.TypeText(LoginPage.enterusername, Arg1);
		Thread.sleep(2000);
	}

	

	@When("^I enter password \"([^\"]*)\"$")
	public void i_enter_password_something(String strArg1) throws Throwable {
		Elements.TypeText(LoginPage.enterpassword, strArg1);
		Thread.sleep(2000);

	}

	@Then("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		Elements.click(LoginPage.clickLogin);
		System.out.println("updated");

	}

}