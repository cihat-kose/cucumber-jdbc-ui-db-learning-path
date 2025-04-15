package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Todo extends JDBCParent {
    /**
     * TODO: Sakila database içerisinde yer alan city tablosundan tüm satırlardaki şehir isimlerini absolute ile yazdırınız
     * TODO: Sakila database içerisinde yer alan city tablosundan tüm satırlardaki şehir isimlerini relative ile yazdırınız
     * ----------------------------------------------------------------------------------
     * TODO: Print the city names in all rows from the city table in the Sakila database with absolute.
     * TODO: Print the city names in all rows from the city table in the Sakila database with relative.
     */

    @Test
    public void absoluteTest() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from city");

        resultTable.last();
        int lastRowNumber = resultTable.getRow();

        for (int i = 1; i <= lastRowNumber; i++) {
            resultTable.absolute(i);
            System.out.println("City name with absolute = " + resultTable.getString("city"));
        }
    }

    @Test
    public void relativeTest() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from city");

        resultTable.last();
        int lastRowNumber = resultTable.getRow();

        resultTable.first();
        int firstRowNumber = resultTable.getRow();

        for (int i = 0; i < lastRowNumber; i++) {
            System.out.println("City name with relative = " + resultTable.getString("city"));
            resultTable.relative(1);
        }
    }
}
