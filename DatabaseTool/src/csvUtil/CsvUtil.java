package csvUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

public class CsvUtil
{

	public static File createCSVFile(List exportData, LinkedHashMap rowMapper,
			String outPutPath, String filename,String getSeparator,String characterSet)
	{
		Logger logger = Logger.getLogger(CsvUtil.class);
		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try
		{
			csvFile = new File(outPutPath + filename + ".csv");
			
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists())
			{
				parent.mkdirs();
			}
			
			logger.info("Create Csv Start");
			
			csvFile.createNewFile();
			
			logger.info("Create Csv End");

			
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(csvFile), characterSet), 1024);
			
			for (Iterator propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext();)
			{
				java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
				csvFileOutputStream.write("\"" + propertyEntry.getValue().toString() + "\"");
				if (propertyIterator.hasNext())
				{
					csvFileOutputStream.write(getSeparator);
				}
			}
			csvFileOutputStream.newLine();

			
			for (Iterator iterator = exportData.iterator(); iterator.hasNext();)
			{
				
				LinkedHashMap row = (LinkedHashMap) iterator.next();
				
				logger.info("Row Data :" + row);
				
				System.out.println(row);

				for (Iterator propertyIterator = row.entrySet().iterator(); propertyIterator
						.hasNext();)
				{
					java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
							.next();
					
					
					if (propertyEntry.getValue() != null){
					csvFileOutputStream.write("\""
							+ propertyEntry.getValue().toString() + "\"");
					}else
					{
						csvFileOutputStream.write("\""
								+ "null" + "\"");
					}
					if (propertyIterator.hasNext())
					{
						csvFileOutputStream.write(getSeparator);
					}
				}
				if (iterator.hasNext())
				{
					csvFileOutputStream.newLine();
				}
			}
			csvFileOutputStream.flush();
		} catch (Exception e)
		{
			logger.fatal(e);
			e.printStackTrace();
		} finally
		{
			try
			{
				csvFileOutputStream.close();
			} catch (IOException e)
			{
				logger.fatal(e);
				e.printStackTrace();
			}
		}
		return csvFile;
	}
}