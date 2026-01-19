package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page3Objects {
    
    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']/bdi")
    private WebElement priceLabel;

    @FindBy(xpath = "//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")
    private WebElement imageLabel;

    public Page3Objects(WebDriver driver) {
        PageFactory.initElements(driver, this);  
    }
    
    public String getPrice() {
        return priceLabel.getText();  
    }

    public String getImageUrl() {
        return imageLabel.getAttribute("src");  
    }
}
