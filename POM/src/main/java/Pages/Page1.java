package Pages;

import Pages.Page1;
import org.openqa.selenium.WebDriver;

import Locators.Page1Objects;

public class Page1 {
    private WebDriver driver;
    //private Page1 page1;
    private Page1Objects page1Objects;

    public Page1(WebDriver driver) {
        this.driver = driver;
        //this.page1 = new Page1(driver);
        this.page1Objects = new Page1Objects(driver);
    }

    public void closePopup() {
    	page1Objects.closePopup();
    }

    public void searchForRice(String riceName) {
    	page1Objects.searchForRice(riceName);
    }
}