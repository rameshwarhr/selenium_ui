package rough;

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

public class update_excelutility 
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
     //   boolean isFirstLoop = true; // Flag to track the first loop
        
        for (int i = 3; i <= rowLast; i++) 
        {
            Row row = sheet.getRow(i);

            for (int j = 0; j < column - 426; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);;//dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (!cellValue.isEmpty() && j < column - 427) {
                	writer.write("^"); // Add caret symbol between entries except for the last one
                	 System.out.print("^");
                	 
                } 
                System.out.print(cellValue);
               
            
               }
          
            writer.newLine();
       //     writer.newLine();
 
       

            for (int j = 9; j < column -258; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);;//dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j+6 < column - 258) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
            //    writer.write(cellValue + "^");
                System.out.print(cellValue);
            }
            
            writer.newLine();
            System.out.println();
            
            
            for (int j = 177; j < column-232 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue =dataFormatter.formatCellValue(cell);;// dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 233) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();
            
            for (int j = 203; j < column-206 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 207) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();
            
            
            
            for (int j = 229; j < column-180 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 181) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();
            
            
            for (int j = 255; j < column-172 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 173) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();
            
            
            for (int j = 263; j < column-164 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 165) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();
            
            
            for (int j = 271; j < column-156 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 157) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();
            
            
            
            for (int j = 279; j < column-143 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 144) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();  
            
            
            for (int j = 292; j < column-130 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                if (j < column - 131) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println();  
            
            
            
            
            
            for (int j = 305; j < column-117 ; j++) 
            {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                writer.write(cellValue);
                
                if (j < column - 118) {
                    writer.write("^"); // Add caret symbol between entries except for the last one
                }
                System.out.print(cellValue);
            }
            writer.newLine();
            System.out.println(); 
              
        }
        writer.newLine();
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
