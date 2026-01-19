package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page3 {
    
    @FindBy(id = "price")
    private WebElement priceElement;

    @FindBy(id = "imageUrl") 
    private WebElement imageUrlElement;

    public Page3(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        return priceElement.getText();
    }

    public String getImageUrl() {
        return imageUrlElement.getAttribute("src");
    }
}
