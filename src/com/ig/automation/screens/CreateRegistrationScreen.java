package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class CreateRegistrationScreen extends DataActions {
	public WebElement createRegPanelTitle;
	public WebElement title;
	public Select 	  docType;
	public WebElement cancelBtn;
	public WebElement rfaProperties;
	public WebElement optionalProperties;
	public Select registrant;
	public Select contactCountry;
	public WebElement contactPhone;
	public WebElement contactEmail;
	public WebElement contactSPL;
	public WebElement contactName;
	public WebElement contactStreet;
	public WebElement contactCity;
	public WebElement contactState;
	public WebElement contactPostal;
	public WebElement createRegBtn;
	public WebElement message;
	public WebElement docLink;
	
	
	
	public void initializeMandatoryProperties() {
		createRegPanelTitle=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/h1"));
		docType = new Select(findElement(By.className("QA_testing_Type")));
		cancelBtn=findElement(By.className("QA_testing_Panel_Btn"));
				
		rfaProperties=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));
		
		optionalProperties=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[1]/h4/a/span[1]"));
	}
	
	public void initializeRFAProperties() {
		registrant= new Select(findElement(By.className("QA_testing_Registrant")));

	}
	
	public void initializeOptionalProperties() {
		title=findElement(By.className("QA_testing_Title"));
		contactCountry=new Select(findElement(By.className("QA_testing_Contact")));
		contactPhone=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[3]/div/div/input"));
		contactEmail=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[4]/div/div/input"));
		contactSPL=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[5]/div/div/div/div/input"));
		contactName=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[6]/div/div/input"));
		contactStreet=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[7]/div/div/input"));
		contactCity=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[8]/div/div/input"));
		contactState=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[9]/div/div/input"));
		contactPostal=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[10]/div/div/input"));
		createRegBtn=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/h1/button[2]"));	
	}
	
	public void initializeMessages(){
		message = waitForElementToAppear(driver, "toast-container");
		docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}	
}
