package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int counter=0;
	int retryLimit=2;
	public boolean retry(ITestResult result) //called inside the test annotation of test class
	{
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
