package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Storage storage= new Storage();
        printprod(storage.sortByprice());
    }
    public static void printprod(List<Product> prod){
        for (int i = 0; i <prod.size() ; i++) {
            System.out.println(prod.get(i).id + ", " + prod.get(i).name + ", " + prod.get(i).price + ", " + prod.get(i).count);
        }
    }
}

