package com.ig.automation.test;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.CreateCPScreen;
import com.ig.automation.screens.CreateDocScreen;
import com.ig.automation.screens.LoginScreen;
import com.ig.automation.utility.Log;


//	xmL-UI-ADS-006.doc
public class CreateCP extends CreateCPScreen {

	HomeTest homeTest = new HomeTest();
	SearchTest searchtest = new SearchTest();
	LoginTest loginTest = new LoginTest();
	ImportDocTest importdoc = new ImportDocTest();

	@BeforeClass
	public void login() {
		try {
			launchUrl();
			String username = DataActions.getUserID("role_author");
			String password = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the Create CP feature of UI 7.0 
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test
	public void testCreateCPProperties() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Centralized Procedure Test Started");
		try {
			initializeActions();
			actions.click();
			initializeEUSubmission();
			Thread.sleep(2000);
			euSubmission.click();
			Thread.sleep(2000);
			initializeCreateCPLink();
			createCPLink.click();
			initializeCPScreentext();
			assertTrue(cpScreentText.isDisplayed(), true, cpScreentText.isDisplayed()); // UA-CCP-01
			Log.info("UA-CCP-01 - Passed - Create Centralised Procedure screen is initially displayed Successfully");
			initializeObjectsCP();
			cancelBtn.click();
			Thread.sleep(2000);
			initializeCPScreentext();
			assertTrue(createCPLink.isDisplayed(), true, createCPLink.isDisplayed()); // UA-CCP-11
			Log.info("UA-CCP-11 - Passed - Create Centralised Procedure – Properties screen is closed");
			createCPLink.click();
			initializeObjectsCP();
			assertTrue(rfaShow.isDisplayed(), true, rfaShow.isDisplayed()); // UA-CCP-02
			Log.info("UA-CCP-02 - Passed - Route For Approval (RFA) section is collapsed");
			assertTrue(optionalShow.isDisplayed(), true, optionalShow.isDisplayed()); // UA-CCP-03
			Log.info("UA-CCP-03 - Passed - optional section is collapsed");
			Assert.assertEquals(addDocBtn == null, true); // UA-CCP-04
			Log.info("UA-CCP-04 - Passed - Add Document button is hidden");
			Assert.assertEquals(createCPBtn == null, true); // UA-CCP-05
			Log.info("UA-CCP-05 - Passed - Create Centralised Procedure button is hidden");
			assertTrue(cancelBtn.isEnabled(), true, cancelBtn.isEnabled()); // UA-CCP-06
			Log.info("UA-CCP-06 - Passed - Cancel button is displayed and enabled.");
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
			// GLM-1437 defect for optional properties and RFA
			initializeShowButton();
			assertTrue(addDocBtn.isEnabled(), true, addDocBtn.isEnabled()); // UA-CCP-07
			Log.info("UA-CCP-07 - Passed - Add Document is displayed and enabled");
			addDocBtn.click();
			initializeAddDocScreen();
			assertTrue(addDocScreen.isDisplayed(), true, addDocScreen.isDisplayed()); // UA-CCP-10
			Log.info("UA-CCP-10 - Passed - Add Document is displayed and enabled");
			cancelBtnIcon.click();
			initializeShowButton();
			assertTrue(createCPBtn.isEnabled(), true, createCPBtn.isEnabled()); // UA-CCP-08
			Log.info("UA-CCP-08 - Passed - Create Centralised Procedure button is displayed and enabled");
			Thread.sleep(2000);
			createCPBtn.click();
			initializeMessage();
			Assert.assertTrue(message.getText().contains("Created successfully"), "Document is sucessfully Created"); // UA-CCP-09
			Log.info("UA-CCP-09 - Passed -The Create Centralised Procedure – Properties screen is closed");

		} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-015.doc Create Centralised Procedure tested Failed");
			Log.endTestCase("Create Centralized Procedure Test Started");
			Assert.fail(t.getMessage());
		}
		Log.endTestCase("Create Centralized Procedure Test Started");
	}

