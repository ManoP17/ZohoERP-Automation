package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Erp;


import utilities.Xls_Reader;
import utilities.ScreenShot;

public class Steps {
	
	public WebDriver driver;
	public Erp erp;
	public Xls_Reader reader;
	public ScreenShot screenShot;
//	public Indent indent;
	@After
	public void screen(Scenario scenario) {
	    if (scenario.isFailed()) {
	        // Capture screenshot as a file
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        try {
	            // Specify the folder where you want to save the screenshot
	            String screenshotFolder = "C:\\Users\\mano\\Desktop\\Mano\\ERP_ZOHO\\Screenshot";
	            
	            // Create the folder if it doesn't exist
	            File folder = new File(screenshotFolder);
	            if (!folder.exists()) {
	                folder.mkdirs();
	            }
	            
	            // Save the screenshot in the specified folder with the scenario name
	            String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";
	            File destinationFile = new File(screenshotFolder + File.separator + screenshotName);
	            FileHandler.copy(screenshotFile, destinationFile);
	            
	            // Optionally attach the screenshot to the scenario in Cucumber report
	            final byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    if (driver != null) {
	        driver.quit();
	    }
	}

	
	@Given("User launched browser and Successfully login")
	public void user_launched_browser_and_successfully_login() throws InterruptedException, IOException {
		
//		ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		erp = new Erp(driver);
		driver.get("https://accounts.zoho.in/signin?servicename=ZohoCreator");
		Thread.sleep(5000);
		Erp.Emailaddress.sendKeys("u2d6-in@synprosoft.co.in");
		Thread.sleep(2000);
		Erp.Next.click();
		Thread.sleep(2000);
		Erp.Password.sendKeys("Openerp@02");
		Thread.sleep(2000);
		Erp.Signin.click();
		Thread.sleep(20000);
		Erp.Erpapp.click();
	   
	}
	
	@And("Create the indent")
	public void create_the_indent() throws InterruptedException, IOException {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
//		int rowCount = reader.getRowCount("Erp");
//		for(int rowNum = 2; rowNum <= rowCount ; rowNum++) {
			Thread.sleep(10000);
			Erp.Purchase.click();
			Thread.sleep(8000);
			Erp.Purchaseview.click();
			Thread.sleep(12000);
			Erp.Createview.click();
			Thread.sleep(10000);
			Erp.Createadd.click();
			Thread.sleep(8000);
			Erp.indentProjectname.click();
			Thread.sleep(7000);
			String projectName = reader.getCellData("Indent","ProjectName", 2);			
			Erp.indentProjectnamesearch.sendKeys(projectName, Keys.ENTER);
			System.out.println(projectName);
			Thread.sleep(3000);
//			Erp.indentProjectnameselect.click();
			Thread.sleep(3000);
			Erp.indentProjectnameadd.click();
			Thread.sleep(6000);
			Erp.Additemdetails.click();
			Thread.sleep(5000);
			String partNo = reader.getCellData("Indent","PartNo", 2);
			Erp.Additemdetailssearch.sendKeys(partNo);
			Thread.sleep(5000);
			Erp.Additemdetailssearch.sendKeys(Keys.TAB);
			System.out.println(partNo);
			Thread.sleep(4000);
//			Erp.Additemdetailsselect.click();
			Thread.sleep(3000);
			String requiredQty = reader.getCellData("Indent","RequiredQty", 2);
			Erp.requiredqty.sendKeys(requiredQty);
			System.out.println(requiredQty);
			Thread.sleep(6000);
			String purpose = reader.getCellData("Indent","Purpose", 2);
			Erp.purpose.sendKeys(purpose);
			System.out.println(purpose);
			Thread.sleep(6000);
			Erp.purchasesubmit.click();
			Thread.sleep(12000);
//			Erp.purchasealert.click();
			Thread.sleep(5000);
			Erp.purchaseok.click();
			Thread.sleep(8000);
			driver.navigate().refresh();
			
		}
		
//	}	
	
	
	@And("Create RFQ against indent")
	public void create_rfq_against_indent() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
//		int rowCount = reader.getRowCount("Erp");
		Thread.sleep(8000);
		Erp.Purchaseqfq.click();
		Thread.sleep(8000);
		Erp.Purchaseviewrfq.click();
		Thread.sleep(7000);
		Erp.rfqcrate.click();
		Thread.sleep(9000);
		Erp.rfqsearch.click();
		Thread.sleep(8000);
		Erp.checkbox.click();
		Thread.sleep(8000);
		String indentno = reader.getCellData("RFQ","IndentNo", 2);
		Erp.prsearch.sendKeys(indentno, Keys.ENTER);
		System.out.println(indentno);
		Thread.sleep(7000);
		Erp.submitpr.click();
		Thread.sleep(5000);
		Erp.checkboxrfq.click();
		Thread.sleep(5000);
		Erp.createrfqbutton.click();
		Thread.sleep(11000);
		String vendorName = reader.getCellData("RFQ","VendorName", 2);
		Erp.vendorname.sendKeys(vendorName);
		System.out.println(vendorName);
		Thread.sleep(6000);
		Erp.vendorname.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		String remarks = reader.getCellData("RFQ","Remarks", 2);
		Erp.remark.sendKeys(remarks);
		System.out.println(remarks);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2000);");
		Erp.rfqsubmit.click();
		Thread.sleep(10000);
		Erp.rfqsubmitok.click();
		Thread.sleep(7000);
		Erp.rfqok.click();
		Thread.sleep(8000);
		
	}

