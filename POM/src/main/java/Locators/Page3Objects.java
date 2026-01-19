package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page3Objects {
    private WebDriver driver;

    private By priceLabel = By.xpath("//span[@class='woocommerce-Price-amount amount']/bdi");  
    private By imageLabel = By.xpath("//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']"); 

    public Page3Objects(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        WebElement priceElement = driver.findElement(priceLabel);
        return priceElement.getText();
    }

    public String getImageUrl() {
        WebElement imageElement = driver.findElement(imageLabel);
        return imageElement.getAttribute("src");
    }
}
