import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckBoxesTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement a = driver.findElement(By.cssSelector("[type=checkbox]"));
        a.isSelected();
        Assert.assertFalse(a.isSelected());
        a.click();
        Assert.assertTrue(a.isSelected());
        WebElement b = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        b.isSelected();
        Assert.assertTrue(b.isSelected());
        b.click();
        Assert.assertFalse(b.isSelected());
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
