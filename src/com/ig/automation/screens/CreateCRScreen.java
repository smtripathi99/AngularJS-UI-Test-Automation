package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class CreateCRScreen extends DataActions {
	public WebElement createCRPanelTitle;
	public WebElement title;
	public Select crType;
	public WebElement country;
	public Select language;
	public Select priority;
	public Select reasonRevision;
	public WebElement comments;
	public WebElement doneBtn;
	public WebElement cancelBtn;
	public WebElement createCRoptional;
	public WebElement relatedDoc;
	public WebElement summary;
	public WebElement description;
	public WebElement reason;
	public WebElement jurification;
	public WebElement createCRBtn;
	public WebElement message;
	public WebElement docLink;
	public WebElement changeRequest;
	public WebElement createChangeRequest;

	// public WebElement createCR = findElement(By.className("createChangeRequest"));

	public void initializeCRTab(){
		changeRequest=findElement(By.xpath("//div/ul/li/a[contains(text(),'Change Request')]"));
	}
	
	public void initializeCreateCRLink(){
		createChangeRequest=findElement(By.xpath("//a[contains(text(),'Create Change Request')]"));
	}
	
	public void initializeMandatoryProperties() {
		
		createCRPanelTitle = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[2]/h1"));
		crType = new Select(findElement(By.className("QA_testing_Change")));
		title = findElement(By.className("QA_testing_Title"));
		country = findElement(By.cssSelector(".gcSidePanel__content>div>div>div>div.section.Pd1.gc__table-list-Wrap>div>div>accordion>div>div>div:nth-child(1)>div.panel-collapse.collapse.in>div>div:nth-child(4)>div>div>div>div>div>tags-input>div>div>input"));
				//.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[1]/div[2]/div/div[3]/div/div/div/tags-input/div/div/input"));
						
		language = new Select(findElement(By.className("QA_testing_Language")));
		priority = new Select(findElement(By.className("QA_testing_Priority")));
		cancelBtn = findElement(By.className("QA_Testing_Panel_Btn_cancel"));
		
		// findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/h1/button[2]"));
	}
	
	public void initializeCRCreateBtn() {
		createCRBtn = findElement(By.className("QA_Testing_Panel_Btn_createRequest"));
	}

	public void initializeOptionalProperties() {
		createCRoptional = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));

	}

	public void initializeCreateCRPanelOptional() {
		relatedDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[2]/div[2]/div/div[1]/div/div/div/tags-input/div/div/input"));
		summary = findElement(By.className("QA_testing_Summary"));
		description = findElement(By.className("QA_testing_Description"));
		reason = findElement(By.className("QA_testing_Reason"));
		jurification = findElement(By.className("QA_testing_Justification"));

	}

	public void initializeMessages() {
		// message = driver.findElement(By.id("toast-container"));
		message = waitForElementToAppear(driver, "toast-container");
		// docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));

	}

}
