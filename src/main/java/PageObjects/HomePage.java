package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    //Web Elements
    @FindBy(name = "search")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='search']/span/button")
    WebElement buttonSearch;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[1]/div/div[2]/div/h4/a")
    WebElement titleFirstSearchResult;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[1]/div/div[2]/div[2]/button[1]/i")
    WebElement firstSearchCartButton;


    //driver.findElement(By.name("search")).sendKeys("macbook");
    //driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
    //driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/i")).click();
    //driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  void GoToHomePage(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnYourStoreButton();
    }

    public void typeOnSearch(String text){
        typeOnElement(searchField,text);
    }

    public void clickOnSearchButton(){
        buttonSearch.click();
    }

    public void clickOnTittleFirstSearchResult(){
        titleFirstSearchResult.click();
    }
}