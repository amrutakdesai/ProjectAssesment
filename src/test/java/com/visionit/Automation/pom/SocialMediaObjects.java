package com.visionit.Automation.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialMediaObjects {
	public static final Logger logger=LogManager.getLogger(SocialMediaObjects.class);

    private WebDriver driver;
    private By TwitterAcBtn=By.xpath("//li[@class='twitter']");
    private By TwitterAccountName=By.xpath("(//span[contains(text(),'Selenium Framework')])[2]");
   		
    public SocialMediaObjects(WebDriver driver)
    {
    	this.driver=driver;
    }
    public void ClickOnButton()
    {
    	driver.findElement(TwitterAcBtn).click();
    	logger.info("Click On Button:");
    }
    public void UrlValidation(String UrlContain)
    {
    	String CurrentUrl=driver.getCurrentUrl();
    	
    	logger.info("Current Url Contains this "+CurrentUrl.contains(UrlContain));
    }
    public void TwitterAccountNameValidation(String AcName)
    {
    	String TwitterAcName=driver.findElement(TwitterAccountName).getText();
		Assert.assertEquals(AcName, TwitterAcName);
		logger.info("Account name is:"+TwitterAcName);

    }
}
