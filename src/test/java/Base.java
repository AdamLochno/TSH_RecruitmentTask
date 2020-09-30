import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    WebDriver driver = new ChromeDriver();

    @Before
    public void iksDe() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        BaseSecondLine base = new BaseSecondLine();
        base.login(driver);
    }

    @After
    public void close() {
        driver.close();
        driver.quit();
    }
}
