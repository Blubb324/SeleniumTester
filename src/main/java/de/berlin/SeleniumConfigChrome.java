package de.berlin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfigChrome {

    private WebDriver driver;
    
    public SeleniumConfigChrome() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    public WebDriver getDriver() {
    	return driver;
    }

    static {
    	 System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
    }
}
