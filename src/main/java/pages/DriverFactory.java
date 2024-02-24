package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {
   public static  WebDriver driver;
    public static final String USERNAME = "kannanre_3IAdJY";
    public static final String AUTOMATE_KEY = "Nx8ZDFbUtWU49hoMQtsS";
    public static final String url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static void initialiseBrowser() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");

        caps.setCapability("name", "sasikumar's First Test");

         driver = new RemoteWebDriver(new URL(url), caps);
// Navigating through the URL
//        driver.get("http://www.google.com");
////Locating the search box of google
//        WebElement element = driver.findElement(By.name("q"));
//// Sending browserstack keyword for search
//        element.sendKeys("BrowserStack");
//        element.submit();
//
//        System.out.println(driver.getTitle());
//        driver.quit();
    }
}
