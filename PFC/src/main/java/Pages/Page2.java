package Pages;

import Locators.Page2Objects;
import org.openqa.selenium.WebDriver;

public class Page2 {

    private Page2Objects page2Objects;

    public Page2(WebDriver driver) {
        this.page2Objects = new Page2Objects(driver);
    }

    public void clickOnRiceProduct(String riceName) {
        page2Objects.clickOnRiceProduct(riceName);
    }

}
