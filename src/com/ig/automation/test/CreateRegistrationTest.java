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
import com.ig.automation.screens.CreateRegistrationScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.utility.Log;


public class CreateRegistrationTest extends CreateRegistrationScreen{

	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			homeTest.testSPLReg();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Test the Create Registration Page of UI 7.0 against the xmL-UI-ADS-025 	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateRegistration() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Registration Test Started");
		try{
			initializeMandatoryProperties();
			Assert.assertEquals(createRegPanelTitle.getText(), "Create New Registration"); //UI-CO-1
			Log.info("UI-CO-1 Passed Successfully");
			Assert.assertEquals(docType.isMultiple(),true);  //UI-CO-2
			Log.info("UI-CO-2 Passed Successfully");
			Assert.assertEquals(createRegBtn.isEnabled(), false); //UI-CO-5
			Log.info("UI-CO-5 Passed Successfully");
			docType.selectByVisibleText("ESTABLISHMENT REGISTRATION");
			Assert.assertEquals(createRegBtn.isEnabled(), true); //UI-CO-8
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
			title.sendKeys("Test Reg");
			contactCountry.selectByVisibleText("AUT");
			contactPhone.sendKeys("111111111");
			contactEmail.sendKeys("test@glm.com");
			contactSPL.sendKeys("05-Jan-2015");
			contactName.sendKeys("test reg");
			contactStreet.sendKeys("ABC");
			contactCity.sendKeys("ABC");
			contactState.sendKeys("XYZ");
			contactPostal.sendKeys("11234");
			createRegBtn.click();
			Assert.assertEquals(cancelBtn.isDisplayed(), false); //UI-CO-10
			Log.info("UI-CO-10 Passed Successfully");
			initializeMessages();
			Assert.assertTrue(message.getText().contains("Create Registration")); // UI-CO-9 , 11
			Log.info("UI-CO-9 and 11 Passed Successfully");
			String successMessage = message.getText(); 
			String  DocID = successMessage.substring(29, 36); 
			writeCSV(DocID);
			Reporter.log("xmL-UI-ADS-025.doc Create Registration tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc Create Registration tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Create Registration Test Ended");
	}

		
	/**
	 * Test the Cancel Reg  Page of UI 7.0 against the xmL-UI-ADS-025 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelReg() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Cancel Create CR Test Started");
		try{
			homeTest.createNewRegistration.click();
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
		Log.endTestCase("Cancel Create Registration Test Ended");

	}

	public String doCreateRegistration() throws Exception{
		try {

			initializeMandatoryProperties();
			docType.selectByVisibleText("ESTABLISHMENT REGISTRATION");
			rfaProperties.click();
			initializeRFAProperties();
			registrant.selectByIndex(0);
			optionalProperties.click();
			initializeOptionalProperties();
			title.sendKeys("Test Reg");
			contactCountry.selectByVisibleText("AUT");
			contactPhone.sendKeys("111111111");
			contactEmail.sendKeys("test@glm.com");
			contactSPL.sendKeys("05-Jan-2015");
			contactName.sendKeys("test reg");
			contactStreet.sendKeys("ABC");
			contactCity.sendKeys("ABC");
			contactState.sendKeys("XYZ");
			contactPostal.sendKeys("11234");
			createRegBtn.click();
			initializeMessages();
			String successMessage = message.getText();
			//String DocID = successMessage.substring(29, 36);
			docLink.click();
			String[] successMsg=successMessage.split(" ", 4);
			String DocID=successMsg[2];
			//writeCSV(DocID);
			return DocID;
		} catch (Throwable e) {
			Log.info(e.getMessage());
			
			return ("xmL-UI-ADS-025.doc Create Registration tested unsuccessfully");
		}
		
	}

	

	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
