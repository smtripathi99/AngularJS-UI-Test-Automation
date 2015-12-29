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
import com.ig.automation.screens.CreateNDCScreen;
import com.ig.automation.screens.CreateRegistrationScreen;
import com.ig.automation.screens.CreateSelfIDScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.utility.Log;


public class CreateNDCTest extends CreateNDCScreen{

	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			homeTest.testSPLNDC();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Test the Create NDC Page of UI 7.0 against the xmL-UI-ADS-025 	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateSelfID() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create NDC Test Started");
		try{
			initializeMandatoryProperties();
			Assert.assertEquals(createNDCPanelTitle.getText(), "Create NDC"); //UI-CO-1
			Log.info("UI-CO-1 Passed Successfully");
			Assert.assertEquals(docType.isMultiple(),true);  //UI-CO-2
			Log.info("UI-CO-2 Passed Successfully");
			Assert.assertEquals(createNDCBtn.isEnabled(), false); //UI-CO-5
			Log.info("UI-CO-5 Passed Successfully");
			docType.selectByVisibleText("NDC/NHRIC Laberer Code Request");
			Assert.assertEquals(createNDCBtn.isEnabled(), true); //UI-CO-8
			Log.info("UI-CO-8 Passed Successfully");
			labeler.selectByIndex(0);
			Assert.assertEquals(optionalProperties.getAttribute("isOpen"), false); //UI-CO-4
			Log.info("UI-CO-4 Passed Successfully");
			Assert.assertEquals(cancelBtn.isEnabled(), true); //UI-CO-6
			Log.info("UI-CO-6 Passed Successfully");
			optionalProperties.click();
			initializeOptionalProperties();
			title.sendKeys("Test NDC");
			contactCountry.selectByVisibleText("AUT");
			contactPhone.sendKeys("111111111");
			contactEmail.sendKeys("test@glm.com");
			contactSPL.sendKeys("05-Jan-2015");
			contactName.sendKeys("test NDC");
			contactStreet.sendKeys("ABC");
			contactCity.sendKeys("ABC");
			contactState.sendKeys("XYZ");
			contactPostal.sendKeys("11234");
			createNDCBtn.click();
			Assert.assertEquals(cancelBtn.isDisplayed(), false); //UI-CO-10
			Log.info("UI-CO-10 Passed Successfully");
			initializeMessages();
			Assert.assertTrue(message.getText().contains("Create NDC")); // UI-CO-9 , 11
			Log.info("UI-CO-9 and 11 Passed Successfully");
			String successMessage = message.getText(); 
			String  DocID = successMessage.substring(29, 36); 
			writeCSV(DocID);
			Reporter.log("xmL-UI-ADS-025.doc Create NDC tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc Create NDC tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Create NDC Test Ended");
	}

		
	/**
	 * Test the Cancel NDC  Page of UI 7.0 against the xmL-UI-ADS-025 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelSelfID() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Cancel Create NDC Test Started");
		try{
			homeTest.createNewNDC.click();
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
		Log.endTestCase("Cancel Create NDC Test Ended");

	}
	public List<String> doCreateNDC(String screenshotFolderName , String docTypeValue , String labelerValue) throws Exception{
		List<String> selectedValuesForNDC = new ArrayList<String>();
		initializeMandatoryProperties();
		String title = createNDCPanelTitle.getText();
		selectedValuesForNDC.add(title);
		
		if(docTypeValue!="" || docTypeValue == null)
			docType.selectByVisibleText(docTypeValue);
		Thread.sleep(2000);
		String selectedDocType= docType.getFirstSelectedOption().getText();
		selectedValuesForNDC.add(selectedDocType);
		if(labelerValue!="" || labelerValue == null)
			labeler.selectByVisibleText(labelerValue);
		String selectedLabeler= labeler.getFirstSelectedOption().getText();
		selectedValuesForNDC.add(selectedLabeler);
		initializeOptionalProperties();
		createNDCBtn.click();
		initializeMessages();
		String successMessage = message.getText(); 	//Created successfully 
		getScreenShot(screenshotFolderName, "CreateNDCScreen");
		docLink.click();
		String[] successMsg=successMessage.split(" ", 4);
		String docID=successMsg[2];
		selectedValuesForNDC.add(docID);
		/*contactCountry.selectByVisibleText("AUT");
		contactPhone.sendKeys("9856325896");
		contactEmail.sendKeys("a@aq.com");
		contactName.sendKeys("Test");
		contactStreet.sendKeys("MGR");
		contactCity.sendKeys("CA");
		contactSPL.click();*/
		return selectedValuesForNDC;
	}
	

	
	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
