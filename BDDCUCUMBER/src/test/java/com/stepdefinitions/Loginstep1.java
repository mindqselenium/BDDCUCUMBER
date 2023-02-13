package com.stepdefinitions;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstep1 {
	WebDriver driver;
	/*
	 * public Loginsteps1(WebDriver driver){ this.driver = driver; }
	 */

	@Before
	public void setup() {
		
	}

	@Given("user needs to be on login page")
	public void user_needs_to_be_on_login_page() {
		//System.setProperty("webdriver.chrome.driver",
			//	"F:\\0730AM NOVEMBER 2022 ONLINE SELNIUM\\BDDCUCUMBER\\drivers\\chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("user is currently on login page");
		String expectedurl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(expectedurl, driver.getCurrentUrl());
	     System.out.println(driver.getTitle());

	}

		
	@When("user enters {string} and {string}>")
	public void user_enters_and(String username, String password) {
		// Write code here that turns the phrase above into concrete actions

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("user enters username and password on login page");
	}

	@When("user needs to click on login button")
	public void user_needs_to_click_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("user is landed on dashboard page")
	public void user_is_landed_on_dashboard_page() throws Exception {
		System.out.println("user is landed to dashboard page");

	}
	
	@Then("user is in the same login page")
	public void user_is_in_the_same_login_page() {
	    System.out.println("user is in login page due to invalid input");
	}
	
	@Then("user is loggedout from application")
	public void user_is_loggedout_from_application() throws Exception {
		String dashboardURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(dashboardURL, driver.getCurrentUrl());
		
		// logout
		if (driver.getCurrentUrl().equalsIgnoreCase(dashboardURL)) {
			// click on list menu
			driver.findElement(By.xpath("//li[@class=\"oxd-userdropdown\"]/span")).click();
			Thread.sleep(3000);
			// click on logout option from the list
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("user is loggedout successfully");
		}
	}

	@Then("finally close the browser")
	public void finally_close_the_browser() {
		// driver.quit();
	}

}
