package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.ExportDocumentScreen;
import com.ig.automation.utility.Log;



public class ExportDocumentTest extends ExportDocumentScreen{

	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			homeTest.testHome();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Test the Export Document of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testExportRMS() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Export Document Test Started");
		try{
			String docID=getDocID("RMS");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			//docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys("RMS");
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeActionMenu();
			viewMenu.click();
			initializeExport();
			exportDoc.click();
			//TODO java security popup windows related stuff
			/*Screen screen = new Screen();
            Thread.sleep(6000);
            Pattern clickAccept1 = new Pattern("\\images\\clickaccept1.png");
            Pattern clickRun1 = new Pattern("\\images\\clickrun1.png");
            try {
                  // screen.wait(target,10);
                   screen.click(clickAccept1);
                   screen.click(clickRun1);
            } catch (FindFailed e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
            }*/

			Reporter.log("xmL-UI-ADS-XXX.doc Export Document tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Export Document tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Export Document Test Ended");
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
	public void doExport(){
		initializeActionMenu();
		viewMenu.click();
		initializeExport();
		exportDoc.click();
	}

	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
