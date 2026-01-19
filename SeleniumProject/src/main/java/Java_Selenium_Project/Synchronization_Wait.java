package Java_Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization_Wait {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.smartbazaar.co.uk/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='sp-image']")));
		driver.findElement(By.xpath("//div[contains(@class,'brave_popup__close')]")).click();
		
		WebElement user_logo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'dropdown-toggle')]")));
		act.moveToElement(user_logo).click();
		Thread.sleep(2000);
		
		WebElement login_Register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Login / Register')]")));
		act.moveToElement(login_Register).click();
		Thread.sleep(2000);
		
		driver.quit();
		
	}
}