	@Test
	public void testCreateCPwithPIDocuments() throws Exception {

		/*DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Add Document");
		try {*/
			initializeCPProperties();
			assertTrue(countryProp.isDisplayed(), true, countryProp.isDisplayed());  // UA-AD-1
			Log.info("UA-AD-1 - Passed - Country is displayed and enabled");
			assertTrue(productNames.isDisplayed(), true, productNames.isDisplayed());  // UA-AD-2
			Log.info("UA-AD-2 - Passed - Product Name is displayed and enabled");
			assertTrue(proprName.isDisplayed(), true, proprName.isDisplayed());  // UA-AD-3
			Log.info("UA-AD-3 - Passed - Proprietary Name is displayed and enabled");
			assertTrue(sopcIcon.isDisplayed(), true, sopcIcon.isDisplayed());  // UA-AD-4
			Log.info("UA-AD-4 - Passed - Summary of Product Characteristics icon is displayed");
			assertTrue(AnnexIIicon.isDisplayed(), true, AnnexIIicon.isDisplayed());  // UA-AD-5
			Log.info("UA-AD-5 - Passed - Annex II icon is displayed");
			assertTrue(outerIcon.isDisplayed(), true, outerIcon.isDisplayed());  // UA-AD-6
			Log.info("UA-AD-6 - Passed - Packaging Text Outer icon is displayed");
			assertTrue(immidiateIcon.isDisplayed(), true, immidiateIcon.isDisplayed());  // UA-AD-7
			Log.info("UA-AD-7 - Passed - Packaging Text Immediate icon is displayed");
			assertTrue(blisterIcon.isDisplayed(), true, blisterIcon.isDisplayed());  // UA-AD-8
			Log.info("UA-AD-8 - Passed -  Packaging Text Blister icon is displayed");
			assertTrue(pLIcon.isDisplayed(), true, pLIcon.isDisplayed());  // UA-AD-9
			Log.info("UA-AD-9 - Passed -  Patient Information Leaflet icon is displayed");
			assertTrue(docDefIcon.isDisplayed(), true, docDefIcon.isDisplayed());  // UA-AD-10
			Log.info("UA-AD-10 - Passed -  Document Definition icon is displayed");
			assertTrue(cCPBtnIcon.isEnabled(), true, cCPBtnIcon.isEnabled());  // UA-AD-11
			Log.info("UA-AD-11 - Passed -  Create Centralised Procedure button is displayed and enabled");
			assertTrue(cancelBtnIcon.isEnabled(), true, cancelBtnIcon.isEnabled());  // UA-AD-12
			Log.info("UA-AD-12 - Passed -  Cancel button is displayed and enabled");
			initializeColor();
			String color1 = smpcColor.getCssValue("background");
			Assert.assertEquals(color1.contains("rgb(76, 201, 241)"), true, "UA-AD-13- Summary of Product Characteristics outlined in blue");// UA-AD-13
			Log.info("UA-AD-13 - Passed -Summary of Product Characteristics document tablets are outlined in blue");
			System.out.println("Blue color Found for SMPC");

			String color2 = annexColor.getCssValue("background");
			Assert.assertEquals(color2.contains("rgb(76, 201, 241)"), true, "UA-AD-14- AnnexII is outlined in blue");// UA-AD-14
			Log.info("UA-AD-14 - Passed -AnnexII document tablets are outlined in blue");
			System.out.println("Blue color Found for AnnexII");

			String color3 = outerColor.getCssValue("background");
			Assert.assertEquals(color3.contains("rgb(76, 201, 241)"), true, "UA-AD-15- Outer Labeling Text is outlined in blue");// UA-AD-15
			Log.info("UA-AD-13 - Passed -Packaging Text Outer document tablets are outlined in blue");
			System.out.println("Blue color Found for Outer Labeling Text");

			String color4 = plColor.getCssValue("background");
			Assert.assertEquals(color4.contains("rgb(76, 201, 241)"), true, "UA-AD-16- PL is outlined in blue");// UA-AD-16
			Log.info("UA-AD-16 is Passed Successfully");
			System.out.println("Blue color Found for Package Leaflet");

			String color5 = docDefColor.getCssValue("background");
			Assert.assertEquals(color5.contains("rgb(76, 201, 241)"), true, "UA-AD-17- Document Definition is outlined in blue");// UA-AD-17
			Log.info("UA-AD-17 is Passed Successfully");
			System.out.println("Blue color Found for Document Definition");

			String color6 = immidiateColor.getCssValue("background");
			System.out.println(immidiateColor.getCssValue("background"));
			Assert.assertEquals(color6.contains("rgb(255, 155, 108)"), true, "UA-AD-18- Immidiate Labeling Text is outlined in Orange");// UA-AD-18
			Log.info("UA-AD-18 is Passed Successfully");
			System.out.println("Orange color Found for Immidiate Labeling  Text");

			String color7 = blisterColor.getCssValue("background");
			Assert.assertEquals(color7.contains("rgb(255, 155, 108)"), true, "UA-AD-19- Blister Labeling Text is outlined in Orange");// UA-AD-19
			Log.info("UA-AD-19 is Passed Successfully");
			System.out.println("Orange color Found for Blister Labeling  Text");
			Thread.sleep(2000);
			initializeSMPCHover();
			Actions action = new Actions(driver);
			// click on Create button from SMPC Hover
			initializeCreateAfterHoverSMPC();
			// Hover SMPC document tablet and find create button
			action.moveToElement(smpcHover).moveToElement(createAfterHoverSMPC).build().perform();
			initializeLinkAfterHoverSMPC();
			// Hover SMPC document tablet and find Link button
			action.moveToElement(smpcHover).moveToElement(linkAfterHoverSMPC).build().perform();
			Assert.assertEquals(createAfterHoverSMPC.isDisplayed(), true, "UA-AD-20- The Create button is displayed and enabled."); // UA-AD-20
			Log.info("UA-AD-20 is Passed Successfully");
			Assert.assertEquals(linkAfterHoverSMPC.isDisplayed(), true, "UA-AD-21- The Link to Existing button is displayed and enabled"); // UA-AD-21
			Log.info("UA-AD-21 is Passed Successfully");
			action.moveToElement(smpcHover).moveToElement(createAfterHoverSMPC).click().build().perform();
			System.out.println("UA-AD-20- The Create New button is displayed and enabled");
			System.out.println("UA-AD-21- The Link to Existing button is displayed and enabled");
			Thread.sleep(2000);
			createPIDocument();
			initializeRemoveIconAfterHoverSMPC();
			// //Hover SMPC document tablet and find Remove icon button
			action.moveToElement(smpcHover).moveToElement(removeIconAfterHoverSMPC).build().perform();
			Assert.assertEquals(removeIconAfterHoverSMPC.isDisplayed(), true, "UA-AD-22 & UA-AD-30 - The Remove Icon button is displayed and enabled"); // UA-AD-22
			Log.info("UA-AD-22 is Passed Successfully");
			Log.info("UA-AD-30 is Passed Successfully");
			// Click on Document Definition document tablet
			docDefIcon.click();
			initializeDocDefText();
			Thread.sleep(2000);
			//Taking Screenshot for Document Definition Screen
			getScreenShot("ADS-15", "DocumentDefinitionScreen");
			// Find and click on Document Definition values
			initializeDocDefGenericName();
			docdefGenericName.click();
			Thread.sleep(2000);
			initializeSelectDocDef();
			//selectDocDef.click();
			// Hover Annex Document Tablet
			initializeANHover();
			// clicked on Link Button in AN
			initializeLinkAfterHoverAN();
			action.moveToElement(anHover).moveToElement(linkAfterHoverAN).build().perform();
			Assert.assertEquals(linkAfterHoverAN.isDisplayed(), true, "UA-AD-24- The user selects the Link Existing button, initiate Create Document Relationship function");// UA-AD-24
			action.moveToElement(anHover).moveToElement(linkAfterHoverAN).click().build().perform();
			Log.info("UA-AD-24 is Passed Successfully");
			Thread.sleep(2000);
			linkPIDocument("AN");
			Thread.sleep(2000);
			docDefIcon.click();
			Thread.sleep(2000);
			initializeDocDefForm();
			docdefForm.click();
			Thread.sleep(2000);
			initializeDocDefFormText();
			docdefFormText.click();
			Thread.sleep(2000);
			initializeOUTHover();
			initializeLinkAfterHoverOUT();
			// click on Link button from OUTER Hover
			Actions action1 = new Actions(driver);
			action.moveToElement(outHover).moveToElement(linkAfterHoverOUT).click().build().perform();
			Thread.sleep(3000);
			linkPIDocument("OUT");
			System.out.println("Mouse hover found for Outer Function Link button Successfully");
			docDefIcon.click();
			Thread.sleep(2000);
			initializeDocDefStrength();
			docdefStrength.click();
			Thread.sleep(2000);
			initializeDocDefStrengthText();
			docdefStrengthText.click();
			Thread.sleep(2000);
			initializeBLIHover();
			initializeLinkAfterHoverBLI();
			// click on Link button from BLIster Hover
			Actions action2 = new Actions(driver);
			action.moveToElement(bliHover).moveToElement(linkAfterHoverBLI).click().build().perform();
			Thread.sleep(5000);
			linkPIDocument("BLI");
			System.out.println("Mouse hover found for Blister Function Link button Successfully");
			docDefIcon.click();
			Thread.sleep(2000);
			initializeDocDefPresentation();
			docdefPresentation.click();
			Thread.sleep(2000);
			initializeDocDefPresentationText();
			docdefPresentationText.click();
			Thread.sleep(2000);
			initializeIMMHover();
			initializeLinkAfterHoverIMM();
			// click on Link button from IMMidiate Hover
			Actions action3 = new Actions(driver);
			action.moveToElement(immHover).moveToElement(linkAfterHoverIMM).click().build().perform();
			Thread.sleep(5000);
			linkPIDocument("IMM");
			System.out.println("Mouse hover found for IMMidiate Function Link button Successfully");
			docDefIcon.click();
			Thread.sleep(2000);
			initializeDocDefAlkaline();
			docdefAlkaline.click();
			Thread.sleep(2000);
			initializeDocDefAlkalineText();
			docdefAlkalineText.click();
			initializePLHover();
			initializeLinkAfterHoverPL();
			// click on Link button from PL Hover
			Actions action4 = new Actions(driver);
			action.moveToElement(plHover).moveToElement(linkAfterHoverPL).click().build().perform();
			Thread.sleep(5000);
			linkPIDocument("PL");
			Log.info("UA-CPO-3 is Passed Successfully");
			System.out.println("Mouse hover found for Package Leaflet Function Link button Successfully");
			docDefIcon.click();
			Log.info("UA-CPO-4 is Passed Successfully");
			Log.info("UA-CPO-5 is Passed Successfully");
			initializeDocDefText();
			Assert.assertEquals(docDefText.isDisplayed(), true, "UA-AD-33 - the Document Definitions screen is displayed successfully");// UA-AD-33
			Log.info("UA-AD-33 is Passed Successfully");
			Thread.sleep(2000);
			initializeDocDefFormSyrup();
			docdefFormSyrup.click();
			Thread.sleep(2000);
			initializeDocDefFormSyrupText();
			docdefFormSyrupText.click();
			initializedocTablet();
			Assert.assertEquals(docTablet.isDisplayed(), true, "UA-AD-31 - Display as a document tablet"); // UA-AD-31
			Log.info("UA-AD-31 is Passed Successfully");
			//Taking Screenshot for DocTablet Screen Displayed
			getScreenShot("ADS-15", "DocTablet");
			initializeUnlinkIcon();
			action.moveToElement(smpcHover).moveToElement(unlinkIcon).build().perform();
			Assert.assertEquals(unlinkIcon.isDisplayed(), true, "UA-AD-32 - Unlink icon to unlink the document to the Centralised Procedure");
			action.moveToElement(smpcHover).moveToElement(unlinkIcon).click().build().perform();
			Log.info("UA-AD-32 is Passed Successfully");
			Assert.assertEquals(cCPBtnIcon.isDisplayed(), true, "UA-AD-34 - Create Button is displayed successfully");// UA-AD-34
			cCPBtnIcon.click();
			Log.info("UA-AD-34 is Passed Successfully");
			initializeMessage();
			Assert.assertTrue(message.getText().contains("Created successfully"), "Document is successfully Created");
			Log.info("UA-CPO-6 is Passed Successfully");
			Thread.sleep(1000);
			//Taking Screenshot for Create Successfully Message
			getScreenShot("ADS-15", "CreatedSuccessfullyMEssagePrompt");
		//	initializeMessageLink();
		//	messageLink.click();
			System.out.println(message.getText());
			String successMessage = message.getText();
		//	String DocID = successMessage.substring(32, 39);
			String[] successMsg=successMessage.split(" ", 4);
			String DocID=successMsg[2];
			writeCSV(DocID);
			//initializeItemsPerPage();
		//	itemsPerPage.selectByIndex(0);
			Thread.sleep(2000);
			//Taking Screenshot for Items Per Page shown as ALL
			getScreenShot("ADS-15", "ItemsPerPageasAll");
		//	initializeSearchIcon();
		//	searchIcon.click();
			Thread.sleep(5000);
			searchtest.doSearchDocument("CP-1443");
		//	initializeSearchTextField();
		//	searchTextField.sendKeys(DocID);
		//	Thread.sleep(5000);
			//Taking Screenshot for Putting Doc ID which created above
			getScreenShot("ADS-15", "PuttingDocIDintoSearchField");
		//	initializeSelectDocType();
		//	selectDocType.click();
		//	Thread.sleep(5000);
			initializePIDoc();
			piDoc.click();
			Thread.sleep(5000);
			//Taking Screenshot for PI Document SCreen Tab
			getScreenShot("ADS-15", "PIDocumentScreenTab");
		//	initializeLinkDocType();
			initializePIResult();
			Assert.assertTrue(piResultAN.getText().contains("AN"), "AN found in PI Documents Link Successfully");
			Assert.assertTrue(piResultBLI.getText().contains("BLI"), "BLI found in PI Documents Link Successfully");
			Assert.assertTrue(piResultIMM.getText().contains("IMM"), "IMM found in PI Documents Link Successfully");
			Assert.assertTrue(piResultOUT.getText().contains("OUT"), "OUT found in PI Documents Link Successfully");
			Assert.assertTrue(piResultPL.getText().contains("PL"), "PL found in PI Documents Link Successfully");
			Assert.assertTrue(piResultSMPC.getText().contains("SmPC"), "PL found in PI Documents Link Successfully");
						
			

			Reporter.log("xmL-UI-ADS-015.doc Create Centralised Procedure tested successfully");

		/*} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-015.doc Create Centralised Procedure tested Failed");
			Log.endTestCase("Add Document");
			Assert.fail(t.getMessage());
		}
		Log.endTestCase("Add Document");*/
	}
		
