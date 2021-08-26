package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

    //Elementos
    @FindBy(xpath="//*[@id='top-links']/ul/li[2]/a")
    WebElement myAccountLinkLocator;

    @FindBy(linkText = "Login")
    WebElement loginButtonLocator;

    @FindBy(linkText = "Register")
    WebElement registerButtonLocator;

    @FindBy(linkText = "Shopping Cart")
    WebElement shoppingCartLocator;

    @FindBy(linkText = "Your Store")
    WebElement StoreButtonLocator;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[4]/a/span")
    WebElement topLinkCart;

    //Methods
    public HeaderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount(){
        hoverOnElement(myAccountLinkLocator);
        loginButtonLocator.click();
    }
    public void clickOnLoginButton(){
        loginButtonLocator.click();
    }
    public void clickOnRegisterButton(){
        registerButtonLocator.click();
    }
    public void clickOnTopLinkCartButton(){
        topLinkCart.click();
    }
    public void clickOnYourStoreButton(){
        StoreButtonLocator.click();
    }
}
