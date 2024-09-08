package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Indent {

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
}
