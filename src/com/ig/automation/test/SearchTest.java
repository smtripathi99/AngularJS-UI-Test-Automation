package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.ChangeLifeCycleStateScreen;
import com.ig.automation.screens.DocumentDetailsScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.SearchTestScreen;
import com.ig.automation.utility.Log;
import com.ig.automation.utility.Sorting;


public class SearchTest extends SearchTestScreen{

	HomeTest homeTest = new HomeTest();
	LoginTest loginTest = new LoginTest();
	DocumentDetailsScreen documentDetailsScreen = new DocumentDetailsScreen();
	
	//private SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public void login() {
		try {
			launchUrl();
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Test the Edit Properties  Page of UI 7.0 against the xmL-UI-ADS-009 Document Properties for Annex II	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testSearch() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Search Test");
		try{
		homeTest.initializeLeftNavigationObjects();
		homeTest.searchIcon.click();
		System.out.println("Search Icon Clicked Successfully");
		initializeBasicSearchIcon();
		//TODO GLM-1498 Search screen is not displayed with Basic Search section open and all fields
		assertTrue(basicSearchIcon.isDisplayed(), true, basicSearchIcon.isDisplayed()); //UA-SD-1
		Log.info("UA-SD-1- Passed -The Search screen is displayed with Basic Search section open and all fields empty");
		initializeBasicSearch();
		basicSearch.click(); 
		Thread.sleep(2000);
		initializeBasicSearchScreen();
		assertTrue(basicSearchScreen.isDisplayed(), true, basicSearchScreen.isDisplayed()); //UA-SD-2
		Log.info("UA-SD-2- Passed -Basic Search section of the Search screen is displayed");
		Thread.sleep(2000);
		assertTrue(docID.isDisplayed(), true, docID.isDisplayed());   //UA-SD-3
		Log.info("UA-SD-3- Passed -Document ID form field is displayed as free text field");
		//TODO GLM-1064  -Title form field is not displayed in Search Panel   //UA-DS-4
		assertTrue(status.isDisplayed(), true, status.isDisplayed());   //UA-SD-5
		Log.info("UA-SD-5- Passed -Status form field is displayed as a drop down ");
		statusDropDown.selectByIndex(1); 
		assertTrue(language.isDisplayed(), true, language.isDisplayed());   //UA-SD-6
		Log.info("UA-SD-6- Passed -Language field is displayed as a drop down");
		languageDropDown.selectByIndex(1);
		assertTrue(countrytextField.isDisplayed(), true, countrytextField.isDisplayed());   //UA-SD-7
		Log.info("UA-SD-7-  Passed -Country field is displayed as a drop down");
		countryDropDown.selectByIndex(1);
		assertTrue(contents.isDisplayed(), true, contents.isDisplayed());   //UA-SD-8
		Log.info("UA-SD-8- Passed -The Content form field is displayed as free text field");
		//TODO GLM-1062 -Clear all values link is not available in Search Panel  //UA-SD-9
		assertTrue(hide.isEnabled(), true, hide.isEnabled());   //UA-SD-10
		Log.info("UA-SD-10- Passed -Hide Link is displayed and enabled");
		assertTrue(searchDocBtn.isEnabled(), true, searchDocBtn.isEnabled());   //UA-SD-11
		Log.info("UA-SD-11- Passed -Search button displayed and enabled");
		//TODO GLM-1071- Cancel button is not displayed in Search Panel  //UA-SD-12
		assertTrue(advanceSearch.isEnabled(), true, advanceSearch.isEnabled());   //UA-SD-13
		Log.info("UA-SD-13- Passed -Advance Search link displayed and enabled");
		docIdValue.sendKeys("BLI-");
		Thread.sleep(2000);
		searchDocBtn.click();
		initializeSearchCriteria();
		assertTrue(dynamicViewBtn.isDisplayed(), true, dynamicViewBtn.isDisplayed());  //UA-SD-18  
		Log.info("UA-SD-18- Passed - user clicks the Search button and no error occurred");
		assertTrue(editSearchViewBtn.isDisplayed(), true, editSearchViewBtn.isDisplayed());  //UA-SD-19
		Log.info("UA-SD-19- Passed - Display the Search Results Panel as described");
		Thread.sleep(2000);
		//TODO GLM-1079- Edit SEarch is not working properly //UA-SD-14
		editSearchViewBtn.click();
		Thread.sleep(2000);
		initializeBasicSearch();
		advanceSearch.click();
		Thread.sleep(2000);
		initializeDocTypes();
		assertTrue(docTypes.isDisplayed(), true, docTypes.isDisplayed());  //UA-SD-15  //UA-SD-20
		Log.info("UA-SD-15- Passed - Advanced Search section opens");
		Log.info("UA-SD-20- Passed - Advanced Search screen is initially displayed- The Document Type selection list is populated ");
		initializeSelectDocType();
		selectDocTypeAnnexII.click();
		initializeSelectDocTypeResult();
		assertTrue(selectDocTypeResult.isDisplayed(), true, selectDocTypeResult.isDisplayed());  //UA-SD-21
		Log.info("UA-SD-21- Passed - When the user selects a document type, the properties that are configured to be searchable are displayed");
		//TODO GLM-1062- Clear all values link not available   //UA-SD-22
		initializeBasicSearch();
		assertTrue(searchDocBtn.isEnabled(), true, searchDocBtn.isEnabled()); //UA-SD-23
		Log.info("UA-SD-23 - Passed- Search button is displayed and enabled.");
		//TODO GLM-1071-  cancel button is enabled and displayed  // UA-SD-24  //UA-SD-16
		//TODO GLM-1444- Edit Search is not Displaying the current search criteria on the screen   //UA-SD-25
		//TODO GLM-1473- clicks the Search button and has not selected a document type- not showing error message  //UA-SD-26
		searchDocBtn.click();
		initializeSearchCriteria();
		assertTrue(dynamicViewBtn.isDisplayed(), true, dynamicViewBtn.isDisplayed());
		Log.info("UA-SD-27 - Passed- When the user clicks the Search button and no error occurred.");   //UA-SD-27 
		Log.info("UA-SD-28 - Passed- Display the Search Results Panel .");   //UA-SD-28
		//TODO Same GLM-1071- the user clicks the Cancel button the Search Panel is closed  //UA-SD-16  //UA-SD-29
		initializeReadOnlySearchResult();
		Assert.assertTrue(readOnlySearchResult.getTagName().equals("p"),"Search Result is ReadOnly"); //UA-SD-30
		Log.info("UA-SD-30 - Passed- Display user specified search criteria in a read only format.");  
		initializeSearchCriteria();
		assertTrue(dynamicViewBtn.isDisplayed(), true, dynamicViewBtn.isDisplayed()); //UA-SD-31
		Log.info("UA-SD-31- Passed - Create Dynamic View button is displayed and enabled");
		assertTrue(editSearchViewBtn.isDisplayed(), true, editSearchViewBtn.isDisplayed()); //UA-SD-32
		Log.info("UA-SD-32- Passed - Edit Search button is displayed and enabled");
		//TODO GLM-1449 - No Message occurring if given wrong input into Search criteria   //US-SD-33
		
		
		
		/*System.out.println(docIdValue.getAttribute("value"));
		Assert.assertEquals(docIdValue.getAttribute("value"), "BLI-"); UA-SD-25
		Log.info("UA-SD-25 is Passed Successfully");
		Thread.sleep(2000);*/
		//TODO GLM-1445 - Message is not prompting  //UA-SD-17
		initializeSearchResult();
		assertTrue(documentId.isDisplayed(), true, documentId.isDisplayed());  //UA-SD-34
		Log.info("UA-SD-34- Passed - Display the documents (sorted by Document ID) that meet the user-specified search criteria");
		String[] arrayS = {firstLine.getText(),secondLine.getText(), thirdLine.getText(),
				fourthLine.getText(), fifthLine.getText(), sixLine.getText(),
				sevenLine.getText(), eightLine.getText(),  nineLine.getText(),
				tenLine.getText()};
		System.out.println(Sorting.isSorted(arrayS));
		Assert.assertEquals(Sorting.isSorted(arrayS), "ascending", 
				"The Document ID list is sorted incrementally");  //UA-SD-34
		assertTrue(version.isDisplayed(), true, version.isDisplayed());  //UA-SD-35
		Log.info("UA-SD-35- Passed - Version is displayed Successfully");
		assertTrue(status1.isDisplayed(), true, status1.isDisplayed());  //UA-SD-36
		Log.info("UA-SD-36- Passed - Status is displayed Successfully");
		assertTrue(language1.isDisplayed(), true, language1.isDisplayed());  //UA-SD-37
		Log.info("UA-SD-37- Passed - Status is displayed Successfully");
		//TODO GLM-1100 Country column is not available   //UA-SD-38
		assertTrue(title.isDisplayed(), true, title.isDisplayed());  //UA-SD-39
		Log.info("UA-SD-39- Passed - Status is displayed Successfully");
		System.out.println(itemsPerPage.getFirstSelectedOption().getText());
		Assert.assertEquals(itemsPerPage.getFirstSelectedOption().getText(), "10");	 //UA-SD-40
		Log.info("UA-SD-40- The items per page will be displayed, enabled, and defaulted to 10");
		pageScrollUp();
		initializeNextLinkpagination();
		nextlinkPagination.click();
		Thread.sleep(2000);
		initializePrevLinkPagination();
		assertTrue(nextlinkPagination.isDisplayed(), true, nextlinkPagination.isDisplayed());  
		assertTrue(prevLinkPagination.isDisplayed(), true, prevLinkPagination.isDisplayed());  //UA-SD-41
		Log.info("UA-SD-41- Passed - Display previous and next hyperlinks");
		initializePageNumberHyperlink();
		assertTrue(pageNumberHyperlink.isDisplayed(), true, prevLinkPagination.isDisplayed());  //UA-SD-42
		Log.info("UA-SD-42- Passed -Display each page number as a hyperlink.");
		//TODO -GLM-1454   //UA-SD-43  //UA-SD-44
		initializeSearchResult();
		selectDoc.click();
		Thread.sleep(2000);
		initializeMenuBar();
		assertTrue(menuBar.isDisplayed(), true, menuBar.isDisplayed());  //UA-SD-45
		Log.info("UA-SD-45- Passed -The system will display document specific menu bar.");  
		initializeDocDetailsPanel();
		assertTrue(docDetailsPanel.isDisplayed(), true, docDetailsPanel.isDisplayed());  //UA-SD-46
		Log.info("UA-SD-46- Passed -System will display Document Details panel");
		//TODO GLM-1457-   UA-SD-47
		initializeSearchCriteria();
		//editSearchViewBtn.click(); 
		//TODO GLM-1457     //UA-SD-47  
		dynamicViewBtn.click();
		initializeCreateDynamicViewScreen();
		assertTrue(createDynamicViewScreen.isDisplayed(), true, createDynamicViewScreen.isDisplayed());  //UA-SD-48
		Log.info("UA-SD-48- Passed -Create Dynamic View” Save Search panel is displayed from the right side of the screen");
			
		

		
		
		
		
			
		
		
		Reporter.log("xmL-UI-ADS-005.doc Search tested successfully");
		
		}
		catch(Throwable t)
		{
			
			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-005.doc Search tested Failed");
			Log.endTestCase("Search Test");
			Assert.fail(t.getMessage());
		}
		Log.endTestCase("Search Test");
	}





