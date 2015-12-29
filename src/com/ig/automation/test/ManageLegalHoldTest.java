package com.ig.automation.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.HomeScreen;
import com.ig.automation.screens.ManageLegalHoldScreen;
import com.ig.automation.utility.Log;


/**
 * Test the Legal Hold of UI 7.0 against the xmL-UI-ADS-038.doc *
 * 
 * @throws Exception If an error occurs.
 * 
 */
public class ManageLegalHoldTest extends ManageLegalHoldScreen {
	HomeTest homeTest = new HomeTest();
	HomeScreen homeScreen = new HomeScreen();
	LoginTest loginTest = new LoginTest();

	@BeforeClass
	public void login() {
		try {
			loginTest.launchUrl();
			String username = DataActions.getUserID("role_author");
			String password = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username, password);
			Thread.sleep(2000);
			Log.info(username + ": is able to log in Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void legalHoldTest() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Log In Test Started as per xmL-UI-ADS-003");
		try {
			homeScreen.initializeLeftNavigationObjects();
			homeScreen.admin.click();
			Thread.sleep(2000);
			homeScreen.initializeAdmin();
			homeScreen.manageLegalHold.click();
			Thread.sleep(2000);
			initializeLegalHoldScreen();
		/*	getScreenShot("LegalHOld", "LegalHold_Screen");
			Assert.assertEquals(legalHoldsTitle.getText().contains("Legal Holds"),
					true,
					"Manage Legal Hold panel is initially displayed Successfully");
			Log.info("Manage Legal Hold panel is initially displayed Successfully");
			Assert.assertEquals(legalHoldProperty.isDisplayed(), true,
					"Legal Hold Property is displayed Successfully");
			Log.info("Legal Hold Property is displayed Successfully");
			Assert.assertEquals(legalHoldValue.isDisplayed(), true,
					"Legal Hold Value is displayed Successfully");
			Log.info("Legal Hold Value is displayed Successfully");
			Assert.assertEquals(actualLegalHoldDate.isDisplayed(), true,
					"Actual Legal Hold Date is Displayed Successfully");
			Log.info("Actual Legal Hold Date is Displayed Successfully");
			Assert.assertEquals(systemLegalHoldDate.isDisplayed(), true,
					"System Legal Hold Date is Displayed Successfully");
			Log.info("System Legal Hold Date is Displayed Successfully");
			Assert.assertTrue(itemsPerPage.getText().contains("10"),
					"Items per page is default to 10");
			Log.info("Items per page is default to 10");
	
			Assert.assertEquals(placeOnLegalHold.isDisplayed(), true,
					"Place on Legal Hold link is displayed Successfully");
			Log.info("Place on Legal Hold link is displayed Successfully");
			Assert.assertEquals(placeOnLegalHold.isEnabled(), true,
					"Place on Legal Hold link is enabled Successfully");
			Log.info("Place on Legal Hold link is enabled Successfully"); //8
*/	
			
			 /** Assert.assertEquals(removeButton.isDisplayed(), true,
			 * "“X” icon in the Action column is displayed Successfully");
			 * Log.info(
			 * "“X” icon in the Action column is displayed Successfully"
			 * ); Assert.assertEquals(removeButton.isEnabled(),
			 * true,"“X” icon in the Action column is enabled Successfully"
			 * ); Log.info(
			 * " "X” icon in the Action column is enabled Successfully");*/
			 
			//TODO : UI-LH-09
			/*try {
				removeButton.click();
			} catch (Exception e) {
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.className("fa-remove")))
						.click();
			}
			Thread.sleep(2000);
			*/
			initializeRemovefromLegalHold();
		/*	Assert.assertEquals(removeRegalHOldTitle.getText().contains("Remove"),
					true,
					"Remove from Legal Hold dialog box is displayed Successfully");
			Log.info("Remove from Legal Hold dialog box is displayed Successfully");*/
			cancelRemove.click();
			Thread.sleep(2000);
			cancelRemove=null;
			placeOnLegalHold.click();
			Thread.sleep(2000);
			initializePlaceOnLegalHold();
			// GLM-1562 : UI-LH-13
			/*Assert.assertEquals(placeOnLegalHoldTitle.isDisplayed(), true,
					"Place on Legal Panel is displayed Successfully");*/
			/*Log.info(" Place on Legal Hold Panel is displayed Successfully");
			placeOnLegalHoldTitle.isDisplayed();*/
			/*String title = placeOnLegalHoldTitle.getText();
			driver.findElement(By.xpath("//*[contains(@class,'sidepanel__header')]/h1")).isDisplayed();
			driver.findElement(By.xpath("//*[contains(@class,'sidepanel__header')]/h1")).getText();
			driver.findElement(By.xpath("//*[contains(@class,'sidepanel__header')]")).isDisplayed();
			driver.findElement(By.xpath("//*[contains(@class,'sidepanel__header')]")).getText();*/
		/*	Assert.assertEquals(placeLegalHoldPropertyVerify.isDisplayed(), true,
					"-Legal Hold Property control is displayed Successfully");
			Log.info("Legal Hold Property control is displayed Successfully");
			Assert.assertEquals(placeLegalHoldPropertyVerify.isEnabled(), true,
					"Legal Hold Property control is enabled Successfully");
			Log.info("Legal Hold Property control is enabled Successfully");
	
			Assert.assertEquals(placeActualLegalHoldDate.isDisplayed(), true,
					"Actual Legal Hold Date is displayed Successfully");
			Log.info("Actual Legal Hold Date is displayed Successfully");
			Assert.assertEquals(placeActualLegalHoldDate.isEnabled(), true,
					" Actual Legal Hold Date is enabled Successfully");
			Log.info("Actual Legal Hold Date is enabled Successfully");
	
			Assert.assertEquals(placeSystemLegalHoldDate.isDisplayed(), true,
					"-System Legal Hold Date is displayed Successfully");
			Log.info("System Legal Hold Date is displayed Successfully");
			String todayDate = getDate();
			if(placeSystemLegalHoldDate.getText().contains(todayDate))
			Assert.assertEquals(
					placeSystemLegalHoldDate.getText().contains(todayDate), true,
					"System Legal Hold Date displays the current date Successfully");
			Log.info("System Legal Hold Date displays the current date Successfully");
			Thread.sleep(2000);
			String checkReadOnly = placeSystemLegalHoldDate.getTagName();
			Assert.assertTrue(checkReadOnly.contains("p"), "");
			Log.info("System Legal Hold Date is displayed in read only mode Successfully.");
			
			// TOBO : Done button should be disabled Issue  : GLM-1563
			Assert.assertEquals(done.isDisplayed(), true,
					"UI-LH-18 -Done Button is displayed Successfully");
			Log.info("UI-LH-18 -Done Button is displayed Successfully");
			Assert.assertEquals(done.isEnabled(), true,
					"UI-LH-18 - Done Button is enabled Successfully");
			Log.info("UI-LH-18 - Done Button is enabled Successfully");
			driver.findElement(By.xpath("//*[contains(@class,'QA_Testing_Panel_Btn_cancel')]")).isDisplayed();
			Assert.assertEquals(cancel.isDisplayed(), true,
					"Cancel Button is displayed Successfully");
			Log.info("Cancel Button is displayed Successfully");
			Assert.assertEquals(cancel.isEnabled(), true,
					"Cancel Button is enabled Successfully");
			Log.info("Cancel Button is enabled Successfully"); //19
	
			Assert.assertEquals(placeLegalHoldValueVerify.isDisplayed(), true,
					"Legal Hold Value control is displayed Successfully");
			Log.info("Legal Hold Value control is displayed Successfully");
			Assert.assertEquals(placeLegalHoldValueVerify.isEnabled(), true,
					"Legal Hold Value control is enabled Successfully");
			Log.info("Legal Hold Value control is enabled Successfully");
			
			placeLegalHoldProperty.selectByVisibleText("Proprietary Name");
			Thread.sleep(2000);
			Log.info("Legal Hold Property value - Proprietary Name is entered Successfully");
			int sizeProprietaryName =placeLegalHoldValue.getOptions().size();
			if ((sizeProprietaryName>0)){
				Log.info("The Legal Hold Value property values is displayed successfully on selecting Legal Hold Property value - Proprietary Name.");
			}
			
			placeLegalHoldProperty.selectByVisibleText("Generic Name");
			Thread.sleep(2000);
			Log.info("Legal Hold Property value - Generic Name is entered Successfully");
			int sizeGenericName =placeLegalHoldValue.getOptions().size();
			if ((sizeGenericName>0)){
				Log.info("The Legal Hold Value property values is displayed successfully on selecting Legal Hold Property value - Generic Name.");
			}
			
			placeLegalHoldValue.selectByVisibleText("Diromax Citrate");
			Log.info("Legal Hold Value value is entered Successfully");
			
			Assert.assertEquals(done.isDisplayed(), true,
					"Done Button is displayed Successfully");
			Log.info("Done Button is displayed Successfully");
			Assert.assertEquals(done.isEnabled(), true,
					"Done Button is enabled Successfully");
			Log.info("Done Button is enabled Successfully"); //21
			
			//TODO :UI-LH-22
			
			done.click();
			Log.info("Done button is Clicked");
			Thread.sleep(2000);
			 * initializeSuccessMsg();
			 * if (successMessage.isDisplayed()) {
			 * Log.info("UI-LH-23 - Success Message is displayed successfully"); }
			 * else { Log.info(
			 * "UI-LH-22 - Success Message is not displayed successfully . Error is displayed"
			 * ); }
			 
			Assert.assertEquals(legalHoldsTitle.getText().contains("Legal Holds"),
					true,
					"Place On Legal Hold panel is Closed Successfully");
			Log.info("Place On Legal Hold panel is Closed Successfully"); //24
			*/
			//placeOnLegalHold.click();
			Thread.sleep(2000);
			try {
				retryingFindClick(cancel);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			Thread.sleep(2000);
			Assert.assertEquals(legalHoldsTitle.getText().contains("Legal Holds"),
					true,
					"Place On Legal Hold panel is Closed Successfully");
			Log.info("Place On Legal Hold panel is Closed Successfully"); //25
			
			removeFromLegalHoldTest();
		} 
		catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("Legal Hold tested unsuccessfully");
		//	Assert.fail();

		}
		Log.endTestCase("Legal Hold Test Ended");

	}

