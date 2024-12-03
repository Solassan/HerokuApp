import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TheInputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TheInputsTest() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("1");
        input.sendKeys(Keys.ARROW_UP);
        String actualValue = input.getAttribute("value");
        Assert.assertEquals(actualValue, "2");
        input.clear();
        input.sendKeys("12");
        input.sendKeys(Keys.ARROW_DOWN);
        String actualValueDown = input.getAttribute("value");
        Assert.assertEquals(actualValueDown, "11");
        input.clear();
        input.sendKeys("adc");
        String actualValueText = input.getAttribute("value");
        Assert.assertEquals(actualValueText, "");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
