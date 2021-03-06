package test.java.com.aw.wd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by amirwaisman on 2/1/17.
 */

public class LocalTest {

    WebDriver driver;

    @BeforeMethod
    public void launchOnefootball(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("webdriver.log.driver", "OFF");
        System.setProperty("webdriver.gecko.driver", "/Users/amirwaisman/Google Drive/WebdriverFramework/wd/src/drivers/geckodriver");
        driver = new FirefoxDriver();

//        driver = new ChromeDriver();
    }

    @AfterMethod
    public void kill(){
        driver.close();
        driver.quit();
    }

    @Test
    public void testTitle(){
        driver.get("http://www.onefootball.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        System.out.println(title);
        assert true;
    }

    @Test
    public void testFacebookLogin(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("generic-header__login-link md-button md-ink-ripple")).click();
    }
}
