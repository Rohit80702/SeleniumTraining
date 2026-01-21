package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RediffAutomation {

    public static void main(String[] args) {

        // Set path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Initialize the WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Define the expected alert messages
        String expectedAlertTextSignIn = "Please enter your username and password.";
        String expectedAlertTextForgotPassword = "Please enter your email address.";

        try {
            // Step 1: Launch the browser and navigate to the Rediff mail login page
            driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

            // Step 2: Leave all fields empty and click the 'Sign In' button
            WebElement signInButton = driver.findElement(By.name("proceed"));
            signInButton.click();

            // Step 3: Wait for the alert to appear and fetch the text
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait for alert
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            // Verify the alert message
            if (alertText.equals(expectedAlertTextSignIn)) {
                System.out.println("Sign In alert verified with text: " + alertText);
            } else {
                System.out.println("Alert message mismatch. Expected: " + expectedAlertTextSignIn + ", but got: " + alertText);
            }

            // Close the alert
            alert.accept();

            // Step 4: Click the 'Forgot password?' link
            WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot password?"));
            forgotPasswordLink.click();

            // Step 5: Click the 'Next' button without filling any details
            WebElement nextButton = driver.findElement(By.name("proceed"));
            nextButton.click();

            // Step 6: Wait for the alert and fetch the text
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait for alert
            alert = driver.switchTo().alert();
            alertText = alert.getText();

            // Verify the alert message
            if (alertText.equals(expectedAlertTextForgotPassword)) {
                System.out.println("Forgot password alert verified with text: " + alertText);
            } else {
                System.out.println("Alert message mismatch. Expected: " + expectedAlertTextForgotPassword + ", but got: " + alertText);
            }

            // Close the alert
            alert.accept();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the browser
            driver.quit();
        }
    }
}
