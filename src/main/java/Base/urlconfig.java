package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class urlconfig 
{
	 Properties property;
	
	public urlconfig()
	{
		File src=new File("C:\\Users\\user2\\eclipse-workspace\\co.cra\\src\\main\\resources\\configuration\\url.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			property=new Properties();
			property.load(fis);
		}catch(Exception e){
			System.out.println("Exception is"+ e.getMessage());
		}
	}

	public  String enpsURL()
	{
		String url=property.getProperty("nps");
		return url;
	}
	
	public String bankUrl()
	{
		return property.getProperty("bank");
	}
}
