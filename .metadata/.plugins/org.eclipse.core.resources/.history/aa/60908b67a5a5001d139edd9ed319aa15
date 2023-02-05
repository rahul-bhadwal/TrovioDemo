package CommonUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions
{
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	// function to read data from excel file
	public static String[] readData(String filePath, String sheetName) throws Exception{
		FileInputStream fs = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = sheet.iterator();
		String[] data= new String[sheet.getLastRowNum()+1];
		int counter=0;
		while(iterator.hasNext())
		{
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			data[counter]="";
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				
				if (currentCell.getCellTypeEnum() == CellType.STRING) 
				{
					data[counter]= data[counter]+currentCell.getStringCellValue() + "--";
				}
				else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
				{
						data[counter]= data[counter].trim()+currentCell.getNumericCellValue() + "--";
				}
				else if (currentCell.getCellTypeEnum() == CellType.FORMULA) 
				{
					FormulaEvaluator formulaEval = workbook.getCreationHelper().createFormulaEvaluator();
					String value = formulaEval.evaluate(currentCell).toString();
			        DataFormatter formatter = new DataFormatter();
					data[counter]= data[counter]+value + "--";
				}
				else if (currentCell.getCellTypeEnum() == CellType.BLANK) 
				{
					data[counter]= data[counter]+"" + "--";
				}
			}
			counter++;
		}
		
		fs.close();
		workbook.close();
		return data;
	}
	
	// function to handle blank cell in excel file
	public static String[] readBlankCell(String filePath, String sheetName) throws IOException
	{
		FileInputStream fs = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet(sheetName);
		
		String[] data= new String[sheet.getLastRowNum()+1];
		
		int rowStart = sheet.getFirstRowNum();
	    int rowEnd = sheet.getLastRowNum();

	    for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++)
	    {
	       Row r = sheet.getRow(rowNum);
	       if (r == null) {
	          continue;
	       }

	       int lastColumn = Math.max(r.getLastCellNum(), 20);
	       data[rowNum]="";

	       for (int cn = 0; cn < lastColumn; cn++)
	       {
	          Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
	          if (c == null)
	          {
	        	  //System.out.println("cell is blank");
	        	  data[rowNum]= data[rowNum]+"NA" + "--";
	          } 
	          else
	          {
	        	  if (c.getCellTypeEnum() == CellType.STRING) 
	        		  	data[rowNum]= data[rowNum]+c.getStringCellValue() + "--";
	        	 
	        	  else if (c.getCellTypeEnum() == CellType.NUMERIC) 
						data[rowNum]= data[rowNum].trim()+c.getNumericCellValue() + "--";
	        	  else if (c.getCellTypeEnum() == CellType.FORMULA) 
	        	  {
	        		  FormulaEvaluator formulaEval = workbook.getCreationHelper().createFormulaEvaluator();
					String value = formulaEval.evaluate(c).toString();
			        DataFormatter formatter = new DataFormatter();
					data[rowNum]= data[rowNum]+value + "--";
	        	  }
	        	  else if (c.getCellTypeEnum() == CellType.BLANK) 
					data[rowNum]= data[rowNum]+"NA" + "--";
	          }
	       }
	    }
	    fs.close();
		workbook.close();
		return data;
	}
	
	// function to count the total number of sheets in the workbook
	public static int getSheetcount(String filename) throws IOException
	{
		InputStream myxls = new FileInputStream(filename);
		Workbook book = new XSSFWorkbook(myxls);
		int totalSheetCount = book.getNumberOfSheets();
		book.close();
		return (totalSheetCount);
	}
	
	// function to write data on excel file
	public static void writeDataAtCell(String fileName, String sheetName, int rowNum, int colNum, String data) throws Exception{
		FileInputStream fis= new FileInputStream(fileName);
		workbook=new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		
		row=sheet.getRow(rowNum);
		cell= row.createCell(colNum);
		cell.setCellValue(data);
		
		fis.close();
		FileOutputStream fos= new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
	
	// function to set path for excel file
	public  static void setPath(String path, String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);	
	}
	
	// function to close path for excel file
	public  static void closePath() throws IOException
	{
		workbook.close();
	}
	
	// function to return sheet name in excel file
	public static String getSheetName(String filename,int sheetNo)throws Exception
	{
		InputStream myxls = new FileInputStream(filename);
		System.out.println(filename);
		Workbook book = new XSSFWorkbook(myxls);
	    String SheetName = book.getSheetName(sheetNo);
	    System.out.println(SheetName);
		book.close();
		return (SheetName);
	}
}