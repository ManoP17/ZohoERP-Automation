package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

    private String path;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public Xls_Reader(String path) {
        this.path = path;
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return 0;
        } else {
            sheet = workbook.getSheetAt(index);
            return sheet.getLastRowNum() + 1;
        }
    }

    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0) return "";

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                System.out.println("Sheet '" + sheetName + "' does not exist.");
                return "";
            }

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);

            if (row == null) {
                System.out.println("Header row does not exist in sheet '" + sheetName + "'.");
                return "";
            }

            int colNum = -1;
            for (int i = 0; i < row.getLastCellNum(); i++) {
                String currentColumn = row.getCell(i).getStringCellValue().trim();
                if (currentColumn.equalsIgnoreCase(colName.trim())) {
                    colNum = i;
                    break;
                }
            }

            if (colNum == -1) {
                System.out.println("Column '" + colName + "' does not exist in sheet '" + sheetName + "'.");
                return "";
            }

            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                System.out.println("Row " + rowNum + " does not exist in sheet '" + sheetName + "'.");
                return "";
            }

            cell = row.getCell(colNum);
            if (cell == null) {
                System.out.println("Cell at row " + rowNum + " and column " + colName + " does not exist.");
                return "";
            }

            // Handle different cell types
            if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                if (DateUtil.isCellDateFormatted(cell)) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(cell.getDateCellValue());
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based
                    int year = cal.get(Calendar.YEAR);
                    
                    // Format the date as dd-MMM-yyyy
                    String formattedDate = String.format("%02d-%s-%d", day, getMonthAbbreviation(month), year);
                    return formattedDate;
                } else {
                    double numericValue = cell.getNumericCellValue();
                    return numericValue == (int) numericValue ? String.valueOf((int) numericValue) : String.valueOf(numericValue);
                }
            } else if (cell.getCellType() == CellType.BLANK) {
                return "";
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                return String.valueOf(cell.getBooleanCellValue());
            }

            return "";

        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    // Helper method for month abbreviation
    private String getMonthAbbreviation(int month) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return months[month - 1];
    }

}