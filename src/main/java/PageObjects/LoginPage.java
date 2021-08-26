package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    //public WebDriver driver;

    //Elementos
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By submitButtonSelector = By.cssSelector("[value='Login']");

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void EnterEmail(String email){
        this.driver.findElement(emailInputLocator).sendKeys(email);
    }
    public void EnterPassword(String password){
        this.driver.findElement(passwordInputLocator).sendKeys(password);
    }
    public void ClickSubmitButton(){
        this.driver.findElement(submitButtonSelector).click();
    }

    public void login(String username, String password){
        this.driver.findElement(emailInputLocator).sendKeys(username);
        this.driver.findElement(passwordInputLocator).sendKeys(password);
        this.driver.findElement(submitButtonSelector).click();
    }

    public void GoToLoginPage(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
    }

}
