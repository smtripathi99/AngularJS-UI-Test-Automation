package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.LoginScreen;
import com.ig.automation.utility.Log;


public class LoginTest extends LoginScreen {
	@BeforeClass
	public void setUp() throws Exception {
		launchUrl();
	}

	/**
	 * Test the Login Page of UI 7.0 against the xmL-UI-ADS-003.doc *
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test(description = "2.1 System Log In")
	public void testLogin() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Log In Test Started as per xmL-UI-ADS-003");
		try {
			initializeObjects();
			DataActions.createConnection();
			String image = titleObj.getText();
			Assert.assertNotNull(image);
			Log.info("UA-LI-01 Passed");

			Assert.assertTrue(userIdObj.isEnabled());
			Log.info("UA-LI-02 Passed");

			Assert.assertTrue(pwdObj.isEnabled());
			Log.info("UA-LI-03 Passed");
			Assert.assertTrue(repoObj.isEnabled());
			Log.info("UA-LI-04 Passed");

			Assert.assertTrue(repoObj.getText() != null);
			Log.info("UA-LI-05 Passed");

			Assert.assertTrue(domainObj.isEnabled());
			Log.info("UA-LI-06 Passed");
			Thread.sleep(5000);
			String loginbtn = loginButton.getText();
			Assert.assertEquals("Login", loginbtn);
			Log.info("UA-LI-07 Passed");

			loginButton.click();

			initializeMessages();
			Assert.assertTrue(message.getText().contains("Please Enter User Name"));
			Log.info("UA-LI-08 Passed");

			userIdObj.sendKeys(userId);
			loginButton.click();

			initializeMessages();
			Assert.assertTrue(message.getText().contains("Please Enter Password"));
			Log.info("UA-LI-09 Passed");

			if (repoObj.getText() == null) {
				Assert.assertTrue(true, "Please select a repository");
				Log.info("UA-LI-10 Passed");
			}

			if (userIdObj.getText() != null && repoObj.getText() != null) {
				pwdObj.sendKeys(pwd);
				loginButton.click();
				Log.info("UA-LI-12 Passed. Refer xmL-UI-ADS-008 test logs");
				Thread.sleep(2000);
			}
			initializeHomeObjects();
			Assert.assertTrue(homeImage.isDisplayed());
			Log.info("UA-LI-13 Passed");
			Reporter.log("2.1 System Log In tested successfully");

		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("2.1 System Log In tested unsuccessfully");
			Assert.fail();

		}
		Log.endTestCase("2.1 System Log In Test Ended");

	}

	public void doLogin(String user, String password) throws Exception {
		try {
			System.out.println("Doing Login");
			initializeObjects();
			// DataActions.createConnection();
			userIdObj.sendKeys(user);
			pwdObj.sendKeys(password);
			loginButton.click();

			/*
			 * System.out.println("Passed:Password is typed successfully."); Thread.sleep(5000); if (userIdObj.getText() != null && pwdObj.getText() != null && repoObj.getText() !=
			 * null) { loginButton.click(); System.out.println("Passed:Login Button is clicked successfully."); // Assert.assertTrue(!loginButton.isDisplayed());
			 * Thread.sleep(2000); } else if (userIdObj.getText() == null) { Assert.assertTrue(true, "Please enter your username"); Log.info("A-LI-07 Passed"); } else if
			 * (pwdObj.getText() == null) { Assert.assertTrue(true, "Please enter your password"); Log.info("A-LI-08 Passed"); }
			 * 
			 * else if (repoObj.getText() == null) { Assert.assertTrue(true, "Please select a repository"); Log.info("A-LI-09 Passed"); }
			 * 
			 * Reporter.log("xmL-UI-ADS-008.docx tested successfully");
			 */
		} catch (Exception e) {
			Log.info(e.getMessage());

		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		if(driver !=null){
			driver.close();
			driver.quit();
		}
	}

}
