package editData;

import gui.SuccessFrame;

import java.io.File;

import databaseOption.ComJdbc;

public class UpdateData {

	public static void upData(String sql){
		
			String currentPath = System.getProperty("user.dir");

			ComJdbc.connection(currentPath + File.separator
					+ "configdb.properties");

			 int rc = ComJdbc.execUpdate(sql);
			if(rc != -1)
			{
			SuccessFrame sf = new SuccessFrame();
			sf.setTitle("Successful !");
			sf.setDefaultCloseOperation(SuccessFrame.EXIT_ON_CLOSE);
			sf.getContentPane().setPreferredSize(null);
			sf.setLocationRelativeTo(null);
			sf.pack();
			sf.setVisible(true);
			}
	}
}
