import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;

import static java.util.concurrent.TimeUnit.SECONDS;


public class TeslLoginPage {

    private static WebDriver driver;

    @Test
    public void testAPositiveLogin() throws Exception {

        new Login();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tenet.tv/");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);



        WebElement serchButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/div/ul[2]/li[3]/a"));
        serchButton.click();

        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys(Login.login);

        WebElement passwordField = driver.findElement(By.id("passw"));
        passwordField.sendKeys(Login.password);

        WebElement enterButton = driver.findElement(By.id("loginuser"));
        enterButton.click();

        Thread.sleep(5000);

        driver.close();
    }

}
