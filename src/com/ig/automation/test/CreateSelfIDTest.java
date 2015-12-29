package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.CreateRegistrationScreen;
import com.ig.automation.screens.CreateSelfIDScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.test.HomeTest;
import com.ig.automation.utility.Log;


public class CreateSelfIDTest extends CreateSelfIDScreen{

	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			homeTest.testSPLSelfID();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Test the Create SelfID Page of UI 7.0 against the xmL-UI-ADS-025 	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateSelfID() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create SelfID Test Started");
		try{
			initializeMandatoryProperties();
			Assert.assertEquals(createSelfIDPanelTitle.getText(), "Create Self Identification"); //UI-CO-1
			Log.info("UI-CO-1 Passed Successfully");
			Assert.assertEquals(docType.isMultiple(),true);  //UI-CO-2
			Log.info("UI-CO-2 Passed Successfully");
			Assert.assertEquals(createSelfIDBtn.isEnabled(), false); //UI-CO-5
			Log.info("UI-CO-5 Passed Successfully");
			docType.selectByVisibleText("GENERIC DRUG FACILITY IDENTIFICATION SUBMISSION");
			Assert.assertEquals(createSelfIDBtn.isEnabled(), true); //UI-CO-8
			Log.info("UI-CO-8 Passed Successfully");
			Assert.assertEquals(rfaProperties.getAttribute("isOpen"), false); //UI-CO-3
			Log.info("UI-CO-3 Passed Successfully");
			rfaProperties.click();
			initializeRFAProperties();
			registrant.selectByIndex(0);
			Assert.assertEquals(optionalProperties.getAttribute("isOpen"), false); //UI-CO-4
			Log.info("UI-CO-4 Passed Successfully");
			Assert.assertEquals(cancelBtn.isEnabled(), true); //UI-CO-6
			Log.info("UI-CO-6 Passed Successfully");
			optionalProperties.click();
			initializeOptionalProperties();
			title.sendKeys("Test SelfID");
			contactCountry.selectByVisibleText("AUT");
			contactPhone.sendKeys("111111111");
			contactEmail.sendKeys("test@glm.com");
			contactSPL.sendKeys("05-Jan-2015");
			contactName.sendKeys("test SELFID");
			contactStreet.sendKeys("ABC");
			contactCity.sendKeys("ABC");
			contactState.sendKeys("XYZ");
			contactPostal.sendKeys("11234");
			createSelfIDBtn.click();
			Assert.assertEquals(cancelBtn.isDisplayed(), false); //UI-CO-10
			Log.info("UI-CO-10 Passed Successfully");
			initializeMessages();
			Assert.assertTrue(message.getText().contains("Create Self")); // UI-CO-9 , 11
			Log.info("UI-CO-9 and 11 Passed Successfully");
			String successMessage = message.getText(); 
			String  DocID = successMessage.substring(29, 36); 
			writeCSV(DocID);
			Reporter.log("xmL-UI-ADS-025.doc Create SelfID tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc Create SelfID tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Create SelfID Test Ended");
	}

		
	/**
	 * Test the Cancel SelfID  Page of UI 7.0 against the xmL-UI-ADS-025 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelSelfID() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Cancel Create SelfID Test Started");
		try{
			homeTest.createNewSelfID.click();
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
		Log.endTestCase("Cancel Create SelfID Test Ended");
		
	}
		
	public List<String> doCreateSelfID(String DocType, String Registrant, String Title, String Country,String Phone,String Email,String Name, String Street, String City ,String State ,String Postal ) throws Exception {
		List<String> itemsToAdd = new ArrayList<String>();
		try{
			
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			Thread.sleep (2000);
			
			homeTest.initializeActionObjects();
			homeTest.spl.click();
			Thread.sleep (2000);
			
			homeTest.initializeCreateNewSelfIdentification();
			homeTest.createNewSelfID.click();
			Thread.sleep (2000);
		
			initializeMandatoryProperties();
			docType.selectByVisibleText(DocType);
			String docType1 = docType.getFirstSelectedOption().getText();
			
			Thread.sleep (2000);
			rfaProperties.click();
			Thread.sleep (2000);
			
			initializeRFAProperties();
			registrant.selectByValue(Registrant);
			String registrant1 = registrant.getFirstSelectedOption().getText();
			
			Thread.sleep (2000);
			optionalProperties.click();
			initializeOptionalProperties();
			title.sendKeys(Title);
			String title1 = title.getText();
			
			contactCountry.selectByVisibleText(Country);
			String contactCountry1 = contactCountry.getFirstSelectedOption().getText();
			
			contactPhone.sendKeys(Phone);
			String contactPhone1 = contactPhone.getText();
			
			contactEmail.sendKeys(Email);
			String contactEmail1 = contactEmail.getText();

			contactSPL.click();
			contactSPL.clear();
			contactSPL.sendKeys(getFutureDate(1));
			
			contactName.sendKeys(Name);
			String contactName1 = contactName.getText();

			contactStreet.sendKeys(Street);
			String contactStreet1 = contactStreet.getText();

			contactCity.sendKeys(City);
			String contactCity1 = contactCity.getText();

			contactState.sendKeys(State);
			String contactState1 = contactState.getText();

			contactPostal.sendKeys(Postal);
			String contactPostal1 = contactPostal.getText();
			
			itemsToAdd.add(docType1);
			itemsToAdd.add(registrant1);
			itemsToAdd.add(title1);
			itemsToAdd.add(contactCountry1);
			itemsToAdd.add(contactPhone1);
			itemsToAdd.add(contactEmail1);
			itemsToAdd.add(contactName1);
			itemsToAdd.add(contactStreet1);
			itemsToAdd.add(contactCity1);
			itemsToAdd.add(contactState1);
			itemsToAdd.add(contactPostal1);
			
			
			
			createSelfIDBtn.click();
			Thread.sleep (6000);
			initializeMessages();
			/*String successMessage = message.getText(); 
			String  DocID = successMessage.substring("", 36); 
			writeCSV(DocID);*/		
			
			String successMessage = message.getText();
			String[] successMsg=successMessage.split(" ", 4);
			String DocID=successMsg[2];
			writeCSV(DocID);
			itemsToAdd.add(DocID);
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc Create SelfID tested unsuccessfully");	
			Assert.fail();
		}
			
		return itemsToAdd;
		
	}
	

	
	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
