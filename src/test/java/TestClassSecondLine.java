import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClassSecondLine {
    public void zbiorczeZadanie(WebDriver driver) {
        goToMain(driver);
        addOneDress(driver);
        addSecondDress(driver);
    }

    public void goToMain(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement mainLogo = driver.findElement(By.cssSelector("a[title='My Store']"));
        mainLogo.click();
    }

    public void addOneDress(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement dressPicture = driver.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
        Actions action = new Actions(driver);
        action.moveToElement(dressPicture).perform();
        WebElement addToKartButton = driver.findElement(By.cssSelector("a[data-id-product='1']"));
        addToKartButton.click();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement continueShopping = driver.findElement(By.cssSelector("span[class='continue btn btn-default button exclusive-medium']"));
        continueShopping.click();
    }

    public void addSecondDress(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[title='Blouse']")));
        WebElement dressPicture = driver.findElement(By.cssSelector("img[title='Blouse']"));
        Actions action = new Actions(driver);
        action.moveToElement(dressPicture).perform();
        WebElement addToKartButton = driver.findElement(By.cssSelector("a[data-id-product='2']"));
        addToKartButton.click();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement goToCartButton = driver.findElement(By.cssSelector("a[class='btn btn-default button button-medium']"));
        goToCartButton.click();
    }

    public void asercja(WebDriver driver) {
        assertEquals("2 Products", driver.findElement(By.cssSelector("span[id='summary_products_quantity']")).getText());
    }
}
