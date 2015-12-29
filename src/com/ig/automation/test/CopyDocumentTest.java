package com.ig.automation.test;

import com.ig.automation.screens.ContentManagementScreen;

public class CopyDocumentTest {
	
	SearchTest searchTest = new SearchTest();
	ContentManagementScreen contentManScreen = new ContentManagementScreen();
	
	public String doCopyDocument(String docID) throws Exception{
		String DocID;
		String successMsg[];
		searchTest.doSearchDocument(docID);
		try {
			contentManScreen.initializeEdit();
			contentManScreen.editLink.click();
			contentManScreen.inilializeGenerateCleanCopyButton();
			contentManScreen.copyDocument.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		contentManScreen.initializeCopyDocumentButton();
		contentManScreen.copyDocumentButton.click();
		contentManScreen.initializeMessages();
		
		String successMessage = contentManScreen.messageCopy.getText(); 	//Created successfully 
													//Document SmPC-470 is successfully
													// created. To view document Click Here
													//AN-1021
													//Created successfully
													//Document CDS-874 is successfully
													//created. To view document Click Here
		contentManScreen.docLink.click();
		successMsg=successMessage.split(" ", 4);
		 DocID=successMsg[2];
		 return DocID;
	}
}
