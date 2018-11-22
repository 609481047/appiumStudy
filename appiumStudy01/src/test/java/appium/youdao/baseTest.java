package appium.youdao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.google.common.io.Resources;

import appium.listeners.MyTestListener;
import appium.utils.WrappedDriver;
import appium.utils.getProperies;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseTest {
	public WrappedDriver<AndroidElement> driver;
	public DesiredCapabilities  caps = new DesiredCapabilities(); 
	@BeforeMethod
	public void d() {
		getProperies pro = new getProperies("youdao.properties");
		URL url = null;
		try {
			url = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, pro.readProperties("DEVICE_NAME"));
		caps.setCapability(MobileCapabilityType.VERSION, pro.readProperties("VERSION"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, pro.readProperties("PLATFORM_NAME"));
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, pro.readProperties("APP_PACKAGE"));
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, pro.readProperties("APP_ACTIVITY"));
		caps.setCapability(MobileCapabilityType.NO_RESET, pro.readProperties("NO_RESET"));
		caps.setCapability(MobileCapabilityType.APP, pro.readProperties("APP"));
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:/Java/eclipse/appiumStudy01/target/test-classes/chromedriver.exe");
		System.out.println(Resources.getResource("chromedriver.exe"));
		driver = new WrappedDriver(url, caps);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
	@AfterMethod
	public void endTest() {
		driver.closeApp();
		driver.quit();
	}
}