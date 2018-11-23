package appium.youdao;

import appium.utils.getProperies;

public class testDemo {
	public static void main(String[] args) {
		getProperies pro =new getProperies("youdao.properties");
		System.out.println(System.getProperty("user.dir")+pro.readProperties("CHROME_DRIVER"));
		
	}

}
