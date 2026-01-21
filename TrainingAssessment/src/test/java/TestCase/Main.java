package TestCase;

import Browser.browser;
import Locators.LoginPage;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {

            browser.openBrowser();
            driver = browser.driver;

            driver.manage().window().maximize();
            driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

            LoginPage.clickSignIn();

            LoginPage.clickForgotPassword();

        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (driver != null) {
                Thread.sleep(3000);
                driver.quit();
            }
        }
    }
}
