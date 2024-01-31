package pages;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    public static WebDriver driver;
    public void initializeBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
public void launchURL(String url){
        System.out.println("url launched");
    driver.get(url);
}

    public void closeBrowser(Scenario scenario) throws Exception {
        takeSnapShot(scenario);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void takeSnapShot(Scenario scenario) throws Exception{
        TakesScreenshot ts=(TakesScreenshot) driver;
        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","Screenshot Attached");
    }

    public static Map<String, String> readJsonElement(String fileName,
                                                      String elementName) throws Exception{
        String filePath = System.getProperty("user.dir") + File.separator+"src"+File.separator+
                "test"+File.separator+"resources"+File.separator+ "testData"+File.separator+fileName;
        JsonElement root = new JsonParser().parse(new FileReader(filePath));
        JsonObject jsonObject = root.getAsJsonObject();
        JsonElement some = jsonObject.get(elementName);
        JsonObject testData = some.getAsJsonObject();
        Map<String, String> testDataMap = new HashMap<String, String>();
        for (Map.Entry<String,JsonElement> entry : testData.entrySet()) {
            testDataMap.put(entry.getKey(), entry.getValue().getAsString());
        }
        return testDataMap;
    }

    public static Response postWithoutAppURL(String url, String body) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Content-Type", ContentType.JSON.toString());
        builder.addHeader("accept", ContentType.JSON.toString());
        builder.setBody(body);
        builder.log(LogDetail.ALL);
        RequestSpecification requestSpec = builder.build();
        return RestAssured
                .expect()
                .given()
                .spec(requestSpec)
                .post(url);
    }

    public static Response put(String url, String appURL, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .put(url);
    }
}
