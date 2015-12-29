package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ig.automation.coreactions.DataActions;

public class EstablishmentsByProductScreen extends DataActions {
	public WebElement establishmentsByproduct;
	public WebElement reports;
	public WebElement uspiIcon;
	public WebElement createdDocument;
	public WebElement inputText;
	public WebElement docIDverification;
	public WebElement enterProductName;
	public WebElement product;
	public WebElement doneBtn;
	public WebElement filterProduct;
	public WebElement dosageFrom;
	public WebElement strength;
	public WebElement presentation;
	public WebElement checkBox;
	public WebElement removeButton;
	public WebElement checkBoxGenericName;
	public WebElement productNameValues;
	
	
	
	
	public void initializeReports() {

		reports = findElement(By
			//	.xpath("//*[contains(@class,'panel-default')]/div[1]/h4/a/label/span/span"));
				//.xpath("/html/body/div/div[2]/div/accordion/div/div[7]/div[1]/h4/a/label/span/span"));
				.cssSelector(".ng-scope>div>accordion>div>div:nth-child(7)>div.panel-heading>h4>a>label>span>span"));
	}

	public void initializeEstablishmentsByProduct() {

		establishmentsByproduct = findElement(By
		//		.xpath("//*[contains(@class,'panel-default')]/div[2]/div/accordion/div/div[2]/div[1]/h4/a/label/span"));
			//	.xpath("/html/body/div/div[2]/div/accordion/div/div[7]/div[2]/div/accordion/div/div[2]/div[1]/h4/a/label/span"));
				.cssSelector(".ng-scope>div>accordion>div>div:nth-child(7)>div.panel-collapse.collapse.in>div>accordion>div>div:nth-child(2)>div.panel-heading>h4>a>label>span"));
	}
    public void initializeUSPIicon(){
    	uspiIcon = findElement(By.cssSelector(".gcGrid__header>div:nth-child(15)>.ps_rel>.section>.display_tble>.display_tbcell>.TblsearchIcon"));
    	                                       
    }
    public void initializeInputText(){
    	inputText = findElement(By.cssSelector(".ng-scope>div>div.ng-isolate-scope>div>div.gcGrid__row.gcGrid__header>div:nth-child(15)>span>span>div>span.display_tbcell.ps_rel"));
    }
	public void initializeDocIDverification(){
		docIDverification = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[15]/div/span"));
	}
       
    
    
    
	
	
	
	
	
}