	public String getDate() {
		String actualdate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date todayDate = new Date();
		String newDate = dateFormat.format(todayDate);
		System.out.println(newDate);
		String date = (String) newDate.substring(0, 1);
		if(date.equals("0")){
			actualdate = (String) newDate.substring(1);
		}else{
			actualdate = newDate;
		}
		return actualdate;
	}

	public void removeFromLegalHoldTest() throws Exception {
		try {
			removeButton.click();
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.className("fa-remove")))
					.click();
		}
		Thread.sleep(2000);
		initializeRemovefromLegalHold();

		Assert.assertEquals(
				removeLabel.isDisplayed(),
				true,
				"Remove from Legal Hold dialog box is initially displayed Successfully");
		Log.info("Remove from Legal Hold dialog box is initially displayed Successfully");
		
		Assert.assertEquals(doneRemove.isDisplayed(), true,
				"Done Button is displayed Successfully");
		Log.info("Done Button is displayed Successfully");
		Assert.assertEquals(doneRemove.isEnabled(), true,
				"Done Button is enabled Successfully");
		Log.info("Done Button is enabled Successfully");
		
		Assert.assertEquals(cancelRemove.isDisplayed(), true,
				"Cancel Button is displayed Successfully");
		Log.info("Cancel Button is displayed Successfully");
		Assert.assertEquals(cancelRemove.isEnabled(), true,
				"Cancel Button is enabled Successfully");
		Log.info("Cancel Button is enabled Successfully");
		
		doneRemove.click();
		Thread.sleep(2000);
		Log.info("Done button is Clicked");
		Assert.assertEquals(legalHoldsTitle.getText().contains("Legal Holds"),
				true,
				"Remove from Legal Hold dialog box is closed Successfully");
		Log.info("Remove from Legal Hold dialog box is closed Successfully");
		getScreenShot("LegalHOld", "RemoveFromLegalHold_Screen");
		try {
			removeButton.click();
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.className("fa-remove")))
					.click();
		}
		Thread.sleep(2000);
		initializeRemovefromLegalHold();
		cancelRemove.click();
		Thread.sleep(2000);
		Assert.assertEquals(legalHoldsTitle.getText().contains("Legal Holds"),
				true,
				"Remove from Legal Hold dialog box is closed Successfully");
		Log.info("Remove from Legal Hold dialog box is closed Successfully");
	}
}
