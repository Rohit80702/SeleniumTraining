package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;

    By nextButton = By.name("proceed");
    By alertMessage = By.xpath("//div[@class='alert_box']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public String getAlertText() {
        return driver.findElement(alertMessage).getText();
    }

    public boolean verifyAlertMessage(String expectedAlertText) {
        return getAlertText().equals(expectedAlertText);
    }
}
