#Author: mano@certifytechnologies.com

@ERP
Feature: Zoho ERP Automation
Scenario Outline: To validate the Zoho erp functionalities
    
    Given User launched browser and Successfully login
    And Create the indent
    And Create RFQ against indent
    And Add Quotation against RFQ
    When Create PO against Quote
		And Create GRN in stores
    When Create IQC in GRN
    And Create Sales order
    When Dispatch plan in Sales order
    And Active Dispatch in Logistics
    When Create Material Request
    And Create the GIN
    When Stock Update both Sales and Purchase
    