	
	
	
	

	
	
	
	package homepage;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.app.pages.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class addtocarthome {
	
	private static final Logger logger = LogManager.getLogger(addtocarthome.class);
	private final WebDriver driver;
	private final Pages pages ;
	
	public addtocarthome() {
		driver = new ChromeDriver();
		pages = new Pages(driver);
	}
	@Given("User navigates to the URL")
	public void user_navigates_to_the_url() {
		logger.info("Navigating to the URL");
		pages.navigateToURL("https://www.chilternoakfurniture.co.uk/");
	}

	@Then("user search sofa")
	public void user_search_book() throws InterruptedException {
		logger.info("user searches for sofa");
		
		pages.inputToSearch("sofa");
		
	}
		
	
	
	

	@Then("add")
	public void add() throws InterruptedException {
		logger.info("Then adds item to cart");
		Thread.sleep(2000);
		pages.add();
		
		
	}
	
	
	
	
		@Then("remove")
		public void remove() throws InterruptedException {
			logger.info("Then removes item from cart");
			Thread.sleep(3000);
			pages.remove();
			
			
			
	}
		
			
	



		
		private static void captureScreenshot(WebDriver driver, String fileName) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(fileName);
			try {
				Files.copy(sourceFile.toPath(), destinationFile.toPath());
				System.out.println("Screenshot captured: " + destinationFile.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("Unable to capture screenshot: " + e.getMessage());
			}
		}
		
			
		}
	



