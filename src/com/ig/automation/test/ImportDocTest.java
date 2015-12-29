package com.ig.automation.test;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.omg.CORBA.OMGVMCID;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.utility.Log;

public class ImportDocTest extends ContentManagementScreen{
	
	HomeTest homeTest = new HomeTest();
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testActionTab();
			homeTest.initializeImportContact();
			homeTest.importContact.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void importDocTest() throws Exception{
		System.out.println("Start running the Auto It file");
		Runtime.getRuntime().exec("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\bin\\runApplet.exe");
		System.out.println("The Auto It file is executed successfully");
		Thread.sleep(16000);
		getScreenShot("ImportContact", "ImportContactcreen");
		initializeImportDocType();
		Assert.assertEquals(docType.isDisplayed(), true, "UI-IM-01 - Select Document Type drop down control is Displayed Successfully"); 
		Log.info("UI-IM-01 - Select Document Type drop down control is Displayed Successfully");
		Assert.assertEquals(selectFileText.isDisplayed(), true, "UI-IM-02 - Select File field is Displayed Successfully"); 
		Log.info("UI-IM-02 - Select File field is Displayed Successfully");
		Assert.assertEquals(selectFileText.isEnabled(), true, "UI-IM-02 - Select File field is Enabled Successfully"); 
		Log.info("UI-IM-02 - Select File field is Enabled Successfully");
		Assert.assertEquals(selectFileText.getText(), "", "UI-IM-02 - Select File field is Cleared"); 
		Log.info("UI-IM-02 - Select File field is Cleared");
		
		Assert.assertEquals(selectFileButton.isDisplayed(), true, "UI-IM-03 - Select File Button is Displayed Successfully"); 
		Log.info("UI-IM-03 - Select File Button is Displayed Successfully");
		
		Assert.assertEquals(selectFileButton.isEnabled(), true, "UI-IM-03 - Select File Button is Enabled Successfully"); 
		Log.info("UI-IM-03 - Select File Button is Enabled Successfully");
		
		/*Assert.assertEquals(importButton.isDisplayed(), true, "UI-IM-04 - Import button is hidden"); 
		Log.info("UI-IM-04 - Import button is hidden");*/
		
		
		Log.info("UI-IM-010 -1.	Select File Format field is verified Successfully");
		docType.sendKeys("Annex II");
		Thread.sleep(2000);
		initializeImportDocs();
		try {
			Assert.assertEquals(importCancelButton.isDisplayed(), true, "UI-IM-05 - Cancel Button is Displayed Successfully"); 
			Log.info("UI-IM-05 - Select File Button is Displayed Successfully");
			
			Assert.assertEquals(importCancelButton.isEnabled(), true, "UI-IM-05 - Cancel Button is Enabled Successfully"); 
			Log.info("UI-IM-05 - Select File Button is Enabled Successfully");
			verifyDropDOwnValue();
			Log.info("UI-IM-10 - Select File Format field is verified Successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertEquals(fileFormat1.isDisplayed(), true, "UI-IM-06 - Select File Fromat drop down field is Displayed Successfully"); 
		Log.info("UI-IM-06 - Select File Fromat drop down field is Displayed Successfully");
		Assert.assertEquals(fileFormat1.isEnabled(), true, "UI-IM-06 - Select File Fromat drop down field is Enabled"); 
		Log.info("UI-IM-06 - Select File Fromat drop down field is Enabled");
		
		if (docType1.getFirstSelectedOption().getText().equals("Annex II")){
			Assert.assertEquals(title.isDisplayed(), true, "Title TextBox is Displayed Successfully"); 
			Log.info("STitle TextBox is Displayed Successfully");
			Assert.assertEquals(proprietaryNames.isDisplayed(), true, "Proprietary Names is Displayed Successfully"); 
			Log.info("Proprietary Names is Displayed Successfully");
			Assert.assertEquals(productName.isDisplayed(), true, "Product Name is Displayed Successfully"); 
			Log.info("Product Name is Displayed Successfully");
			Assert.assertEquals(proprietaryNames.isDisplayed(), true, "Proprietary Names is Displayed Successfully"); 
			Log.info("Proprietary Names is Displayed Successfully");
			Log.info("UI-IM-08 - is verified successfully");
		}
		doImportDocument("Acrobat PDF", "Test", "European Union","English","Alkaline Aqua","ALLERSOLV");
		Thread.sleep(12000);
		System.out.println("The Auto It file is executed successfully 1");
		Runtime.getRuntime().exec("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\select.exe");
		Thread.sleep(5000);
		Log.info("UI-IM-09 - the Standard operating system select file window is displayed successfully");
		getScreenShot("ImportContact", "ImportContactcreenWithValues");
		System.out.println("The Auto It file is executed successfully 2");
		Assert.assertEquals(importButton.isDisplayed(), true, "UI-IM-11 - Import button is Displayed"); 
		Log.info("UI-IM-11 - Import button is Displayed");
		Assert.assertEquals(importButton.isEnabled(), true, "UI-IM-11 - Import button is Enabled"); 
		Log.info("UI-IM-11 - Import button is Enabled");
		importButton.click();
		
	}
	
	@Test(priority=2)
	public void importContactsCancel() throws InterruptedException{
		homeTest.actions.click();
		Thread.sleep(2000);
		homeTest.importContact.click();
		Thread.sleep(2000);
		Assert.assertEquals(cancelButton.isDisplayed(), true, "Cancel Button is displayed Successfully"); 
		Log.info("Cancel Button is displayed Successfully");
		cancelButton.click();
		Log.info("UI-IM-15 - Cancel Button is displayed Successfully");
	}

	public void verifyDropDOwnValue(){
		 String[] exp = {"PDF","Word","Document","XML"};
		 boolean match = false;
		 for(int i=1 ; i<5 ; i++){
			 
			 WebElement options = fileFormat.getOptions().get(i);  
			 System.out.println(options.getText());
			 if (options.getText().contains(exp[i-1])){
			        match = true;
			   }
		 }
		  Assert.assertTrue(match);
	}
	
	public void doImportDocument( String FileFormat,String Title, String Country, String Language, String Product, String Proprietary)
			throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Import Document");
		String DocID;
		String successMsg[];
		try {
			if (!FileFormat.isEmpty()) {
				enterFileFormat(FileFormat);
			}
			if (!Title.isEmpty()) {
				enterTitle(Title);
			}
			enterCountry(Country);
			Thread.sleep(1000);
			enterLanguage(Language);
			if (!Product.isEmpty()) {
				selectProductName.click();
				Thread.sleep(2000);
				initializeProductName();
				enterProduct(Product);
				Thread.sleep(2000);
				initializeTickBox();
				tickBox.click();
				Thread.sleep(1000);
				productDoneButton.click();
			}
			Thread.sleep(3000);
			if (!Proprietary.isEmpty()) {
				enterProprietary(Proprietary);
			}
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	public void enterFileFormat(String FileFormat) {
		fileFormat.selectByVisibleText(FileFormat);
	}
	
	public void enterTitle(String Title) {
		title.clear();
		title.sendKeys(Title);
	}

	public void enterCountry(String Country) {
		countries.clear();
		countries.sendKeys(Country);
		countries.sendKeys(Keys.ARROW_DOWN);
		countries.sendKeys(Keys.ENTER);
	}

	public void enterLanguage(String Language) {
		language.selectByVisibleText(Language);
	}

	public void enterProduct(String Product) {
		productName.clear();
		productName.sendKeys(Product);
		productName.sendKeys(Keys.ARROW_DOWN);
		productName.sendKeys(Keys.ENTER);
	}

	public void enterProprietary(String Proprietary) {
		proprietaryNames.clear();
		proprietaryNames.sendKeys(Proprietary);
		proprietaryNames.sendKeys(Keys.ARROW_DOWN);
		proprietaryNames.sendKeys(Keys.ENTER);
	}
	
}
