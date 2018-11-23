package com.youdao.pages;

import static org.testng.Assert.fail;

import java.awt.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
//封装页面
public class mainActivity {
	Logger log = LogManager.getLogger();
	private AndroidDriver<AndroidElement> driver;
	//封装元素
	@FindBy(id = "com.youdao.note:id/add_note")
	private AndroidElement add_note_btn;

	@AndroidFindBy(id = "com.youdao.note:id/add_icon")
	private AndroidElement add_new_note_btn;

	@AndroidFindBy(id = "com.youdao.note:id/note_title")
	private AndroidElement note_title;

	@AndroidFindBy(xpath = "html/body/textarea")
	private AndroidElement content_btn; 

	@AndroidFindBy(id = "com.youdao.note:id/actionbar_complete_text")
	private AndroidElement completed_btn;

	@AndroidFindBy(xpath = "//*[contains(@text,'保存成功')]")
	private AndroidElement ensure_completeed_toast;
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout")
	private java.util.List<AndroidElement>  title_list;
	@AndroidFindBy(id = "com.youdao.note:id/btn_oks")
	private AndroidElement cancle_delete_ensure_btn;
	@AndroidFindBy(id ="com.youdao.note:id/btn_cancel" )
	private AndroidElement delete_cancel;
	//创建类的构造器
	public mainActivity(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//封装元素操作方法
	public void clickAddNoteButon() {
		add_note_btn.click();
	}
	public void clickAddNewButton() {
		add_new_note_btn.click();
	}
	public void  input_title() {
		note_title.sendKeys("this is the new title");

	}

	public void input_content() {
		// 获取当前共有几个页面
		System.out.println(driver.getContextHandles());
		// 切换到webview页面
		driver.context("WEBVIEW_com.youdao.note");
		driver.findElementByXPath("/html/body/textarea").sendKeys("this is content");
	}
	//点击完成操作
	public void completed_btn() {
		driver.context("NATIVE_APP");
		driver.findElement(By.id("com.youdao.note:id/actionbar_complete_text")).click();
	}
	//获取toast
	public void toast_exsit() {
		System.out.println(driver.findElement(By.xpath("//*[contains(@text,'保存成功')]")).getText());
	}
	//删除操作
	public void note_delete(int index) {
		if(index > title_list.size()) {
			log.error("输入的页数超出范围");
			fail("input  error");			
		}else {
			driver.performTouchAction(new TouchAction(driver).
					longPress(LongPressOptions.longPressOptions()
							.withElement(ElementOption.element(title_list.get(index)))).release().perform());
			driver.findElement(By.xpath("//android.widget.TextView[@text='删除']")).click();
		}
	}
	
	public void delete_ensure () {
		cancle_delete_ensure_btn.click();
	}
	public void delete_cancle() {
		delete_cancel.click();
	}
}
