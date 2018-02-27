import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestTopMenu {

    private static WebDriver driver;

    @Test
    public void testTopMenu() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tenet.tv");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        WebElement aboutProgectTVButton = driver.findElement(By.cssSelector(".top-menu-left > li:nth-child(2) > a:nth-child(1)"));
        aboutProgectTVButton.click();

        Thread.sleep(2000);

        String actualText = "TENET-TV — ВСЕ, ЧТО ЛЮБИШЬ";
        String expectedText = driver.findElement(By.cssSelector(".o-proeke-tenet-tv > h1:nth-child(1)")).getText();

        Assert.assertEquals(actualText, expectedText);


        WebElement lookTVButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/div/ul[1]/li[3]/a"));
        lookTVButton.click();

        Thread.sleep(2000);

        String actualText2 = "TENET-TV - смотрите везде, где есть Интернет";
        String expectedText2 = driver.findElement(By.cssSelector(".page-tarif > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h1:nth-child(1)")).getText();

        Assert.assertEquals(actualText2, expectedText2);


        WebElement costTVButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div/div/ul[1]/li[4]/a"));
        costTVButton.click();

        Thread.sleep(2000);

        String actualText3 = "TENET-TV: СМОТРИ ВСЕ, ЧТО ЛЮБИШЬ И НА ЧЁМ УДОБНО";
        String expectedText3 = driver.findElement(By.xpath("//*[@id=\"scroller\"]/div[1]/div[2]/div/div/h1")).getText();

        Assert.assertEquals(actualText3, expectedText3);

        driver.close();


    }
}
