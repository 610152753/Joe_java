package editData;

import gui.SqlErrorFrame;
import gui.SuccessFrame;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import csvUtil.CsvUtil;
import databaseOption.ComJdbc;

public class ProcessData
{
	public static void sqlQuery(String csvName,String characterSet,String valSeparator,String strSql)

	{
		Logger logger = Logger.getLogger(ProcessData.class);
		try
		{
			logger.info("Main Start");
			
			String currentPath = System.getProperty("user.dir");
			
			logger.info("GET Porperties File:\"" + currentPath + File.separator + "configdb.properties\"");
			
			logger.debug("Call: ComJdbc.connection Start");

			ComJdbc.connection( currentPath + File.separator + "configdb.properties");
			
			logger.debug("Call: ComJdbc.connection End");

//			logger.info("Get Sql From :" + currentPath + File.separator + "selectSql.ddl " + "Start");
//
//			ConfigGetDb getsql = new ConfigGetDb(currentPath + File.separator + "selectSql.ddl");
//			
//			String strSql = getsql.execSql; 
			
			logger.info("Exec Query Sql :\"" + strSql + "\"");
			
			logger.debug("Call : ComJdbc.execQuery() Start");

			ResultSet rs = ComJdbc.execQuery(strSql);
			
			logger.debug("Call : ComJdbc.execQuery() End");

			ResultSetMetaData metaDate = rs.getMetaData();

			int columnCount = metaDate.getColumnCount();
			
			logger.info("Geted The Table Number Of Columns :" + columnCount);

			List exportData = new ArrayList();

			Map row1 = null;

			while (rs.next())
			{
				row1 = new LinkedHashMap();

				for (int i = 1; i <= columnCount; i++)
				{
					row1.put(new Integer(i), rs.getString(i));
				}
				exportData.add(row1);
			}

			LinkedHashMap map = new LinkedHashMap();

			for (int i = 1; i <= columnCount; i++)
			{
				map.put(new Integer(i), metaDate.getColumnName(i));
			}
			
			logger.info("Exec Query End");

			logger.info("Call createCSVFile Start");
			
			CsvUtil.createCSVFile(exportData, map, currentPath + File.separator, csvName,valSeparator,characterSet);

			logger.info("Call createCSVFile End");
			
			SuccessFrame sf = new SuccessFrame();
			sf.setTitle("Successful!");
			sf.setDefaultCloseOperation(SuccessFrame.EXIT_ON_CLOSE);
			sf.getContentPane().setPreferredSize(null);
			sf.setLocationRelativeTo(null);
			sf.pack();
			sf.setVisible(true);
			
		} catch (SQLException e)
		{	
			
			SqlErrorFrame sef = new SqlErrorFrame();
			sef.setDefaultCloseOperation(SqlErrorFrame.EXIT_ON_CLOSE);
			sef.getContentPane().setPreferredSize(null);
			sef.pack();
			sef.setLocationRelativeTo(null);
			sef.setVisible(true);
			
			logger.fatal(e);
			e.printStackTrace();
		} finally
		{
			ComJdbc.close();
		}
	}
}
