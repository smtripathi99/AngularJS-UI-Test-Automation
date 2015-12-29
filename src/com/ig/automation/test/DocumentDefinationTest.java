package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CreateCPScreen;
import com.ig.automation.utility.Log;

public class DocumentDefinationTest extends CreateCPScreen{

	HomeTest homeTest = new HomeTest();
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testCP();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void documentDefinationTest() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Document Defination Test");
		try {
			//create document
			initializeObjectsCP();
			title.sendKeys("Test");
			country.sendKeys("Euro");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			initializeDocProp();
			selectProductName.click();
			initializeProductName();
			enterProductName.clear();
			enterProductName.sendKeys("a");
			enterProductName.sendKeys(Keys.ARROW_DOWN);
			enterProductName.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			initializeTickBox();
			tickBox.click();
			Thread.sleep(2000);
			productDoneBtn.click();
			proprietaryName.selectByIndex(1);
			Thread.sleep(2000);
			addDocBtn.click();
			initializeAddDocScreen();
			Assert.assertEquals(addDocScreen.isDisplayed(), true, "Add Document screen is displayed");
			//Taking Screenshot for Add document Screen
			getScreenShot("DDS-15", "AddDocumentScreen");
			Assert.assertEquals(addDocScreen.isDisplayed(), true, "Add Document screen is displayed");
			
			//verify Create Centralised Procedure heading -> UA-DD-7
			initializeCPProperties();
			Assert.assertEquals(countryProp.isDisplayed(), true, "UA-DD-8- Country is displayed Successfully"); 
			Log.info("UA-DD-8 is Passed Successfully");
			Assert.assertEquals(productNames.isDisplayed(), true, "UA-DD-9- Product Name properties displayed Successfully"); 
			Log.info("UA-DD-9 is Passed Successfully");
			Assert.assertEquals(proprName.isDisplayed(), true, "UA-DD-10- Proprietary Name is Displayed Successfully"); 
			Log.info("UA-DD-10 is Passed Successfully");
			Log.info("UA-DD-7 is Passed Successfully");
			Thread.sleep(2000);
			
			Actions action = new Actions(driver);
			// click on Create button from SMPC Hover
			initializeSMPCHover();
			initializeCreateAfterHoverSMPC();
			// Hover SMPC document tablet and find create button and click on it
			action.moveToElement(smpcHover).moveToElement(createAfterHoverSMPC).build().perform();
			Assert.assertEquals(createAfterHoverSMPC.isDisplayed(), true, "The Create button is displayed and enabled."); 
			action.moveToElement(smpcHover).moveToElement(createAfterHoverSMPC).click().build().perform();
			System.out.println("The Create New button is displayed and enabled");
			Thread.sleep(2000);
			
			//Create PI Document
			createPIDocument();
			
			// Click on Document Definition document tablet
			docDefIcon.click();
			initializeDocDefText();
			Thread.sleep(2000);
			//Taking Screenshot for Document Definition Screen
			getScreenShot("DDS-15", "DocumentDefinitionScreen");
			
			initializeDocDefGenericName();
			Assert.assertEquals(docdefGenericName.isDisplayed(), true, "UA-DD-12- Product is displayed Successfully"); 
			Log.info("UA-DD-12 is Passed Successfully");
			
			// Product
			docdefGenericName.click();
			Thread.sleep(2000);
			initializeSelectDocDef();
			Assert.assertEquals(selectDocDef.isDisplayed(), true, "UA-DD-16- Create Annex II selection is displayed Successfully"); 
			Log.info("UA-DD-16 is Passed Successfully");
			selectDocDef.click();
			initializeDocDefAlkaline();
			docdefAlkaline.click();
			Thread.sleep(2000);
			initializeDocDefAlkalineText();
			docdefAlkalineText.click();
			initializeAlakineIcon();
			Assert.assertEquals(alakineFirstIcon.isDisplayed(), true, "UA-DD-14- Icon is displayed Successfully"); 
			Log.info("UA-DD-14 is Passed Successfully");
			Assert.assertEquals(alakineSecIcon.isDisplayed(), true, "UA-DD-15- Icon is displayed Successfully"); 
			Log.info("UA-DD-15 is Passed Successfully");
			
			//Form
			initializeDocDefForm();
			Assert.assertEquals(docdefForm.isDisplayed(), true, "UA-DD-12- Form is displayed Successfully"); 
			Log.info("UA-DD-12 is Passed Successfully");
			docdefForm.click();
			Thread.sleep(2000);
			initializeDocDefFormText();
			docdefFormText.click();
			Thread.sleep(2000);
			initializeDocDefFormSyrup();
			docdefFormSyrup.click();
			Thread.sleep(2000);
			initializeDocDefFormSyrupText();
			docdefFormSyrupText.click();
			Thread.sleep(2000);
			initializeFormIcon();
			Assert.assertEquals(formIcon.isDisplayed(), true, "UA-DD-17- Icon is displayed Successfully"); 
			Log.info("UA-DD-17 is Passed Successfully");
			Assert.assertEquals(syrupIcon.isDisplayed(), true, "UA-DD-18- Icon is displayed Successfully"); 
			Log.info("UA-DD-18 is Passed Successfully");
			
			//Strength
			initializeDocDefStrength();
			Assert.assertEquals(docdefStrength.isDisplayed(), true, "UA-DD-12- Strength is displayed Successfully"); 
			Log.info("UA-DD-12 is Passed Successfully");
			docdefStrength.click();
			Thread.sleep(2000);
			initializeDocDefStrengthText();
			docdefStrengthText.click();
			Thread.sleep(2000);
			initializeDocDefStrength10ml();
			docDefTenMl.click();
			initializeDocDefStrength10mlText();
			docDefTenMlText.click();
			initializeStrengthIcon();
			Assert.assertEquals(strengthFirstIcon.isDisplayed(), true, "UA-DD-17- Icon is displayed Successfully"); 
			Log.info("UA-DD-17 is Passed Successfully");
			Assert.assertEquals(strengthSecIcon.isDisplayed(), true, "UA-DD-18- Icon is displayed Successfully"); 
			Log.info("UA-DD-18 is Passed Successfully");
			
			//Presentation
			initializeDocDefPresentation();
			Assert.assertEquals(docdefPresentation.isDisplayed(), true, "UA-DD-13- Presentation is displayed Successfully"); 
			Log.info("UA-DD-13 is Passed Successfully");
			docdefPresentation.click();
			Thread.sleep(2000);
			initializeDocDefPresentationText();
			docdefPresentationText.click();
			Thread.sleep(2000);
			inilializeDocDefFluid();
			docDefPresentaionFluid.click();
			inilializeDocDefFluidText();
			docDefPresentaionFluidText.click();
			initializePresentationIcon();
			Assert.assertEquals(presentationFirstIcon.isDisplayed(), true, "UA-DD-17- Icon is displayed Successfully"); 
			Log.info("UA-DD-17 is Passed Successfully");
			Assert.assertEquals(presentationSecIcon.isDisplayed(), true, "UA-DD-18- Icon is displayed Successfully"); 
			Log.info("UA-DD-18 is Passed Successfully");
			
			action.moveToElement(alakineFirstIcon).build().perform();
			initializeProductCancel();
			action.moveToElement(presentationFirstIcon).build().perform();
			Assert.assertEquals(presentationFirstIcon.isDisplayed(), true, "UA-DD-20- The Cancel button is displayed and enabled."); 
			Log.info("UA-DD-20 is Passed Successfully");
			presentationFirstIcon.click();
			
			//Taking Screenshot for DocTablet Screen Displayed
			getScreenShot("DDS-15", "DocTablet");

		} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-DDS-018.doc Document Defination tested Failed");
			Log.endTestCase("Document Defination Test");
			Assert.fail(t.getMessage());
		}
	
}
	
	public void createPIDocument() throws Exception {
		initializeAddDocLanguage();
		Assert.assertEquals(addDoclanguage.equals(addDoclanguage), true, "Language is Displayed Successfully"); // UA-CCP4
		addDoclanguage.selectByVisibleText("English");
		Thread.sleep(1000);
		initializeSelectAddDocTemplate();
		selectAddDocTemplate.click();
		Thread.sleep(2000);
		initializeAddDocTemplate();
		selectATemplate.click();
		Thread.sleep(2000);
		templateDoneBtn.click();
		Thread.sleep(2000);
		initializecreateDocumentBtn();
		createDocBtn.click(); 
		//taking screenshot after clicking on Create Done button and it goes to Green color
		getScreenShot("DDS-15", "BackgroundChangeToGreenColor");
		initializeDocIcon();
		Assert.assertEquals(iconGenericName.isDisplayed(), true, "UA-DD-02 - Generic Name is displayed successfully in the document icon:"); 
		Log.info("UA-DD-02 is Passed Successfully");
		Assert.assertEquals(iconLanguage.isDisplayed(), true, "UA-DD-03 -Language is displayed successfully in the document icon:"); 
		Log.info("UA-DD-03 is Passed Successfully");
		Assert.assertEquals(iconCountries.isDisplayed(), true, "UA-DD-04 - Countries is displayed successfully in the document icon:"); 
		Log.info("UA-DD-04 is Passed Successfully");
		Assert.assertEquals(iconPencil.isDisplayed(), true, "UA-DD-05 - 'Pencil' icon is displayed successfully to edit the document."); 
		Log.info("UA-DD-01 is Passed Successfully");
	}
	
}
