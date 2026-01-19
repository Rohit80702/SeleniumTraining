package Pages;

import Locators.Page1Objects;  
import org.openqa.selenium.WebDriver;

public class Page1 {

    private Page1Objects page1Objects;

    public Page1(WebDriver driver) {
        this.page1Objects = new Page1Objects(driver);
    }

    public void closePopup() {
        page1Objects.closePopup();
    }

    public void searchForRice(String riceName) {
        page1Objects.searchForRice(riceName);
    }
}
