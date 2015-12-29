package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.BasicNavigationScreen;
import com.ig.automation.screens.CreateDocScreen;
import com.ig.automation.utility.Log;


//	xmL-UI-ADS-007.doc
public class SpecializedControlsTest extends BasicNavigationScreen {

	HomeTest homeTest = new HomeTest();
	LoginTest loginTest = new LoginTest();
	CreateDocScreen cdScr=new CreateDocScreen();

	
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
	 * Test the Create Document feature of UI 7.0 against the UI-ADS-007	 * 
	 * @throws Exception If an error occurs.
	 */
	@Test
	public void testSelectProduct() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Select Product Test");
		try {
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			cdScr.inilializeObjectsDocType("role_eu_labeling_author");
			cdScr.annexType.click();			
			Thread.sleep(2000);
			initializeProduct();
			selectProductNameBtn.click();
			initializeButtons();
			Assert.assertEquals(enterProductName.isDisplayed(), true, "A.	Call GET method of /table/productdata Web Services");
			Log.info("UA-SP-1 is Passed Successfully");
			Thread.sleep(2000);
			cancelBtn.click();
			Assert.assertEquals(selectProductNameBtn.isDisplayed(), true, "product name field values are not retained and the Select Product panel closes."); 
			Log.info("UA-SP-15 is Passed Successfully");
			Thread.sleep(2000);
			selectProductNameBtn.click();
			Assert.assertEquals(genericNameLabel.getText().contains("Generic"), true, "Generic Name is Enabled and Displayed"); 
			Log.info("UA-SP-2 is Passed Successfully");
			Assert.assertEquals(doneBtn.isEnabled(), true, "Done Button is Enabled and Displayed"); 
			Log.info("UA-SP-3 is Passed Successfully");
			Assert.assertEquals(cancelBtn.isEnabled(), true, "Cancel Button box is Enabled and Displayed"); 
			Log.info("UA-SP-4 is Passed Successfully");
			Thread.sleep(2000);
			enterProductName.clear();
			enterProductName.sendKeys("a");
			Thread.sleep(2000);
			initializeFilterProduct();
			Assert.assertTrue(filterProduct.getText().contains("Alkaline"), "product names containing the letter pressed will be displayed"); 
			Log.info("UA-SP-5 is Passed Successfully");
			enterProductName.sendKeys(Keys.ARROW_DOWN);
			enterProductName.sendKeys(Keys.ENTER);
			initializeSelectProductTree();
			Assert.assertTrue(genericName.getText().contains("Alkaline"), "Generic Name is available for the selected product"); 
			Log.info("UA-SP-6 is Passed Successfully");
			Assert.assertTrue(dosageFrom.getText().contains("Syrup"), "Dosage From is available for the selected product"); 
			Log.info("UA-SP-7 is Passed Successfully");
			Assert.assertTrue(strength.getText().contains("ml"), "Strength is available for the selected product"); 
			Log.info("UA-SP-8 is Passed Successfully");
			Assert.assertTrue(presentation.getText().contains("Bottle"), "Presentation is available for the selected product"); 
			Log.info("UA-SP-9 is Passed Successfully");
			Assert.assertEquals(checkBox0.isDisplayed(), true, "Checkboxes are Displayed and Enabled next to the available product information"); 
			checkBox0.click();
			Assert.assertEquals(checkBox0.isSelected(), true, "A check is placed at the selected level and below in that portion of the product tree");
			Log.info("UA-SP-10 is Passed Successfully");
			Assert.assertEquals(checkBox1.isSelected(), true, "A check is placed at the selected level and below in that portion of the product tree");
			Log.info("UA-SP-11 is Passed Successfully");
			Assert.assertEquals(checkBox2.isSelected(), true, "A check is placed at the selected level and below in that portion of the product tree");
			Log.info("UA-SP-12 is Passed Successfully");
			removeButton.click();
			Assert.assertEquals(selectedProductName.getText().trim().length(), 0); 
			Log.info("UA-SP-13 is Passed Successfully");
			enterProductName.sendKeys("a");
			Thread.sleep(2000);
			initializeFilterProduct();
			enterProductName.sendKeys(Keys.ARROW_DOWN);
			enterProductName.sendKeys(Keys.ENTER);
			initializeSelectProductTree();
			checkBox0.click();
			doneBtn.click();
			initializeProductValue();
			Assert.assertEquals(productNameValues.isDisplayed(), true, "selected product name values are retained and the Select Product panel closes."); 
			Log.info("UA-SP-14 is Passed Successfully");
			Reporter.log("xmL-UI-ADS-007.doc Select Product has been tested Successfully & Passed");

		} catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-007.doc Select Product has been tested Failed");
			Log.endTestCase("Select Product Test Ended");
		}
	}
	
	//TODO There are missing functionalities related to following
	// 2.4	Self-ID Business Operations / Qualifiers Control – Establishment 
	//2.3	Type of Operations / Business Operation Qualifiers Control – Establishment 
	//2.2	Business Operations Control – NDC Labeler Code

	/*
	 * @AfterClass public void tearDown() throws Exception { driver.close(); driver.quit();
	 * 
	 * }
	 */
}
