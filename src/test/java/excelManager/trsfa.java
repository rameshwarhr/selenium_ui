package excelManager;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class trsfa 
{
    public static DataFormatter dataFormatter = new DataFormatter();

    public static void main(String[] args) throws IOException {
        String inputFilePath = "C:\\Users\\user2\\Desktop\\Excel_Utility\\updated_templetee.xlsx";  // Replace with the path to your Excel file
        String outputFilePath = "C:\\Users\\user2\\Desktop\\Excel_Utility\\update_entity.txt";  // Replace with the desired path for the output text file

        FileInputStream fileInputStream = new FileInputStream(inputFilePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        int rowLast = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();

        int maxRowCount = getMaxRowCount(workbook);
        System.out.println("Number of Rows: " + maxRowCount + "  Last Row: " + rowLast + "  Columns: " + column);
     
        for(int i = 3; i <= rowLast; i++) {
            Row row = sheet.getRow(i);
            
            for (int j = 0; j < column - 426; j++) {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                
                if (!cellValue.isEmpty() && j < column - 427) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
            }
          
            writer.newLine();
            
        }
        
        // Close the writer after writing all data
        writer.close();
        
        System.out.println("Data has been written to the text file: " + outputFilePath);
    }

    
    
    
    
    
    
    
    
    
    
    
    private static int getMaxRowCount(Workbook workbook) {
        int maxRowCount = 0;
        int numberOfSheets = workbook.getNumberOfSheets();

        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int lastRowNum = sheet.getLastRowNum() + 1;
            if (lastRowNum > maxRowCount) {
                maxRowCount = lastRowNum;
            }
        }

        return maxRowCount;
    }
}
	    
	    

	


