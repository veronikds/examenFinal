package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Items {
	
	private WebDriver driver;
	private By noResultsBanner;
	
	public Items(WebDriver driver) {
		this.driver = driver;
		noResultsBanner = By.xpath("//*[@id='center_column']/p");
	}
	public String getLighterBannerText() {
		return driver.findElement(By.className("lighter")).getText();
	}
	public String getNoResuktsBannerText() {
		return driver.findElement(noResultsBanner).getText();
	}
	public void colorBlue() {
		driver.findElement(By.xpath("//*[@id=\"color_14\"]")).click();
	}
	
	public void colorWhite() {
		driver.findElement(By.xpath("//*[@id=\"color_8\"]")).click();
	}
	
	public void secondArt() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a")).click();
	}
}
