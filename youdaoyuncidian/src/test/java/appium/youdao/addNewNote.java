package appium.youdao;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.youdao.pages.NoteEditActivity;
import com.youdao.pages.mainActivity;

public class addNewNote extends baseTest {
	
	@Test(description="添加一条带标题和内容的笔记")
	public void AddTest() {
		mainActivity main = new mainActivity(driver);
		main.clickAddNoteButon();
		main.clickAddNewButton();
		main.input_title();
		main.input_content();
		main.completed_btn();
		main.toast_exsit();
	}



@Test( enabled = false,  dataProviderClass=appium.utils.youdaoTestData.class,dataProvider="addNewNoteData",description="这是使用dataprovider来进行驱动测试的")
public void addNewNoteTest(String title, String content, String toastMsg) {
	mainActivity main = new mainActivity(driver);
	main.clickAddNoteButon();
	main.clickAddNewButton();
	NoteEditActivity noteEditActivity = new NoteEditActivity(driver);
	noteEditActivity.editNote(title, content);
	noteEditActivity.clickFinishButton();
	try {
		driver.findElementByXPath("//*[@text='"+toastMsg+"']");
		
	}catch(Exception e) {
		e.printStackTrace();
		fail("未找到toast提示——"+toastMsg);
	}
}
}