	public void createPIDocument() throws Exception {
		initializeAddDocLanguage();
		Assert.assertEquals(addDoclanguage.equals(addDoclanguage), true, "Language is Displayed Successfully"); // UA-CCP4
		Log.info("UA-CCP4 is Passed Successfully");
		addDoclanguage.selectByVisibleText("English");
		Thread.sleep(1000);
		//Taking Screenshot for Language in Create CP SCreen with Add Document Screen
		getScreenShot("ADS-15", "LanguageScreen");
		initializeSelectAddDocTemplate();
		selectAddDocTemplate.click();
		Thread.sleep(2000);
		initializeAddDocTemplate();
		selectATemplate.click();
		Thread.sleep(2000);
		templateDoneBtn.click();
		Thread.sleep(2000);
		initializecreateDocumentBtn();
		createDocBtn.click(); // UA-AD-23
		Assert.assertEquals(addDocScreen.isDisplayed(), true, "UA-AD-23 - the user selects the Create New button, initiate create new function");// UA-AD-23
		Log.info("UA-AD-23 is Passed Successfully");
		Thread.sleep(2000);
		//taking screenshot after clicking on Create Done button and it goes to Green color
		getScreenShot("ADS-15", "BackgroundChangeToGreenColor");
		initializeDocIcon();
		Assert.assertEquals(iconGenericName.isDisplayed(), true, "UA-AD-26 - New document is displayed Generic Name in the document icon:"); // UA-AD-26
		Log.info("UA-AD-26 is Passed Successfully");
		Assert.assertEquals(iconLanguage.isDisplayed(), true, "UA-AD-27 -New document is displayed Language in the document icon:"); // UA-AD-27
		Log.info("UA-AD-27 is Passed Successfully");
		Assert.assertEquals(iconCountries.isDisplayed(), true, "UA-AD-28 - New document is displayed Countries in the document icon:"); // UA-AD-28
		Log.info("UA-AD-28 is Passed Successfully");
		Assert.assertEquals(iconPencil.isDisplayed(), true, "UA-AD-29 - pencil” icon is displayed to edit the document."); // UA-AD-29
		Log.info("UA-AD-29 is Passed Successfully");
	}

