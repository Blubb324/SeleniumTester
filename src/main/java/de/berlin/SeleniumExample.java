package de.berlin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExample {

	private SeleniumConfigFirefox config;
	private String url = "http://www.baeldung.com/";

	public SeleniumExample() {
		config = new SeleniumConfigFirefox();
		config.getDriver().get(url);
	}

	public void closeWindow() {
		this.config.getDriver().close();
	}

	public String getTitle() {
		return this.config.getDriver().getTitle();
	}

	public void getAboutBaeldungPage() {
		closeOverlay();
		closeCookieAlert();

		clickAboutLink();
		clickAboutUsLink();
	}

	private void closeOverlay() {
		List<WebElement> webElementList = this.config.getDriver().findElements(By.tagName("a"));
		if (webElementList != null) {
			webElementList.stream().filter(webElement -> "Close".equalsIgnoreCase(webElement.getAttribute("title")))
					.filter(WebElement::isDisplayed).findAny().ifPresent(WebElement::click);
		}
	}

	private void clickAboutLink() {
		Actions actions = new Actions(config.getDriver());
		WebElement aboutElement = this.config.getDriver().findElement(By.id("menu-item-6138"));

		actions.moveToElement(aboutElement).perform();
	}

	private void clickAboutUsLink() {
		WebElement element = this.config.getDriver().findElement(By.partialLinkText("About Baeldung"));
		element.click();
	}

	private void closeCookie() {
		By cookies_accept = By.xpath("//*[@title='Accept Cookies']");
		By cookies_gotIt = By.xpath("//a[text()='AGREE']");
		WebDriverWait wait = new WebDriverWait(config.getDriver(), 3);
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
		wait.until(ExpectedConditions.elementToBeClickable(cookies_gotIt)).click();
	}

	/**
	 * Schließe den Cookie-Hinweis
	 */
	private void closeCookieAlert() {
		WebElement inputButton = this.config.getDriver()
				.findElement(By.xpath("//button[contains(@class, 'css-flk0bs')]"));
		if (inputButton.isDisplayed()) {
			inputButton.click();
		}
	}

	public boolean isAuthorInformationAvailable() {
		return this.config.getDriver().getPageSource().contains("Hey ! I'm Eugen");
	}
}