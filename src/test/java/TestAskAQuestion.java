import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestAskAQuestion {


    private static WebDriver driver;

    @Test
    static void testAskAQuestion() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tenet.tv");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);


        WebElement costTVButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/div/ul[1]/li[5]/a"));
        costTVButton.click();

        WebElement formFullName = driver.findElement(By.cssSelector("#name_help"));
        formFullName.sendKeys("Automation");

        WebElement formEmail = driver.findElement(By.cssSelector("#mail_help"));
        formEmail.sendKeys("m0rik1@ukr.net");

        WebElement formPhone = driver.findElement(By.cssSelector("#phone_help"));
        formPhone.sendKeys("+380952225522");

        WebElement formTopicMassage = driver.findElement(By.cssSelector("#subject_help"));
        formTopicMassage.sendKeys("Automation Test");

        WebElement formMassage = driver.findElement(By.cssSelector("#message_help"));
        formMassage.sendKeys("Test message");

        WebElement keySend = driver.findElement(By.cssSelector(".inp-reg"));
        keySend.click();

        driver.close();
    }

}
