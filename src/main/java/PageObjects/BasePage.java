package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public Actions action;

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        action = new Actions(driver);
    }

    public static String getAlphaNumericEmail(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString() + "@ucreativa.com";
    }

    public static String getNumber(int n) {

        String AlphaNumericString = "1234567890";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public boolean hoverOnElement(WebElement element) {
        try {
            action.moveToElement(element).build().perform();
            element.click();
            return true;
        } catch (Exception e) {
            System.err.println("Hover on element failed.");
            return false;
        }
    }

    public boolean typeOnElement(WebElement element, String text) {

        try {

            if (waitForElementEnable(element)) {
                element.clear();
                element.sendKeys(text);
                return true;

            } else {

                return false;

            }

        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitForElementEnable(WebElement element) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return false;
            // TODO: handle exception
        }
    }

    public boolean waitForElementVisible(WebElement element) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));

            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return false;
        }
    }

    public String getTextFromElement(WebElement element) {
        try {
            if (waitForElementVisible(element))
                return element.getText();
            return "";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "";
        }
    }

    public boolean clickOnElement(WebElement element) {
        try {
            if (waitForElementEnable(element)) {
                element.click();
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {

            return false;
        }
    }

}