package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class MyDocScreen extends DataActions {
    @CacheLookup
	public WebElement myDocumentLabel;
	public WebElement myCheckedDocumentLabel;
	public WebElement myCheckedoutDoc;
	public WebElement myDocID1;
	public WebElement myDocID2;
	public By myCheckedDocID;
	public Select myDocPages;
	public WebElement pagePrevious;
	public WebElement pageNext;
	public WebElement pageLink;
	public WebElement docAction;
	public WebElement documentID;
	public WebElement language;
	public WebElement currentVersion;
	public WebElement status;
	public WebElement title;
	public WebElement addremoveMydoc;

	public void initializeaddMyDocsObjects() {
		addremoveMydoc = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[1]/div/div/i[1]"));
	}

	public void initializeMyDocsObjects() {
		myDocumentLabel = findElement(By.xpath("/html/body/div/div[4]/div[2]/div/div/div/ul/li[1]/a"));
		/*
		 * documentID=findElement(By .xpath("/html/body/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[10]/div[4]/div[1]/span/span/div/span[2]/span[1]/span"));
		 * language=findElement(By .xpath("/html/body/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[10]/div[4]/div[3]/span/span/div/span[2]/span[1]/span"));
		 * currentVersion=findElement(By .xpath("/html/body/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[10]/div[4]/div[5]/span/span/div/span[2]/span[1]/span"));
		 * status=findElement(By .xpath("/html/body/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[10]/div[4]/div[7]/span/span/div/span[2]/span[1]/span")); title=findElement(By
		 * .xpath("/html/body/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[10]/div[4]/div[9]/span/span/div/span[2]/span[1]/span"));
		 */myCheckedDocumentLabel = findElement(By.xpath("/html/body/div/div[4]/div[2]/div/div/div/ul/li[2]/a"));
		myDocID1 = findElement(By.xpath("//*[contains(@class,'gcGrid__row-even')]/div/div/div/span"));
		myDocID2 = findElement(By.xpath("//*[contains(@class,'gcGrid__row-even')]/div/div/div/span[2]"));
		myCheckedoutDoc = findElement(By.xpath("//*[text()='My Checked Out Documents']"));
	}

	public void initializeMyDocPageObjects() {
		myDocPages = new Select(findElement(By.xpath("//div[@class='gcGrid__cell']/div/select")));
		pagePrevious = findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]/div/span[2]"));
		pageNext = findElement(By.xpath("//*[contains(text(),'Next')]"));
		pageLink = findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]/div/span[4]"));

	}

	public void initializeDocumentInfoObjects() {
		docAction = findElement(By.xpath("//*[contains(@class,'gcDocMenu__actionHeader')]"));
	}

	public void initializeMyCheckedDocsObjects() {
		myCheckedDocID = (By.xpath("//*[contains(@class,'gcGrid__row-even')]/div/div/div/span"));
	}

}