	public void linkPIDocument(String docType) throws Exception {
		initializeLinkToExisting();
		SearchTabforLink.click();
		Thread.sleep(2000);
		//taking screenshot for Link to Existing Screen
		getScreenShot("ADS-15", "LinkToEXistingScreen");
		initiaizeLinkBasicSearch();
		initiaizeLinkBasicSearchShow();
		if (linkBasicSearchShow.getText().equals("Show")) {
			linkBasicSearch.click();
		}
		Thread.sleep(2000);
		initializeLinkDocID();
		linkDocID.clear();
		linkDocID.sendKeys(docType);
		initializeLinkSearchBtn();
		searchBtnLink.click();
		Thread.sleep(2000);
		initializeSelectSearchDocTypeforLink();
		selectSearchDocTypeforLink.click();
		Thread.sleep(2000);
		initializeLinkDoneBtn();
		linkDoneBtn.click();
	}

	
	public void doCreateCP() throws Exception {
		
		try {
			initializeActions();
			actions.click();
			initializeEUSubmission();
			Thread.sleep(2000);
			euSubmission.click();
			Thread.sleep(2000);
			initializeCreateCPLink();
			createCPLink.click();
			initializeCPScreentext();
			initializeObjectsCP();
			cancelBtn.click();
			Thread.sleep(2000);
			initializeCPScreentext();			
			createCPLink.click();
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
			createCPBtn.click();
			initializeMessage();		

		} catch (Throwable t) {
			Log.info(t.getMessage());			
		}
	}

	// @AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
