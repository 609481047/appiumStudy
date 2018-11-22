package appium.youdao;

import org.testng.annotations.Test;

import com.youdao.pages.mainActivity;

public class note_delete extends baseTest {
	
	@Test
	public void note_delete() {
		mainActivity mainActivity = new mainActivity(driver);
		mainActivity.note_delete(10);
	}
	
}
