package appium.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	private static int RetryCount = 1;
	private static int maxRetryCount = 2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

		if(RetryCount <= maxRetryCount) {
			RetryCount ++;
			System.out.println("---->>"+result.getName()+"监测到有测试用例执行失败，开始重新执行"+"第"+RetryCount+"次");
			return true;

		}
		return false;
	}

}
