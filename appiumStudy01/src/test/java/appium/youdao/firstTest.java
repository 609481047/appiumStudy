package appium.youdao;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import appium.listeners.MyRetryAnalyzer;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class firstTest extends baseTest {
	Logger log = LogManager.getLogger();
	//日志分5大级别：trace、debug、info、warn、error、fatal
	@Test(alwaysRun = false)
	public void A_loginAndLayOutTest() {
		/*
		 * driver.findElementById("com.youdao.note:id/tab_mine").click();
		 * driver.findElement(By.id("com.youdao.note:id/user_name")).click();
		 */
		driver.findElementById("com.youdao.note:id/edittext").clear();
		driver.findElement(By.id("com.youdao.note:id/edittext")).sendKeys("cheat2018@163.com");
		driver.findElementById("com.youdao.note:id/suggest_text").click();
		// driver.findElementByAndroidUIAutomator("new
		// UiSelector().text(\"cheat2018@163.com\")").click();

		driver.findElement(By.id("com.youdao.note:id/password")).findElementById("com.youdao.note:id/edittext")
				.sendKeys("chan2018");
		driver.findElement(By.id("com.youdao.note:id/login")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void B_addTest() {

		driver.findElement(By.id("com.youdao.note:id/add_note")).click();
		driver.findElement(By.id("com.youdao.note:id/add_icon")).click();
		driver.findElement(By.id("com.youdao.note:id/note_title")).sendKeys("this is the first demo");
		// 获取当前共有几个页面
		System.out.println(driver.getContextHandles());
		// 切换到webview页面
		driver.context("WEBVIEW_com.youdao.note");
		driver.findElementByXPath("/html/body/textarea").sendKeys("this is content");
		// 操作完成后
		driver.context("NATIVE_APP");
		driver.findElement(By.id("com.youdao.note:id/actionbar_complete_text")).click();
		// 查找toaste

		System.out.println(driver.findElement(By.xpath("//*[contains(@text,'保存成功')]")).getText());

	}

	@Test(invocationCount = 1)
	public void C_deleteTest() {
		driver.performTouchAction(new TouchAction<>(driver)).longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(
						driver.findElementByAndroidUIAutomator("new UiSelector().text(\"this is the first demo\")")))
				.withDuration(Duration.ofMillis(500))).release().perform();
		// uiautonmator定位，取元素的text属性
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"删除\")").click();
		// 返回，取消删除
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		// 确认删除
		driver.findElement(By.id("com.youdao.note:id/btn_ok")).click();
		// 退出功能
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementById("com.youdao.note:id/tab_mine").findElement(By.id("com.youdao.note:id/tab_mine")).click();
		driver.findElement(By.id("com.youdao.note:id/menu_setting")).click();
		driver.findElement(By.id("com.youdao.note:id/account_info")).click();
		driver.findElementById("com.youdao.note:id/logout").click();
		driver.findElement(By.id("com.youdao.note:id/clear_history")).click();

	}

	@Test(retryAnalyzer = MyRetryAnalyzer.class)
	public void D_logout() {
		// 退出功能

		driver.findElementById("com.youdao.note:id/tab_mine").findElement(By.id("com.youdao.note:id/tab_mine")).click();
		driver.findElement(By.id("com.youdao.note:id/menu_setting")).click();
		driver.findElement(By.id("com.youdao.note:id/account_info")).click();
		driver.findElementById("com.youdao.note:id/logout").click();
		driver.findElement(By.id("com.youdao.note:id/clear_history")).click();

	}
}
