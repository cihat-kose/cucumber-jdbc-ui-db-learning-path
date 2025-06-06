package apachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_CreateMultiplicationTableExcel {

    public static void main(String[] args) throws IOException {
        /**
         Yen bir excel dosyasına çarpım tablosunu
         alt alta yazdırınız.
         -------------------------------------------------------------------
         Copy the multiplication table into a new excel file
         print below.
         */

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

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

        String path = "src/test/java/apachePOI/resource/NewMultiplicationTable.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

        System.out.println("The process is over.");
    }
}
