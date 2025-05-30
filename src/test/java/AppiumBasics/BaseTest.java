package AppiumBasics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest
{

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass

    public void configureAppium() throws URISyntaxException, MalformedURLException
    {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\arunp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Arun");
        options.setApp("C:\\Users\\arunp\\IdeaProjects\\AppiumAutomation\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);

    }

    @AfterClass

    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
