package Tests;

import DataProviders.ProductsProvider;
import Pojo.Products;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductTests extends BaseClass{

    @Description("Test to validate different prices")
    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = ProductsProvider.class)
    public void Test_Validate_Different_Prices(Products testData){

        //Set up
        String username = "bryan.guzman.valerin@ucreativa.com";
        String pass= "XTyeZZnt@md5VvJ";
        String messageProductAdded = "Success: You have added MacBook to your shopping cart!";

        //Go to login
        loginPage().GoToLoginPage();
        loginPage().login(username,pass);

        //Go back to home page in order to search a product
        homePage().GoToHomePage();
        homePage().typeOnSearch(testData.getSearchCriteria());
        homePage().clickOnSearchButton();

        //Select the first product on list
        homePage().clickOnTittleFirstSearchResult();

        //Add to cart on search results page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchResultsPage().addToCart();
        //Assert.assertTrue(searchResultsPage().getMessageProductAdded().contains(messageProductAdded),"Product message differences");

        productPage().clickChangeToDollar();
        Assert.assertEquals(productPage().getDollarPrice(), testData.getDollarPrice());

        productPage().clickChangeToEuro();
        Assert.assertEquals(productPage().getEuroPrice(), testData.getEuroPrice());

        productPage().clickChangeToPound();
        Assert.assertEquals(productPage().getPoundPrice(), testData.getSterlingPoundPrice());
    }
}