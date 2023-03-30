package com.diatoz.automation.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.wml.WMLElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.diatoz.automation.base.Base;

public class Elements {

	private static final By WebElement = null;
	public Logger log = Logger.getLogger(Elements.class);

	public static void TypeText(WebElement element, String titleofblogs) {
		element.sendKeys(titleofblogs);
	}

	public static void TypeTextIfElementPresent(WebElement element, String data) {
		if (element.isDisplayed()) {
			element.sendKeys(data);
		}
	}

	public static void clearTxtBox(WebElement element) {
		element.clear();
	}

	public static void typeRandomNumber(WebElement element, int data) {
		Random random = new Random();
		int rn = random.nextInt(100);
		String randomNumber = Integer.toString(rn);
		element.sendKeys(randomNumber);
	}

	public static String getTextBoxValue(WebElement element) {
		return element.getAttribute("value");
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static boolean VerifyTextEquals(WebElement element, String expected) {
		boolean flag = false;
		if (element.getText().equals(expected))
			return flag = true;
		return flag;
	}

	public static String getTitle() {
		return Base.driver.getTitle();
	}

	public static String getCurrentUrl() {
		return Base.driver.getCurrentUrl();
	}

	public static boolean isSelected(WebElement element) {
		if (element.isSelected())
			return true;
		return false;
	}

	public static void selectCheckBox(WebElement element) {
		if (!isSelected(element))
			element.click();
	}

	public static void deSelectCheckbox(WebElement element) {
		if (isSelected(element))
			element.click();
	}

	public static void selectRadioButton(WebElement element) {
		if (!isSelected(element))
			element.click();
	}

	public static void deSelectRadioButton(WebElement element) {
		if (isSelected(element))
			element.click();
	}

	public static boolean isEnabled(WebElement element) {
		if (element.isEnabled())
			return true;
		return false;
	}

	public static boolean isDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		return false;
	}

