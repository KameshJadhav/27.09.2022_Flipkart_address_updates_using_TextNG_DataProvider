package testClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass1;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class testClass2 {
	
	static WebDriver driver;
	
	LoginPage lp;
	HomePage hp;
	
	
	@BeforeClass
	public void beforeClass() {
		
		driver = BaseClass1.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}

	@Test(priority = 1)
	public void VerifyUserCanSearchProduct() throws InterruptedException {
		
		hp.searchProduct();
		
		hp = new HomePage(driver);
		
		String actualText = hp.getValidText();
		
		if(actualText.contains("Showing 1 –")) {
			System.out.println("Test case Passed");
		}else {
			Assert.fail();
		}	
	}
	
	@Test(priority = 2)
	public void VerifyUserCanGetLowestPriceProductFromEachPage() {
		
		List<String> lowsetPriceFron5Page = new ArrayList<>();
		
		for(int i=1; i<=5; i++) {
			
			if(i != 1) {
				hp.switchToPage(i);
			}
			hp = new HomePage(driver);
			lowsetPriceFron5Page.add(hp.getLowestPriceOfProduct());
		}
		
		System.out.println(lowsetPriceFron5Page);
		
	}
	
	@Test
	public void test3() throws InterruptedException {
		
	}
	
	@Test
	public void test4() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
}
