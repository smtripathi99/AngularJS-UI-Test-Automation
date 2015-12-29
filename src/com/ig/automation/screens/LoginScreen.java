package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ig.automation.coreactions.DataActions;


public class LoginScreen extends DataActions {
	public WebElement titleObj;
	public WebElement userIdObj;
	public WebElement pwdObj;
	public WebElement repoObj;
	public WebElement domainObj;

	public WebElement loginButton;
	public WebElement homeImage;
	public WebElement message;

	public void initializeObjects() {
		titleObj = findElement(By.xpath("/html/body/div/div/div[1]/div/div[1]/img"));
		userIdObj = findElement(By.id("login-username"));
		pwdObj = findElement(By.id("login-password"));
		repoObj = findElement(By.id("repository"));
		domainObj = findElement(By.id("domain"));
		loginButton = findElement(By.id("btn-login"));

	}

	public void initializeHomeObjects() {
		homeImage = findElement(By.xpath("/html/body/div/div[1]/div/div[1]/a/img"));

	}

	public void initializeMessages() {
		// message = driver.findElement(By.id("toast-container"));
		message = waitForElementToAppear(driver, "toast-container");

	}

}
