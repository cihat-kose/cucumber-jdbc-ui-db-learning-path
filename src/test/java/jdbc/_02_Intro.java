package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Intro extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from customer");

        resultTable.next(); // At this stage we have completed the first line
        System.out.println(resultTable.getString("first_name"));//
        System.out.println(resultTable.getString("last_name"));

        System.out.println("*************************************************");

        resultTable.next(); // At this stage we have completed the second line
        System.out.println(resultTable.getString("first_name"));
        System.out.println(resultTable.getString("last_name"));
    }
}
