package com.visionit.Automation.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductCategoryObjects {
	private static final Logger logger = LogManager.getLogger(ProductCategoryObjects.class);

	private WebDriver driver;
	private By productNameList =By.xpath("//div[@id='block_top_menu']/ul/li");

	public ProductCategoryObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ProductCategoryValidation(int NoOfCategory)

	{
		List<WebElement> productList=driver.findElements(productNameList);
		Assert.assertEquals(productList.size(),NoOfCategory);
		logger.info("Categories Of Product:"+productList.size());

	}
	public void NoOfProductCategory(String ProductCategories)
	{
		List<WebElement> productList=driver.findElements(productNameList);
		
		String p1=productList.get(0).getText();
		String p2=productList.get(1).getText();
		String p3=productList.get(2).getText();
		if(p1.contentEquals(ProductCategories))
		{
			Assert.assertTrue(true);

			logger.info("Product Categories are:"+ProductCategories+" Equal:"+p1);
		
		}
		else if(p2.equals(ProductCategories))
		{
			Assert.assertTrue(true);
			logger.info("Product Categories are: "+ProductCategories+" is Equal:"+p2);
		
		}
		else if(p3.equals(ProductCategories))
		{
			Assert.assertTrue(true);

			logger.info("Product Categories are: "+ProductCategories+"is Equal:"+p3);
		
		}
		else
		{
			Assert.fail();
		}
		
	}
}


	