package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class CreateSelfIDScreen extends DataActions {
	public WebElement createSelfIDPanelTitle;
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
	public WebElement createSelfIDBtn;
	public WebElement message;
	public WebElement createNewSelfID;
	
	
	
	public void initializeMandatoryProperties() {
		createSelfIDPanelTitle=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/h1"));
		docType = new Select(findElement(By.className("QA_testing_Type")));
		cancelBtn=findElement(By.className("QA_testing_Panel_Btn"));
				
		rfaProperties=findElement(By.xpath("//*[contains(@class,'panel-title')]/a/span[1][contains(text(),'Required for Approval (RFA)')]"));
		
		optionalProperties=findElement(By.xpath(" //*[contains(@class,'panel-title')]/a/span[1][contains(text(),'Optional')]"));
	}
	
	public void initializeRFAProperties() {
		registrant= new Select(findElement(By.className("QA_testing_Registrant")));

	}
	
	
	
	public void initializeOptionalProperties() {
		title=findElement(By.className("QA_testing_Title"));
		contactCountry=new Select (findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Country')]")));
		contactPhone=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Phone')]"));
		contactEmail=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Email')]"));
		contactSPL=findElement(By.xpath("//*[contains(@class,'QA_testing_SPL')]"));
		contactName=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Name')]"));
		contactStreet=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Street')]"));
		contactCity=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact City')]"));
		contactState=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact State')]"));
		contactPostal=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Postal Code')]"));
		createSelfIDBtn=findElement(By.className("QA_Testing_Panel_Btn_createRequest"));	
	}
	
	public void initializeMessages(){
		message = driver.findElement(By.id("toast-container"));
	}	
}
