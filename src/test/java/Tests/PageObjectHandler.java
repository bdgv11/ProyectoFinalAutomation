package Tests;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectHandler {

    /*Esta clase va a manejar todas las creaciones de las instancias de cada Page
    * para no estar creando cada instancia en los tests
    * */

    public WebDriver driver;

    private HomePage homePage;

    public PageObjectHandler(){

    }

    public HomePage homePage(){

        if(this.driver == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}