	public static void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static String getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}

	public static List<WebElement> getAllOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}

	public static void deSelectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public static void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public static void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public static void click(WebElement element) {
		Waits.waitUntil(() -> isDisplayed(element));
		element.click();
	}

	public static void clickOnlyIfElementPresent(WebElement element) {
		if (isDisplayed(element))
			element.click();
	}

	public static Alert getAlert() {
		return Base.driver.switchTo().alert();
	}

	public static void AcceptAlert() {
		getAlert().accept();
	}

	public static void DismissAlert() {
		getAlert().dismiss();
	}

	public static String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public static boolean isAlertPresent() {
		try {
			Base.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
	}

	public static void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
	}

	public static void AcceptPrompt(String text) {

		if (!isAlertPresent())
			return;

		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
	}

	public static void scrollToElemet(WebElement element) {
		Waits.tryJavascript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
	}

	public static void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	}

	public static void LocateHidedElement(WebElement element, JavascriptExecutor driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void scrollIntoView(WebElement element) {
		Waits.tryJavascript("arguments[0].scrollIntoView()", element);
	}

	public static void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	}

	public static void scrollDownVertically() {
		Waits.tryJavascript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpVertically() {
		Waits.tryJavascript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollDownByPixel() {
		Waits.tryJavascript("window.scrollBy(0,500)");
	}

	public static void scrollUpByPixel() {
		Waits.tryJavascript("window.scrollBy(0,-500)");
	}

	public static void ZoomInBypercentage() {
		Waits.tryJavascript("document.body.style.zoom='40%'");
	}

	public static void ZoomBy100percentage() {
		Waits.tryJavascript("document.body.style.zoom='100%'");
	}

	public static void TypeText(WebElement element1, WebElement element2, String data1,
			String data2) {
		element1.sendKeys(data1);
		element2.sendKeys(data2);
	}

	public static void TypeText(WebElement element1, WebElement element2, WebElement element3, String data1,
			String data2, String data3) {
		element1.sendKeys(data1);
		element2.sendKeys(data2);
		element3.sendKeys(data3);

	}

	public static void clearWebField(org.openqa.selenium.WebElement enterphno) {
		while (!enterphno.getAttribute("value").equals("")) {
			enterphno.sendKeys(Keys.BACK_SPACE);
		}
	}

	public static void sendKeysDelete(WebElement element1) {
		element1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	public static String enterrandomalphabet(WebElement element, int i) {
		String s = RandomStringUtils.randomAlphabetic(i);
		return s;

	}

	public static String enterrandomNumeric(WebElement element, int i) {
		String s = RandomStringUtils.randomNumeric(i);
		return s;
	}

	public static String RandomGenerator(String x, int i) {
		String randomstring = null;
		switch (x) {
			case "Alpha":
				randomstring = RandomStringUtils.randomAlphabetic(i);
				randomstring = randomstring.toLowerCase();
				return randomstring;

			case "Numeric":
				randomstring = RandomStringUtils.randomNumeric(i);
				return randomstring;

			case "AlphaNumeric":
				randomstring = RandomStringUtils.randomAlphanumeric(i);
				return randomstring;

		}
		return randomstring;
	}

	public static void SelectEle(WebElement element) {
		Actions a = new Actions(Base.driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, "A"));
	}

	public static void CopyEle(WebElement element) {
		Actions a = new Actions(Base.driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	public static void PasteEle(WebElement element) {
		Actions a = new Actions(Base.driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public static void selectTab(WebElement element) {
		Actions a = new Actions(Base.driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, "Tab"));
	}

	public static void KeyboardEnter(WebElement element1) {
		Actions a = new Actions(Base.driver);
		a.sendKeys(Keys.ENTER).build().perform();
	}

	public static void switchTab(String ID) throws Throwable {

		((JavascriptExecutor) Base.driver).executeScript("window.open()");
		Set<String> windows = Base.driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String ID1 = itr.next();
		String ID2 = itr.next();
		Thread.sleep(1000);
		if (ID == "ID1") {
			Base.driver.switchTo().window(ID2);
			Base.driver.get("https://mail7.io/");
			//Base.driver.get("https://mail.yahoo.com/d/folders/1");
			Thread.sleep(2000);
		} else if (ID == "ID2") {
			Base.driver.switchTo().window(ID1);
		}

	}

	public static void switchToFrame() {
		WebElement iframe = Base.driver.findElement(By.xpath("//div[@class='message']//iframe"));
		Base.driver.switchTo().frame(iframe);

	}

	public StringBuffer deleteCharAt(WebElement element) {

		String string = "agvdg_1234";
		StringBuffer sb = new StringBuffer(string);
		return sb.deleteCharAt(sb.length() - 1);

	}

	public static void deletecharacter(WebElement element) {
		String string = "Deletechar";
		StringBuffer sb = new StringBuffer(string);
		sb.deleteCharAt(sb.length() - 1);
	}

	public static void deleteChar(WebElement elm) {

		String str = "@mail7.io";
		str.substring(0, str.length() - 2);

	}

	public static void deleteallchars(WebElement elm) {

		String email = "ghcfhfhd_gdfgdgd";
		String[] re = email.split("_");
		email = re[0] + "_";

	}

	public static void deletecharss(WebElement emailField) {
		emailField.sendKeys("@mail7.io");
		emailField.clear();
	}

	public static String removeLastCharacter(String str) {
		String result = null;
		if ((str != null) && (str.length() > 0)) {
			result = str.substring(0, str.length() - 1);
		}

		return result;
	}

	public static void ActionsEnterText(WebElement element, String data) {
		Actions ob = new Actions(Base.driver);
		ob.moveToElement(element).sendKeys(data).build().perform();
	}

	public static void ActionsClass(WebElement element) {

		Actions a = new Actions(Base.driver);
		a.moveToElement(element).click().build().perform();
		Math.random();
	}

	public void extractLetters(String str) {
		String result = "_";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				result += str.charAt(i);
			}
		}
	}

	public static String getRandomElement() {
		Random rand = new Random();
		List<String> list = new ArrayList<>();
		list.add("On Hold");
		list.add("Rejected By Candidate");
		list.add("Did not join");
		list.add("Hired");
		list.add("Rejected");
		list.add("Full Time");
		list.add("Part Time");
		list.add("Internship");
		return list.get(rand.nextInt(list.size()));
	}

	public static void scrollToElemets(WebElement element) {
		Waits.tryJavascript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
	}

	public static void scrollToElemetsAndTypeText(WebElement element, String data) {
		scrollToElemets(element);
		element.sendKeys(data);
	}

	public static void scrollDownByPixel(WebElement element){
		
	}
}
