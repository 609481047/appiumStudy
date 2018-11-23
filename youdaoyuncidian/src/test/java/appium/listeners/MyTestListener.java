package appium.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyTestListener extends TestListenerAdapter    {
	private static Logger log = LogManager.getLogger();
	public static  AndroidDriver<AndroidElement> driver;
	@SuppressWarnings("unchecked")
	public void onTestFailure(ITestResult tr) {
		System.out.println("监测到测试用例执行失败:"
				+tr.getName()
				+"该方法在："+tr.getTestClass().getName()+"类中");
		Reporter.log("监测到测试用例执行失败:"
				+tr.getName()
				+"该方法在："+tr.getTestClass().getName()+"类中");
		String directory = "screenShot";
		String fileName = tr.getTestClass().getName()+"."
				+tr.getMethod().getMethodName()
				+"_"+ new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss").format(new Date())+".png";
		try {
			driver = (AndroidDriver<AndroidElement>) tr.getTestClass().getRealClass().getField("driver").get(tr.getInstance());
			File file = driver.getScreenshotAs(OutputType.FILE);
			File dir = new File(directory);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			file.renameTo(new File(dir,fileName));
			log.info("错误截图完成，图片保存在："+dir+"/"+fileName);

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
