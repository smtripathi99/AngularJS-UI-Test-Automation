package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class BasicNavigationScreen extends DataActions {
	public WebElement createDoc;
	public WebElement annexType;
	public WebElement cancelBtn;
	public WebElement createdDocument;
	public WebElement selectProductNameBtn;
	public WebElement genericName;
	public WebElement enterProductName;
	public WebElement product;
	public WebElement doneBtn;
	public WebElement filterProduct;
	public WebElement dosageFrom;
	public WebElement strength;
	public WebElement presentation;
	public WebElement checkBox0;
	public WebElement checkBox1;
	public WebElement checkBox2;
	public WebElement removeButton;
	public WebElement checkBoxGenericName;
	public WebElement productNameValues;
	public WebElement genericNameLabel;
	public WebElement selectedProductName;
	public WebElement drugListingTab;
	public WebElement addMCPLink;
	public WebElement addDrugPLink;
	public WebElement addDevicePLink;
	public WebElement titleMCPSidePanel;
	public WebElement titleDrugPSidePanel;
	public WebElement titleDevicePSidePanel;
	public Select properietaryName;
	public WebElement properietaryNameSuffix;
	public Select overallNonProprietaryName;
	public WebElement manufacturedProductCode;
	public Select dosageForm;
	public WebElement doneBtnMCP;
	public WebElement existFirstMCPLink;
	public WebElement message;
	
	
	
	public void initializeDocType() {

		annexType = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[3]/div[1]/div/div/form/div/ul/li[1]"));
	}

	public void initializeProduct() {

		selectProductNameBtn = findElement(By.className("QA_testing_Select_product"));
	}

	public void initializeButtons() {
		
		genericNameLabel = findElement(By
				.xpath("//*[contains(@class,'section')]//div/label"));

		enterProductName = findElement(By
				.xpath("//*[contains(@class,'QA_testing_Product')]/div/div/input"));

		doneBtn = findElement(By
				.className("QA_Testing_Panel_Btn_done"));
		cancelBtn = findElement(By
				.className("QA_Testing_Panel_Btn_cancel"));
	}

	public void initializeFilterProduct() {
		filterProduct = findElement(By
				.xpath("//*[contains(@class,'suggestion-item')]"));
	}

	public void initializeSelectProductTree() {

		genericName = findElement(By
				.xpath("//*[contains(@class,'gcTree_Node_0')]/span/span"));
		dosageFrom = findElement(By.xpath("//*[contains(@class,'gcTree_Node_1')]/span/span"));
		strength = findElement(By.xpath("//*[contains(@class,'gcTree_Node_2')]/span/span"));
		presentation = findElement(By.xpath("//*[contains(@class,'gcTree_Node_3')]/span/span"));
		checkBox0 = findElement(By
				.className("QA_testing_Product_name_values_0"));
		checkBox1 = findElement(By
				.className("QA_testing_Product_name_values_1"));
		checkBox2 = findElement(By
				.className("QA_testing_Product_name_values_2"));
		selectedProductName = findElement(By.xpath("//*[contains(@class,'tag-item')]"));
	    
	}
	public void initializeProductValue(){
		removeButton = findElement(By.xpath("//*[contains(@class,'remove-button')]"));
		productNameValues = findElement(By.xpath("//*[contains(@class,'productListing')]"));
	}
	
	public void initializeDrugListing() {
		drugListingTab = findElement(By
				.xpath("//*[contains(text(),'Drug Listing')]"));
	}
	
	public void initializeDrugListingLinks() {
		addMCPLink = findElement(By
				.xpath("//*[contains(text(),'Add Multi-Component Product')]"));
		addDrugPLink = findElement(By
				.xpath("//*[contains(text(),'Add Drug Product')]"));
		addDevicePLink = findElement(By
				.xpath("//*[contains(text(),'Add Device Product')]"));
	}
	
	public void initializeDrugListingDetails() {
		existFirstMCPLink = findElement(By
				.xpath("//*[contains(text(),'MCP')]"));
		
	}
	
	public void initializeMCPSidePanel() {
		titleMCPSidePanel=findElement(By
				.xpath("//*[contains(text(),'Add New MCP Product')]"));
		properietaryName=new Select(findElement(By
				.className("QA_testing_propriatary_name")));
		properietaryNameSuffix=findElement(By
				.className("QA_testing_proprietary_name_suffix"));
		overallNonProprietaryName=new Select(findElement(By
				.className("QA_testing_overall_nonproprietary_name")));		 
		manufacturedProductCode=findElement(By
				.className("QA_testing_manufactured_product_code"));		 
		dosageForm=new Select(findElement(By
				.className("QA_testing_dosage_form")));		
		doneBtnMCP=findElement(By
				.className("QA_Testing_Panel_Btn_doneDrugProdInfo"));
		cancelBtn = findElement(By
				.className("QA_Testing_Panel_Btn_cancel"));		
	}
	
	public void initializeDrugPSidePanel() {
		titleDrugPSidePanel=findElement(By
				.xpath("//*[contains(text(),'Add New Drug Product')]"));			
	}
	
	public void initializeDevicePSidePanel() {
		titleDevicePSidePanel=findElement(By
				.xpath("//*[contains(text(),'Add New Device Product')]"));			
	}
	
	public void initializeMessages() {
		// message = driver.findElement(By.id("toast-container"));
		message = waitForElementToAppear(driver, "toast-container");

	}
}
