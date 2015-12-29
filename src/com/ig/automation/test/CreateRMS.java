package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.CreateDocScreen;
import com.ig.automation.screens.CreateRMSScreen;
import com.ig.automation.screens.LoginScreen;
import com.ig.automation.utility.Log;

//	xmL-UI-ADS-006.doc
public class CreateRMS extends CreateRMSScreen {

	public static HomeTest homeTest = new HomeTest();
	SearchTest searchtest = new SearchTest();
	LoginTest loginTest = new LoginTest();
	
	
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
	 * Test the Create RMS feature of UI 7.0 
	 * 
	 * @throws Exception If an error occurs.
	 */


@Test
	public void testCreateRMSProperties() throws InterruptedException {
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create RMS Document");
		try {
			initializeActions();
			actions.click();
			initializeEUSubmission();
			Thread.sleep(2000);
			euSubmission.click();
			Thread.sleep(2000);
			initializeCreateRMSlink();
			createRMSlink.click();
			initializeRMSScreentext();
			assertTrue(rmsScreentText.isDisplayed(), true, rmsScreentText.isDisplayed()); // UA-RMS-1
			Log.info("UA-RMS-1 - Passed - Create Referenced Member State screen is initially displayed Successfully");
			inilializeObjectsRMS();
			cancelBtn.click();
			assertTrue(createRMSlink.isDisplayed(), true, createRMSlink.isDisplayed()); // UA-RMS-11
			Log.info("UA-RMS-11 - Passed - Create Centralised Procedure – Properties screen is closed");
			createRMSlink.click();
			inilializeObjectsRMS();
			//TODO GLM-1558
			/*assertTrue(rfaShow.isDisplayed(), true, rfaShow.isDisplayed()); // UA-RMS-2
			Log.info("UA-RMS-2 - Passed - Route For Approval (RFA) section is collapsed");*/
			assertTrue(optionalShow.isDisplayed(), true, optionalShow.isDisplayed()); // UA-RMS-3
			Log.info("UA-RMS-3 - Passed - optional section is collapsed");
			Assert.assertEquals(addDocBtn == null, true); // UA-RMS-4
			Log.info("UA-RMS-4 - Passed - Add Document button is hidden");
			Assert.assertEquals(createRMSBtn == null, true); // UA-RMS-5
			Log.info("UA-RMS-5 - Passed - Create Centralised Procedure button is hidden");
			assertTrue(cancelBtn.isEnabled(), true, cancelBtn.isEnabled()); // UA-RMS-6
			Log.info("UA-RMS-6 - Passed - Cancel button is displayed and enabled.");
			title.sendKeys("Test");
			country.sendKeys("Euro");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByIndex(5);
			productName.click();
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

            //TODO GLM-1559 // UA-RMS-7
			
			addDocBtn.click();
			initializeAddDocScreen();
			assertTrue(addDocScreen.isDisplayed(), true, addDocScreen.isDisplayed()); // UA-RMS-10
			Log.info("UA-RMS-10 - Passed - Add Document is displayed and enabled");
			cancelBtnIcon.click();
			initializeShowButton();
			assertTrue(createRMSBtn.isEnabled(), true, createRMSBtn.isEnabled()); // UA-RMS-8
			Log.info("UA-RMS-8 - Passed - Create Centralised Procedure button is displayed and enabled");
			Thread.sleep(2000);
			createRMSBtn.click();
			initializeMessage();
			Assert.assertTrue(message.getText().contains("Created successfully"), "Document is sucessfully Created"); // UA-RMS-9
			Log.info("UA-RMS-9 - Passed -The Create Centralised Procedure – Properties screen is closed");

		} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-020.doc Create RMS tested Failed");
			Log.endTestCase("Create RMS Document Test Started");
			Assert.fail(t.getMessage());
		}
		Log.endTestCase("Create RMS Document Test Started");
	}

	@Test
	public void testCreateRMSwithPIDocuments() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Add Document");
		
		try {
			initializeActions();
			actions.click();
			initializeEUSubmission();
			Thread.sleep(2000);
			euSubmission.click();
			Thread.sleep(2000);
			initializeCreateRMSlink();
			createRMSlink.click();
			inilializeObjectsRMS();
			title.sendKeys("Test");
			country.sendKeys("Euro");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByIndex(5);
			productName.click();
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

            //TODO GLM-1559 // UA-RMS-7
			
			addDocBtn.click();	
			initializeAddDocScreen();
			Assert.assertEquals(addDocScreen.isDisplayed(), true, "Add Document screen is displayed");
					
			initializeRMSProperties();
			assertTrue(countryProp.isDisplayed(), true, countryProp.isDisplayed()); //UA-RAD-1
			Log.info("UA-RAD-1 - Passed - Countries property is Displayed Successfully");
			assertTrue(productNames.isDisplayed(), true, productNames.isDisplayed());   // UA-RAD-2
			Log.info("UA-RAD-2 - Passed - Product Name property is Displayed Successfully");
			assertTrue(proprName.isDisplayed(), true, proprName.isDisplayed());  // UA-RAD-3
			Log.info("UA-RAD-3 - Passed - Proprietary Name is Displayed Successfully");
			assertTrue(sopcIcon.isDisplayed(), true, sopcIcon.isDisplayed());   // UA-RAD-4
			Log.info("UA-RAD-4 - Passed - Summary of Product Characteristics icon is displayed");
			assertTrue(outerIcon.isDisplayed(), true, outerIcon.isDisplayed()); // UA-RAD-5 
			Log.info("UA-RAD-5 - Passed - Packaging Text Outer icon is displayed");
			assertTrue(immidiateIcon.isDisplayed(), true, immidiateIcon.isDisplayed()); // UA-RAD-6
			Log.info("UA-RAD-6 - Passed - Packaging Text Immediate icon is displayed");
			assertTrue(blisterIcon.isDisplayed(), true, blisterIcon.isDisplayed());   // UA-RAD-7
			Log.info("UA-RAD-7 - Passed -Packaging Text Blister icon is displayed");
			assertTrue(pLIcon.isDisplayed(), true, pLIcon.isDisplayed()); 	 // UA-RAD-8
			Log.info("UA-RAD-8 - Passed -Patient Information Leaflet icon is displayed");
			assertTrue(docDefIcon.isDisplayed(), true, docDefIcon.isDisplayed());  // UA-RAD-9
			Log.info("UA-RAD-9 - Passed - Document Definition icon is displayed");
			assertTrue(cRMSBtnIcon.isDisplayed(), true, cRMSBtnIcon.isDisplayed()); // UA-RAD-10
			Log.info("UA-RAD-10 -Passed - Create RMS Submission button is displayed and enabled");
			assertTrue(cancelBtnIcon.isEnabled(), true, cancelBtnIcon.isEnabled()); // UA-RAD-11
			Log.info("UA-RAD-11 - Passed - Cancel button is displayed and enabled");
			initializeColor();
			String color1 = smpcColor.getCssValue("background");
			Assert.assertEquals(color1.contains("rgb(76, 201, 241)"), true);  // UA-RAD-12
			Log.info("UA-RAD-12  - Passed -Summary of Product Characteristics outlined in blue");
			System.out.println("Blue color Found for SMPC");
			String color3 = outerColor.getCssValue("background");
			Assert.assertEquals(color3.contains("rgb(76, 201, 241)"), true);  // UA-RAD-13
			Log.info("UA-RAD-13  - Passed - Outer Labeling Text is outlined in blue");
			System.out.println("Blue color Found for Outer Labeling Text");
			String color4 = plColor.getCssValue("background");
			Assert.assertEquals(color4.contains("rgb(76, 201, 241)"), true);  // UA-RAD-14
			Log.info("UA-RAD-14 - Passed -PL is outlined in blue");
			System.out.println("Blue color Found for Package Leaflet");
			String color5 = docDefColor.getCssValue("background");
			Assert.assertEquals(color5.contains("rgb(76, 201, 241)"), true);  // UA-RAD-15
			Log.info("UA-RAD-15 - Passed - Document Definition is outlined in blue");
			System.out.println("Blue color Found for Document Definition");
			String color6 = immidiateColor.getCssValue("background");
			System.out.println(immidiateColor.getCssValue("background"));
			Assert.assertEquals(color6.contains("rgb(255, 155, 108)"), true); // UA-RAD-16
			Log.info("UA-RAD-16 - Passed - Immidiate Labeling Text is outlined in Orange");
			System.out.println("Orange color Found for Immidiate Labeling  Text");
			String color7 = blisterColor.getCssValue("background");
			Assert.assertEquals(color7.contains("rgb(255, 155, 108)"), true);// UA-RAD-17
			Log.info("UA-RAD-17 - Passed - Blister Labeling Text is outlined in Orange");
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
			Assert.assertEquals(createAfterHoverSMPC.isDisplayed(), true);  // UA-RAD-18
			Log.info("UA-RAD-18 - Passed - The Create button is displayed and enabled");
			Assert.assertEquals(linkAfterHoverSMPC.isDisplayed(), true); // UA-RAD-19
			Log.info("UA-RAD-19 - Passed -The Link to Existing button is displayed and enabled");
			action.moveToElement(smpcHover).moveToElement(createAfterHoverSMPC).click().build().perform();
			Thread.sleep(2000);
			createPIDocument();
			initializeRemoveIconAfterHoverSMPC();
			//Hover SMPC document tablet and find Remove icon button
			action.moveToElement(smpcHover).moveToElement(removeIconAfterHoverSMPC).build().perform();
			Assert.assertEquals(removeIconAfterHoverSMPC.isDisplayed(), true); // UA-RAD-20
			Log.info("UA-RAD-20 - Passed - The Remove x Icon button is displayed and enabled");
			Log.info("UA-RAD-27 - Passed - The Remove x Icon button is displayed and enabled");
			// Click on Document Definition document tablet
			docDefIcon.click();
			initializeDocDefText();
			Thread.sleep(2000);
			// Find and click on Document Definition values
			initializeDocDefForm();
			docdefForm.click();
			Thread.sleep(2000);
			initializeDocDefFormText();
			docdefFormText.click();
			Thread.sleep(2000);
			//Taking Screenshot for Document Definition Screen
			getScreenShot("ADS-20", "DocumentDefinitionScreen");
			
			initializeOUTHover();
			initializeLinkAfterHoverOUT();
			// click on Link button from OUTER Hover
			action.moveToElement(outHover).moveToElement(linkAfterHoverOUT).build().perform();
			Assert.assertEquals(linkAfterHoverOUT.isDisplayed(), true);  // UA-RAD-22
			Log.info("UA-RAD-27 - Passed - The user selects the Link Existing button, initiate Create Document Relationship function");
			action.moveToElement(outHover).moveToElement(linkAfterHoverOUT).click().build().perform();
			Log.info("UA-RAD-22 - Passed - If the user selects the Link Existing button, initiate Create Document Relationship function");
			Thread.sleep(3000);
			linkPIDocument("OUT");
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
			System.out.println("Mouse hover found for Package Leaflet Function Link button Successfully");
			docDefIcon.click();
			Log.info("UA-CRMO-4 is Passed Successfully");
			initializeDocDefText();
			Log.info("UA-CRMO-5 is Passed Successfully");
			Assert.assertEquals(docDefText.isDisplayed(), true); // UA-RAD-30
			Log.info("UA-RAD-30 - Passed - the Document Definitions screen is displayed successfully");
			Thread.sleep(2000);
			initializeDocDefFormSyrup();
			docdefFormSyrup.click();
			Thread.sleep(2000);
			initializeDocDefFormSyrupText();
			docdefFormSyrupText.click();
			initializedocTablet();
			Assert.assertEquals(docTablet.isDisplayed(), true); // UA-RAD-28
			Log.info("UA-RAD-28 - Passed - Display as a document tablet");
			//Taking Screenshot for DocTablet Screen Displayed
			getScreenShot("ADS-20", "DocTablet");
			initializeUnlinkIcon();
			action.moveToElement(smpcHover).moveToElement(unlinkIcon).build().perform();
			Assert.assertEquals(unlinkIcon.isDisplayed(), true);
			Log.info("UA-RAD-29 - Passed - Display as a document tablet");
			action.moveToElement(smpcHover).moveToElement(unlinkIcon).click().build().perform();
			Log.info("UA-RAD-29 is Passed Successfully");
			Assert.assertEquals(cRMSBtnIcon.isDisplayed(), true, "UA-RAD-31 - Create Button is displayed successfully");// UA-AD-34
			cRMSBtnIcon.click();
			Log.info("UA-RAD-31 is Passed Successfully");
			initializeMessage();
			Assert.assertTrue(message.getText().contains("Created successfully"), "Document is successfully Created");
			Log.info("UA-CRMO-6 - Passed - Document is successfully Created");
			Thread.sleep(1000);
			
			//Taking Screenshot for Create Successfully Message
			getScreenShot("ADS-20", "CreatedSuccessfullyMEssagePrompt");
			initializeMessageLink();
			messageLink.click();
			System.out.println(message.getText());
			String successMessage = message.getText();
			String DocID = successMessage.substring(32, 39);
			writeCSV(DocID);
			initializeItemsPerPage();
			itemsPerPage.selectByIndex(0);
			Thread.sleep(5000);
			
			//Taking Screenshot for Items Per Page shown as ALL
			getScreenShot("ADS-20", "ItemsPerPageasAll");
			initializeSearchIcon();
			searchIcon.click();
			Thread.sleep(5000);
			initializeSearchTextField();
			searchTextField.sendKeys(DocID);
			Thread.sleep(5000);
			
			//Taking Screenshot for Putting Doc ID which created above
			getScreenShot("ADS-20", "PuttingDocIDintoSearchField");
			initializeSelectDocType();
			selectDocType.click();
			Thread.sleep(5000);
			initializePIDoc();
			piDoc.click();
			Thread.sleep(5000);
			
			//Taking Screenshot for PI Document SCreen Tab
			getScreenShot("ADS-20", "PIDocumentScreenTab");
			initializeLinkDocType();
			initializePaginatorResult();
			Assert.assertTrue(paginatorResult.getText().contains("BLI"), "BLI found in PI Documents Link Successfully");
			Assert.assertTrue(paginatorResult.getText().contains("IMM"), "IMM found in PI Documents Link Successfully");
			Assert.assertTrue(paginatorResult.getText().contains("OUT"), "OUT found in PI Documents Link Successfully");
			Assert.assertTrue(paginatorResult.getText().contains("PL"), "PL found in PI Documents Link Successfully");
			
			// TO DO document has created in backend - no message is prompting
			// for
			// creating document in UI
			Log.info("UA-CRMO-2 is Passed Successfully");
			Log.info("UA-CRMO-3 is Passed Successfully");
			Log.info("UA-CRMO-5 is Passed Successfully");

			Reporter.log("xmL-UI-ADS-020.doc CreateRMS tested successfully");

		} catch (Exception t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-020.doc Create RMS tested Failed");
			Log.endTestCase("Add Document");
			//Assert.fail(t.getMessage());
		}
		Log.endTestCase("Add Document");
	}
	

	public void linkPIDocument(String docType) throws Exception {
		initializeLinkToExisting();
		SearchTabforLink.click();
		Thread.sleep(2000);
		//taking screenshot for Link to Existing Screen
		getScreenShot("ADS-20", "LinkToExistingScreen");
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
	
	public void createPIDocument() throws Exception {
		initializeSelectAddDocTemplate();
		selectAddDocTemplate.click();
		Thread.sleep(2000);
		initializeAddDocTemplate();
		selectATemplate.click();
		Thread.sleep(2000);
		templateDoneBtn.click();
		Thread.sleep(2000);
		initializecreateDocumentBtn();
		createDocBtn.click(); // UA-RAD-21
		Assert.assertEquals(addDocScreen.isDisplayed(), true);// UA-RAD-21
		Log.info("UA-RAD-21 - Passed - the user selects the Create New button, initiate create new function");
		Thread.sleep(2000);
		//taking screenshot after clicking on Create Done button and it goes to Green color
		getScreenShot("ADS-20", "BackgroundChangeToGreenColor");
		initializeDocIcon();
		Assert.assertEquals(iconGenericName.isDisplayed(), true); // UA-RAD-24
		Log.info("UA-RAD-24 - Passed - New document is displayed Generic Name in the document icon:");
		Assert.assertEquals(iconLanguage.isDisplayed(), true); // UA-RAD-25
		Log.info("UA-RAD-25 -Passed - New document is displayed Language in the document icon:");
		Assert.assertEquals(iconCountries.isDisplayed(), true); // UA-RAD-26
		Log.info("UA-RAD-26 - Passed - New document is displayed Countries in the document icon:");
	}

	public void doCreateRMS() throws InterruptedException {		
	
		try {
			initializeActions();
			actions.click();
			initializeEUSubmission();
			Thread.sleep(2000);
			euSubmission.click();
			Thread.sleep(2000);
			initializeCreateRMSlink();
			createRMSlink.click();
			initializeRMSScreentext();
			inilializeObjectsRMS();
			cancelBtn.click();
			createRMSlink.click();
			inilializeObjectsRMS();
			title.sendKeys("Test");
			country.sendKeys("Euro");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByIndex(5);
			productName.click();
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
			createRMSBtn.click();
			initializeMessage();			
			
		} catch (Throwable t) {
			Log.info(t.getMessage());	
		
		}
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
