import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;

    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void getText() {
        driver.get("https://demo.zeuz.ai/web/level/one/actions/save_text");
        String getText = driver.findElement(By.id("randomText")).getText();
        driver.findElement(By.id("enter_text")).sendKeys(getText);
        driver.findElement(By.id("verify_id")).click();
        String text = driver.findElement(By.id("text_showing")).getText();
        Assert.assertTrue(text.contains("You have successfully verified the text"));
    }

    @After
    public void stop() {
        driver.close();
    }
}

