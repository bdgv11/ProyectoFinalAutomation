package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage{

    //Web elements
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement messageProductAdded;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToCart(){
        clickOnElement(addToCartButton);
    }

    public String getMessageProductAdded(){
        return messageProductAdded.getText();
    }
}
