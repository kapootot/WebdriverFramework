package test.java.com.aw.wd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Test class to run on Grid
 */
public class GridTest {

    public WebDriver driver;
    public String URL, Node;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;

    @Parameters("browser")
    @BeforeMethod
    public void launchapp(String browser) throws MalformedURLException
    {
        String URL = "http://www.onefootball.com";

        if (browser.equalsIgnoreCase("firefox"))
        {
            System.out.println(" Executing on FireFox");
            String Node = "http://localhost:5559/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL(Node), cap);
            // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Launch website
            driver.navigate().to(URL);
            driver.manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            System.out.println(" Executing on CHROME");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            String Node = "http://localhost:5558/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Launch website
            driver.navigate().to(URL);
            driver.manage().window().maximize();
        }
        else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    @AfterMethod
    public void shutDown(){
        driver.close();
        driver.quit();
    }


    @Test
    public void testTitleInGrid1(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        System.out.println(title);
        assert true;
    }

//    @Test
//    public void testTitleInGrid2(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
//
//    @Test
//    public void testTitleInGrid3(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
//
//    @Test
//    public void testTitleInGrid4(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
//
//    @Test
//    public void testTitleInGrid5(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
//
//    @Test
//    public void testTitleInGrid6(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
//
//    @Test
//    public void testTitleInGrid7(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
//
//    @Test
//    public void testTitleInGrid8(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String title = driver.getTitle();
//        System.out.println(title);
//        assert true;
//    }
}

