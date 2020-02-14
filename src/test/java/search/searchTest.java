package search;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Category;
import pages.Index;
import pages.Items;

public class searchTest {
	
	private WebDriver driver;
	private Index index;
	private Items items;
	private Category category;
		
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		index = new Index(driver);
		items = new Items(driver);
		category = new Category(driver);
	}
	
	@AfterMethod
	private void tearDown() {
		driver.close();
		driver.quit();
	}

	@Test
	public void searchExist() {
		index.search("Blouse");
		String textNameShirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).getText();
		System.out.println(textNameShirt);
		Assert.assertEquals(textNameShirt, "Blouse");
	}

	@Test
	public void searchNoExist() {
		index.search("Tennis");
		String textNotFound = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		System.out.println(textNotFound);
		Assert.assertEquals(textNotFound, "No results were found for your search \"Tennis\"");
	}
	
	@Test
	public void summerDress() {
		index.clickDressesLink();
		category.clickSummerDress();
		category.clickDress();
		items.colorBlue();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "http://automationpractice.com/index.php?id_product=5&controller=product#/size-s/color-blue");
	}

	@Test
	public void women() {
		index.clickWomenLink();
		category.clickTops();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "http://automationpractice.com/index.php?id_category=4&controller=category");
		items.secondArt();
		items.colorWhite();
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);
		Assert.assertEquals(url2, "http://automationpractice.com/index.php?id_product=2&controller=product#/size-s/color-white");
	}
	
	@Test
	public void Dropdowns() {
		index.clickTShirt();
		category.selectByText("Price: Lowest first");
	}
	
	@Test
	public void authError() {
		index.clickSignIn();
		index.emailLog("email@valido.com");
		index.passLog("passvalida123");
		index.clickLog();
		String errorText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		System.out.println(errorText);
		Assert.assertEquals(errorText, "Authentication failed.");
	}
}