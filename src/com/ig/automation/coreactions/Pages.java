package com.ig.automation.coreactions;

import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.HAInterActionTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;

public class Pages {
	
	private static HomeTest homeTest = new HomeTest();	
	private static SearchTest searchTest = new SearchTest();
	private static ContentManagementScreen contentManagementScreen = new ContentManagementScreen();
	private static LoginTest loginTest = new LoginTest();
	private static CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	private static ChangeLifeCycleStateTest changeLifeCycleStateTest = new ChangeLifeCycleStateTest();
	private static HAInterActionTest haInterActionTest = new HAInterActionTest();
	
	public static HomeTest getHomeTest() {
		return homeTest;
	}
	public static void setHomeTest(HomeTest homeTest) {
		Pages.homeTest = homeTest;
	}
	public static SearchTest getSearchTest() {
		return searchTest;
	}
	public static void setSearchTest(SearchTest searchTest) {
		Pages.searchTest = searchTest;
	}
	public static ContentManagementScreen getContentManagementScreen() {
		return contentManagementScreen;
	}
	public static void setContentManagementScreen(ContentManagementScreen contentManagementScreen) {
		Pages.contentManagementScreen = contentManagementScreen;
	}
	public static LoginTest getLoginTest() {
		return loginTest;
	}
	public static void setLoginTest(LoginTest loginTest) {
		Pages.loginTest = loginTest;
	}
	public static CreateDocumentTest getCreateDocumentTest() {
		return createDocumentTest;
	}
	public static void setCreateDocumentTest(CreateDocumentTest createDocumentTest) {
		Pages.createDocumentTest = createDocumentTest;
	}
	public static ChangeLifeCycleStateTest getChangeLifeCycleStateTest() {
		return changeLifeCycleStateTest;
	}
	public static void setChangeLifeCycleStateTest(ChangeLifeCycleStateTest changeLifeCycleStateTest) {
		Pages.changeLifeCycleStateTest = changeLifeCycleStateTest;
	}
	public static HAInterActionTest getHaInterActionTest() {
		return haInterActionTest;
	}
	public static void setHaInterActionTest(HAInterActionTest haInterActionTest) {
		Pages.haInterActionTest = haInterActionTest;
	}
}
