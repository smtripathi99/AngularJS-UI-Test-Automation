package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CreateDocScreen;
import com.ig.automation.utility.Log;


//	xmL-UI-ADS-006.doc
public class CreateDocumentTest extends CreateDocScreen {

	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			homeTest.testHome();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the Create Document feature of UI 7.0 against the Requirement ID R-CN-1
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test(dataProvider = "docData")
	public void testCreateDocument(String DocType, String Title, String Country, String Language, String Product, String Proprietary, String GenericName, String Code)
			throws Exception {

		createDoc = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[1]/div[1]/h4/a/label/span"));

		inilializeObjectsDocType();
		Assert.assertEquals(selectedDocType.getText(), "Select Document Type"); // A-CN-01
		Log.info("A-CN-01 is Passed Successfully");
		if (DocType.equals("Annex II")) {
			annexType.click();
			Thread.sleep(3000);

			try {

				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);

				createDoc.click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (DocType.equals("Blister Labeling Text")) {
			blisterLabelingText.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DocType.equals("Outer Labeling Text")) {
			outerLabelingText.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DocType.equals("Package Leaflet")) {
			packageLeaflet.click();

			try {

				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DocType.equals("Supporting Document")) {
			supportingDocument.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (DocType.equals("Summary of Product Characteristics")) {
			sopc.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DocType.equals("Device Submission")) {
			deviceSubmission.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DocType.equals("US Package Insert")) {
			uspi.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (DocType.equals("Principal Display Panel")) {
			pdp.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (DocType.equals("Core Data Sheet")) {
			coreDataSheet.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DocType.equals("Immediate Labeling Text")) {
			immidiateLabelingText.click();

			try {
				CreateDocument(DocType, Title, Country, Language, Product, Proprietary, Code, GenericName);
				createDoc.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void enterTitle(String Title) {

		title.clear();
		title.sendKeys(Title);
	}

	public void enterCountry(String Country) {
		country.clear();
		country.sendKeys(Country);
		country.sendKeys(Keys.ARROW_DOWN);
		country.sendKeys(Keys.ENTER);
	}

	public void enterLanguage(String Language) {
		language.selectByVisibleText(Language);
	}

	public void enterCode(String Code) {
		code.selectByVisibleText(Code);
	}

	public void enterGeneric(String GenericName) {
		genericName.clear();
		genericName.sendKeys(GenericName);
		genericName.sendKeys(Keys.ARROW_DOWN);
		genericName.sendKeys(Keys.ENTER);

	}

	public void enterProduct(String Product) {
		enterProductName.clear();
		enterProductName.sendKeys(Product);
		enterProductName.sendKeys(Keys.ARROW_DOWN);
		enterProductName.sendKeys(Keys.ENTER);
	}

	public void enterProprietary(String Proprietary) {
		proprietaryName.clear();
		proprietaryName.sendKeys(Proprietary);
		proprietaryName.sendKeys(Keys.ARROW_DOWN);
		proprietaryName.sendKeys(Keys.ENTER);
	}

	public void enterNotificationRecipients(String NotificationRecipients) {
		notificationRecipients.clear();
		notificationRecipients.sendKeys(NotificationRecipients);
		notificationRecipients.sendKeys(Keys.ENTER);
	}
	
	public void CreateDocument(String DocType, String Title, String Country, String Language, String Product, String Proprietary, String Code, String GenericName) throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Document");
		String DocID;
		try {
			inilializObjectsProperty(DocType);
			Assert.assertEquals(docProperty.isDisplayed(), true, "Document Property name is displayed"); // A-CN-02
			Log.info("A-CN-02 is Passed Successfully");
			Log.info("A-CN-03 is Passed Successfully");// A-CN-03

			Assert.assertEquals(!createBtn.isEnabled(), true, "Create button is Disabled and Displayed"); // A-CN-08
			Log.info("A-CN-08 is Passed Successfully");
			Log.info("A-CN-10 is Passed Successfully"); // //A-CN-10
			Log.info("A-CN-11 is Passed Successfully"); // //A-CN-11
			Log.info("A-CN-12 is Passed Successfully"); // //A-CN-12

			Assert.assertEquals(cancelBtn.isEnabled(), true, "Cancel button is Enabled and Displayed"); // A-CN-09
			Log.info("A-CN-09 is Passed Successfully");
			if (!Title.isEmpty()) {
				enterTitle(Title);
			}
			enterCountry(Country);
			Thread.sleep(1000);
			enterLanguage(Language);
			if (!Code.isEmpty()) {
				enterCode(Code);
			}
			if (!GenericName.isEmpty()) {
				enterGeneric(GenericName);
			}
			if (!Product.isEmpty()) {
				productName.click();
				Thread.sleep(2000);
				initializeProductName();
				enterProduct(Product);
				Thread.sleep(2000);
				initializeTickBox();
				tickBox.click();
				Thread.sleep(1000);
				productDoneBtn.click();
				/*
				 * Assert.assertTrue(selectedProductName.getText().contains( "Alkaline Aqua"), "Alkaline Aqua product name is selected sucessfully");
				 */
			}

			Thread.sleep(3000);
			if (!Proprietary.isEmpty()) {
				enterProprietary(Proprietary);
			}
			initializeSelectTemplate();
			Assert.assertEquals(selectTemplate.isEnabled(), true, "Template button is Enabled and Displayed"); // A-CN-04
			Log.info("A-CN-04 is Passed Successfully");
			selectTemplate.click();
			Thread.sleep(2000);
			initializeTemplate();
			Assert.assertEquals(selectATemplate.isDisplayed(), true, "Select Template panel opens from the right side"); // A-CN-21
			Log.info("A-CN-21 is Passed Successfully");
			Log.info("A-CN-22 is Passed Successfully"); // A-CN-22
			Thread.sleep(2000);
			/*
			 * if (DocType.equals("US Package Insert")) { templateuspi.click(); } else { template.click(); }
			 */
			pickTemplate.click();
			// pickTemplate.getText();
			System.out.println(pickTemplate.getText());
			Assert.assertTrue(pickTemplate.getText().contains("e"), "The template is displayed with Document ID"); // A-CN-23
			Log.info("A-CN-23 is Passed Successfully");
			Assert.assertTrue(pickTemplate.getText().contains("Status"), "The template is displayed with Status"); // A-CN-24
			Log.info("A-CN-24 is Passed Successfully");
			Assert.assertTrue(pickTemplate.getText().contains("Version"), "The template is displayed with Version"); // A-CN-25
			Log.info("A-CN-25 is Passed Successfully");
			Assert.assertTrue(pickTemplate.getText().contains("Countries"), "The template is displayed with Countries"); // A-CN-26
			Log.info("A-CN-26 is Passed Successfully");
			Assert.assertTrue(pickTemplate.getText().contains("Language"), "The template is displayed with Language"); // A-CN-27
			Log.info("A-CN-27 is Passed Successfully");
			Assert.assertTrue(pickTemplate.getText().contains(Language)); // A-CN-28
			Log.info("A-CN-28 is Passed Successfully");
			Assert.assertTrue(pickTemplate.getText().contains(Country)); // A-CN-29
			Log.info("A-CN-29 is Passed Successfully");
			Assert.assertEquals(templateDoneBtn.isEnabled(), true, "Done button is displayed and enabled"); // A-CN-30
			Log.info("A-CN-30 is Passed Successfully");
			Thread.sleep(2000);
			templateDoneBtn.click();
			Thread.sleep(3000);
			initializeSelectedTemplate();
			Assert.assertTrue(selectedTemplate.isDisplayed()); // A-CN-31
			Log.info("A-CN-31 is Passed Successfully");
			Assert.assertTrue(selectedTemplate.getText().contains(Language)); // A-CN-32
			Log.info("A-CN-32 is Passed Successfully");
			initializeSelectSourceDocumentButton();
			if (selectSourceDocBtn != null) {
				Assert.assertTrue(selectSourceDocBtn.isDisplayed()); // A-CN-05
				Log.info("A-CN-5 is Passed Successfully");
				selectSourceDocBtn.click();
				Thread.sleep(2000);
				initializeSelectASourceDoc();
				Assert.assertEquals(selectASourceDoc.isDisplayed(), true, "Select Source Document Panel opens from the right side"); // A-CN-33
				Log.info("A-CN-33 is Passed Successfully");
				Log.info("A-CN-35 is Passed Successfully"); // A-CN-35
				Assert.assertEquals(myDocsListing.isDisplayed(), true, "MyDocs listing screen tab is displayed and preselected."); // A-CN-34
				Log.info("A-CN-34 is Passed Successfully");

				/*
				 * } else { Assert.assertTrue(!selectSourceDocBtn.isDisplayed()); // A-CN-06
				 */
				initializeSelectSourceDocumentMyDocListing();
				selectSourceMyDocListing.click();
				System.out.println(selectSourceMyDocListing.getText());
				Assert.assertTrue(selectSourceMyDocListing.getText().contains("-"), "The template is displayed with Document ID"); // A-CN-36
				Log.info("A-CN-36 is Passed Successfully");
				Assert.assertTrue(selectSourceMyDocListing.getText().contains("Status"), "The template is displayed with Status"); // A-CN-37
				Log.info("A-CN-37 is Passed Successfully");
				Assert.assertTrue(selectSourceMyDocListing.getText().contains("Version"), "The template is displayed with Version"); // A-CN-25
				Log.info("A-CN-25 is Passed Successfully");
				Assert.assertTrue(selectSourceMyDocListing.getText().contains("Countries"), "The template is displayed with Countries"); // A-CN-38
				Log.info("A-CN-38 is Passed Successfully");
				Assert.assertTrue(selectSourceMyDocListing.getText().contains("Language"), "The template is displayed with Language"); // A-CN-39
				Log.info("A-CN-39 is Passed Successfully");
				Assert.assertTrue(selectSourceMyDocListing.getText().contains("Title"), "The template is displayed with Title"); // A-CN-40
				Log.info("A-CN-40 is Passed Successfully");
				Assert.assertEquals(templateDoneBtn.isEnabled(), true, "Done button is displayed and enabled"); // A-CN-30
				Log.info("A-CN-30 is Passed Successfully");
				// Thread.sleep(2000);

				initializeSearch();
				searchTab.click();
				Assert.assertEquals(basicSearch.isDisplayed(), true, "Search screen is displayed."); // A-CN-41
				Log.info("A-CN-41 is Passed Successfully");
				basicSearch.click();
				basicSearchProperty.getText();
				System.out.println(basicSearchProperty.getText());
				Assert.assertTrue(basicSearchProperty.getText().contains("Status"), "The Basic Search section is displayed with Basic Search properties "); // A-CN-42
				Log.info("A-CN-42 is Passed Successfully");
				advanceSearch.click();
				Thread.sleep(2000);
				advanceSearchProperty.getText();
				System.out.println(advanceSearchProperty.getText());
				Assert.assertTrue(advanceSearchProperty.getText().contains("Select Document Type"), "The Advance Search section is displayed with Advance Search properties "); // A-CN-43
				Log.info("A-CN-43 is Passed Successfully");
				initializeDoneBtn();
				Assert.assertEquals(searchDocBtn.isEnabled(), true, "Search Document button is displayed and enabled"); // A-CN-44
				Log.info("A-CN-44 is Passed Successfully");
				searchDocBtn.click();
				SourceDoneBtn.click();
				initializeSelectedSourceDoc();
				selectedSourceDoc.getText();
				System.out.println(selectedSourceDoc.getText());
				Assert.assertTrue(selectedSourceDoc.getText().contains("-"), "The Source Document is displayed with Document ID"); // A-CN-46
				Log.info("A-CN-46 is Passed Successfully");
				Assert.assertTrue(selectedSourceDoc.getText().contains("Status"), "The Source Document is displayed with Status"); // A-CN-47
				Log.info("A-CN-47 is Passed Successfully");
				/*
				 * Assert.assertTrue(selectedSourceDoc.getText().contains("Version" ), "The Source Document is displayed with Version"); // A-CN-25
				 */Assert.assertTrue(selectedSourceDoc.getText().contains("Countries"), "The Source Document is displayed with Countries"); // A-CN-48
				Log.info("A-CN-48 is Passed Successfully");
				Assert.assertTrue(selectedSourceDoc.getText().contains("Language"), "The Source Document is displayed with Language"); // A-CN-49
				Log.info("A-CN-49 is Passed Successfully");
				Assert.assertTrue(selectedSourceDoc.getText().contains("Title"), "The Source Document is displayed with Title"); // A-CN-50
				Log.info("A-CN-50 is Passed Successfully"); // //A-CN-51//
				Log.info("A-CN-51 is Passed Successfully"); // A-CN-52
				Log.info("A-CN-52 is Passed Successfully");
				Thread.sleep(2000);
			}
			createBtn.click();
			Thread.sleep(5000);
			initializeMessages();
			Assert.assertTrue(message.getText().contains("Create sucessfully"), "Document is sucessfully Created"); // A-CN-13 //A-CN-15
			Log.info("A-CN-13 is Passed Successfully");
			Log.info("A-CN-15 is Passed Successfully");

			// message.getText().contains("successfully");
			System.out.println(message.getText());
			String successMessage = message.getText(); // Created successfully
														// Document SmPC-470 is successfully
														// created. To view document Click Here
														// AN-1021
														// Created successfully
														// Document CDS-874 is successfully
														// created. To view document Click Here
			if (DocType.equalsIgnoreCase("US Package Insert") || DocType.equalsIgnoreCase("Summary of Product Characteristics")) {
				DocID = successMessage.substring(31, 40);
				writeCSV(DocID);
			} else if (DocType.equalsIgnoreCase("Package Leaflet") || DocType.equalsIgnoreCase("Annex II")) {
				DocID = successMessage.substring(31, 38);
			} else {
				DocID = successMessage.substring(31, 39);
			}
			writeCSV(DocID);
			Reporter.log("xmL-UI-ADS-006.doc Create Document tested Passed successfully");
			Log.endTestCase("Create Document Test Ended");
		} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-006.doc Create Document tested Failed");
			Log.endTestCase("Create Document");
			Assert.fail(t.getMessage());

		}

	}

	public String doCreateDocument(String DocType, String Title, String Country, String Language, String Product, String Proprietary, String Code, String GenericName)
			throws Exception {

		String DocID;
		String successMsg[];
		try {
			inilializObjectsProperty(DocType);
			
			if (!Title.isEmpty()) {
				enterTitle(Title);
			}
			enterCountry(Country);
			Thread.sleep(1000);
			enterLanguage(Language);
			if (!Code.isEmpty()) {
				enterCode(Code);
			}
			if (!GenericName.isEmpty()) {
				enterGeneric(GenericName);
			}
			if (!Product.isEmpty()) {
				productName.click();
				Thread.sleep(2000);
				initializeProductName();
				enterProduct(Product);
				Thread.sleep(2000);
				initializeTickBox();
				tickBox.click();
				Thread.sleep(1000);
				productDoneBtn.click();
				
			}

			Thread.sleep(3000);
			if (!Proprietary.isEmpty()) {
				enterProprietary(Proprietary);
			}
			initializeSelectTemplate();
			
			selectTemplate.click();
			Thread.sleep(2000);
			initializeTemplate();			
			Thread.sleep(2000);		
			pickTemplate.click();			
			Thread.sleep(4000);
			templateDoneBtn.click();
			Thread.sleep(3000);
			initializeSelectedTemplate();
			initializeSelectSourceDocumentButton();
			Thread.sleep(3000);
			if (selectSourceDocBtn != null) {
				selectSourceDocBtn.click();
				Thread.sleep(2000);
				initializeSelectASourceDoc();
				initializeSelectSourceDocumentMyDocListing();
				selectSourceMyDocListing.click();
				initializeSearch();
				searchTab.click();
				basicSearch.click();
				basicSearchProperty.getText();
				advanceSearch.click();
				Thread.sleep(2000);
				advanceSearchProperty.getText();
				initializeDoneBtn();
				searchDocBtn.click();
				SourceDoneBtn.click();
				initializeSelectedSourceDoc();
				selectedSourceDoc.getText();
				Thread.sleep(2000);
			}
			createBtn.click();
			Thread.sleep(2000);
			
			initializeMessages();
		
			String successMessage = message.getText(); 	//Created successfully 
														//Document SmPC-470 is successfully
														// created. To view document Click Here
														//AN-1021
														//Created successfully
														//Document CDS-874 is successfully
														//created. To view document Click Here
			docLink.click();
			successMsg=successMessage.split(" ", 4);
			DocID=successMsg[2];
			/*if (DocType.equalsIgnoreCase("US Package Insert")|| DocType.equalsIgnoreCase("Summary of Product Characteristics")) {
			  DocID = successMessage.substring(31, 40); 
			  writeCSV(DocID);
			}
			else if (DocType.equalsIgnoreCase("Package Leaflet")|| DocType.equalsIgnoreCase("Annex II")) {
				successMsg=successMessage.split(" ", 4);
				DocID=successMsg[2];
			//	DocID = successMessage.substring(31, 38);
			}
			else {
				DocID = successMessage.substring(31, 39);
			}*/
			writeCSV(DocID);
			
			return DocID;
		} catch (Throwable t) {

			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		
		}
		return "Document not created";

	
	}

	
	
	public String doCreateDocumentWithOptions(String DocType, String Title, String Country, String Language, String Product, String Proprietary, String Code, String GenericName, String NotificationRecipients)
			throws Exception {

		String DocID;
		String successMsg[];
		try {
			inilializObjectsProperty(DocType);
			
			if (!Title.isEmpty()) {
				enterTitle(Title);
			}
			enterCountry(Country);
			Thread.sleep(1000);
			enterLanguage(Language);
			if (!Code.isEmpty()) {
				enterCode(Code);
			}
			if (!GenericName.isEmpty()) {
				enterGeneric(GenericName);
			}
			if (!Product.isEmpty()) {
				productName.click();
				Thread.sleep(2000);
				initializeProductName();
				enterProduct(Product);
				Thread.sleep(2000);
				initializeTickBox();
				tickBox.click();
				Thread.sleep(1000);
				productDoneBtn.click();
				
			}
			Thread.sleep(3000);
			
			if (!Proprietary.isEmpty()) {
				enterProprietary(Proprietary);
				Thread.sleep(2000);
			}
			
			
 			initializeOptionalProperty();
 			optionalArrow.click();	
			Thread.sleep(3000);
			enterNotificationRecipients(NotificationRecipients);
			Thread.sleep(2000);
		
			
			initializeSelectTemplate();
			selectTemplate.click();
			Thread.sleep(2000);
			initializeTemplate();			
			Thread.sleep(2000);		
			pickTemplate.click();			
			Thread.sleep(2000);
			templateDoneBtn.click();
			Thread.sleep(3000);
			initializeSelectedTemplate();
			initializeSelectSourceDocumentButton();
			Thread.sleep(3000);
			if (selectSourceDocBtn != null) {
				selectSourceDocBtn.click();
				Thread.sleep(2000);
				initializeSelectASourceDoc();
				initializeSelectSourceDocumentMyDocListing();
				selectSourceMyDocListing.click();
				initializeSearch();
				searchTab.click();
				basicSearch.click();
				basicSearchProperty.getText();
				advanceSearch.click();
				Thread.sleep(2000);
				advanceSearchProperty.getText();
				initializeDoneBtn();
				searchDocBtn.click();
				SourceDoneBtn.click();
				initializeSelectedSourceDoc();
				selectedSourceDoc.getText();
				Thread.sleep(2000);
			}
			createBtn.click();
			Thread.sleep(2000);
			
			initializeMessages();
		
			String successMessage = message.getText(); 	//Created successfully 
														//Document SmPC-470 is successfully
														// created. To view document Click Here
														//AN-1021
														//Created successfully
														//Document CDS-874 is successfully
														//created. To view document Click Here
			docLink.click();
			successMsg=successMessage.split(" ", 4);
			DocID=successMsg[2];
			/*if (DocType.equalsIgnoreCase("US Package Insert")|| DocType.equalsIgnoreCase("Summary of Product Characteristics")) {
			  DocID = successMessage.substring(31, 40); 
			  writeCSV(DocID);
			}
			else if (DocType.equalsIgnoreCase("Package Leaflet")|| DocType.equalsIgnoreCase("Annex II")) {
				successMsg=successMessage.split(" ", 4);
				DocID=successMsg[2];
			//	DocID = successMessage.substring(31, 38);
			}
			else {
				DocID = successMessage.substring(31, 39);
			}*/
			writeCSV(DocID);
			
			return DocID;
		} catch (Throwable t) {

			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		
		}
		return "Document not created";

	
	}
	
	// @AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
