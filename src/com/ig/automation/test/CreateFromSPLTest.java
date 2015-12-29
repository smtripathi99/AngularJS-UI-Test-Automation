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


public class CreateFromSPLTest extends SPLProcessingScreen{
	
	HomeTest homeTest = new HomeTest();
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testActionTab();
			homeTest.initializeActionObjects();
			homeTest.spl.click();
			Thread.sleep(2000);
			homeTest.initializeCreateSPL();
			homeTest.createSPL.click();
			Thread.sleep(12000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void createFromSPLTest() throws Exception{
		System.out.println("Start running the Auto It file");
		Runtime.getRuntime().exec("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\runApplet.exe");
		System.out.println("The Auto It file is executed successfully");
		Thread.sleep(12000);
		getScreenShot("CreateFromSPL", "CreateFromSPLscreen");
		
		initializeCreateFromSPLScreen();
		
		Log.info("UI-CFSPL-01 - Select File field is Enabled Successfully");
		Assert.assertEquals(createFromSPLText.getText(), "", "UI-CFSPL-01 - Select File field is Cleared"); 
		Log.info("UI-CFSPL-01 - Select File field is Cleared");
		
		Assert.assertEquals(selectFileButton.isDisplayed(), true, "UI-CFSPL-02 - Select File Button is Displayed Successfully"); 
		Log.info("UI-CFSPL-02 - Select File Button is Displayed Successfully");
		Assert.assertEquals(selectFileButton.isEnabled(), true, "UI-CFSPL-02 - Select File Button is Enabled Successfully"); 
		Log.info("UI-CFSPL-02 - Select File Button is Enabled Successfully");
		
		Assert.assertEquals(proprietaryNames.isDisplayed(), true, "UI-CFSPL-03 - Proprietary Names is Displayed Successfully"); 
		Log.info("UI-CFSPL-03 - Proprietary Names is Displayed Successfully");
		
		Assert.assertEquals(genericName.isDisplayed(), true, "UI-CFSPL-04 - Generic Name is Displayed Successfully"); 
		Log.info("UI-CFSPL-04 - Generic Name is Displayed Successfully");
		
		Assert.assertEquals(sourceSPLVersion1.isDisplayed(), true, "UI-CFSPL-05 - Select Source SPL Version drop down field is Displayed Successfully"); 
		Log.info("UI-CFSPL-05 - Select Source SPL Version drop down field is Displayed Successfully");
		Assert.assertEquals(sourceSPLVersion1.isEnabled(), true, "UI-CFSPL-05 - Select Source SPL Version drop down field is Enabled"); 
		Log.info("UI-CFSPL-05 - Select Source SPL Version drop down field is Enabled");
		verifyDropDownValue();
		Log.info("UI-CFSPL-05 - Select Source SPL Version numbers are verified Successfully");
		
		Assert.assertEquals(title.isDisplayed(), true, "UI-CFSPL-06- Title field is Displayed Successfully"); 
		Log.info("UI-CFSPL-06 - Title field is Displayed Successfully");
		Assert.assertEquals(title.isEnabled(), true, "UI-CFSPL-06 - Title field is Enabled Successfully"); 
		
		Assert.assertEquals(doneButton.isDisplayed(), true, "UI-CFSPL-07 - Done button is hidden"); 
		Log.info("UI-CFSPL-07 - Done button is hidden");
		
		initializeCreateFromSPLScreen();
		Assert.assertEquals(cancelButton.isDisplayed(), true, "UI-CFSPL-08 - Cancel Button is Displayed Successfully"); 
		Log.info("UI-CFSPL-08 - Cancel File Button is Displayed Successfully");
		Assert.assertEquals(cancelButton.isEnabled(), true, "UI-CFSPL-08 - Cancel Button is Enabled Successfully"); 
		Log.info("UI-CFSPL-08 - Cancel File Button is Enabled Successfully");
		
		
		createFromSPLText.sendKeys("mLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\spl.xml");
		Log.info("UI-CFSPL-11 - XML File Selected");
		String locationpath = createFromSPLText.getText();
		Log.info("UI-CFSPL-10 - The file location path in the Select Files field"+locationpath);
		
		
		
		Runtime.getRuntime().exec("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\select.exe");
		System.out.println("The Auto It file is executed successfully 1");
		Thread.sleep(5000);
		
		doImportDocument("ALLERSOLV","Alkaline Aqua","R3","Test");
		Thread.sleep(12000);
		getScreenShot("CreateFromSPL", "CreateFromSPLScreenWithValues");
		Assert.assertEquals(doneButton.isDisplayed(), true, "UI-CFSPL-15 - Done button is Displayed"); 
		Log.info("UI-CFSPL-15 - Done button is Displayed");
		Assert.assertEquals(doneButton.isEnabled(), true, "UI-CFSPL-15 - Done button is Enabled"); 
		Log.info("UI-CFSPL-15 - Done button is Enabled");
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
		Log.info("UI-CFSPL-21 - Cancel Button is displayed Successfully");
		cancelButton.click();
		Log.info("UI-CFSPL-19 - Close the Create from SPL panel Successfully");
		
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
	
	public void doImportDocument(String Proprietary,String GenericName,String SourceSPLVersion,String Title)
			throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create From SPL");
		String DocID;
		String successMsg[];
		try {
			
			if (!Proprietary.isEmpty()) {
				enterProprietary(Proprietary);
				Log.info("UI-CFSPL-12 - Proprietary Name property contains a value");
			}
			if (!GenericName.isEmpty()) {
				enterGenericName(GenericName);
				Log.info("UI-CFSPL-13 - GenericName Name property contains a value");
			}
			if (!SourceSPLVersion.isEmpty()) {
				entersourceSPLVersion(SourceSPLVersion);	
				Log.info("UI-CFSPL-14 - SPL Version property contains a value");
			}
			if (!Title.isEmpty()) {
				enterTitle(Title);	
				Log.info("UI-CFSPL-15 - Title property contains a value");
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



	public void enterProprietary(String Proprietary) {
		proprietaryNames.clear();
		proprietaryNames.sendKeys(Proprietary);
		proprietaryNames.sendKeys(Keys.ARROW_DOWN);
		proprietaryNames.sendKeys(Keys.ENTER);
	}
	
	public void enterGenericName(String GenericName) {
		genericName.clear();
		genericName.sendKeys(GenericName);
		genericName.sendKeys(Keys.ARROW_DOWN);
		genericName.sendKeys(Keys.ENTER);
		
	}
	
	public void entersourceSPLVersion(String SourceSPLVersion) {
		sourceSPLVersion1.sendKeys(SourceSPLVersion);
		sourceSPLVersion1.sendKeys(Keys.ENTER);
	}
	
	
	public void docreateFromSPLTest() throws Exception{
		
		initializeCreateFromSPLScreen();
		
		
		verifyDropDownValue();
		
		
		initializeCreateFromSPLScreen();
		
		
		
		createFromSPLText.sendKeys("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\spl.xml");
		
		String locationpath = createFromSPLText.getText();
		
		
		
		
		Runtime.getRuntime().exec("xmLabeling_IG_UI\\Test\\UI\\Automation\\gtc_xmlabeling_automation\\resources\\select.exe");
		System.out.println("The Auto It file is executed successfully 1");
		Thread.sleep(5000);
		
		doImportDocument("ALLERSOLV","Alkaline Aqua","R3","Test");
		Thread.sleep(12000);
		getScreenShot("CreateFromSPL", "CreateFromSPLScreenWithValues");
		Assert.assertEquals(doneButton.isDisplayed(), true, "UI-CFSPL-15 - Done button is Displayed"); 
		Log.info("UI-CFSPL-15 - Done button is Displayed");
		Assert.assertEquals(doneButton.isEnabled(), true, "UI-CFSPL-15 - Done button is Enabled"); 
		Log.info("UI-CFSPL-15 - Done button is Enabled");
		doneButton.click();

}
	
public void doGenerateSPLTest() throws Exception{
		
	   initializeGenerateSPLScreen();
		splManagement.click();
		generateSPL.click();
		
		
		
		
		
}
}

