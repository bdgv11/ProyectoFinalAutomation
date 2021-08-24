package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass extends PageObjectHandler{

    private String URL = "https://demo.opencart.com/";

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new FirefoxDriver();
        }

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void beforeMethod(){
        TakeScreenchot(driver);
        driver.close();
        try {
            driver.quit();
        }catch (WebDriverException ex){
            System.out.println("Driver didn't close");
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenchot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}