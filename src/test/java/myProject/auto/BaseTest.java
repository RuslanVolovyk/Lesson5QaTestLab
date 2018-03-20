package myProject.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected GeneralActions actions;
    protected boolean isMobileTesting;

    @BeforeClass
    @Parameters({"selenium.browser", "selenium.grid"})
    public void setUp(@Optional("chrome local") String browser, @Optional("http://localhost:4444/wd/hub") String gridUrl) {
        switch (browser) {
//            case "firefox":
//                try {
//                        FirefoxOptions options = new FirefoxOptions();
//                        driver = new RemoteWebDriver(new URL(gridUrl), options);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//            case "chrome":
//                try {
//                    ChromeOptions options = new ChromeOptions();
//                    driver = new RemoteWebDriver(new URL(gridUrl), options);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            case "android":
//                try {
//                    Map<String, String> mobile = new HashMap<>();
//                    mobile.put("deviceName", "iPhone 6");
//                    ChromeOptions options = new ChromeOptions();
//                    options.setExperimentalOption("MobileEmulation", options);
//                    driver = new RemoteWebDriver(options);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
            case "chrome local":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver();
//            case "firefox local":
//                System.setProperty("webdriver.gecko.driver",
//                        System.getProperty("user.dir") + "/drivers/geckodriver.exe");
//                driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        if (!isMobileTesting(browser))
            driver.manage().window().maximize();

        isMobileTesting = isMobileTesting(browser);
        actions = new GeneralActions(driver);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private boolean isMobileTesting(String browser) {
        switch (browser) {
            case "android":
                return true;
            case "firefox":
            case "ie":
            case "internet explorer":
            case "chrome":
            case "phantomjs":
            default:
                return false;
        }
    }
}
