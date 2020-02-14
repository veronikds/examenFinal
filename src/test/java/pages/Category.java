package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Category {
	
	private WebDriver driver;
	private By sortDropDown;

	
	public Category(WebDriver driver) {
		this.driver = driver;
		sortDropDown = By.id("selectProductSort");
	}
	 
	public void clickSummerDress() {
		driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")).click();
	}
	
	public void clickDress() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
	}
	

	
	public void selectByText(String textToSearch) {
	Select order = new Select(driver.findElement(sortDropDown)); 
	order.selectByVisibleText(textToSearch);
	}
	
	public void selectByValue(String value) {
		Select order = new Select(driver.findElement(sortDropDown));
		order.selectByValue(value);
	}
	
	public void selectByIndex(int value) {
		Select order = new Select(driver.findElement(sortDropDown));
		order.selectByIndex(value);
	}
	
	public void clickTops() {
		driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")).click();
	}
	

}