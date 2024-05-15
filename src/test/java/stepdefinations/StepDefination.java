package stepdefinations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import PageObject.AdminPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ReadConfig;

public class StepDefination extends Base {

	// Hook concept
	@Before
	public void setUp() throws Exception {
		System.out.println("Set up method execution");

		readConfig = new ReadConfig();// creating object of ReadConfig

		String browser = readConfig.getBrowser();// chrome

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}

	}

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		// driver= new ChromeDriver();
		admin = new AdminPage(driver); // Creating object of admin page java class
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		driver.get(url);

	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {

		admin.SetUsername(email);
		admin.SetPassword(password);

	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		admin.ClickOnLogin();

	}

	@Then("User verify the page title should be {string}")
	public void user_verify_the_page_title_should_be(String title) {

		// Using assert concept
		Assert.assertEquals(driver.getTitle(), title);

	}

	@Then("Close Browser")
	public void close_browser() {

		driver.close();

	}

	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("Teat down method execute after each scenario");

		// capture screenshot of failed scenarios

		if (sc.isFailed() == true) {

			String filepath = "C:\\Users\\Prashant\\eclipse-workspace\\04Dec2023CucumberMavenproject\\Screenshot\\failedscreenshot.jpg";
			// convert WebDriver object into TakeScreenshot

			TakesScreenshot scrshot = (TakesScreenshot) driver;

			// call getScreenshotAs()
			File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
			Thread.sleep(2000);

			File destFile = new File("filepath");

			FileUtils.copyFile(scrFile, destFile);

			Thread.sleep(2000);

			driver.quit();

		}

	}

}
