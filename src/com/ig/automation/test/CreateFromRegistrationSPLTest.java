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

import com.ig.automation.screens.SPLProcessingScreen;
import com.ig.automation.utility.Log;


public class CreateFromRegistrationSPLTest extends SPLProcessingScreen{
	
	HomeTest homeTest = new HomeTest();
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testActionTab();
			homeTest.initializeActionObjects();
			homeTest.spl.click();
			Thread.sleep(2000);
			homeTest.initializeCreateRegistrationSPL();
			homeTest.createRegistrationSPL.click();
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void createFromRegistrationSPLTest() throws Exception{
	/*	System.out.println("Start running the Auto It file");
		Runtime.getRuntime().exec("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\runApplet.exe");
		System.out.println("The Auto It file is executed successfully");
		Thread.sleep(12000);*/
		getScreenShot("CreateFromRegistrationSPL", "CreateFromRegistrationSPLscreen");
		
		initializeCreateFromRegistrationSPLScreen();
		
		Log.info("UI--01 - Select File field is Enabled Successfully");
		Assert.assertEquals(selectFile.getText(), "", "UI-CFRSPL-01 - Select File field is Cleared"); 
		Log.info("UI-CFRSPL-01 - Select File field is Cleared");
		
		Assert.assertEquals(selectFileButton.isDisplayed(), true, "UI-CFRSPL-02 - Select File Button is Displayed Successfully"); 
		Log.info("UI-CFRSPL-02 - Select File Button is Displayed Successfully");
		Assert.assertEquals(selectFileButton.isEnabled(), true, "UI-CFRSPL-02 - Select File Button is Enabled Successfully"); 
		Log.info("UI-CFRSPL-02 - Select File Button is Enabled Successfully");
		
		Assert.assertEquals(sourceSPLVersion1.isDisplayed(), true, "UI-CFRSPL-03 - Select Source SPL Version drop down field is Displayed Successfully"); 
		Log.info("UI-CFRSPL-03 - Select Source SPL Version drop down field is Displayed Successfully");
		Assert.assertEquals(sourceSPLVersion1.isEnabled(), true, "UI-CFRSPL-03 - Select Source SPL Version drop down field is Enabled"); 
		Log.info("UI-CFRSPL-03 - Select Source SPL Version drop down field is Enabled");
		verifyDropDownValue();
		Log.info("UI-CFRSPL-03 - Select Source SPL Version numbers are verified Successfully");
		
		Assert.assertEquals(title.isDisplayed(), true, "UI-CFRSPL-04- Title field is Displayed Successfully"); 
		Log.info("UI-CFRSPL-04 - Title field is Displayed Successfully");
		Assert.assertEquals(title.isEnabled(), true, "UI-CFRSPL-04 - Title field is Enabled Successfully"); 
		
		Assert.assertEquals(doneButton.isDisplayed(), true, "UI-CFRSPL-05 - Done button is hidden"); 
		Log.info("UI-CFRSPL-05 - Done button is hidden");

		Assert.assertEquals(cancelButton.isDisplayed(), true, "UI-CFRSPL-06 - Cancel Button is Displayed Successfully"); 
		Log.info("UI-CFRSPL-06 - Cancel File Button is Displayed Successfully");
		Assert.assertEquals(cancelButton.isEnabled(), true, "UI-CFRSPL-06 - Cancel Button is Enabled Successfully"); 
		Log.info("UI-CFRSPL-06 - Cancel File Button is Enabled Successfully");
		
		Assert.assertEquals(fileFormat1.isDisplayed(), true, "Select File Fromat drop down field is Displayed Successfully"); 
		Log.info("Select File Fromat drop down field is Displayed Successfully");
		Assert.assertEquals(fileFormat1.isEnabled(), true, "Select File Fromat drop down field is Enabled"); 
		Log.info("Select File Fromat drop down field is Enabled");
		
		Assert.assertEquals(SPLOutputType1.isDisplayed(), true, "SPL Output Type Names is Displayed Successfully"); 
		Log.info("SPL Output Type Names is Displayed Successfully");
		
		selectFile.sendKeys("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\spl.xml");
		Log.info("UI-CFRSPL-08 - XML File Selected");
		String locationpath = selectFile.getText();
		Log.info("UI-CFRSPL-09 - The file location path in the Select Files field"+locationpath);
		

		
		doImportDocument("SPL Output","XML Document","R3","Test");
		Thread.sleep(3000);
		getScreenShot("CreateFromRegistrationSPL", "CreateFromRegistrationSPLWithValues");
		Assert.assertEquals(doneButton.isDisplayed(), true, "UI-CFRSPL-11 - Done button is Displayed"); 
		Log.info("UI-CFRSPL-11 - Done button is Displayed");
		Assert.assertEquals(doneButton.isEnabled(), true, "UI-CFRSPL-11 - Done button is Enabled"); 
		Log.info("UI-CFRSPL-11 - Done button is Enabled");
		doneButton.click();
		
		
	}
	
	@Test(priority=2)
	public void createFromSPLCancel() throws InterruptedException{
		homeTest.actions.click();
		Thread.sleep(2000);
		homeTest.spl.click();
		Thread.sleep(2000);
		homeTest.createSPL.click();
		Thread.sleep(2000);
		Assert.assertEquals(cancelButton.isDisplayed(), true, "Cancel Button is displayed Successfully"); 
		Log.info("Cancel Button is displayed Successfully");
		Log.info("UI-CFRSPL-06 - Cancel Button is displayed Successfully");
		cancelButton.click();
		Log.info("UI-CFRSPL-15 - Close the Create from SPL panel Successfully");
		Log.info("UI-CFRSPL-17 - Close the Create from SPL panel Successfully");
		
		
	}

	public void verifyDropDownValue () {
		 String[] exp = {"R3","R4"};
		 boolean match = false;
		 for(int i=1 ; i<3 ; i++){
			 
			 WebElement options = sourceSPLVersion.getOptions().get(i);  
			 System.out.println(options.getText());
			 if (options.getText().contains(exp[i-1])){
			        match = true;
			   }
		 }
		  Assert.assertTrue(match);
	}
	
	public void doImportDocument(String Type,String FileFormat,String SourceSPLVersion,String Title)
			throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create From SPL");
		String DocID;
		String successMsg[];
		try {
			
			if (!Type.isEmpty()) {
				enterOuputType(Type);
				Log.info("UI-CFRSPL-12 - Ouput Type Name property contains a value");
			}
			if (!FileFormat.isEmpty()) {
				enterFileFormat(FileFormat);
				Log.info("UI-CFRSPL-13 - File Format Name property contains a value");
			}
			if (!SourceSPLVersion.isEmpty()) {
				entersourceSPLVersion(SourceSPLVersion);	
				Log.info("UI-CFRSPL-10 - SPL Version property contains a value");
			}
			if (!Title.isEmpty()) {
				enterTitle(Title);	
				Log.info("UI-CFRSPL-11 - Title property contains a value");
			}
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	
	public void enterTitle(String Title) {
		title.clear();
		title.sendKeys(Title);
	}


	public void enterOuputType(String Type) {
		SPLOutputType.selectByVisibleText (Type);
	}
	
	public void enterFileFormat(String FileFormat) {
		fileFormat.selectByVisibleText(FileFormat);
		
	}
	
	public void entersourceSPLVersion(String SourceSPLVersion) {
		sourceSPLVersion1.sendKeys(SourceSPLVersion);
		sourceSPLVersion1.sendKeys(Keys.ENTER);
	}
	
}
