package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.CreateEstablishmentScreen;
import com.ig.automation.screens.CreateNDCScreen;
import com.ig.automation.screens.CreateRegistrationScreen;
import com.ig.automation.screens.CreateSelfIDScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.utility.Log;


public class CreateEstablishmentTest extends CreateEstablishmentScreen{

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
	 * Test the Create Establishment Page of UI 7.0 against the xmL-UI-ADS-025 	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateEstablishment() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Establishment Test Started");
		try{
			String docID=getDocID("USPI");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeEstbTab();
			estbTab.click();
			initializeCreateEstbLink();
			createEstbLink.click();
			initializeMandatoryProperties();
			Assert.assertEquals(createEstbPanelTitle.getText(), "Create Establishment"); //UI-CO-1
			Log.info("UI-CO-1 Passed Successfully");
			Assert.assertEquals(estbName.isEnabled(),true);  //UI-CO-2
			Log.info("UI-CO-2 Passed Successfully");
			Assert.assertEquals(createEstbBtn.isEnabled(), false); //UI-CO-5
			Log.info("UI-CO-5 Passed Successfully");
			estbName.sendKeys("Test Estb");;
			Assert.assertEquals(createEstbBtn.isEnabled(), true); //UI-CO-8
			Log.info("UI-CO-8 Passed Successfully");
			Assert.assertEquals(optionalProperties.getAttribute("isOpen"), false); //UI-CO-4
			Log.info("UI-CO-4 Passed Successfully");
			Assert.assertEquals(cancelBtn.isEnabled(), true); //UI-CO-6
			Log.info("UI-CO-6 Passed Successfully");
			optionalProperties.click();
			initializeOptionalProperties();
			confidential.click();
			contactName.sendKeys("test NDC");
			contactStreet.sendKeys("ABC");
			contactCity.sendKeys("ABC");
			contactState.sendKeys("XYZ");
			contactPostal.sendKeys("11234");
			contactCountry.selectByVisibleText("AUT");
			contactPhone.sendKeys("111111111");
			contactEmail.sendKeys("test@glm.com");
			typeOperation.sendKeys("Business");
			selfidOperation.sendKeys("Slef id");
			usAgent.sendKeys("test1");
			importer.sendKeys("test2");
			dunsno.sendKeys("123");
			regno.sendKeys("456");
			street.sendKeys("abc");
			city.sendKeys("xyz");
			state.sendKeys("sed");
			postal.sendKeys("12345");
			country.selectByVisibleText("AUT");
			title.sendKeys("Test NDC");
			createEstbBtn.click();
			Assert.assertEquals(cancelBtn.isDisplayed(), false); //UI-CO-10
			Log.info("UI-CO-10 Passed Successfully");
			initializeMessages();
			Assert.assertTrue(message.getText().contains("Create Establishment")); // UI-CO-9 , 11
			Log.info("UI-CO-9 and 11 Passed Successfully");
			String successMessage = message.getText(); 
			String  DocID = successMessage.substring(29, 36); 
			writeCSV(DocID);
			Reporter.log("xmL-UI-ADS-025.doc Create Establishment tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc Create Establishment tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Create Establishment Test Ended");
	}

		
	/**
	 * Test the Cancel Establishment  Page of UI 7.0 against the xmL-UI-ADS-025 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelEstb() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Cancel Create Establishment Test Started");
		try{
			String docID=getDocID("USPI");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeEstbTab();
			estbTab.click();
			initializeCreateEstbLink();
			createEstbLink.click();
			initializeMandatoryProperties();
			cancelBtn.click();  // UI-CO-12
			Assert.assertEquals(cancelBtn.isDisplayed(), false); //UI-CO-12
			Log.info("UI-CO-12 Passed Successfully");
			Reporter.log("xmL-UI-ADS-025.doc tested successfully for Cancel");
			}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc tested unsuccessfully for Cancel");
			Assert.fail();
		}
		Log.endTestCase("Cancel Create Establishment Test Ended");

	}
	
public String getDocID(String doctype) throws Exception {
		
		List<String[]> list=readCSV();
		for(String[] str: list) {
		    for(String doc: str){
		    	if(doc.contains(doctype))
		    		return doc.toString();
		    } 
		}
	    return null;
	}

public String doCreateEstablishment(String docID) throws Exception{
	
	try{
		
		initializeSearch();
		searchDoc.click();
		initializeBasicSearch();
		basicSearch.click();
		initializeDocIDSearch();
		Thread.sleep(2000);
		docIDSearchdropdown.selectByVisibleText("=");
		enterDocIDbox.clear();
		enterDocIDbox.sendKeys(docID);
		Thread.sleep(3000);
		searchButton.click();
		Thread.sleep(3000);
		initializeDocument();
		filterDocID.click();
		initializeEstbTab();
		estbTab.click();
		initializeCreateEstbLink();
		createEstbLink.click();
		initializeMandatoryProperties();
		estbName.sendKeys("Test Estb");		
		optionalProperties.click();
		Thread.sleep(2000);
		initializeOptionalProperties();
		confidential.click();
		contactName.sendKeys("test NDC");
		contactStreet.sendKeys("ABC");
		contactCity.sendKeys("ABC");
		contactState.sendKeys("XYZ");
		contactPostal.sendKeys("11234");
		contactCountry.selectByVisibleText("AUT");
		contactPhone.sendKeys("111111111");
		contactEmail.sendKeys("test@glm.com");
		typeOperation.sendKeys("Business");
		selfidOperation.sendKeys("Slef id");
		//usAgent.sendKeys("test1");
		//importer.sendKeys("test2");
		dunsno.sendKeys("123456789");
		regno.sendKeys("456");
		street.sendKeys("abc");
		city.sendKeys("xyz");
		state.sendKeys("sed");
		postal.sendKeys("12345");
		country.selectByVisibleText("AUT");
		title.sendKeys("Test NDC");
		createEstbBtn.click();
		
		initializeMessages();
		
		String successMessage = message.getText(); 
		String  DocID = successMessage.substring(29, 36); 
		//writeCSV(DocID);
		return DocID;
		//return("Establishment Documnet id Created Successfully");
	}
	catch(Throwable e){
		Log.info(e.getMessage());
		
		Assert.fail();
		return ("Establishment document created failed");
	}
		
}
	
	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
