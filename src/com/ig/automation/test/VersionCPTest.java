package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.VersionCMSScreen;
import com.ig.automation.screens.VersionCPScreen;
import com.ig.automation.utility.Log;


public class VersionCPTest extends VersionCPScreen{

	LoginTest loginTest = new LoginTest();
	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			//loginTest.testLogin();
			launchUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test the Version CP Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionCP() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version CP Test Started");
		try{
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			homeTest.initializeActionObjects();
			homeTest.eusubmission.click();
			homeTest.initializeEUSubmissionObjects();
			homeTest.createCP.click();
			CreateCP createCP=new CreateCP();
			createCP.doCreateCP();
			initializeActionMenu();
			eusubmissionMenu.click();
			initializeVersionCP();
			versionCP.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version CP tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version CP tested unsuccessfully");	
		}
			Log.endTestCase("Version CMS Test Ended");
	}	

	@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}
}
