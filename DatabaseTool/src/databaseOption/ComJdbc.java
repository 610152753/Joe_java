package databaseOption;

import gui.SqlErrorFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import properties.ConfigGetDb;

public class ComJdbc
{
	static Connection conn = null;
	
	static Statement stmt = null;
	
	static ResultSet rs = null;
	
	static Logger logger = Logger.getLogger(ComJdbc.class);
	
	public static void connection(String configfile)
	{
		ConfigGetDb getconfig = new ConfigGetDb(configfile);
		
		String driver = getconfig.driver;
		
		String url = getconfig.url;
		
		String uesr = getconfig.user;
		
		String password = getconfig.password;
		
		try
		{
			Class.forName(driver);
			
			logger.debug("Connection database url :" + url + "User :" + uesr);

			logger.info("Connection database Start");
			
			conn = DriverManager.getConnection(url, uesr, password);
			
			logger.info("Connection database Successed");
			
		} catch (Exception e)
		{
			logger.fatal(e);
			
			e.printStackTrace();
		}
	}
	
	public static ResultSet execQuery(String strSql)
	{

		try
		{
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			logger.fatal(e);
			
			e.printStackTrace();
		}

		try
		{
			logger.info("Execute Query Sql Start");
			rs = stmt.executeQuery(strSql);
		} catch (SQLException e)
		{
			SqlErrorFrame sef = new SqlErrorFrame();
			sef.setTitle("SQL ERROR");
			sef.setDefaultCloseOperation(SqlErrorFrame.EXIT_ON_CLOSE);
			sef.getContentPane().setPreferredSize(null);
			sef.pack();
			sef.setLocationRelativeTo(null);
			sef.setVisible(true);
			
			logger.fatal(e);
			
			e.printStackTrace();
			
		} 
		
		logger.info("Execute Query Sql End");
		
		return rs;
	}
	
	public static int execUpdate(String strSql)
	{

		try
		{
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			logger.fatal(e);
			
			e.printStackTrace();
		}

		try
		{
			logger.info("Execute Update Sql Start");
			logger.info("Execute Update Sql statment:" + strSql);
			int SqlR  = stmt.executeUpdate(strSql);
			return SqlR;
		} catch (SQLException e)
		{
			
			SqlErrorFrame sef = new SqlErrorFrame();
			sef.setTitle("SQL ERROR");
			sef.setDefaultCloseOperation(SqlErrorFrame.EXIT_ON_CLOSE);
			sef.getContentPane().setPreferredSize(null);
			sef.pack();
			sef.setLocationRelativeTo(null);
			sef.setVisible(true);
			
			logger.fatal(e);
			
			e.printStackTrace();
			
			return -1;
			
		} 
		

		
	}
	
	public static void close(){
		
		try
		{
			rs.close();
		} catch (SQLException e)
		{
			logger.fatal(e);
			
			e.printStackTrace();
		}
		
		try
		{
			stmt.close();
		} catch (SQLException e)
		{
			logger.fatal(e);
			e.printStackTrace();
		}
		
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			logger.fatal(e);
			e.printStackTrace();
		}
	}
}
