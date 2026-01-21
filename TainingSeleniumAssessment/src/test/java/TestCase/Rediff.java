package TestCase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rediff {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='proceed']")));
        proceedButton.click();

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        String alertText1 = alert1.getText();
        System.out.println("First Alert Text: " + alertText1);

        if (alertText1.equals("Please enter a valid user name")) {
            System.out.println("First alert verification passed");
        } else {
            System.out.println("First alert verification failed");
        }

        alert1.accept();

        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot password?")));
        forgotPasswordLink.click();

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='next']")));
        nextButton.click();

        String alertText2 = alert1.getText();
        System.out.println("Second Alert Text: " + alertText2);

        if (alertText2.equals("Please enter your email ID")) {
            System.out.println("Second alert verification passed");
        } else {
            System.out.println("Second alert verification failed");
        }

        alert1.accept();
        Thread.sleep(2000);
        driver.quit();
    }
}
