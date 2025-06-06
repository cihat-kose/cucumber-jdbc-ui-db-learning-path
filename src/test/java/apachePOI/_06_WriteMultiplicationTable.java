package apachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteMultiplicationTable {
    public static void main(String[] args) throws IOException {
        /**
         Boş bir excel dosyasına çarpım tablosunu
         alt alta yazdırınız.
         -------------------------------------------------------------------
         Copy the multiplication table into a blank excel file
         print below.
         */

        String path = "src/test/java/apachePOI/resource/MultiplicationTable.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int newRowIndex = 0; // sheet.getPhysicalNumberOfRows();

        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 10; j++) {
                Row row = sheet.createRow(newRowIndex++);

                row.createCell(0).setCellValue(i);
                row.createCell(1).setCellValue("x");
                row.createCell(2).setCellValue(j);
                row.createCell(3).setCellValue("=");
                row.createCell(4).setCellValue(i * j);
            }
            Row nextRow = sheet.createRow(newRowIndex++);
        }

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

        System.out.println("The process is over.");
    }
}
