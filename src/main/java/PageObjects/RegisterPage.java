package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    /**
     * All WebElements are identified by @FindBy annotation
     */

    @FindBy(name = "firstname")
    WebElement NameLocator;

    @FindBy(name = "lastname")
    WebElement LastNameLocator;

    @FindBy(name = "email")
    WebElement EmailLocator;

    @FindBy(name = "telephone")
    WebElement TelephoneLocator;

    @FindBy(name = "password")
    WebElement PasswordLocator;

    @FindBy(name = "confirm")
    WebElement ConfirmLocator;

    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement ConfirmRegisterMessageLocator;

    @FindBy(name = "agree")
    WebElement TermsCheckBoxLocator;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement ContinueButtonLocator;

    //Methods
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void GoToRegisterPage(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }

    public void FillForm(String firstName, String lastName, String email, String telephone, String password){
        NameLocator.sendKeys(firstName);
        LastNameLocator.sendKeys(lastName);


        EmailLocator.sendKeys(email);
        TelephoneLocator.sendKeys(telephone);
        PasswordLocator.sendKeys(password);
        ConfirmLocator.sendKeys(password);
        TermsCheckBoxLocator.click();
        ContinueButtonLocator.click();
    }

    public String GetConfirmationMessage(){
        return ConfirmRegisterMessageLocator.getText();
    }

    public String randomEmail(int size) {
        return getAlphaNumericEmail(size);
    }

    public String randomTelephone(int size){
        return getNumber(size);
    }
}