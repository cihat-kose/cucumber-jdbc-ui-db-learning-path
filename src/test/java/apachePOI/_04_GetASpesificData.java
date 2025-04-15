package apachePOI;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_GetASpesificData {

    /**
     * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
     * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
     * Yani metoda "Password" kelimesi gönderilecek, dönen değer Password un değeri olacak.
     * Bulma ve sonucun döndürülmesi için metod kullanınız.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     * -------------------------------------------------------------------------------------------
     * The user will enter whatever he wants from the information in the 1st column in the excel below.
     * in return all corresponding information in the line of this information will be printed.
     * In other words, the word "Password" will be sent to the method, and the returned value will be the value of Password.
     * Use the method to find and return the result.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     */

    public static void main(String[] args) throws IOException {
        String returningResult = bringFromExcel("address");
        System.out.println(returningResult);
    }

    private static String bringFromExcel(String searchWord) throws IOException {

        String willReturn = "";

        String path = "src/test/java/apachePOI/resource/LoginData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(searchWord.toLowerCase())) {
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    willReturn += sheet.getRow(i).getCell(j);
                }
            }
        }
        return willReturn;

        /** The Second Way --- With StringBuilder*/
//        StringBuilder willReturn = new StringBuilder();
//
//        String path = "src/test/java/apachePOI/resource/LoginData.xlsx";
//        FileInputStream fileInputStream = new FileInputStream(path);
//        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(searchWord.toLowerCase())) {
//                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
//                    willReturn.append(sheet.getRow(i).getCell(j));
//                }
//            }
//        }
//        return willReturn.toString();
    }
}
