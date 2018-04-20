package runner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;

public class TestQuizful {
	private Steps steps;
	private final String USERNAME = "tanushechka6768";
	private final String PASSWORD = "1234567jhk";
	private final String EMAIL = "olushechka86@mail.ru";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void registerSuccess() throws InterruptedException {
		steps.registerquizful(USERNAME, PASSWORD, EMAIL);
		Thread.sleep(18000);
		steps.loginquizful(USERNAME, PASSWORD);

	}
	
	@Test
	public void loginsuccess() throws InterruptedException{
		steps.loginquizful(USERNAME, PASSWORD);
	}
		

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}