package appium.utils;

import org.testng.annotations.DataProvider;

public class youdaoTestData {
	@DataProvider(name = "addNewNoteData")
	public static Object[][] getaddNewNoteData(){
		Object[][] objs = new Object[][] {
			{"test demo 2","","保存成功"},
			{"test demo 3","这是参数化发笔记的内容","保存成功"},
			{"","试一下有内容但是没标题","保存成功"}
		};
		return objs;
	}
}
