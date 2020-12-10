package pomPages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClsGetData 
{
	public static Object[][] getExcelData(String dataFile) throws Exception
	{
		Object[][] myData=null;

		XSSFWorkbook wb=new XSSFWorkbook(dataFile);
		XSSFSheet ws=wb.getSheet("Sheet1");
		int rows=ws.getPhysicalNumberOfRows();

		myData=new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			myData[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
			myData[i][1]=ws.getRow(i).getCell(1).getStringCellValue();    	
		}

		return myData;
		
	}
}
