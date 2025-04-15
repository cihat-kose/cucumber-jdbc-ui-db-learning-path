package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    public static Connection connection;
    public static Statement statement;

    public static List<List<String>> getDataList(String sql) {

        List<List<String>> table = new ArrayList<>();

        try {
            dbConnectionOpen();

            if (connection == null || statement == null) {
                throw new RuntimeException("Database connection is not established!");
            }

            ResultSet resultTable = statement.executeQuery(sql);
            ResultSetMetaData resultTableMetaData = resultTable.getMetaData();

//            ArrayList<String> columnNames = new ArrayList<>();
//            for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
//                columnNames.add(resultTableMetaData.getColumnName(i));
//            }
//
//            table.add(columnNames);

            while (resultTable.next()) {
                List<String> rowList = new ArrayList<>();
                for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
                    rowList.add(resultTable.getString(i));
                }
                table.add(rowList);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Database error occurred!", exception);
        } finally {
            dbConnectionClose();
        }

        return table;
    }

    public static void dbConnectionOpen() {

        String hostUrl = "jdbc:mysql://demo.mersys.io:33906/sakila";
        String username = "admin";
        String password = "Techno24Study.%=";

        try {
            connection = DriverManager.getConnection(hostUrl, username, password);
            statement = connection.createStatement();
        } catch (Exception exception) {
            exception.printStackTrace(); // Failed to connect due to which error, to be able to see clearly
        }

        System.out.println("Connection object: " + connection);

    }

    public static void dbConnectionClose() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}