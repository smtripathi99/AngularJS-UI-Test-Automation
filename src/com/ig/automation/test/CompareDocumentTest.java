package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.utility.Log;



public class CompareDocumentTest extends ContentManagementScreen{

	HomeTest homeTest = new HomeTest();
	CreateDocumentTest cdTest = new CreateDocumentTest();
	CheckinScreen ciScreen = new CheckinScreen ();
	String DocA = null; 	
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testHome();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Test the Compare Document of UI 7.0 against the xmL-UI-ADS-034  
	 * @throws Exception If an error occurs.
	 * 
	 */
	
	
	@Test(priority=1)
	public void testCompareDocumentVersions() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Compare Document Test Started");
		try{
			
			createDocument();
			Thread.sleep(2000);
			searchDocument(DocA);
			Thread.sleep(2000);
			initializeSearchResult();
			selectDoc.click();
			initializeEdit();
			editMenu.click();
			editDocument.click();
			Thread.sleep(3000);
			initializeBasicSearch();
			searchBtn.click();
			initializeCheckIn();
			checkInKey.click();
			Thread.sleep(2000);
			ciScreen.initializeCheckinPanel();
			Thread.sleep(2000);
			ciScreen.doneBtn.click();
			Thread.sleep(6000);
			searchBtn.click();
			Thread.sleep(2000);
			initializeSearchResult();
			selectDoc1.click();
			initializeEdit();
			editMenu.click();
			initializeCompareDocument();
			compareDocument.click();
			Thread.sleep(2000);
			allVersions.click();
			Thread.sleep(2000);
			Log.info("Requirement UI-COMD-07 is passed. The “ALL Versions tab is Enable");
			getScreenShot("CompareDocument-ADS-034", "ALLVersions.jpg");
			Assert.assertTrue(tblDocumentID.getText().equalsIgnoreCase(DocA));
			Log.info("Requirement UI-COMD-08 is passed. The “DocumentID is Avilable");
			Assert.assertTrue(tblVersion.getText().equalsIgnoreCase("1.0, CURRENT"));
			Log.info("Requirement UI-COMD-09 is passed. The “Version is Avilable");
			Assert.assertTrue(tblStatus.getText().equalsIgnoreCase("Accepted"));
			Log.info("Requirement UI-COMD-10 is passed. The “Status is Avilable");
			Assert.assertTrue(tblLanguage.getText().equalsIgnoreCase("English"));
			Log.info("Requirement UI-COMD-11 is passed. The “Language is Avilable");
			Assert.assertTrue(tblCountry.getText().equalsIgnoreCase("European Union"));
			Log.info("Requirement UI-COMD-12 is passed. The “Country is Avilable");
			Assert.assertTrue(tblTitle.getText().equalsIgnoreCase("ANTest"));
			Log.info("Requirement UI-COMD-13 is passed. The “Title is Avilable");
			
			Assert.assertEquals(compareDocumentBtn.isEnabled(),false, "UI-COMD-14 - Compare Document button is Disable"); 
			Log.info("UI-COMD-14 - Compare Document button is Disable");
			
			Assert.assertEquals(cancelBtn.isDisplayed(), true, "UI-COMD-15 - Cancel button is Displayed"); 
			Log.info("UI-COMD-15 - Cancel button is Displayed");
			Assert.assertEquals(cancelBtn.isEnabled(), true, "UI-COMD-15 - Cancel button is Enable"); 
			Log.info("UI-COMD-15 - Cancel button is Enable");
			
			selectDocument.click();
			if (compareDocumentBtn.isEnabled()) {
				compareDocumentBtn.click();
				Thread.sleep(8000);
				getScreenShot("CompareDocument-ADS-034", "Compared_Successfully_AllVersios_UI-COMD-24");
				Log.info("UI-COMD-24 - Clicks the Compare Document button and Documents Compared");
				cdTest.initializeMessages();
				Assert.assertTrue(message.getText().contains("Request Submitted"));
				System.out.println(message.getText());
				String successMessage = message.getText(); // Document AN-2001,
				String DocID = successMessage.substring(29, 36); 
				writeCSV(DocID);

				Reporter.log("xmL-UI-ADS-034.doc Compare Document (Version) successfully");
				}
			}
			catch(Throwable e){
				Log.info(e.getMessage());
				Reporter.log("xmL-UI-ADS-034.doc Compare Document (Version) unsuccessfully");	
				Assert.fail();
			}
				Log.endTestCase("Compare Document Test Ended");
		}

	
	@Test(priority=2)
	public void testCompareDocumentMyDoc() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Compare Document Test Started");
		try{
			
			createDocument();
			Thread.sleep(2000);
			searchDocument(DocA);
			Thread.sleep(2000);
			initializeSearchResult();
			myDocIcon.click();
			Thread.sleep(2000);
			selectDoc.click();
			initializeEdit();
			editMenu.click();
			editDocument.click();
			Thread.sleep(3000);
			initializeBasicSearch();
			searchBtn.click();
			initializeCheckIn();
			checkInKey.click();
			Thread.sleep(2000);
			ciScreen.initializeCheckinPanel();
			Thread.sleep(2000);
			ciScreen.doneBtn.click();
			Thread.sleep(6000);
			searchBtn.click();
			Thread.sleep(2000);
			initializeSearchResult();
			selectDoc1.click();
			initializeEdit();
			editMenu.click();
			initializeCompareDocument();
			compareDocument.click();
			Thread.sleep(2000);
			
			initializeCompareDocumentHeaderPanel();
			Assert.assertTrue(documentID.getText().equalsIgnoreCase(DocA));
			Log.info("Requirement UI-COMD-01 is passed. The “DocumentID is Avilable");
			Assert.assertTrue(version.getText().equalsIgnoreCase("1.0, CURRENT"));
			Log.info("Requirement UI-COMD-02 is passed. The “Version is Avilable");
			Assert.assertTrue(status.getText().equalsIgnoreCase("Accepted"));
			Log.info("Requirement UI-COMD-03 is passed. The “Status is Avilable");
			Assert.assertTrue(languageHeader.getText().equalsIgnoreCase("English"));
			Log.info("Requirement UI-COMD-04 is passed. The “Language is Avilable");
			Assert.assertTrue(country.getText().equalsIgnoreCase("European Union"));
			Log.info("Requirement UI-COMD-05 is passed. The “Country is Avilable");
			Assert.assertTrue(titleHeader.getText().equalsIgnoreCase("ANTest"));
			Log.info("Requirement UI-COMD-06 is passed. The “Title is Avilable");
			
			initializeCompareDocumentTable();
			tblSearchIcon.click();
			tblDocIDSearch.sendKeys(DocA);
			Log.info("Requirement UI-COMD-16 is passed. The “MyDocs tab is Enable");
			getScreenShot("CompareDocument-ADS-034", "MyDocs.jpg");
			Assert.assertTrue(tblDocumentID.getText().equalsIgnoreCase(DocA));
			Log.info("Requirement UI-COMD-17 is passed. The “DocumentID is Avilable");
			Assert.assertTrue(tblVersion.getText().equalsIgnoreCase("1.0, CURRENT"));
			Log.info("Requirement UI-COMD-18 is passed. The “Version is Avilable");
			Assert.assertTrue(tblStatus.getText().equalsIgnoreCase("Accepted"));
			Log.info("Requirement UI-COMD-19 is passed. The “Status is Avilable");
			Assert.assertTrue(tblLanguage.getText().equalsIgnoreCase("English"));
			Log.info("Requirement UI-COMD-20 is passed. The “Language is Avilable");
			Assert.assertTrue(tblCountry.getText().equalsIgnoreCase("European Union"));
			Log.info("Requirement UI-COMD-21 is passed. The “Country is Avilable");
			Assert.assertTrue(tblTitle.getText().equalsIgnoreCase("ANTest"));
			Log.info("Requirement UI-COMD-22 is passed. The “Title is Avilable");
			
			initializeCompareDocument();
			if (selectDocument1 != null) {
				selectDocument1.click();
			}
			
			Assert.assertEquals(compareDocumentBtn.isDisplayed(),true, "UI-COMD-23 - Compare Document button is Displayed"); 
			Log.info("UI-COMD-23 - Compare Document button is Displayed");
			
			if (compareDocumentBtn.isEnabled()){
				Assert.assertEquals(compareDocumentBtn.isEnabled(),true, "UI-COMD-23 - Compare Document button is Enable"); 
				Log.info("UI-COMD-23 - Compare Document button is Enable");
				compareDocumentBtn.click();
				Thread.sleep(8000);
				getScreenShot("CompareDocument-ADS-034", "Compared_Successfully_MyDocs_UI-COMD-24");
				Log.info("UI-COMD-24 - Clicks the Compare Document button and Documents Compared");
				Assert.assertEquals(compareDocPanelHeading.isDisplayed(),false, "UI-COMD-25 - Compare Document Panel Closes");
								
				cdTest.initializeMessages();
				Assert.assertTrue(message.getText().contains("Request Submitted"));
				System.out.println(message.getText());
				String successMessage = message.getText(); // Document AN-2001,
				String DocID = successMessage.substring(29, 36); 
				writeCSV(DocID);
				Reporter.log("xmL-UI-ADS-034.doc Compare Document (MyDoc) successfully");
			}
		}
			catch(Throwable e){
				Log.info(e.getMessage());
				Reporter.log("xmL-UI-ADS-034.doc Compare Document (MyDoc) unsuccessfully");	
				Assert.fail();
		}
			Log.endTestCase("Compare Document Test Ended");
	}
	
	
	@Test(priority=3)
	public void testCompareDocumentCancel() throws InterruptedException{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Compare Document For Cancel Test Started");
		try{
			createDocument();
			Thread.sleep(2000);
			searchDocument(DocA);
			Thread.sleep(2000);
			initializeSearchResult();
			selectDoc.click();
			initializeEdit();
			editMenu.click();
			editDocument.click();
			Thread.sleep(3000);
			initializeBasicSearch();
			searchBtn.click();
			initializeCheckIn();
			checkInKey.click();
			Thread.sleep(2000);
			ciScreen.initializeCheckinPanel();
			Thread.sleep(2000);
			ciScreen.doneBtn.click();
			Thread.sleep(6000);
			searchBtn.click();
			Thread.sleep(2000);
			initializeSearchResult();
			selectDoc1.click();
			initializeEdit();
			editMenu.click();
			initializeCompareDocument();
			compareDocument.click();
			Thread.sleep(2000);
			if (cancelBtn.isEnabled()){
				compareDocumentBtn.click();
				Thread.sleep(3000);
				getScreenShot("CompareDocument-ADS-034", "Compare_Document_panel_closes_UI-COMD-26");
				Assert.assertEquals(compareDocPanelHeading.isDisplayed(),false, "UI-COMD-26 - Compare Document Panel Closes");
				Log.info("UI-COMD-26 - Compare Document panel closes.");
			}
		}	
			catch(Throwable e){
				Log.info(e.getMessage());
				Reporter.log("xmL-UI-ADS-034.doc Compare Document Cancel test Unsuccessfully");	
				Assert.fail();
			}
				Log.endTestCase("Compare Document Cancel test Ended");
	}
	
	
	
	
	public void createDocument() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Document Test Started");
		try {
			cdTest.inilializeObjectsDocType();
			cdTest.annexType.click();
			Thread.sleep(3000);
			DocA = cdTest.doCreateDocument("Annex II","ANTest","European Union","English","Alkaline Aqua","ALLERSOLV","","");//06
		
		}
		catch (Throwable t) {

			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	

	public void searchDocument(String docid) throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Document Test Started");
		try{
			initializeSearch();
			Thread.sleep(2000);
			searchIcon.click();
			System.out.println("Search Icon Clicked Successfully");
			Thread.sleep(2000);
			initializeBasicSearchIcon();
			basicSearchIcon.click();
			Thread.sleep(2000);
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);  // docID 
			Thread.sleep(3000);
			initializeBasicSearch();
			searchBtn.click();
		}
		catch(Throwable t)
		{
			Log.info(t.getMessage());
			Reporter.log("Search tested Failed");
		}
	}
		
		
		
	

	/*public String getDocID(String doctype) throws Exception {
		
		List<String[]> list=readCSV();
		for(String[] str: list) {
		    for(String doc: str){
		    	if(doc.contains(doctype))
		    		return doc.toString();
		    } 
		}
	    return null;
	}*/

	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
