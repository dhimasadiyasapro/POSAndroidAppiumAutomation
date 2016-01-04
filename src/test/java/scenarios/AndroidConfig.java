package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Dhimas Adiyasa Wirawan on 11/29/2015.
 */
public class AndroidConfig {
    protected AndroidDriver driver;

    protected void prepareAppiumAndroid() throws MalformedURLException {
        File appDir = new File("D:/apps/");
        File app = new File(appDir,"app-staging-release_2-1_22.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app",app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
        //capabilities.setCapability("autoAcceptAlerts",true);
    }
}
