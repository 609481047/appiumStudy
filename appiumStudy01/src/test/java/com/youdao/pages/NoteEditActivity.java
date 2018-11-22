package com.youdao.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NoteEditActivity {
	
	
	//笔记title
	@AndroidFindBy(id="com.youdao.note:id/note_title")
	private AndroidElement note_title_input;
	//笔记内容
	@AndroidFindBy(xpath="//textarea")
	private AndroidElement note_content_input;
	
	//保存笔记
	@AndroidFindBy(id="com.youdao.note:id/actionbar_complete_text")
	private AndroidElement finish_btn;
	
	private AndroidDriver<AndroidElement> driver;
	
	public NoteEditActivity(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void editNote(String title, String content) {
		note_title_input.sendKeys(title);
		driver.context("WEBVIEW_com.youdao.note");
		note_content_input.sendKeys(content);
	}
	
	public void clickFinishButton() {
		driver.context("NATIVE_APP");
		finish_btn.click();
	}
}

