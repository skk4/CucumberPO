package com.cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaiduHome_page;
import com.cucumber.config.ConfigManager;
import com.cucumber.utl.SharedDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class BaiduSearchStepfs {
	 //private WebDriver driver; 
	private final WebDriver driver;
    private final ConfigManager config;
    private final BaiduHome_page baiduHome_page;
    private static String baseUrl;
    public BaiduSearchStepfs(SharedDriver driver, ConfigManager config, BaiduHome_page baiduHome_page) {  
        this.driver = driver;  
        this.config = config;  
        this.baiduHome_page = baiduHome_page;  
    }
	@Given("^Go to baidu home$")
	public void go_to_baidu_home() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		/*   
		    driver = new ChromeDriver();  
	        driver.manage().window().maximize();  
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	        driver.get("http://www.baidu.com/");
	        */
	        baseUrl = this.config.get("base_path");  
	        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);  
	        this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);  
	        this.driver.navigate().to(baseUrl); 
	}

	@When("^I find baidu logo$")
	public WebElement i_find_baidu_logo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		/*
		WebDriverWait wait = new WebDriverWait(driver,10);  
        WebElement element = wait.until(ExpectedConditions.visibilityOf  
                (driver.findElement(By.id("su"))));  
  
        return element; 
        */
        WebElement element = this.baiduHome_page.ElementBaiduLogo;  
        return element;  
	}

	@When("^Type the search text \"([^\"]*)\"$")
	public void type_the_search_text(String searchText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		/*
        driver.findElement(By.id("kw")).clear();  
        driver.findElement(By.id("kw")).sendKeys(searchText);
        */
		this.baiduHome_page.enterSearch(searchText); 
		  
	}

	@When("^Click the submit$")
	public void click_the_submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	    //driver.findElement(By.id("su")).click(); 
	    this.baiduHome_page.submit(); 
	}

	@Then("^Wait the query result$")
	public void wait_the_query_result() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		/*
		Thread.sleep(10000);  
        Assert.assertEquals("selenium_百度搜索", driver.getTitle());  
        driver.close();  
        driver.quit();  
        */
        Thread.sleep(10000);    //等待时间selenium_百度搜索 
        Assert.assertEquals("selenium_百度搜索", this.baiduHome_page.getPageTitle());
	}

}
