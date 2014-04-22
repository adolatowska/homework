package com.adolatowska.selenium.homework_wikia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiaHomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public WikiaHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}

	/* text boxes */
	By usernameTextBox = By.name("username");
	By passwordTextBox = By.name("password");
	By urlTextBox = By.id("wpWikiaVideoAddUrl");

	/* buttons */
	By loginButton = By.xpath("/html/body/div[3]/header/div/div/ul/li/a");
	By submitLoginButton = By.xpath("//input[@value='Log in']");
	By contributeButton = By.xpath("//header[@id='WikiHeader']/div[2]/nav");
	By addVideoButton = By
			.xpath("//a[contains(@href, '/wiki/Special:WikiaVideoAdd')]");
	By submitUrlButton = By.xpath("//input[@value='Add']");
	By videoFileName = By.xpath("//header[@id='WikiaPageHeader']/h1");

	/* Click 'Log In' button method */
	public WikiaHomePage clickLogin() {
		driver.findElement(loginButton).click();
		return this;
	}

	/* Type 'Username' method */
	public WikiaHomePage typeUsername(String user) {
		driver.findElement(usernameTextBox).sendKeys(user);
		return this;
	}

	/* Type 'Password' method */
	public WikiaHomePage typePassword(String pass) {
		driver.findElement(passwordTextBox).sendKeys(pass);
		return this;
	}

	/* Click submit 'Log In' button method */
	public WikiaHomePage submitLogin() {
		driver.findElement(submitLoginButton).click();
		return this;
	}

	/* Perform login method */
	public WikiaHomePage doLogin(String user, String pass) {
		clickLogin();
		typeUsername(user);
		typePassword(pass);
		submitLogin();
		return this;
	}

	/* Click 'Contribute' button method */
	public WikiaHomePage clickContribute() {
		driver.findElement(contributeButton).click();
		return this;
	}

	/* Perform adding video method */
	public WikiaHomePage addVideo(String url) throws InterruptedException {
		driver.findElement(addVideoButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(urlTextBox));
		driver.findElement(urlTextBox).sendKeys(url);
		Thread.sleep(2000);
		driver.findElement(submitUrlButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(videoFileName));
		return this;
	}

	/* Click link to added video method */
	public WikiaHomePage clickVideoLink(By link) {
		driver.findElement(link).click();
		return this;
	}

	/* Get text from desired web element method */
	public String getText(By element) {

		return driver.findElement(element).getText();
	}

	/* Open web page method */
	public void open(String url) {
		driver.get(url);
	}

	/* Quit web driver method */
	public void close() {
		driver.quit();
	}
}