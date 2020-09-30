import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class TestClassSecondLine {
    public void addClothesToCart(WebDriver driver) {
        goToMain(driver);
        addOneDress(driver);
        addSecondDress(driver);
    }

    public void goToMain(WebDriver driver) {
        waitForIt(driver);
        WebElement mainLogo = findByCSS(driver,"a[title='My Store']");
        mainLogo.click();
    }

    public void addOneDress(WebDriver driver) {
        waitForIt(driver);
        WebElement dressPicture = findByCSS(driver,"img[title='Faded Short Sleeve T-shirts']");
        Actions action = new Actions(driver);
        action.moveToElement(dressPicture).perform();
        WebElement addToCartButton = findByCSS(driver,"a[data-id-product='1']");
        addToCartButton.click();
        waitForIt(driver);
        WebElement continueShopping = findByCSS(driver,"span[class='continue btn btn-default button exclusive-medium']");
        continueShopping.click();
    }

    public void addSecondDress(WebDriver driver) {
        waitForIt(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[title='Blouse']")));
        WebElement dressPicture = findByCSS(driver,"img[title='Blouse']");
        Actions action = new Actions(driver);
        action.moveToElement(dressPicture).perform();
        WebElement addToCartButton = findByCSS(driver,"a[data-id-product='2']");
        addToCartButton.click();
        waitForIt(driver);
        WebElement goToCartButton = findByCSS(driver,"a[class='btn btn-default button button-medium'] i");
        goToCartButton.click();
    }

    public void checkAmountOfClothesAtCart(WebDriver driver) {
        assertEquals("2 Products", driver.findElement(By.cssSelector("span[id='summary_products_quantity']")).getText());
    }
    public void waitForIt(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }
    public WebElement findByCSS(WebDriver driver, String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator));
    }
}
