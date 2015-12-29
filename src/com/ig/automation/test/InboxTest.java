package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.InboxScreen;
import com.ig.automation.utility.Log;

public class InboxTest extends InboxScreen{
	
	HomeTest homeTest = new HomeTest();
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testHome();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void inboxTest() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Inbox Test");
		try {
			inilializeInboxLink();
			inbox.click();
			Thread.sleep(2000);
			getScreenShot("Inbox", "InboxScreen");
			initializeInboxLables();
			
			Assert.assertTrue(firstDocDetailContainer.isDisplayed(), "UI-IN-01 - Inbox screen is defaulted to Task tab successfully");
			Log.info("UI-IN-01 - Inbox screen is defaulted to Task tab successfully" );
			Assert.assertTrue(documentLabel.getText().contains("Document"), "UI-IN-03- Document Label is displayed successfully");
			Log.info("UI-IN-03 - Document Label is displayed successfully");
			Assert.assertTrue(subjectLabel.getText().contains("Subject"), "UI-IN-04- Subject Label is displayed successfully");
			Log.info(" UI-IN-04 - Subject Label is displayed successfully");
			Assert.assertTrue(dueDateLabel.getText().contains("Due Date"), " UI-IN-05 - Due Date Label is displayed successfully");
			Log.info("UI-IN-05 - Due Date Label is displayed successfully");
			Assert.assertTrue(statusLabel.getText().contains("Status"), "UI-IN-06 - Status Label is displayed successfully");
			Log.info("UI-IN-06 - Status Label is displayed successfully");
			Assert.assertTrue(workFlowLabel.getText().contains("Workflow Due Date"), "UI-IN-07 - Workflow Due Date Label is displayed successfully");
			Log.info("UI-IN-07 - Workflow Due Date Label is displayed successfully");
			String selectedItem = itemsPerPage.getFirstSelectedOption().getText();
			Assert.assertTrue(workFlowLabel.isDisplayed(), "UI-IN-08 - The Items per page is displayed successfully");
			Log.info("UI-IN-08 - The Items per page is displayed successfully");
			Assert.assertTrue(workFlowLabel.isEnabled(), "UI-IN-08 - The Items per page is enabled successfully");
			Log.info("UI-IN-08 - The Items per page is enabled successfully");
			if(selectedItem.equals("10")){
				Log.info("UI-IN-08 - The Items per page is defaulted to 10");
			}
			String tagName = nextLink.getTagName();
			Assert.assertEquals(tagName, "a" , "UI-IN-09 - Next HyperLink is displayed successfully.");
			Log.info("UI-IN-09 - Next HyperLink is displayed successfully.");
			
			String tagName1 = firstPage.getTagName();
			Assert.assertEquals(tagName1, "a" , "UI-IN-11 - First Page HyperLink is displayed successfully.");
			Log.info("UI-IN-10 - each page number is displayed as a hyperlink.");
			Log.info("UI-IN-11 - First Page HyperLink is displayed successfully.");
			
			firstDocDetailContainer.click();
			
			initializeTaskDetailsPanel();
			Assert.assertTrue(taskDetailPanel.isDisplayed(), "UI-IN-13- If the user selects a task row the Task Details Panel is displayed successfully");
			Log.info("UI-IN-13- If the user selects a task row the Task Details Panel is displayed successfully");
				
			//todo 12
			/*try {
				String pagenation1 = pagenation.getText();
				String[] tokens = pagenation1.split(" ");
				String lastToken = tokens[tokens.length-3];
				int pageCount = lastToken.length();
				int lastPage = Integer.parseInt(lastToken) % 10;
				System.out.println(lastPage);
			} catch (Exception e) {
				// TODO: handle exception
			}
			findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[2]/div[1]/span[" +(8)+"]/a")).click();
			*/
			
			notificationTab.click();
			Thread.sleep(2000);
			getScreenShot("Inbox", "Inbox_NotificationTab");
			initializeNotificationTab();
			Assert.assertTrue(documentLabelNotification.getText().contains("Document"), "UI-IN-15- Document Label is displayed successfully");
			Log.info("UI-IN-15 - Document Label is displayed successfully");
			Assert.assertTrue(subjectLabelNotification.getText().contains("Subject"), "UI-IN-16- Subject Label is displayed successfully");
			Log.info(" UI-IN-16 - Subject Label is displayed successfully");
			Assert.assertTrue(dueDateLabelNotification.getText().contains("Due Date"), " UI-IN-19 - Due Date Label is displayed successfully");
			Log.info("UI-IN-19 - Due Date Label is displayed successfully");
			//FROM
			Assert.assertTrue(statusLabelNotification.getText().contains("Status"), "UI-IN-17- Status Label is displayed successfully");
			Log.info("UI-IN-17 - Status Label is displayed successfully");
			//DATE RECEIVED
			Assert.assertTrue(workFlowLabelNotification.getText().contains("Workflow Due Date"), "UI-IN-18 - Workflow Due Date Label is displayed successfully");
			Log.info("UI-IN-18 - Workflow Due Date Label is displayed successfully");
			String selectedItemN = itemsPerPage.getFirstSelectedOption().getText();
			Assert.assertTrue(workFlowLabelNotification.isDisplayed(), "UI-IN-20 - The Items per page is displayed successfully");
			Log.info("UI-IN-20 - The Items per page is displayed successfully");
			Assert.assertTrue(workFlowLabelNotification.isEnabled(), "UI-IN-20 - The Items per page is enabled successfully");
			Log.info("UI-IN-20 - The Items per page is enabled successfully");
			if(selectedItemN.equals("10")){
				Log.info("UI-IN-20 - The Items per page is defaulted to 10");
			}
			String tagNameN = nextLink.getTagName();
			Assert.assertEquals(tagNameN, "a" , "UI-IN-21 - Next HyperLink is displayed successfully.");
			Log.info("UI-IN-21 - Next HyperLink is displayed successfully.");
			
			String tagNameFirstPage = firstPage.getTagName();
			Assert.assertEquals(tagNameFirstPage, "a" , "UI-IN-23 - First Page HyperLink is displayed successfully.");
			Log.info("UI-IN-22 - each page number is displayed as a hyperlink.");
			Log.info("UI-IN-23 - First Page HyperLink is displayed successfully.");
			firstContainer.click();
			
			initializeNotificationDetailPanel();
			Assert.assertTrue(detailPanel.isDisplayed(), "UI-IN-25- When the user selects a notification row, the Notification Details panel is displayed .");
			Log.info("UI-IN-25 - When the user selects a notification row, the Notification Details panel is displayed ");
			Assert.assertTrue(subject.isDisplayed(), "UI-NP-02- Subject Label is displayed successfully");
			Log.info(" UI-NP-02 - Subject Label is displayed successfully");
			Assert.assertTrue(from.isDisplayed(), " UI-NP-03 -From Label is displayed successfully");
			Log.info("UI-NP-03 - From Label is displayed successfully");
			Assert.assertTrue(dateReceived.isDisplayed(), "UI-NP-04 - Date Received Label is displayed successfully");
			Log.info("UI-NP-04 - Date Received Label is displayed successfully");
			Assert.assertTrue(workFlowLabel.isDisplayed(), "UI-NP-05 -  Due Date Label is displayed successfully");
			Log.info("UI-NP-05 - Due Date Label is displayed successfully");
			Assert.assertTrue(instructions.isDisplayed(), "UI-NP-06 -  Instructions Label is displayed successfully");
			Log.info("UI-NP-06 - Instructions Label is displayed successfully");
			Assert.assertEquals(deleteButton.isDisplayed(), true, "UI-NP-08 - Delete button is Displayed Successfully"); 
			Log.info("UI-NP-08 - Delete button is Displayed Successfully");
			Assert.assertEquals(deleteButton.isEnabled(), true, "UI-NP-08 - Delete button is Enabled Successfully"); 
			Log.info("UI-NP-08 - Delete button is Enabled Successfully");
			deleteButton.click();
			Log.info("UI-NP-09 - Delete button is Clicked Successfully");
			
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-006.doc Create Document tested Failed");
			Log.endTestCase("Create Document");
			Assert.fail(t.getMessage());
		}
	}
}
