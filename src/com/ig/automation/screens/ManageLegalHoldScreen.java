package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class ManageLegalHoldScreen extends DataActions {

	public WebElement legalHoldProperty;
	public WebElement legalHoldValue;
	public WebElement actualLegalHoldDate;
	public WebElement systemLegalHoldDate;
	public WebElement itemsPerPage;
	public WebElement legalHoldsTitle;
	public WebElement placeOnLegalHold;
	public Select placeLegalHoldProperty;
	public Select placeLegalHoldValue;
	public WebElement placeLegalHoldPropertyVerify;
	public WebElement placeLegalHoldValueVerify;
	public WebElement placeSystemLegalHoldDate;
	public WebElement placeActualLegalHoldDate;
	public WebElement placeOnLegalHoldTitle;
	public WebElement done;
	public By cancel;
	public WebElement removeButton;
	public WebElement removeRegalHOldTitle;
	public WebElement cancelRemove;
	public WebElement doneRemove;
	public WebElement removeLabel;
	public WebElement successMessage;
	public WebElement month;
	public WebElement date;

	public void initializeLegalHoldScreen(){
		legalHoldProperty=findElement(By.xpath("//*[contains(@class,'gcGrid__header')]/div[1]"));
		legalHoldValue=findElement(By.xpath("//*[contains(@class,'gcGrid__header')]/div[3]"));
		actualLegalHoldDate=findElement(By.xpath("//*[contains(@class,'gcGrid__header')]/div[5]"));
		systemLegalHoldDate=findElement(By.xpath("//*[contains(@class,'gcGrid__header')]/div[7]"));
		itemsPerPage=findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]//select[contains(@class,'form-control')]"));
		placeOnLegalHold=findElement(By.xpath("//*[contains(text(),' Place on Legal Hold')]"));
		legalHoldsTitle=findElement(By.xpath("//*[contains(@class,'section')]/div[2]/h3"));
		removeButton=findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[3]/div/div[1]/div/div/div/button"));
	}
	
	public void initializePlaceOnLegalHold(){
	/*	placeOnLegalHoldTitle=findElement(By.xpath("//*[contains(@class,'sidepanel__header')]/h1"));
		placeLegalHoldProperty=new Select(findElement(By.className("QA_testing_legalholdproperty")));
		placeLegalHoldValue=new Select(findElement(By.className("QA_testing_legalholdvalue")));
		placeLegalHoldPropertyVerify=findElement(By.className("QA_testing_legalholdproperty"));
		placeLegalHoldValueVerify=findElement(By.className("QA_testing_legalholdvalue"));
		placeActualLegalHoldDate=findElement(By.className("QA_testing_actual_legal_hold_date"));
		placeSystemLegalHoldDate=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div/div[4]/div/div/p"));
		done=findElement(By.className("QA_Testing_Panel_Btn_doneSelectPerformer"));
	*/	cancel= By.xpath("//*[contains(@class,'QA_Testing_Panel_Btn_cancel')]");
	}
	
	public void initializeRemovefromLegalHold(){
		
		removeRegalHOldTitle= findElement(By.xpath("//*[contains(@class,'sidepanel__header')]"));
		cancelRemove= findElement(By.xpath("//*[contains(@class,'QA_Testing_Panel_Btn_cancel')]"));
		doneRemove=findElement(By.xpath("//*[contains(@class,'QA_Testing_Panel_Btn_done')]"));
		removeLabel=findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div"));
	}
	
	public void initializeSuccessMsg(){
		successMessage = waitForElementToAppear(driver, "toast-container");
	}
}
