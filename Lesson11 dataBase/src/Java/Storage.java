package Java;

import sun.dc.pr.PRError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    Connection connection;

    public Storage() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Product_db", "postgres", "frnbvtkm");
    }         //Коннект с бд

    List<Product> getAllProducts() throws SQLException {
        //statement.executeUpdate("UPDATE product SET price = 15 WHERE ID = 2"); //Вызов запроса на изменение в базе данных
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM product");
        List<Product> productList = new ArrayList<Product>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int count = rs.getInt("count");
            Product p = new Product(id, name, price, count);
            productList.add(p);
        }
        return productList;
    }

    Product getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        //statement.executeUpdate("UPDATE product SET price = 15 WHERE ID = 2"); //Вызов запроса на изменение в базе данных
        ResultSet rs = statement.executeQuery("SELECT * FROM product WHERE id =" + id);
        System.out.println(rs);
        rs.next();
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int count = rs.getInt("count");
        Product p = new Product(id, name, price, count);
        return p;
    }

    List<Product> sortByprice() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product ORDER BY price");
        List<Product> list = new ArrayList<Product>();
        System.out.println(resultSet);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int count = resultSet.getInt("count");
            Product p = new Product(id, name, price, count);
            list.add(p);
        }
        return list;
    }
    void updateProductName(int id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "UPDATE product SET name = '" + name +
                "' WHERE id = " + id;
        System.out.println(sqlQuery);
        statement.executeUpdate(sqlQuery);
    }
    List<Product> getMostExpensiveprod() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product WHERE SELECT MAX(price)");
    }
}
