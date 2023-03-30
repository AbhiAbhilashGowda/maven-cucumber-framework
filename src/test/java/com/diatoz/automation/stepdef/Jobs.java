//package com.diatoz.automation.stepdef;
//
//import java.util.Iterator;
//import java.util.Set;
//
//import com.diatoz.automation.base.Base;
//import com.diatoz.automation.framework.Elements;
//import com.diatoz.automation.pages.JobsPage;
//import com.diatoz.automation.pages.LoginPage;
//import cucumber.api.java.en.*;
//
//public class Jobs extends Base {
//
//	
//    	JobsPage scend = new JobsPage();
//    	LoginPage scenA = new LoginPage();
//
//    	@Then("^I click on jobs$")
//    	public void i_click_on_jobs() throws Throwable {
//    		Thread.sleep(2000);
//    	Elements.click(JobsPage.clickonjobs);
//    		Thread.sleep(4000);
//
//    	}
//
//    	@Then("^I select first job$")
//    	public void i_select_first_job() throws Throwable {
//
//    		Thread.sleep(2000);
//    		Elements.click(JobsPage.clickonfirstjob);
//    		Set<String> handles = driver.getWindowHandles();
//    		Iterator<String> it = handles.iterator();
//    		while (it.hasNext()) {
//    			String parent = it.next();
//    			String newwin = it.next();
//    			driver.switchTo().window(newwin);
//    			Thread.sleep(5000);
//    		}
//    	}
//
//    	@Then("^I click on copylink$")
//    	public void i_select_share_on_mail() throws Throwable {
//    		Thread.sleep(2000);
//    		Elements.click(JobsPage.clickoncopylink);
//    		Thread.sleep(4000);
//
//    	}
//
//    }
//
//}