package com.visionit.Automation.core;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	public static final Logger logger=LogManager.getLogger(WebDriverFactory.class);
	static WebDriver driver=null;
	public static WebDriver getDriverForBrowser(String browser) throws Exception
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("Chrome Browser is Invoke");
			break;

		case "firefox":
			//System.setProperty("webdriver.firefox.driver", "geckodriver.exe");

			driver=new FirefoxDriver();
			logger.info("Firefox Browser is Invoke");

			break;

		default:
			logger.fatal("no Such Browser is implemented.Browser Name Sent: "+browser);
			throw new Exception("No Such Browser is implemented.Browser Name Sent: "+browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		logger.info("Driver maximized and implicit time out set to 20 seconds");
		return driver;
	}
	public static void quitDriver()
	{
		driver.quit();
		logger.info("Driver is closed");

	}
	public static void navigateToUrl(String url)
	{
		driver.get(url);
		logger.info("Navigate To Url:"+url);

	}
	public static void switchedBrowserToTab()
	{
		Set<String> handles=driver.getWindowHandles();
		logger.info("List of windows found: "+handles.size());
		logger.info("Windows handles: " + handles.toString());
		Iterator<String> it=handles.iterator();
		String original=it.next();
		String nextTab=it.next();
		driver.switchTo().window(nextTab);
		logger.info("Switch To The Next Tab Window");

	}
	public static String getBrowserName()
	{
		String browserDefault="chrome";
		String browserSentFromCmd=System.getProperty("browser");
		if(browserSentFromCmd==null)
		{
			return browserDefault;
		}
		else
		{
			return browserSentFromCmd;
		}
	}

}

