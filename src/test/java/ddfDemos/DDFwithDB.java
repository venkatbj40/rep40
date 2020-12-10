package ddfDemos;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DDFwithDB {
	@Test(dataProvider = "ebayData")
	public void CatSearch(String cat,String prod) 
	{
		WebDriverManager.chromedriver().version("86").setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ebay.com");
		
		WebElement dd=driver.findElement(By.id("gh-cat"));
		Select s=new Select(dd);
		s.selectByVisibleText(cat);

		driver.findElement(By.id("gh-ac")).sendKeys(prod);
		driver.findElement(By.id("gh-btn")).click();

		Reporter.log("'" + prod + "' Product Search in '" + cat + "' Category Test is Successful",true);
	}

	@DataProvider
	public Object[][] ebayData() throws Exception 
	{
		Object[][] myData=new Object[2][2];

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ebayDB11AM;integratedsecurity=true");

		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from ebayInput");

		int i=0;
		while(rs.next())
		{
			myData[i][0]=rs.getString(1);
			myData[i][1]=rs.getString(2);
			i=i+1;
		}
	
		return myData;
	}
}