	@And("Add Quotation against RFQ")
	public void add_quotation_against_rfq() throws InterruptedException {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(8000);
		Erp.Purchasequote.click();
		Thread.sleep(7000);
		Erp.Purchaseviewquote.click();
		Thread.sleep(7000);
		Erp.quotation.click();
		Thread.sleep(10000);
		Erp.quotationsearch.click();
		Thread.sleep(8000);
		Erp.quotationcheckbox.click();
		Thread.sleep(7000);
		String rfqnumber = reader.getCellData("Quote","RFQNumber", 2);
		Erp.quotationenter.sendKeys(rfqnumber,Keys.ENTER);
		System.out.println(rfqnumber);
		Thread.sleep(4000);
		Erp.quotationsearchbutton.click();
		Thread.sleep(4000);
		Erp.quotationaddquote.click();
		Thread.sleep(4000);
//		Erp.quotesubmittedby.click();
//		Thread.sleep(4000);
		Erp.vendornamequote.click();
		Thread.sleep(4000);
		String vendorname = reader.getCellData("Quote","VendorName", 2);
		Erp.vendornamequotesearch.sendKeys(vendorname);
		System.out.println(vendorname);
		Thread.sleep(4000);
		Erp.vendornamequoteselect.click();
		Thread.sleep(4000);
		String quoteReferenceNumber = reader.getCellData("Quote","QuoteReferenceNumber", 2);
		Erp.vendorquotereference.sendKeys(quoteReferenceNumber);
		System.out.println(quoteReferenceNumber);
		Thread.sleep(4000);
		String quoteValidityDate = reader.getCellData("Quote","QuoteValidityDate", 2);
		Erp.quotevaliditydate.sendKeys(quoteValidityDate,Keys.ENTER);
		System.out.println(quoteValidityDate);
		Thread.sleep(4000);
		String QuoteRate = reader.getCellData("Quote","QuoteRate", 2);
		Erp.quoterate.sendKeys(QuoteRate);
		System.out.println(QuoteRate);
		Thread.sleep(4000);
//		Erp.quotetax.click();
//		Thread.sleep(4000);
//		Erp.quotetaxsearch.sendKeys("GST18");
//		Thread.sleep(4000);
//		Erp.quotetaxselect.click();
//		Thread.sleep(4000);
		Erp.quotesubmit.click();
		Thread.sleep(10000);
		Erp.quotesubmitok.click();
		Thread.sleep(5000);
		Erp.quoteok.click();
		Thread.sleep(8000);
		
		
	}
	
	
	@When("Create PO against Quote")
	public void create_po_against_quote() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(7000);
		Erp.Purchasepo.click();
		Thread.sleep(12000);
		Erp.Purchaseviewpo.click();
		Thread.sleep(10000);
		Erp.createquotepo.click();
		Thread.sleep(10000);
		Erp.poagainstsearch.click();
		Thread.sleep(9000);
		Erp.quotecheckbox.click();
		Thread.sleep(6000);
		String quoteNo = reader.getCellData("PO","QuoteNo", 2);
		Erp.quotationpo.sendKeys(quoteNo,Keys.ENTER);
		System.out.println(quoteNo);
		Thread.sleep(4000);
//		Erp.quotationposelect.click();
//		Thread.sleep(4000);
		Erp.quotationposearchbutton.click();
		Thread.sleep(4000);
		Erp.createpurchasecheckbox.click();
		Thread.sleep(4000);
		Erp.createpurchasebutton.click();
		Thread.sleep(12000);
		String deliveryDate = reader.getCellData("PO","DeliveryDate", 2);
		Erp.deliverydatepo.sendKeys(deliveryDate,Keys.ENTER);
		System.out.println(deliveryDate);
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//input[@value='Send to Approval']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
//		Erp.processsubmitpo.click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2000);");
		Erp.purchasesubmitpo.click();
		Thread.sleep(12000);
		Erp.submitpurchaseokpo.click();
		Thread.sleep(5000);
		Erp.purchaseokpo.click();
		Thread.sleep(8000);
		
		
	}
	
	@And("Create GRN in stores")
	public void create_grn_in_stores() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(8000);
		Erp.dotGRN.click();
		Thread.sleep(10000);
		Erp.stores.click();
		Thread.sleep(8000);
		Erp.storesview.click();
		Thread.sleep(7000);
		Erp.creategrn.click();
		Thread.sleep(10000);
		Erp.grnsearch.click();
		Thread.sleep(8000);
		Erp.grnposearch.click();
		Thread.sleep(7000);
		String postatusNo = reader.getCellData("GRN","PoStatusNo", 2);
		Erp.grnsend.sendKeys(postatusNo, Keys.ENTER );
		System.out.println(postatusNo);
		Thread.sleep(5000);
		Erp.grnstatussearch.click();
		Thread.sleep(5000);
		Erp.grncheckbox.click();
		Thread.sleep(5000);
		Erp.createGRNbutton.click();
		Thread.sleep(5000);
		String vendorinvoiceno = reader.getCellData("GRN","VendorInvoiceNo", 2);
		Erp.GRNinvoice.sendKeys(vendorinvoiceno);
		System.out.println(vendorinvoiceno);
		Thread.sleep(5000);
		String vendorinvoicedate = reader.getCellData("GRN","VendorInvoiceDate", 2);
		Erp.GRNinvoicedate.sendKeys(vendorinvoicedate, Keys.ENTER);
		System.out.println(vendorinvoicedate);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(5000);
		Erp.GRNsubmit.click();
		Thread.sleep(12000);
		Erp.grnalert.click();
		Thread.sleep(5000);
		Erp.grnok.click();
		Thread.sleep(8000);
	}
	
	@When("Create IQC in GRN")
	public void create_iqc_in_grn() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(8000);
		Erp.dot.click();
		Thread.sleep(8000);
		Erp.quality.click();
		Thread.sleep(8000);
		Erp.qualityview.click();
		Thread.sleep(8000);
		Erp.crateiqc.click();
		Thread.sleep(9000);
		Erp.iqcsearch.click();
		Thread.sleep(8000);
		Erp.iqccheckbox.click();
		Thread.sleep(6000);
		String Grnnumber = reader.getCellData("IQC","GRNNumber", 2);
		Erp.iqcpo.sendKeys(Grnnumber,Keys.ENTER);
		System.out.println(Grnnumber);
		Thread.sleep(4000);
		Erp.iqcsearchbutton.click();
		Thread.sleep(6000);
		Erp.crateiqccheckbox.click();
		Thread.sleep(6000);
		Erp.crateiqcbutton.click();
		Thread.sleep(14000);
		//Window Handle
		Set<String> handle=driver.getWindowHandles();
		Iterator it=handle.iterator();
		String parentid= (String) it.next();
		String childid=(String) it.next();
		driver.switchTo().window(childid);
		Thread.sleep(4000);
		Erp.iqcstatus.click();
		Thread.sleep(4000);
		String status = reader.getCellData("IQC","Status", 2);
		Erp.iqcstatussearch.sendKeys(status,Keys.ENTER);
		System.out.println(status);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 1000)");
	    Thread.sleep(4000);
	    String acceptedsampleqty = reader.getCellData("IQC","AcceptedSampleQty", 2);
		Erp.sampleqty.sendKeys(acceptedsampleqty);
		System.out.println(acceptedsampleqty);
		Thread.sleep(4000);
		String acceptedqty = reader.getCellData("IQC","AcceptedQty", 2);
		Erp.acceptedqty.sendKeys(acceptedqty);
		System.out.println(acceptedqty);
		Thread.sleep(4000);
		Erp.iqcsubmit.click();
		Thread.sleep(10000);
		Erp.iqcalert.click();
		Thread.sleep(5000);
		Erp.iqcok.click();
		Thread.sleep(8000);
		driver.switchTo().window(parentid);
		Thread.sleep(5000);
	}
	
	@Given("Create Sales order")
	public void create_sales_order() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(12000);
		Erp.Sales.click();
		Thread.sleep(8000);
		Erp.Salesorder.click();
		Thread.sleep(8000);
		Erp.CreateSalesorder.click();
		Thread.sleep(8000);
		Erp.Salescustomername.click();
		Thread.sleep(8000);
		String salescustomername = reader.getCellData("Sales","SalesCustomerName", 2);
		Erp.Salescustomernamesearch.sendKeys(salescustomername);
		System.out.println(salescustomername);
		Thread.sleep(4000);
		Erp.Salescustomernameselect.click();
		Thread.sleep(4000);
		String poreference = reader.getCellData("Sales","POReference", 2);
		Erp.Salesporef.sendKeys(poreference);
		System.out.println(poreference);
		Thread.sleep(4000);
		String podate = reader.getCellData("Sales","PODate", 2);
		Erp.Salespodate.sendKeys(podate,Keys.ENTER);
		System.out.println(podate);
		Thread.sleep(4000);
		Erp.Salesadd.click();
		Thread.sleep(4000);
		Erp.Salespartno.click();
		Thread.sleep(4000);
		String salespartno = reader.getCellData("Sales","SalesPartNo", 2);
		Erp.Salespartnosearch.sendKeys(salespartno);
		System.out.println(salespartno);
		Thread.sleep(4000);
		Erp.Salespartnoselect.click();
		Thread.sleep(4000);
		String orderno = reader.getCellData("Sales","OrderNo", 2);
		Erp.Salesorderitem.sendKeys(orderno);
		System.out.println(salespartno);
		Thread.sleep(4000);
		Erp.Salesprocess.click();
		Thread.sleep(4000);
		Erp.Salesppc.click();
		Thread.sleep(4000);
		Erp.Salesubmit.click();
		Thread.sleep(10000);
		Erp.Salesalert.click();
		Thread.sleep(6000);
		Erp.Salesorderok.click();
		Thread.sleep(8000);
		
	}
	
	@When("Dispatch plan in Sales order")
	public void dispatch_plan_in_sales_order() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(12000);
		Erp.Salesbutton.click();
		Thread.sleep(7000);
		Erp.Activesalesorder.click();
		Thread.sleep(8000);
		Erp.Activesalessearch.click();
		Thread.sleep(8000);
		Erp.Activesalescheckbox.click();
		Thread.sleep(5000);
		String salesorderNo = reader.getCellData("DispatchPlan","SalesOrderNO", 2);
		Erp.Activetype.sendKeys(salesorderNo,Keys.ENTER);
		System.out.println(salesorderNo);
		Thread.sleep(6000);
		Erp.Activesearchbutton.click();
		Thread.sleep(4000);
		Erp.Dispatchplan.click();
		Thread.sleep(14000);
		String productdetailslist = reader.getCellData("DispatchPlan","ProductDetailsList", 2);
		Erp.Productdetailslist.sendKeys(productdetailslist);
		System.out.println(productdetailslist);
		Thread.sleep(8000);
		Erp.Productdetailslist.sendKeys(Keys.TAB);
		Thread.sleep(8000);
		String dispatchdeliverydate = reader.getCellData("DispatchPlan","DispatchDeliveryDate", 2);
		Erp.dispatchdeliverydate.sendKeys(dispatchdeliverydate,Keys.ENTER);
		System.out.println(dispatchdeliverydate);
		Thread.sleep(8000);
		Erp.loadproductdetails.click();
		Thread.sleep(8000);
		Erp.Dispatchplansubmit.click();
		Thread.sleep(12000);
		Erp.Dispatchorderok.click();
		Thread.sleep(8000);
	}
	
	@When("Active Dispatch in Logistics")
	public void active_dispatch_in_logistics() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(12000);
		Erp.logistics.click();
		Thread.sleep(8000);
		Erp.activedispatch.click();
		Thread.sleep(8000);
		Erp.dispatchsearch.click();
		Thread.sleep(8000);
		Erp.dispatchsalesorderno.click();
		Thread.sleep(6000);
		String salesorderno = reader.getCellData("ActiveDispatch","SalesOrderNO", 2);
		Erp.dispatchnosearch.sendKeys(salesorderno,Keys.ENTER);
		System.out.println(salesorderno);
		Thread.sleep(6000);
		Erp.createdispatchnote.click();
		Thread.sleep(9000);
		Erp.transporttype.click();
		Thread.sleep(6000);
		String transportername = reader.getCellData("ActiveDispatch","TransporterName", 2);
		Erp.transportername.sendKeys(transportername);
		System.out.println(transportername);
		Thread.sleep(6000);
		String Grrrno = reader.getCellData("ActiveDispatch","GRRRNO", 2);
		Erp.grrr.sendKeys(Grrrno);
		System.out.println(transportername);
		Thread.sleep(6000);
		String vehicleno = reader.getCellData("ActiveDispatch","VehicleNo", 2);
		Erp.vehicleno.sendKeys(vehicleno);
		System.out.println(vehicleno);
		Thread.sleep(6000);
		String drivername = reader.getCellData("ActiveDispatch","DriverName", 2);
		Erp.drivername.sendKeys(drivername);
		System.out.println(vehicleno);
		Thread.sleep(6000);
		String mobileno = reader.getCellData("ActiveDispatch","MobileNo", 2);
		Erp.drivermobilenumber.sendKeys(mobileno);
		System.out.println(mobileno);
		Thread.sleep(6000);
		Erp.vehicletype.click();
		Thread.sleep(6000);
		String vehicletype = reader.getCellData("ActiveDispatch","VehicleType", 2);
		Erp.vehicletypesearch.sendKeys(vehicletype, Keys.ENTER);
		System.out.println(vehicletype);
		Thread.sleep(6000);
		Erp.createdispatchupdate.click();
		Thread.sleep(6000);
		
		
		
	}
	
	@When("Create Material Request")
	public void create_material_request() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(9000);
		Erp.dot.click();
		Thread.sleep(8000);
		Erp.stores3.click();
		Thread.sleep(6000);
		Erp.storesbutton.click();
		Thread.sleep(6000);
		Erp.creatematerialreq.click();
		Thread.sleep(6000);
		Erp.materialreqprojectname.click();
		Thread.sleep(4000);
		String projectname = reader.getCellData("MaterialRequest","ProjectName", 2);
		Erp.materialreqsearchname.sendKeys(projectname, Keys.ENTER);
		System.out.println(projectname);
		Thread.sleep(4000);
		Erp.Addmrq.click();
		Thread.sleep(6000);
		Erp.mrqpartno.click();
		Thread.sleep(6000);
		String partno = reader.getCellData("MaterialRequest","PartNO", 2);
		Erp.mrqpartnosearch.sendKeys(partno);
		System.out.println(partno);
		Thread.sleep(6000);
		Erp.mrqpartnosselect.click();
		Thread.sleep(4000);
		String requiredqty = reader.getCellData("MaterialRequest","Requiredqty", 2);
		Erp.mrqrequiredqty.sendKeys(requiredqty);
		System.out.println(requiredqty);
		Thread.sleep(4000);
		Erp.mrqsubmit.click();
		Thread.sleep(10000);
		Erp.mrqalert.click();
		Thread.sleep(6000);
		Erp.mrqok.click();
		Thread.sleep(8000);
		
	}
	
	@When("Create the GIN")
	public void create_the_gin() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(9000);
		Erp.dot.click();
		Thread.sleep(9000);
		Erp.stores2.click();
		Thread.sleep(9000);
		Erp.storesbutton2.click();
		Thread.sleep(10000);
		Erp.creategin.click();
		Thread.sleep(9000);
		Erp.requestraised.click();
		Thread.sleep(6000);
		String requestraisedBy = reader.getCellData("GIN","RequestRaisedBy", 2);
		Erp.requestraisedsearch.sendKeys("requestraisedBy", Keys.ENTER);
		System.out.println(requestraisedBy);
		Thread.sleep(6000);
		String requestdate = reader.getCellData("GIN","RequestDate", 2);
		Erp.requestdategin.sendKeys(requestdate,Keys.ENTER);
		System.out.println(requestdate);
		Thread.sleep(6000);
		Erp.projectnamegin.click();
		Thread.sleep(6000);
		String projectname = reader.getCellData("GIN","ProjectName", 2);
		Erp.projectnamesearchgin.sendKeys(projectname, Keys.ENTER);
		System.out.println(projectname);
		Thread.sleep(6000);
		Erp.Addgin.click();
		Thread.sleep(6000);
		Erp.partnogin.click();
		Thread.sleep(6000);
		String partname = reader.getCellData("GIN","PartNo", 2);
		Erp.partnosearchgin.sendKeys(partname);
		System.out.println(partname);
		Thread.sleep(6000);
		Erp.partnoselectgin.click();
		Thread.sleep(6000);
		String requireqty = reader.getCellData("GIN","RequireQty", 2);
		Erp.requiredgtygin.sendKeys(requireqty);
		System.out.println(requireqty);
		Thread.sleep(6000);
		String issuedqty = reader.getCellData("GIN","IssuedQty", 2);
		Erp.issuedgtygin.sendKeys(issuedqty);
		System.out.println(issuedqty);
		Thread.sleep(6000);
		String rate = reader.getCellData("GIN","Rate", 2);
		Erp.rategin.sendKeys(rate);
		System.out.println(rate);
		Thread.sleep(6000);
		Erp.ginsubmit.click();
		Thread.sleep(10000);
		Erp.ginalert.click();
		Thread.sleep(6000);
		Erp.ginok.click();
		Thread.sleep(8000);
		
		
	}
	
	@When("Stock Update both Sales and Purchase")
	public void stock_update_both_sales_and_purchase() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\mano\\Desktop\\Mano\\datas.xlsx");
		Thread.sleep(9000);
		Erp.dot.click();
		Thread.sleep(9000);
		Erp.stores4.click();
		Thread.sleep(9000);
		Erp.storesbutton4.click();
		Thread.sleep(10000);
		Erp.movetostock.click();
		Thread.sleep(9000);
//		Erp.stocksearch.click();
//		Thread.sleep(7000);
//		Erp.stockcheckbox.click();
//		Thread.sleep(7000);
//		Erp.stockenter.sendKeys("GRN-HO-000022",Keys.ENTER);
//		Thread.sleep(7000);
//		Erp.stockentersearch.click();
//		Thread.sleep(7000);
		Erp.movetostockbutton.click();
		Thread.sleep(7000);
		Erp.location.click();
		Thread.sleep(7000);
		String location = reader.getCellData("Stock","Location", 2);
		Erp.searchlocation.sendKeys(location, Keys.ENTER);
		System.out.println(location);
		Thread.sleep(7000);
		Erp.sublocation.click();
		Thread.sleep(7000);
		String sublocation = reader.getCellData("Stock","SubLocation", 2);
		Erp.sublocationsearch.sendKeys(sublocation, Keys.ENTER);
		System.out.println(sublocation);
		Thread.sleep(7000);
		Erp.stockupdatesubmit.click();
		Thread.sleep(10000);
		Erp.stockalert.click();
		Thread.sleep(7000);
		Erp.stockok.click();
		Thread.sleep(9000);
		
	}

}
