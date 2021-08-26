package Tests;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectHandler {

    /*Esta clase va a manejar todas las creaciones de las instancias de cada Page
    * para no estar creando cada instancia en los tests
    * */

    public WebDriver driver;

    private HomePage homePage;
    private HeaderPage headerPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SearchResultsPage searchResultsPage;
    private ShoppingCartPage shoppingCartPage;
    private ProductPage productPage;

    public PageObjectHandler(){
    }

    public SearchResultsPage searchResultsPage(){
        if(this.searchResultsPage == null){
            searchResultsPage = new SearchResultsPage(driver);
        }
        return searchResultsPage;
    }

    public ShoppingCartPage shoppingCartPage(){
        if(this.shoppingCartPage == null){
            shoppingCartPage = new ShoppingCartPage(driver);
        }
        return shoppingCartPage;
    }

    public HomePage homePage(){
        if(this.homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public HeaderPage headerPage(){
        if(this.headerPage == null)
            headerPage = new HeaderPage(driver);
        return headerPage;
    }
    public LoginPage loginPage(){
        if(this.loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }
    public RegisterPage registerPage(){
        if(this.registerPage == null)
            registerPage = new RegisterPage(driver);
        return registerPage;
    }
}