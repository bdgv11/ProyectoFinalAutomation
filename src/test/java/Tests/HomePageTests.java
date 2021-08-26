package Tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTests extends BaseClass {

    /*
    Agregar una orden de compras utilizando la búsqueda para encontrar el producto.
    Ir al sitio web.
    Buscar un producto (Macbook)
    Hacer click en el producto.
    Agregar el producto al carrito de compras.
    Verificar el mensaje de éxito.
    Ir al carrito de compras
    Verificar que el producto no se pueda agregar!
     */

    @Description("This test try to add one product to shopping cart")
    @Test(description = "Test add to cart")
    public void Test_Add_Cart(){

        //Set up
        String username = "bryan.guzman.valerin@ucreativa.com";
        String pass= "XTyeZZnt@md5VvJ";
        String text = "MacBook";
        String messageProductAdded = "Success: You have added MacBook to your shopping cart!";
        String errorMessageCheckOutButton = "Products marked with *** are not available in the desired quantity or not in stock!";

        Assert.assertTrue(headerPage().verifyPageLoad());

        //Go to login
        loginPage().GoToLoginPage();
        loginPage().login(username,pass);

        //Go back to home page in order to search a product
        homePage().GoToHomePage();
        homePage().typeOnSearch(text);
        homePage().clickOnSearchButton();

        //Select the first product on list
        homePage().clickOnTittleFirstSearchResult();

        //Add to cart on search results page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchResultsPage().addToCart();
        Assert.assertTrue(searchResultsPage().getMessageProductAdded().contains(messageProductAdded),"Product message differences");

        //Go to shopping cart
        headerPage().clickOnTopLinkCartButton();

        //Verify product is added
        Assert.assertEquals(shoppingCartPage().productAddedCorrectly(),text);

        shoppingCartPage().clickOnCheckOutButton();

        Assert.assertTrue(shoppingCartPage().getErrorMessageProductCheckOut().contains(errorMessageCheckOutButton), "Differences between error messages");
    }
}