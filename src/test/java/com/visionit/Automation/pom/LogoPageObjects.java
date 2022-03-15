package com.visionit.Automation.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoPageObjects {
	
	 private static final Logger logger = LogManager.getLogger(LogoPageObjects.class);

	    private WebDriver driver;
	    private By HomePageLogo=By.xpath("//img[@class='logo img-responsive']");
	    
	    
	    public LogoPageObjects(WebDriver driver)
	    {
	    	this.driver=driver;
	    }
	    public void LogoIsDisplayed()
	    {
	    	if(driver.findElement(HomePageLogo).isDisplayed())
	    	{
	    		logger.info("Logo is Visible");
	    	}
	    	else
	    	{
	    		logger.info("Logo Is Not Visible");
	    	}
	    	
	    }
	    public void LogoSizeValidation(String height,String width)
	    {
	    	 String LogowidthLocator=driver.findElement(HomePageLogo).getAttribute("width");
	    	 String LogoheightLocator=driver.findElement(HomePageLogo).getAttribute("height");
	    	 Assert.assertEquals(LogowidthLocator, width);
			logger.info("Width Of Logo is:"+LogowidthLocator);
			Assert.assertEquals(LogoheightLocator, height);
			logger.info("Height of Logo is:"+LogoheightLocator);
			logger.info("Validation Of Logo height and Width is Successfull");
	    }
	    

}
