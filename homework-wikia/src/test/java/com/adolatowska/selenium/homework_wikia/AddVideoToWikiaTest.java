package com.adolatowska.selenium.homework_wikia;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AddVideoToWikiaTest {

	private WikiaHomePage page;

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
	public void addVideo() throws InterruptedException {

		page.doLogin("Adolatowska", "K0ng3rik3t");
		page.clickContribute();
		page.addVideo("http://www.youtube.com/watch?v=h9tRIZyTXTI");
		By videoLink = By
				.xpath("//a[contains(text(),'File:The Best Classical Music In The World')]");
		Assert.assertEquals(page.getText(videoLink),
				"File:The Best Classical Music In The World");
		page.clickVideoLink(videoLink);
		Assert.assertEquals(page.getText(page.videoFileName),
				"The Best Classical Music In The World");
	}
}