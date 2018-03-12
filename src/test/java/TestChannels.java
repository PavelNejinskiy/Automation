
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import javax.swing.*;


public class TestChannels {

    private static WebDriver driver;

    @Test
    public void MyTest() throws Exception {

        new Login();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dev.tenet.tv/");
        //  driver.manage().timeouts().implicitlyWait(10, SECONDS);


        Channels channels = new Channels();

        WebElement serchButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/div/ul[2]/li[3]/a"));
        serchButton.click();

        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys(Login.login);

        WebElement passwordField = driver.findElement(By.id("passw"));
        passwordField.sendKeys(Login.password);

        WebElement enterButton = driver.findElement(By.id("loginuser"));
        enterButton.click();

        Thread.sleep(5000);

//         JavascriptExecutor jse = (JavascriptExecutor)driver;
        Actions builder = new Actions(driver);



        for (int i = 0; i < channels.getChannels().size(); i++) {
            WebElement channel = driver.findElement(By.cssSelector(channels.getChannels().get(i)));
            channel.click();
            Thread.sleep(5000);

         //   jse.executeScript("window.scrollBy(0,250)", "");
         //   builder.click().keyDown(Keys.DOWN);

         //   Thread.sleep(1000);

        }

        driver.quit();
        driver.close();
    }


}
