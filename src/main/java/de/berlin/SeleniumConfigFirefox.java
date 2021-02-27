package de.berlin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumConfigFirefox {

    private WebDriver driver;
    
    public SeleniumConfigFirefox() {
        Capabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    public WebDriver getDriver() {
    	return driver;
    }

    static {
    	 System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver.exe");
    }
}