	public void doSearchDocument(String docid) throws Exception {
	try {
		initializeSearch();
		searchIcon.click();
		Thread.sleep(2000);
	/*	initializeBasicSearchIcon();
		basicSearchIcon.click();
		Thread.sleep(2000);*/
		initializeBasicSearch1();
		docID1.clear();
		docID1.sendKeys(docid);
		Thread.sleep(2000);
		searchDocBtn1.click();
		Thread.sleep(2000);
		initializeSearchResult1();
		//Assert.assertEquals(selectDoc1.getText().equalsIgnoreCase(docid),true , "Document :" + docid + "is searched Successfully."); 
		Log.info("Document :" + docid + "is searched Successfully.");
		selectDoc1.click();
		Thread.sleep(2000);
	} catch (Exception e) {
		System.out.println("Fail");
	}
	
}	
	
	public void doSearchDocument(String docid , String status) throws Exception {
		try {
			initializeSearch();
			searchIcon.click();
			Thread.sleep(2000);
			initializeBasicSearch1();
			docID1.clear();
			docID1.sendKeys(docid);
			Thread.sleep(2000);
			statusSearch.selectByVisibleText(status);
			Thread.sleep(2000);
			searchDocBtn1.click();
			Thread.sleep(2000);
			initializeSearchResult1();
			Log.info("Document :" + docid + "is searched Successfully.");
			selectDoc1.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Fail");
		}
		
	}	
	
