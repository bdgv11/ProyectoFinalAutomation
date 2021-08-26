package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div[2]/div/button")
    WebElement buttonAddToCartProductPage;

    @FindBy(xpath = "//div[@id='product-product']/div[1]")
    WebElement productAddedMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(){
        buttonAddToCartProductPage.click();
    }

    public String getAddedMessage(){
        return productAddedMessage.getText();
    }
}
