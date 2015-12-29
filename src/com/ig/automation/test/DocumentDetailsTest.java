package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CreateDocScreen;
import com.ig.automation.screens.DocumentDetailsScreen;
import com.ig.automation.utility.Log;
import com.sun.jna.StringArray;


//	xmL-UI-ADS-006.doc
public class DocumentDetailsTest extends DocumentDetailsScreen {

	
	public WebElement auditTrailtab;
	private String[] propVal;
	


	/**
	 * Test the Create Document feature of UI 7.0 against the Requirement ID R-CN-1
	 * @throws InterruptedException 
	 * 
	 * @throws Exception If an error occurs.
	 */

	
	
	public void doDocumentDetails() throws InterruptedException {
		// try{

		initializePropertie();
		properties.click();
		initializeTypeofDoc();
		Assert.assertEquals(typeofDoc.getText(),"ESTABLISHMENT REGISTRATION");
		initializeEditLink();
		editLink.click();
		initializeDraftState();
		Assert.assertTrue(draftState.getText().contains("Draft"), "Document is in Draft State");
		initializerfaLink();
		rfalink.click();
		Thread.sleep(2000);
		initializeRegistrant();
		registrant.selectByIndex(1);
		initializeOptional();
		optional.click();
		initializeEffectiveDate();
		effectiveDate.sendKeys("12-Mar-2015");
		initializeSaveBtn();
		saveBtn.click();
		initializeAuditTrail();
		auditTrail.click();
		//TODO - GLM-1356 
		initializeAuditTrailEvent();
		Assert.assertTrue(auditTrailEvent.getText().contains("Edit Properties"), "Audit Trail is correctly recorded for the Edit Properties events");
		//TODO- GLM-1357
		
		
			
		
			/*}
			catch(Throwable t)
			{
				
				Log.info(t.getMessage());
			
				
			}*/
			
		}
	
	public List<String>  doDocumentDetailsAuditTrail()  {
		
		initializeAuditTrail();
		auditTrail.click();
		initializeAuditTrailEvent();
		String event= auditTrailEvent.getText();
		initializeUserName();
		String userNameValue = userName.getText();
		initializeVersion();
		String versionValue = version.getText();
		initializeDate();
		String dateValue = date.getText();
		initializeComment();
		String commentValue = comment.getText();
		initializeProperties();
		String propertiesValue = properties.getText();
		propVal = propertiesValue.split(" ", 2);
		String haResponse= propVal[0];
		String haResponseDate= propVal[1];
		List<String> itemsToAdd = new ArrayList<String>();
		itemsToAdd.add(event);
		itemsToAdd.add(userNameValue);
		itemsToAdd.add(versionValue);
		itemsToAdd.add(dateValue);
		itemsToAdd.add(commentValue);
		itemsToAdd.add(propertiesValue);
		itemsToAdd.add(haResponse);
		itemsToAdd.add(haResponseDate);
		return itemsToAdd;
	}
	
public List<String>  doDocumentDetailsEstablishments()  {
		
		initializeEstablishments();
		establishments.click();
		initializeLinkEstablishment();
		linkEstablishment.click();
		initializeSearchTab();
		searchTab.click();
		//TODO - GLM-1425 Not able to search any document from search tab from Search for Establishments
		initializeAuditTrailEvent();
		String event= auditTrailEvent.getText();
		initializeUserName();
		String userNameValue = userName.getText();
		initializeVersion();
		String versionValue = version.getText();
		initializeDate();
		String dateValue = date.getText();
		initializeComment();
		String commentValue = comment.getText();
		initializeProperties();
		String propertiesValue = properties.getText();
		propVal = propertiesValue.split(" ", 2);
		String haResponse= propVal[0];
		String haResponseDate= propVal[1];
		List<String> itemsToAdd = new ArrayList<String>();
		itemsToAdd.add(event);
		itemsToAdd.add(userNameValue);
		itemsToAdd.add(versionValue);
		itemsToAdd.add(dateValue);
		itemsToAdd.add(commentValue);
		itemsToAdd.add(propertiesValue);
		itemsToAdd.add(haResponse);
		itemsToAdd.add(haResponseDate);
		return itemsToAdd;
	}




	// @AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