	public void doEditSearchView(String docid) throws Exception {
		try {
			initializeSearchCriteria();
			editSearchViewBtn.click();
			Thread.sleep(2000);
			/*initializeBasicSearchIcon();
			basicSearchIcon.click();
			Thread.sleep(2000);*/
			initializeBasicSearch1();
			docID1.clear();
			docID1.sendKeys(docid);
			Thread.sleep(2000);
			searchDocBtn1.click();
			Thread.sleep(2000);
			initializeSearchResult1();
			/*Assert.assertEquals(selectDoc1.getText().equalsIgnoreCase(docid),true , "Document :" + docid + "is searched Successfully."); 
			Log.info("Document :" + docid + "is searched Successfully.");*/
			selectDoc1.click();
		} catch (Exception e) {
			System.out.println("Fail");
		}
}
	
	public void doEditSearchView(String docid , String status) throws Exception {
		try {
			initializeSearchCriteria();
			editSearchViewBtn.click();
			Thread.sleep(2000);
			/*initializeBasicSearchIcon();
			basicSearchIcon.click();
			Thread.sleep(2000);*/
			initializeBasicSearch1();
			docID1.clear();
			docID1.sendKeys(docid);
			Thread.sleep(2000);
			statusSearch.selectByVisibleText(status);
			Thread.sleep(2000);
			searchDocBtn1.click();
			Thread.sleep(2000);
		/*	initializeSearchResult1();
			Assert.assertEquals(selectDoc1.getText().equalsIgnoreCase(docid),true , "Document :" + docid + "is searched Successfully."); 
			Log.info("Document :" + docid + "is searched Successfully.");*/
			selectDoc1.click();
		} catch (Exception e) {
			System.out.println("Fail");
		}
}

	public List<String> doCheckSourceDoc(String docId) throws Exception{
		List<String> sourceDocDetails = new ArrayList<String>();
		doSearchDocument(docId);
		documentDetailsScreen.initializeSourceDoc();
		documentDetailsScreen.sourceDoc.click();
		documentDetailsScreen.initializesourceDocId();
		String souceDocIDForDocB = documentDetailsScreen.sourceDocId.getTagName();
		sourceDocDetails.add(souceDocIDForDocB);
		String versionIDForDocB = documentDetailsScreen.versionSourceDoc.getTagName();
		sourceDocDetails.add(versionIDForDocB);
		return sourceDocDetails;
	}
	

	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
