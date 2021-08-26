package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//*[@id='content']/div[3]/div[2]/a")
    WebElement checkOutButton;

    //@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']/i")
    @FindBy(xpath = "//div[@id='checkout-cart']/div/i/..")
    WebElement errorMessage;

    @FindBy(xpath = "//div[@id='content']//tbody/tr/td[2]/a")
    WebElement firstProductName;

    private String productRowLocator = "//div[@id='content']//tr[contains(.,'name')]"; //Este agarra todo el row de la tabla
    private WebElement productRow;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckOutButton(){
        clickOnElement(checkOutButton);
    }

    public boolean isProductRowDisplayed(String name){
        this.productRow = driver.findElement(By.xpath(productRowLocator.replace("<name>",name)));
        return this.productRow.isDisplayed();
    }

    public String getErrorMessageProductCheckOut(){
        return getTextFromElement(errorMessage);
    }

    public String productAddedCorrectly(){
        return firstProductName.getText();
    }
}