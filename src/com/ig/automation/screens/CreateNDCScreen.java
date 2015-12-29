package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class CreateNDCScreen extends DataActions {
	public WebElement createNDCPanelTitle;
	public WebElement title;
	public Select 	  docType;
	public WebElement cancelBtn;
	public Select labeler;
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
	public WebElement createNDCBtn;
	public WebElement message;
	public WebElement docLink;
	
	
	
	public void initializeMandatoryProperties() {
		createNDCPanelTitle=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/h1"));
		docType = new Select(findElement(By.className("QA_testing_Type")));
		cancelBtn=findElement(By.className("QA_Testing_Panel_Btn_cancelLinkToExisiting"));
				
		labeler=new Select(findElement(By.className("QA_testing_Labeler")));
		
		optionalProperties=findElement(By.cssSelector("span:contains('Optional')"));
	}
	
	
	
	public void initializeOptionalProperties() {
		title=findElement(By.className("QA_testing_Title"));
		contactCountry=new Select(findElement(By.cssSelector(".Country")));
		contactPhone=findElement(By.cssSelector(".Phone"));
		contactEmail=findElement(By.cssSelector(".Email"));
		contactSPL=findElement(By.cssSelector(".Date"));
		contactName=findElement(By.cssSelector(".Name"));
		contactStreet=findElement(By.cssSelector(".Street"));
		contactCity=findElement(By.cssSelector(".City"));
		contactState=findElement(By.cssSelector(".State"));
		contactPostal=findElement(By.cssSelector(".Postal"));
		createNDCBtn=findElement(By.cssSelector(".QA_Testing_Panel_Btn_createRequest"));	
	}
	
	public void initializeMessages(){
		message = driver.findElement(By.id("toast-container"));
		docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}	
}
