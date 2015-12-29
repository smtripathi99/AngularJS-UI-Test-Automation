package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.utility.Log;


public class EditPropertiesTest extends EditPropertiesScreen{

	HomeTest homeTest = new HomeTest();
	LoginTest loginTest = new LoginTest();
	CreateDocumentTest cdTest=new CreateDocumentTest();

	
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
	 * Test the Properties  Page of UI 7.0 against the xmL-UI-ADS-009 Document Properties for Annex II	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testAnnexIIEditProperties() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Properties Test for Annex Started");
		try{
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			cdTest.inilializeObjectsDocType("role_eu_labeling_author");
			cdTest.annexType.click();
			Thread.sleep(1000);
			String docID=cdTest.doCreateDocument("Annex II", "AnnexII 009", "Austria", "English", "Alkaline Aqua", "ALLERSOLV", "", "");
			Thread.sleep(2000);
			initializePropertiesTab();
			propertiesTab.click();
			initializeEdit(docID);
			//existOptional.click();
			edit.click();
			initializeEditMandatory(docID);
			//Assert.assertTrue(editPropertyLabel.isDisplayed());			
			//Log.info("UA-EP-1 Passed");
			Assert.assertTrue(docHeader.getText().contains(docID),"Document ID is displayed");		
			Log.info("UA-EP-1 Passed");
			Assert.assertTrue(docHeader.getText().contains("Status"),"Status is displayed");		
			Log.info("UA-EP-2 Passed");
			Assert.assertTrue(docHeader.getText().contains("Version"),"Version is displayed");		
			Log.info("UA-EP-3 Passed");			
			Assert.assertTrue(docHeader.getText().contains("Language"),"Language is displayed");						
			Log.info("UA-EP-4 Passed");
			Assert.assertTrue(docHeader.getText().contains("Countr"),"Country is displayed");					 
			Log.info("UA-EP-5 Passed");
			Assert.assertTrue(docHeader.getText().contains("Title"),"Title is displayed");					 
			Log.info("UA-EP-6 Passed");
			Assert.assertTrue(mandatory.getText().contains("Hide"),"Mandatory section is displayed and open");					 
			Log.info("UA-EP-8 Passed");
			Assert.assertTrue(optional.getText().contains("Show"),"Optional section is displayed and collapsed");					 
			Log.info("UA-EP-12 Passed");
			Assert.assertTrue(!doneButton.isDisplayed(),"Save button is hidden");					 
			Log.info("UA-EP-14 Passed");
			Assert.assertTrue(doneButton.isEnabled(),"Save button is enabled");					 
			Log.info("UA-EP-15 Passed");
			Assert.assertTrue(cancelButton.isEnabled(),"Cancel button is enabled");					 
			Log.info("UA-EP-16 Passed");
			cancelButton.click(); 
			Assert.assertTrue(existTitle.isDisplayed(),"Close the Property Panel");					 
			Log.info("UA-EP-21 Passed");
			edit.click();
			title.clear();
			title.sendKeys("edit annex");
			country.sendKeys("AUSTRIA");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByVisibleText("German");
			properietary.clear();
			properietary.sendKeys("SALT WATER");
			properietary.sendKeys(Keys.ARROW_DOWN);
			properietary.sendKeys(Keys.ENTER);
			optional.click();
			initializeEditOptional(docID);
			legalStatus.clear();
			legalStatus.sendKeys("with-prescription");
			legalStatus.sendKeys(Keys.ARROW_DOWN);
			legalStatus.sendKeys(Keys.ENTER);
			author.sendKeys("test");
			notifrecipient.clear();
			notifrecipient.sendKeys("CDS AUTHOR 01");
			notifrecipient.sendKeys(Keys.ARROW_DOWN);
			notifrecipient.sendKeys(Keys.ENTER);
			addDescription.sendKeys("test");
			comments.sendKeys("test");
			reasonforRevision.selectByVisibleText("Other");
			manufactureActive.sendKeys("test");
			manufactureBatch.sendKeys("test");
			registrationProcedure.selectByVisibleText("Centralised");
			submissionType.selectByVisibleText("Renewal");
			doneButton.click();
			Assert.assertTrue(existTitle.isDisplayed(),"Close the Property Panel");					 
			Log.info("UA-EP-18 Passed");
			cdTest.initializeMessages();
			Assert.assertTrue(cdTest.message.getText().contains("Properties successfully saved"),"Document proerty is saved");					 
			Log.info("UA-EP-20 Passed");
			initializeExistingOptional(docID);
			Assert.assertTrue(existTitle.getText().contains("edit"),"Refresh the listing screen");					 
			Log.info("UA-EP-19 Passed");
			Reporter.log("xmL-UI-ADS-009.doc Document Properties tested successfully for Annex");
			Log.endTestCase("Properties Test for Annex Ended");

		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-009.doc Document Properties tested unsuccessfully for Annex");	
			//Assert.fail();
		}
	}

	/**
	 * Test the Properties  Page of UI 7.0 against the xmL-UI-ADS-009 Document Properties for USPI	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testUSPIEditProperties() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Properties Test for USPI Started");
		try{
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			cdTest.inilializeObjectsDocType();
			cdTest.uspi.click();
			Thread.sleep(1000);
			String docID=cdTest.doCreateDocument("US Package Insert", "USPI 009", "European Union", "English", "", "ALLERSOLV", "OTC MEDICAL DEVICE", "Alkaline Aqua");
			Thread.sleep(2000);
			initializePropertiesTab();
			propertiesTab.click();
			initializeEdit(docID);
			existOptional.click();
			edit.click();
			initializeEditMandatory(docID);
			existRFAProperties.click();
			Assert.assertTrue(existRFAProperties.getText().contains("Hide"),"RFA section is displayed and open");					 
			Log.info("UA-EP-10 Passed");
			title.clear();
			title.sendKeys("edit uspi");
			country.sendKeys("AUSTRIA");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByVisibleText("German");
			properietary.sendKeys("SALT WATER");
			properietary.sendKeys(Keys.ARROW_DOWN);
			properietary.sendKeys(Keys.ENTER);
			genericName.sendKeys("Diromax Citrate");
			genericName.sendKeys(Keys.ARROW_DOWN);
			genericName.sendKeys(Keys.ENTER);
			code.selectByVisibleText("Cosmetic");
			splFormat.selectByVisibleText("PLR");
			splEffective.selectByVisibleText("=");
			splDate.sendKeys("04-Dec-2014");
			optional.click();
			initializeEditOptional(docID);
			addDescription.sendKeys("test");
			reasonforRevision.selectByVisibleText("Other");
			splReldoc.sendKeys("test");
			doneButton.click();
			initializeExistingOptional(docID);
			Assert.assertTrue(successMessage.isDisplayed());					//UA-EP-16
			Reporter.log("xmL-UI-ADS-009.doc Document Properties tested successfully for USPI");
			Log.endTestCase("Properties Test for USPI Ended");

		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-009.doc Document Properties tested unsuccessfully for USPI");
			//Assert.fail();
		}

	}
	
	
	
	public List<String> doEditESTPropertiesTest(String estName,String estContactName,String estContactStreet,String estContactCity,String estContactState,String estContactPostal,String estContactPhone,String estContactEmail,String estTitle, String estDunsNumber,String extRegNumber,String extStreet,String extCity,String extState,String extPostal) 
			throws Exception {
		try {
			
			String docID = getDocID("EST");
			
			initializeEdit(docID);
			edit.click();
			Thread.sleep(2000);
			initializeMandatoryProperties();
			estbName.clear();
			estbName.sendKeys(estName);
			String estName1 = estbName.getText();
			optionalProperties.click();
			Thread.sleep(2000);
			
			initializeOptionalProperties();
			contactName.clear();
			contactName.sendKeys(estContactName);
			String contactName1 = contactName.getText();
			
			contactStreet.clear();
			contactStreet.sendKeys(estContactStreet);
			String contactStreet1 = contactStreet.getText();
			
			contactCity.clear();
			contactCity.sendKeys(estContactCity);
			String contactCity1 = contactCity.getText();

			contactState.clear();
			contactState.sendKeys(estContactState);
			String contactState1 = contactState.getText();

			contactPostal.clear();
			contactPostal.sendKeys(estContactPostal);
			String contactPostal1 = contactPostal.getText();

			Thread.sleep(2000);
			contactCountry.selectByIndex(6);
			Thread.sleep(2000);
			
			contactPhone.clear();
			contactPhone.sendKeys(estContactPhone);
			String contactPhone1 = contactPhone.getText();
			
			contactEmail.clear();
			contactEmail.sendKeys(estContactEmail);
			String contactEmail1= contactEmail.getText();
			
			title.clear();
			title.sendKeys(estTitle);
			String title1 = title.getText();
			
			dunsno.clear();
			dunsno.sendKeys(estDunsNumber);
			String dunsno1 = dunsno.getText();

			regno.clear();
			regno.sendKeys(extRegNumber);
			String regno1 = regno.getText();

			street.clear();
			street.sendKeys(extStreet);
			String street1 = street.getText();

			city.clear();
			city.sendKeys(extCity);
			String city1 = city.getText();

			state.clear();
			state.sendKeys(extState);
			String state1 = state.getText();
	
			postal.clear();
			postal.sendKeys(extPostal);
			String postal1 = postal.getText();

			Thread.sleep(2000);
			countryDropDown.selectByIndex(6);
			Thread.sleep(2000);
			
			saveBtn.click();
			
			List<String> itemsToGet = new ArrayList<String>();
			itemsToGet.add(estName1);
			itemsToGet.add(contactName1);
			itemsToGet.add(contactStreet1);
			itemsToGet.add(contactCity1);
			itemsToGet.add(contactState1);
			itemsToGet.add(contactPostal1);
			itemsToGet.add(contactPhone1);
			itemsToGet.add(contactEmail1);
			itemsToGet.add(title1);
			itemsToGet.add(dunsno1);
			itemsToGet.add(regno1);
			itemsToGet.add(street1);
			itemsToGet.add(city1);
			itemsToGet.add(state1);
			itemsToGet.add(postal1);
			return itemsToGet;

			
		}
			
			// TODO for Verification message
	
	
		catch(Throwable e){
			Log.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		return null;
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
	
	
	
	/*public void doEditTest(){
		try {
			try {
				checkinScreen.initializeActionMenu();
				checkinScreen.editMenu.click();
				checkinScreen.initializeEdit();
				checkinScreen.edit.click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			searchDocument(documentB);
			try {
				findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[1]/div/div/i[2]")).click();
			} catch (Exception e) {
			}
			Log.info("SR-EV-1 - Document is edited.");
			checkinScreen.initializeCheckinPanel();
			checkinScreen.reasonRevision.selectByVisibleText("Health Authority Request");
			String comment ="Check In Document";
			checkinScreen.comments.sendKeys(comment);
			Log.info("Comment Entered Is : " + comment);
			getScreenShot("ST_026", "SR-EV-18");
			Log.info("SR-EV-18 - Document is checked in as a new minor version."); //16
			checkinScreen.doneBtn.click();
			
		//	validate msg
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

	@AfterClass
	public void tearDown() throws Exception{
		homeTest.initializeTopNavigationObjects(false);
		homeTest.logOff.click();
		driver.close();
		driver.quit();
		System.out.println("Properties screen is tested.");	
	}
}
