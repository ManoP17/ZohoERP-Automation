package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Erp {

	public WebDriver ldriver;

	public Erp(WebDriver rdriver)
	{ 
	 ldriver = rdriver;
	 
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "login_id")
	public static WebElement Emailaddress;

	@FindBy(xpath = "//button[@id='nextbtn']")
	public static WebElement Next;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement Password;
	
	@FindBy(xpath = "//button[@id='nextbtn']")
	public static WebElement Signin;
	
	@FindBy(xpath = "//a[@app-link-name='synprosoft-erp-302']")
	public static WebElement Erpapp;
	
	//Create Indent 
	@FindBy(xpath = "//span[normalize-space()='Purchase']")
	public static WebElement Purchase;
	
	@FindBy(xpath = "//span[normalize-space()='Purchase View']")
	public static WebElement Purchaseview;
	
	@FindBy(xpath = "//a[normalize-space()='Create / View Indent']")
	public static WebElement Createview;
	
	@FindBy(xpath = "//a[@class='zc_transition pull-right zc-add-record zc-tooltip-el']//label[@class='add-record'][normalize-space()='Add']")
	public static WebElement Createadd;
	
	@FindBy(xpath = "//div[contains(@class,'select2-container zc-Project_Name')]")
	public static WebElement indentProjectname;
	
	@FindBy(css = "input[name='zc-sel2-inp-Project_Name']")
	public static WebElement indentProjectnamesearch;
	
	@FindBy(xpath = "//span[text()='SPS-16 - Robotic Cell Installation']")
	public static WebElement indentProjectnameselect;
	
	@FindBy(xpath = "//div[@name='Item_Details']//a[@elname='subFormLink'][normalize-space()='Add New']")
	public static WebElement indentProjectnameadd;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[29]")
	public static WebElement Additemdetails;
	
	@FindBy(css = "input[name='zc-sel2-inp-Item_Details.t::row_1.Part_No']")
	public static WebElement Additemdetailssearch;
	
	@FindBy(xpath = "//span[text()='100001']")
	public static WebElement Additemdetailsselect;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Required_Qty']")
	public static WebElement requiredqty;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Purpose_of_Indent']")
	public static WebElement purpose;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement purchasesubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement purchasealert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement purchaseok;
	
	//Create RFQ against Indent
	@FindBy(xpath = "//span[normalize-space()='Purchase']")
	public static WebElement Purchaseqfq;
	
	@FindBy(xpath = "//span[normalize-space()='Purchase View']")
	public static WebElement Purchaseviewrfq;
	
	@FindBy(xpath = "(//a[normalize-space()='Create RFQ Against Indent'])[1]")
	public static WebElement rfqcrate;
	
	@FindBy(xpath = "(//i[@class='fa fa-search'])[1]")
	public static WebElement rfqsearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[2]")
	public static WebElement checkbox;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement prsearch;
	
	@FindBy(xpath = "(//a[@type='button'])[1]")
	public static WebElement submitpr;
	
	@FindBy(xpath = "(//td[@class='zcReport_Edit htDimmed']//label)[1]")
	public static WebElement checkboxrfq;
	
	@FindBy(xpath = "//span[normalize-space()='Create RFQ']")
	public static WebElement createrfqbutton;
	
	@FindBy(xpath = "(//li[@class='select2-search-field']//input)[1]")
	public static WebElement vendorname;
	
	@FindBy(xpath = "//textarea[@id='zc-Remarks_for_Supplier']")
	public static WebElement remark;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement rfqsubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement rfqsubmitok;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement rfqok;
	
	//Add Quotation against RFQ
	@FindBy(xpath = "//span[normalize-space()='Purchase']")
	public static WebElement Purchasequote;
	
	@FindBy(xpath = "//span[normalize-space()='Purchase View']")
	public static WebElement Purchaseviewquote;
	
	@FindBy(xpath = "//a[normalize-space()='Add Quotation Against RFQ']")
	public static WebElement quotation;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public static WebElement quotationsearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[1]")
	public static WebElement quotationcheckbox;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement quotationenter;
	
	@FindBy(xpath = "//a[@type='button']")
	public static WebElement quotationsearchbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Add Quote']")
	public static WebElement quotationaddquote;
	
//	@FindBy(xpath = "//div[contains(@class,'form-group clearfix zc-Quote_Submitted_by-group zc-radio-field-group')]//div[contains(@class,'choice-table-row')]//div[1]//span[1]//label[1]")
//	public static WebElement quotesubmittedby;
	
	@FindBy(xpath = "(//a[@class='select2-choice select2-default']//span)[1]")
	public static WebElement vendornamequote;
	
	@FindBy(css = "input[name='zc-sel2-inp-Vendor_Name']")
	public static WebElement vendornamequotesearch;
	
	@FindBy(xpath = "(//span[contains(text(),'360 Engineering Solution')])[1]")
	public static WebElement vendornamequoteselect;
	
	@FindBy(xpath = "//input[@id='zc-Vendor_Quote_Ref_No']")
	public static WebElement vendorquotereference;
	
	@FindBy(xpath = "//input[@id='Quote_Validity_Date']")
	public static WebElement quotevaliditydate;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Rate']")
	public static WebElement quoterate;
	
//	@FindBy(xpath = "(//span[@class='select2-chosen'])[7]")
//	public static WebElement quotetax;
//	
//	@FindBy(css = "input[name='zc-sel2-inp-Item_Details.t::row_1.Tax']")
//	public static WebElement quotetaxsearch;
//	
//	@FindBy(xpath = "//span[contains(text(),'GST18')]")
//	public static WebElement quotetaxselect;
	
	@FindBy(css = "input[name='Submit1']")
	public static WebElement quotesubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement quotesubmitok;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement quoteok;
	
	
	//Create PO against Quote
	@FindBy(xpath = "//span[normalize-space()='Purchase']")
	public static WebElement Purchasepo;
	
	@FindBy(xpath = "//span[normalize-space()='Purchase View']")
	public static WebElement Purchaseviewpo;
	
	@FindBy(xpath = "//a[normalize-space()='Create PO Against Quote']")
	public static WebElement createquotepo;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public static WebElement poagainstsearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[1]")
	public static WebElement quotecheckbox;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement quotationpo;
	
//	@FindBy(xpath = "(//div[contains(text(),'QUT-HO-000030')])[1]")
//	public static WebElement quotationposelect;
	
	@FindBy(xpath = "//a[@type='button']")
	public static WebElement quotationposearchbutton;
	
	@FindBy(xpath = "(//td[@class='zcReport_Edit htDimmed']//label)[1]")
	public static WebElement createpurchasecheckbox;
	
	@FindBy(xpath = "//a[@class='zc-custom-btn zc_transition']")
	public static WebElement createpurchasebutton;
	
	@FindBy(xpath = "//input[@id='Delivery_Date']")
	public static WebElement deliverydatepo;
	
	
	@FindBy(xpath = "//div[contains(@class,'form-group clearfix zc-Process_to_Submit-group zc-radio-field-group')]//div[2]//div[1]//span[1]//label[1]")
	public static WebElement processsubmitpo;
	
	@FindBy(xpath = "//input[@type='submit']")
	public static WebElement purchasesubmitpo;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement submitpurchaseokpo;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement purchaseokpo;
	
	
	//Create GRN in stores
	@FindBy(xpath = "(//li[@class='pane_hidden_menu']//a)[1]")
	public static WebElement dotGRN;
	
	@FindBy(xpath = "//a[@id='tab_Stores']//span[contains(@class,'title')][normalize-space()='Stores']")
	public static WebElement stores;
	
	@FindBy(xpath = "//a[@id='Stores']//span[contains(@class,'title')][normalize-space()='Stores']")
	public static WebElement storesview;
	
	@FindBy(xpath = "//a[normalize-space()='Create GRN']")
	public static WebElement creategrn;
	
	@FindBy(xpath = "(//i[@class='fa fa-search'])[1]")
	public static WebElement grnsearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[3]")
	public static WebElement grnposearch;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement grnsend;
	
	@FindBy(xpath = "//a[@type='button']")
	public static WebElement grnstatussearch;
	
	@FindBy(xpath = "(//td[@class='zcReport_Edit htDimmed']//label)[1]")
	public static WebElement grncheckbox;
	
	@FindBy(xpath = "//span[contains(@class,'title')][normalize-space()='Create GRN']")
	public static WebElement createGRNbutton;
	
	@FindBy(xpath = "//input[@id='zc-Vendor_Invoice_Number']")
	public static WebElement GRNinvoice;
	
	@FindBy(xpath = "//input[@id='Vendor_Invoice_Date']")
	public static WebElement GRNinvoicedate;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement GRNsubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement grnalert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement grnok;
	
	
	//Create IQC in GRN
	@FindBy(xpath = "(//li[@class='pane_hidden_menu']//a)[1]")
	public static WebElement dot;
	
	@FindBy(xpath = "//span[normalize-space()='Quality']")
	public static WebElement quality;
	
	@FindBy(xpath = "//span[normalize-space()='Quality View']")
	public static WebElement qualityview;
	
	@FindBy(xpath = "//a[normalize-space()='Create IQC']")
	public static WebElement crateiqc;
	
	@FindBy(xpath = "(//i[@class='fa fa-search'])[1]")
	public static WebElement iqcsearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[1]")
	public static WebElement iqccheckbox;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement iqcpo;
	
	@FindBy(xpath = "//a[@type='button']")
	public static WebElement iqcsearchbutton;
	
	@FindBy(xpath = "(//td[@class='zcReport_Edit htDimmed']//label)[1]")
	public static WebElement crateiqccheckbox;
	
	@FindBy(xpath = "//a[normalize-space()='Create IQC']")
	public static WebElement crateiqcbutton;
	
	@FindBy(xpath = "(//a[@class='select2-choice select2-default']//span)[3]")
	public static WebElement iqcstatus;
	
	@FindBy(css = "input[name='zc-sel2-inp-Inspection_Parameters.t::row_1.OkStatus']")
	public static WebElement iqcstatussearch;
	
	@FindBy(xpath = "//input[@id='zc-Accepted_Sample_Qty']")
	public static WebElement sampleqty;
	
	@FindBy(xpath = "//input[@id='zc-Accepted_Qty']")
	public static WebElement acceptedqty;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement iqcsubmit;
	

	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement iqcalert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement iqcok;
	
	
	//Create sales order
	@FindBy(xpath = "//span[normalize-space()='Sales']")
	public static WebElement Sales;
	
	@FindBy(xpath = "//span[normalize-space()='Sales Order']")
	public static WebElement Salesorder;
	
	@FindBy(xpath = "//a[normalize-space()='Create Sales Order']")
	public static WebElement CreateSalesorder;
	
	@FindBy(xpath = "(//span[text()='-Select-'])[3]")
	public static WebElement Salescustomername;
	
	@FindBy(css = "input[name='zc-sel2-inp-Customer_Name']")
	public static WebElement Salescustomernamesearch;
	
	@FindBy(xpath = "(//span[text()='A S International'])[1]")
	public static WebElement Salescustomernameselect;
	
	@FindBy(xpath = "//input[@id='zc-PO_Reference']")
	public static WebElement Salesporef;
	

	@FindBy(xpath = "//input[@id='PO_Date']")
	public static WebElement Salespodate;
	
	@FindBy(xpath = "//div[@name='Item_Details']//a[@elname='subFormLink'][normalize-space()='Add New']")
	public static WebElement Salesadd;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[15]")
	public static WebElement Salespartno;
	
	@FindBy(css = "input[name='zc-sel2-inp-Item_Details.t::row_1.Part_No']")
	public static WebElement Salespartnosearch;
	
	@FindBy(xpath = "//span[text()='AS0001_UP']")
	public static WebElement Salespartnoselect;
	

	@FindBy(xpath = "//input[@id='zc-Item_Details-Qty']")
	public static WebElement Salesorderitem;
	
	@FindBy(xpath = "//div[contains(@class,'form-group clearfix zc-Process_to_Submit-group zc-radio-field-group')]//div[2]//span[1]//label[1]")
	public static WebElement Salesprocess;
	
	@FindBy(xpath = "//div[contains(@class,'form-group clearfix zc-Sent_to_PPC-group zc-radio-field-group')]//div[2]//span[1]//label[1]")
	public static WebElement Salesppc;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement Salesubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement Salesalert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement Salesorderok;
	
	
	
	//Dispatch Plan
	@FindBy(xpath = "//span[normalize-space()='Sales']")
	public static WebElement Salesbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Active Sales Order']")
	public static WebElement Activesalesorder;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public static WebElement Activesalessearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[1]")
	public static WebElement Activesalescheckbox;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement Activetype;
	
	@FindBy(xpath = "//a[@type='button']")
	public static WebElement Activesearchbutton;
	
//	@FindBy(xpath = "//label[@for='Sales_Order_Process_ZC_QTX3T6-for-all']")
//	public static WebElement Activecheckbox;
	
	@FindBy(xpath = "//a[normalize-space()='Dispatch Plan']")
	public static WebElement Dispatchplan;
	
	
	@FindBy(xpath = "(//li[@class='select2-search-field']//input)[4]")
	public static WebElement Productdetailslist;
	
//	@FindBy(xpath = "//form[@name='Create_Dispatch_Note_Format']")
//	public static WebElement Salessubmitalert;
	
	@FindBy(xpath = "//input[@id='Delivery_Date']")
	public static WebElement dispatchdeliverydate;
	
	@FindBy(xpath = "//div[@class='decision-box-field form-field clearfix']//label[@for='ZC_N12N4H_Load_Products_1']")
	public static WebElement loadproductdetails;
	
//	@FindBy(xpath = "//form[@name='Alert_Messages']")
//	public static WebElement Salesdispatchalert;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement Dispatchplansubmit;
	
	@FindBy(css = "input[name='OK']")
	public static WebElement Dispatchorderok;
	
	
	//Active Dispatch in Logistics
	@FindBy(xpath = "//span[normalize-space()='Logistics']")
	public static WebElement logistics;
	
	@FindBy(xpath = "//a[normalize-space()='Active Dispatch Note Actual']")
	public static WebElement activedispatch;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public static WebElement dispatchsearch;
	
	@FindBy(xpath = "(//div[@class='zc-cb-checkbox']//label)[1]")
	public static WebElement dispatchsalesorderno;
	
	@FindBy(xpath = "//li[@class='select2-search-field']//input[1]")
	public static WebElement dispatchnosearch;
	
	@FindBy(xpath = "//a[normalize-space()='Create Dispatch Note Actual']")
	public static WebElement createdispatchnote;
	
	@FindBy(xpath = "//div[contains(@class,'formColumn first-column')]//div[2]//span[1]//label[1]")
	public static WebElement transporttype;
	
	@FindBy(xpath = "//input[@id='zc-Transporter_Name']")
	public static WebElement transportername;
	
	@FindBy(xpath = "//input[@id='zc-GR_No']")
	public static WebElement grrr;
	
	@FindBy(xpath = "//input[@id='zc-Vehicle_No_dup']")
	public static WebElement vehicleno;
	
	@FindBy(xpath = "//input[@id='zc-Driver_Name']")
	public static WebElement drivername;
	
	@FindBy(xpath = "//input[@id='zc-Driver_Mobile_Number']")
	public static WebElement drivermobilenumber;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[28]")
	public static WebElement vehicletype;
	
	@FindBy(css = "input[name='zc-sel2-inp-Vehicle_Type']")
	public static WebElement vehicletypesearch;
	
	@FindBy(xpath = "//input[@name='update']")
	public static WebElement createdispatchupdate;
	
	
	//Create Material Request
	@FindBy(xpath = "//a[@id='tab_Stores']//span[@class='title'][normalize-space()='Stores']")
	public static WebElement stores3;
	
	@FindBy(xpath = "//a[@id='Stores']//span[@class='title'][normalize-space()='Stores']")
	public static WebElement storesbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Create Material Request']")
	public static WebElement creatematerialreq;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[5]")
	public static WebElement materialreqprojectname;
	
	@FindBy(css = "input[name='zc-sel2-inp-Project_Name']")
	public static WebElement materialreqsearchname;
	
	@FindBy(xpath = "//a[@elname='subFormLink']")
	public static WebElement Addmrq;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[10]")
	public static WebElement mrqpartno;
	
	@FindBy(css = "input[name='zc-sel2-inp-Item_Details.t::row_1.Part_No']")
	public static WebElement mrqpartnosearch;
	
	@FindBy(xpath = "//span[text()='100003']")
	public static WebElement mrqpartnosselect;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Required_Qty']")
	public static WebElement  mrqrequiredqty;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement  mrqsubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement  mrqalert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement  mrqok;
	
	
	//Create the GIN
	@FindBy(xpath = "//a[@id='tab_Stores']//span[@class='title'][normalize-space()='Stores']")
	public static WebElement  stores2;
	
	@FindBy(xpath = "//a[@id='Stores']//span[@class='title'][normalize-space()='Stores']")
	public static WebElement  storesbutton2;
	
	@FindBy(xpath = "//a[normalize-space()='Create GIN']")
	public static WebElement  creategin;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[5]")
	public static WebElement  requestraised;
	
	@FindBy(css = "input[name='zc-sel2-inp-Request_raised_By']")
	public static WebElement  requestraisedsearch;
	
	@FindBy(xpath = "//input[@id='Request_Date']")
	public static WebElement  requestdategin;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[7]")
	public static WebElement  projectnamegin;
	
	@FindBy(css = "input[name='zc-sel2-inp-Project_Name']")
	public static WebElement  projectnamesearchgin;
	
	@FindBy(xpath = "//div[@name='Item_Details']//a[@elname='subFormLink'][normalize-space()='Add New']")
	public static WebElement  Addgin;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[8]")
	public static WebElement  partnogin;
	
	@FindBy(css = "input[name='zc-sel2-inp-Item_Details.t::row_1.Part_No']")
	public static WebElement  partnosearchgin;
	
	@FindBy(xpath = "//span[text()='100001']")
	public static WebElement partnoselectgin;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Required_Quantity']")
	public static WebElement  requiredgtygin;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Issued_Quantity']")
	public static WebElement  issuedgtygin;
	
	@FindBy(xpath = "//input[@id='zc-Item_Details-Rate']")
	public static WebElement  rategin;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement  ginsubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement  ginalert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement  ginok;
	
	
	//Stock Update both Sales and Purchase
	@FindBy(xpath = "//a[@id='tab_Stores']//span[@class='title'][normalize-space()='Stores']")
	public static WebElement  stores4;
	
	@FindBy(xpath = "//a[@id='Stores']//span[@class='title'][normalize-space()='Stores']")
	public static WebElement  storesbutton4;
	
	@FindBy(xpath = "//a[normalize-space()='Move to Stock']")
	public static WebElement  movetostock;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public static WebElement  stocksearch;
	
	@FindBy(xpath = "(//label[@for='checkbox-GRN_No-ZC_JE8GK5'])[1]")
	public static WebElement  stockcheckbox;
	
	@FindBy(xpath = "(//li[@class='select2-search-field']//input)[3]")
	public static WebElement  stockenter;
	
	@FindBy(xpath = "//a[@type='button']")
	public static WebElement  stockentersearch;
	
	@FindBy(xpath = "//a[@class='zc-custom-btn zc_transition']")
	public static WebElement  movetostockbutton;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[37]")
	public static WebElement  location;
	
	@FindBy(css = "input[name='zc-sel2-inp-Location_Name']")
	public static WebElement  searchlocation;
	
	@FindBy(xpath = "(//span[@class='select2-chosen'])[38]")
	public static WebElement  sublocation;
	
	@FindBy(css = "input[name='zc-sel2-inp-Sub_Location']")
	public static WebElement  sublocationsearch;
	
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement  stockupdatesubmit;
	
	@FindBy(xpath = "//form[@name='Alert_Messages']")
	public static WebElement  stockalert;
	
	@FindBy(xpath = "//input[@name='OK']")
	public static WebElement  stockok;
	
}
