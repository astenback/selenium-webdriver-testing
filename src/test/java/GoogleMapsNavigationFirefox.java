// Generated by Selenium IDE

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GoogleMapsNavigationFirefox {

    private static WebDriver driver;
    private static Map<String, Object> vars;

    static JavascriptExecutor js;

    private static String headless;

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return options;
    }

    @BeforeTest
    @Parameters ({"headless"})
    public void setUp(@Optional ("true") String headless) {

        System.setProperty("webdriver.gecko.driver", "/Users/alans/tools/geckodriver");

        if (headless == "true"){
            driver = new FirefoxDriver(getFirefoxOptions());
        }else{
            driver = new FirefoxDriver();
        }

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Parameters ({"startingPoint", "destination", "headless"})
    public static void startingPointToDestination(@Optional ("New York City, New York") String startingPoint,
                                                  @Optional ("Los Angeles, California") String destination,
                                                  @Optional ("true") String headless) {

        //System.setProperty("webdriver.chrome.driver", "/Users/alans/tools/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/alans/tools/geckodriver");

        if (headless == "true"){
            driver = new FirefoxDriver(getFirefoxOptions());
        }else{
            driver = new FirefoxDriver();
        }

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/maps");
        driver.manage().window().setSize(new Dimension(1024, 800));
        driver.findElement(By.id("searchboxinput")).sendKeys(destination);
        driver.findElement(By.id("searchboxinput")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".iRxY3GoUYUY__promoted .iRxY3GoUYUY__button")).click();
        driver.findElement(By.cssSelector("#sb_ifc51 > .tactile-searchbox-input")).sendKeys(startingPoint);
        driver.findElement(By.cssSelector("#sb_ifc51 > .tactile-searchbox-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("#section-directions-trip-title-0 > span")).click();

        driver.quit();
    }

    public static void main (String args[]){

        String headless = "true";

        GoogleMapsNavigationFirefox.startingPointToDestination("Miami, Florida", "Seattle, Washington", headless);
        GoogleMapsNavigationFirefox.startingPointToDestination("New York City, New York", "Los Angeles, California", headless);
        GoogleMapsNavigationFirefox.startingPointToDestination("Portland, Maine", "San Diego, California", headless);

    }
}
