package demoSelenium;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstDemo {
	
	static WebDriver driver;
	String url = "https://www.google.com";
	static String url2 = "https://www.youtube.com/";
	

	@BeforeClass
	public static void setUpBeforeClass() {
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Carson Pemble\\OneDrive\\Documents\\Eclipse JARs\\Drivers\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carson Pemble\\OneDrive\\Documents\\Eclipse JARs\\Drivers\\chromedriver.exe");
		
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		
		driver.get(url2);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	
	@Test
	public void test() throws Exception {
		
		// Get Page Title
		String title = driver.getTitle();
		System.out.println(title);
		
		// Get the Name of first video on page
		String message = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-browse/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[6]/ytd-rich-item-renderer[1]/div/ytd-rich-grid-media/div[1]/div/div[1]/h3/a/yt-formatted-string")).getText();
        System.out.println(message);
		
		
		// Enter in Search
		//driver.findElement(By.id("search")).sendKeys("Carson Pemble");
		driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div/div[1]/input")).sendKeys("Carson Pemble");
		
		
		//Click on search button
        driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();

        // Select my account
        driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-channel-renderer[1]/div/div[2]/a/div[1]/ytd-channel-name/div/div/yt-formatted-string")).click();
        Thread.sleep(2500);
        
        // Select Play All
        driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-shelf-renderer/div[1]/div[1]/div/h2/div[2]/ytd-button-renderer/a/paper-button/yt-formatted-string")).click();
        Thread.sleep(2500);
        
        // Get Title of my first video
        title = driver.getTitle();
		System.out.println(title);
		
		// Take a Screenshot
		String screenshotLocation = "C:\\\\Users\\\\Carson Pemble\\\\OneDrive\\\\Documents\\\\Lex Notes\\\\Selenium\\\\Screenshots\\\\Image.png";
		//TakesScreenshot ts = ((TakesScreenshot)driver);
		//File scrFile = ts.getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(scrFile, new File("C:\\Users\\Carson Pemble\\OneDrive\\Documents\\Lex Notes\\Selenium\\Screenshots\\Image.jpg"));
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(screenshotLocation));
		System.out.println("Screenshot saved: " + screenshotLocation);
		Thread.sleep(2500);
		
	}
	
	

	@AfterClass
	public static void tearDownAfterClass() {
		//driver.close();
		//driver.quit();
	}
	
	


}
