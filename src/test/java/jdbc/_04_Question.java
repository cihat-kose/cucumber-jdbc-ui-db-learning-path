package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Question extends JDBCParent {
    /**
     * Sakila database içerisinde yer alan city tablosundan tüm satırlardaki şehir isimlerini next ile yazdırınız.
     * ---------------------------------------------------------------------------------------------------------------
     * Print the city names in all rows from the city table in the Sakila database with next.
     */

    @Test
    public void cityTest() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from city");

        while (resultTable.next()) {
            System.out.println("City Name = " + resultTable.getString("city"));
        }
    }
}


