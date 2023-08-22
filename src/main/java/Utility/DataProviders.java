package Utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import ExcelManager.DataUtil;
import ExcelManager.ExcelReader;

public class DataProviders 
{
	
	

	@DataProvider(name="bankManagerDP")
	public static Object[][] getDataSuit1(Method m) {

		System.out.println(m.getName());
		ExcelReader excel=new ExcelReader(Constants.excelpath);
		String testcase=m.getName();
		return DataUtil.dataProvider(testcase, excel);
	}
	
	
	
	
	@DataProvider(name="customerDP")
	public static Object[][] getDataSuit2(Method m) {

		System.out.println(m.getName());
		ExcelReader excel=new ExcelReader(Constants.excelpath);
		String testcase=m.getName();
		return DataUtil.dataProvider(testcase, excel);
	}

}
