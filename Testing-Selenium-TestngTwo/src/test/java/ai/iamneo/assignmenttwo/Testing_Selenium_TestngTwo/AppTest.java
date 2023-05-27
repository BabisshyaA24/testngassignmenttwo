package ai.iamneo.assignmenttwo.Testing_Selenium_TestngTwo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.port", "8080");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.fb.com");
	}

	@Test
	public void titlematch() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("http://www.facebook.com")) {
			System.out.println("Page is redirected to http://www.facebook.com");
		} else {
			System.out.println("Instead of http://www.facebook.com url, redirected to " + currentUrl);
		}
		WebElement createNewAccount = driver.findElement(By.xpath(
				"//*[contains(@class, '_42ft') and contains(@class, '_4jy0') and contains(@class, '_6lti') and contains(@class, '_4jy6') and contains(@class, '_4jy2') and contains(@class, 'selected') and contains(@class, '_51sy')]"));
		Assert.assertTrue(createNewAccount.isDisplayed(), "Create an account button is not visible");
		createNewAccount.click();

		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @aria-label='First name']"))
				.sendKeys("Abi");
		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @aria-label='Surname']"))
				.sendKeys("Manoharan");
		driver.findElement(By.xpath(
				"//input[@class='inputtext _58mg _5dba _2ph-' and @aria-label='Mobile number or email address']"))
				.sendKeys("6381773008");
		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @aria-label='New password']"))
				.sendKeys("6381443008BA");

		WebElement birthDayDropDown = driver.findElement(By.name("birthday_day"));
		Select birthDaySelect = new Select(birthDayDropDown);
		birthDaySelect.selectByValue("24");

		WebElement birthMonthDropDown = driver.findElement(By.name("birthday_month"));
		Select birthMonthSelect = new Select(birthMonthDropDown);
		birthMonthSelect.selectByValue("3");

		WebElement birthYearDropDown = driver.findElement(By.name("birthday_year"));
		Select birthYearSelect = new Select(birthYearDropDown);
		birthYearSelect.selectByValue("2002");
		WebElement genderRadioButton = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		genderRadioButton.click();
		WebElement createAccountButton = driver.findElement(By.name("websubmit"));
		createAccountButton.click();
		

	}

	@AfterMethod
	public void facebooksignup() {

		List<WebElement> successElements = driver
				.findElements(By.xpath("//*[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft\"]"));
		if (!successElements.isEmpty()) {
			System.out.println("The account is created successfully");
		} else {
			System.out.println("The account is not created successfully");
		}
	}
}
