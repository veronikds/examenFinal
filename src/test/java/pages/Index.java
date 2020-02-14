package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Index {
	
	private By searchField;
	private By searchButton;
	private WebDriver driver;
	
	public Index(WebDriver driver) {
		this.driver = driver;	
		searchField = By.id("search_query_top");
		searchButton = By.name("submit_search");
	}
	
	public void search(String item) {
		driver.findElement(searchField).sendKeys(item);
		driver.findElement(searchButton).click();
	}
	
	public void clickWomenLink() {
		driver.findElement(By.linkText("Women")).click();
	}
	
	public void clickDressesLink() {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
	}
	
	public void clickTShirt() {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
	}
	
	public void clickSignIn() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}
	
	public void emailLog(String email) {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
	}
	
	public void passLog(String pass) {
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(pass);
	}
	
	public void clickLog() {
		driver.findElement(By.id("SubmitLogin")).click();
	}
}
