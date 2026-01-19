package TestCase;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
	@Test
	public void sample() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.quit();
	}
}

