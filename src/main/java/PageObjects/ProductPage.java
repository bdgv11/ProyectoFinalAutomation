package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div[2]/div/button")
    WebElement buttonAddToCartProductPage;

    @FindBy(xpath = "//div[@id='product-product']/div[1]")
    WebElement productAddedMessage;

    @FindBy(xpath = "//div[@class='pull-left']/form/div/button")
    WebElement currencyButton;


    @FindBy(xpath = "//div[@class='pull-left']/form/div/ul/li[3]/button")
    WebElement dollarCurrencyButton;

    @FindBy(xpath = "//div[@class='pull-left']/form/div/ul/li[1]/button")
    WebElement euroCurrencyButton;

    @FindBy(xpath = "//div[@class='pull-left']/form/div/ul/li[2]/button")
    WebElement poundSterlingCurrencyButton;

    @FindBy(xpath = "//div[@id='content']/div/div[2]/ul[2]/li/h2")
    WebElement dollarPriceLocator;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(){
        buttonAddToCartProductPage.click();
    }

    public String getAddedMessage(){
        return productAddedMessage.getText();
    }

    public void clickChangeToDollar(){
        hoverOnElement(currencyButton);
        clickOnElement(dollarCurrencyButton);
    }

    public void clickChangeToEuro(){
        hoverOnElement(currencyButton);
        clickOnElement(euroCurrencyButton);
    }

    public void clickChangeToPound(){
        hoverOnElement(currencyButton);
        clickOnElement(poundSterlingCurrencyButton);
    }

    public double getDollarPrice(){

        String text = getTextFromElement(dollarPriceLocator);
        if(text.startsWith("$")) {
           text= text.substring(1);
        }
        return Double.parseDouble(text);
    }

    public double getPoundPrice(){

        String text = getTextFromElement(dollarPriceLocator);
        if(text.startsWith("£")) {
            text= text.substring(1);
        }
        return Double.parseDouble(text);
    }

    public double getEuroPrice(){

        String text = getTextFromElement(dollarPriceLocator);
        if(text.endsWith("€")) {
            text= text.substring(0, text.length() - 1);
        }
        return Double.parseDouble(text);
    }
}
