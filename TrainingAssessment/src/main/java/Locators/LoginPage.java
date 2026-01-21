package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    static WebDriver driver;

    static By signInButton = By.name("proceed");
    static By forgotPasswordLink = By.linkText("Forgot password?");
    By alertMessage = By.xpath("//div[@class='alert_box']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    }

    public static void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public static void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public String getAlertText() {
        return driver.findElement(alertMessage).getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean verifyAlertMessage(String expectedAlertText) {
        return getAlertText().equals(expectedAlertText);
    }
}
