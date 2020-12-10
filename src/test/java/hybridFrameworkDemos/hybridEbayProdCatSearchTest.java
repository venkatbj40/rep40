package hybridFrameworkDemos;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.BrowserFactory;
import pomPages.ClsEbay;
import pomPages.ClsGetData;

public class hybridEbayProdCatSearchTest {
	@Test(dataProvider = "ebayData")
	public void CatSearch(String cat,String prod) 
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");

		ClsEbay obj=new ClsEbay(driver);
		obj.fnCatSearch(cat, prod);
		
		Reporter.log("'" + prod + "' Product Search in '" + cat + "' Category Test is Successful",true);
	}

	@DataProvider
	public Object[][] ebayData() throws Exception 
	{
		Object[][] testData=ClsGetData.getExcelData("D:\\Google Drive\\QA @11AM IST\\Selenium\\Programs\\mvnDemo\\src\\test\\resources\\TestData\\DDFEbayTestData.xlsx");

		return testData;
	}
}
