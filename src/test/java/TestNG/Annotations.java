package TestNG;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

public class Annotations extends  ReusableMethod {
	 
	@BeforeMethod
	public void SetupDriverAndUrl() throws IOException {
		initialize_driver();
		launchUrl();
		
	}
	@AfterMethod
	public void TeardownDriverAndUrl() {
		
		report.endTest(logger);
		
	}
	@BeforeTest
	public  void SetUpExtentReport() throws IOException {
		initializeExtentReport();
		
	}
	@AfterTest
	public  void TeardownExtentReport() {
		closeTestCase();
	}
    @Test
	public static void TC1_Login() throws InterruptedException, IOException

	{
			
		logger=report.startTest("Test script : TC1_Login");
		
		String[][] data = readXlData("C:\\Users\\poorn\\eclipse-workspace1\\SalesForceProject\\XLTestData\\TC1_Login.xls","Sheet1");
		
		String username1 = data[0][1];
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, username1, "UserName");
		
		String password1 = data[1][1];
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        enterText(pwd, password1, "Password");
        
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObj(login, "login");
		
		driver.close();
		
		System.out.println("TC1_Login is completed");
	  

	}
   
    
	@Test(enabled=false)
	public static void TC2_NoPswd() throws IOException, InterruptedException {
		logger=report.startTest("Test script : TC2_NoPswd");
		
		String[][] data = readXlData("C:\\Users\\poorn\\eclipse-workspace1\\SalesForceProject\\XLTestData\\TC1_Login.xls","Sheet1");
		String username1 = data[0][1];
			WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
			enterText(Uname, username1, "UserName");
			Thread.sleep(3000);
			WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
			clickObj(login, "login");
			String errormessage = driver.findElement(By.cssSelector("#error")).getText();
			if (errormessage.equals("Please enter your password.")){
				logger.log(LogStatus.ERROR,"Errormessage displayed : Please enter your password.");
		   
			}
			else {
				logger.log(LogStatus.INFO, "Not displayed");
				
			}
			
			System.out.println("TC2_LoginError is completed");
			
		}
	
	@Test(enabled=false)
	public static void TC03_CheckRememberMe() throws IOException, InterruptedException {
		logger=report.startTest("Test script : TC03_CheckRememberMe()");
		String[][] data = readXlData("C:\\Users\\poorn\\eclipse-workspace1\\SalesForceProject\\XLTestData\\TC1_Login.xls","Sheet1");
		String username1 = data[0][1];
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, username1, "UserName");
		String password1 = data[1][1];
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, password1, "Password");
	
		WebElement remember=driver.findElement(By.xpath("//*[@id='rememberUn']"));
		remember.click();
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		login.click();
		WebElement UserMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		UserMenu.click();
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		logout.click();
		
		System.out.println("TC03_CheckRememberMe is completed");
		
	
	}
	
}





