package com.adolatowska.selenium.homework_wikia;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginToWikiaTest {

	public WikiaHomePage page;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws IOException {
		if (browser.equalsIgnoreCase("chrome")) {
			String propFileName = "settings/config.properties";

			Properties props = new Properties();
			FileReader reader = new FileReader(propFileName);
			props.load(reader);

			System.setProperty("webdriver.chrome.driver", props.getProperty("chrome.driver"));

			page = PageFactory.initElements(new ChromeDriver(),
					WikiaHomePage.class);
		} else {
			page = PageFactory.initElements(new FirefoxDriver(),
					WikiaHomePage.class);
		}
		page.open("http://testhomework.wikia.com");
	}

	@AfterClass
	public void cleanUp() {
		page.close();
	}

	@Test
	public void loginToWikia() {

		page.doLogin("Adolatowska", "K0ng3rik3t");
		Assert.assertEquals(page.getText(page.loginButton), "Adolatowska");
	}
}