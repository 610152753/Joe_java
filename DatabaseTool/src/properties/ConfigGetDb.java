package properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigGetDb
{
	public String url = null;
	
	public String driver = null;
	
	public String user = null;
	
	public String password = null;
	
	public String execSql = null; 

	public  ConfigGetDb(String fileName)
	{
		FileInputStream inputFile = null;
		
		try
		{
			inputFile = new FileInputStream(fileName);
	
		} catch (FileNotFoundException e)
		{
			System.out.println(fileName + ":" + e);
		
			e.printStackTrace();
		}
		Properties props = new Properties();
		
		InputStream in = new BufferedInputStream(inputFile);
		
		try
		{
			props.load(in);
		
			this.url = props.getProperty("url");
			
			this.driver = props.getProperty("driver");
			
			this.user = props.getProperty("user");
			
			this.password = props.getProperty("password");
			
			this.execSql = props.getProperty("sql");
		
		} catch (IOException e)
		
		{
			System.out.println(fileName + ":" + e);
		
			e.printStackTrace();
		}
	}
}
