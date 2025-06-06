package apachePOI;

/**
 * Main den bir metod çağırmak suretiyle, henüz oluşturulmamış
 * path'i verilen excel için, program her çalıştıkça içine "Test passed"
 * yazısını ekleyen metodu yazınız.
 * Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
 * dosya varsa en son satırın altına yaz.
 * ----------------------------------------------------------------------------------
 * By calling a method from Main, a method that has not yet been created can be created.
 * For Excel whose path is given, "test passed" is entered every time the program runs.
 * Write the method that adds the text.
 * So if there is no file, write create on the first line, then the file will be created.
 * If there is a file, write it below the last line.
 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _10_ScenarioResultsAppender {

    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI/resource/ScenarioResultsDemo.xlsx";
        String data = "Test passed";

        writeToExcel(path, data); // Excel will be created
        writeToExcel(path, data); // The file now exists, the lower part will work
        writeToExcel(path, data);
        writeToExcel(path, data);
    }

    public static void writeToExcel(String path, String data) {
        File file = new File(path);

        if (!file.exists()) { // If the file does not exist, it runs first time and 1 time

            // Create a workbook in memory, create a sheet in memory
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Scenario Results");

            // Perform operations in memory
            Row newRow = sheet.createRow(0);
            Cell cell = newRow.createCell(0);
            cell.setCellValue(data + " was created");

            // Save
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception exception) {
                System.out.println("exception.getMessage() = " + exception.getMessage());
            }
        } else {
            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception exception) {
                System.out.println("exception.getMessage() = " + exception.getMessage());
            }

            int lastRowIndex = sheet.getPhysicalNumberOfRows();
            Row newRow = sheet.createRow(lastRowIndex);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(data);

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception exception) {
                System.out.println("exception.getMessage() = " + exception.getMessage());
            }
        }
    }
}
