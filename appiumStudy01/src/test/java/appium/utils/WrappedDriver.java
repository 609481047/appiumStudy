package appium.utils;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;


public class WrappedDriver<T extends WebElement> extends AndroidDriver<T>{
	Logger log = LogManager.getLogger();

	public WrappedDriver(URL remoteAddress, Capabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);
		// TODO Auto-generated constructor stub
	}
	@Override
	public T findElementById(String id) {
		log.info("开始查找id为："+id+"的元素");
		// TODO Auto-generated method stub
		return super.findElementById(id);
	}
	@Override
	public T findElementByXPath(String using) {
		// TODO Auto-generated method stub
		log.info("开始查找xpath为："+using+"的元素");
		return super.findElementByXPath(using);
	}
}
