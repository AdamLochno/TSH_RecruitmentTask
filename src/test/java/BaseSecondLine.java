import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseSecondLine {

    String username = "adamlochno@gmail.com";
    String password = "300920TSh";

    public void login(WebDriver driver) {
        WebElement signInButton = driver.findElement(By.cssSelector("a[class='login']"));
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement inputEMailAddress = driver.findElement(By.cssSelector("input[id='email']"));
        inputEMailAddress.sendKeys(username);
        WebElement inputPassword = driver.findElement(By.cssSelector("input[id='passwd']"));
        inputPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement logInButton = driver.findElement(By.cssSelector("button[id='SubmitLogin']"));
        logInButton.click();
    }
}
