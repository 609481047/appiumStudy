package appium.youdao;

import org.testng.annotations.Test;

import com.youdao.pages.mainActivity;

public class note_delete extends baseTest {
	
	@Test(description="删除，确认删除")
	public void note_delete_Ensure() {
		mainActivity mainActivity = new mainActivity(driver);
		mainActivity.note_delete(0);
		mainActivity.delete_ensure();
	}
	@Test(description="删除，然后取消删除")
	public void note_delete_Cancle() {
		mainActivity mainActivity = new mainActivity(driver);
		mainActivity.note_delete(0);
		mainActivity.delete_cancle();
	}
	
}
