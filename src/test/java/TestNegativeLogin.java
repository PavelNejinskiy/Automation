import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import static java.util.concurrent.TimeUnit.SECONDS;

public class TestNegativeLogin {


    private static WebDriver driver;

    @Test
    public void testNegativeLogin() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tenet.tv/");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        WebElement serchButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/div/ul[2]/li[3]/a"));
        serchButton.click();

        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("test");

        WebElement passwordField = driver.findElement(By.id("passw"));
        passwordField.sendKeys("test");

        WebElement enterButton = driver.findElement(By.id("loginuser"));
        enterButton.click();

        Thread.sleep(2000);

        String actualText = "Увы, но такая комбинация логина и пароля отсутствует.";

        WebElement alert = driver.findElement(By.cssSelector(".bootstrap-dialog-message > div:nth-child(1)"));
        String expectedText = alert.getText();

        Assert.assertEquals(actualText , expectedText);

        driver.close();
    }

}
