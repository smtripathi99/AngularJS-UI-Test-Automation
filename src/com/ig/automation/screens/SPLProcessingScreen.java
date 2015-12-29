package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class SPLProcessingScreen extends DataActions{

	public WebElement cleanCopyAccept ;
	public WebElement cleanCopyRemove;
	public WebElement cleanCopyProcessNotes;
	public WebElement generateCleanCopyLink;
	public WebElement editLink;
	public WebElement generateCleanCopyButton;
	public WebElement generateCleanCopyTitle;
	public WebElement generateCleanCopyTemplate;
	public WebElement message;
	public WebElement annexLink;
	public WebElement cancelButton;
	public WebElement docType;
	public Select docType1;
	public WebElement createFromSPLText;
	public WebElement selectFileButton;
	public WebElement title;
	public WebElement countries;
	public WebElement proprietaryNames;
	public WebElement doneButton;
	public WebElement importCancelButton;
	public WebElement sourceSPLVersion1;
	public Select sourceSPLVersion;
	public WebElement selectProductName;
	public WebElement productName;
	public WebElement tickBox;
	public WebElement productDoneButton;
	public Select fileFormat;
	public WebElement fileFormat1;
	public WebElement genericName;
	public Select SPLOutputType;
	public WebElement SPLOutputType1;
	public WebElement selectFile;
	public WebElement createFromSPL;
	public WebElement splManagement;
	public WebElement generateSPL;
	
	
		
	public void initializeCreateFromSPLScreen(){
		title=findElement(By.className("QA_testing_Title"));
		sourceSPLVersion1 = findElement(By.xpath("//div[2]/div/accordion/div/div/div/div[2]/div/div[3]/div/div/select"));
		sourceSPLVersion = new Select(findElement(By.xpath("//div[2]/div/accordion/div/div/div/div[2]/div/div[3]/div/div/select")));
		proprietaryNames=findElement(By.xpath("//div[2]/div/accordion/div/div/div/div[2]/div/div[1]/div/div/div/tags-input/div/div/input"));
		genericName = findElement(By.xpath("//div[2]/div/accordion/div/div/div/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
		doneButton=findElement(By.className("QA_Testing_Panel_Btn_createSPL"));
		cancelButton=findElement(By.className("QA_Testing_Panel_Btn_cancelLink"));
		//createFromSPLText=findElement(By.xpath("//div[1]/div/div[1]/input"));
		createFromSPLText= findElement(By.id("selectedfile"));
		selectFileButton=findElement(By.className("QA_testing_Panel_Btn"));
	}
	
	
	
	public void initializeCreateFromRegistrationSPLScreen(){
		title=findElement(By.className("QA_testing_Title"));
		sourceSPLVersion1 = findElement(By.xpath("//div[4]/accordion/div/div/div/div[2]/div/div[1]/div/div/select"));
		sourceSPLVersion = new Select(findElement(By.xpath("//div[4]/accordion/div/div/div/div[2]/div/div[1]/div/div/select")));
		fileFormat1 = findElement(By.xpath ("//div[3]/select"));
		fileFormat = new Select (findElement(By.xpath ("//div[3]/select")));
		SPLOutputType1 = findElement (By.xpath ("//div[2]/select"));
		SPLOutputType = new Select (findElement (By.xpath ("//div[2]/select")));
		doneButton=findElement(By.className("QA_Testing_Panel_Btn_createFromRegSPL"));
		cancelButton=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
		selectFile=findElement(By.xpath("//div[1]/div/input"));
		selectFileButton=findElement(By.className("QA_testing_Panel_Btn"));
	}
	public void initializeGenerateSPLScreen(){
		splManagement = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[4]"));
		generateSPL = findElement(By.className("gcDocMenu__button"));
		
	}
	
		
}
