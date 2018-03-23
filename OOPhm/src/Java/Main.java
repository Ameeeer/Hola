package Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    final static String FILENAME = "products.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Product[] products = load(FILENAME);
        Product product = getMostExpensiveProduct();
        System.out.println(product.id + ", " + product.name + ", " + product.price + ", " + product.count);
        SortirationbyPrice(products);
        printProducts(products);
    }

    /**
     * Выводит на консоль информацию о содержимом массива продуктов
     *
     * @param products продукты, которые будут распечатаны
     */
    static void printProducts(Product[] products) throws FileNotFoundException {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].id + ", " + products[i].name + ", " + products[i].price + ", " + products[i].count);
        }
    }


    /**
     * Возвращает Product по его id
     *
     * @param id идентификатор нужного продукта
     */
    static Product getById(int id) throws FileNotFoundException {
        Product[] products = load(FILENAME);
        for (int i = 0; i < products.length; i++) {
            if (products[i].id == id) {
                return products[i];
            }
        }
        return null;
    }

    /**
     * Возвращает самый дорогой Product, имеющийся на складе
     *
     * @param products
     * @return
     */
    static Product getMostExpensiveProduct() throws FileNotFoundException {
        Product[] products = load(FILENAME);
        Product productwithmaxprice = products[0];
        for (int i = 0; i < products.length; i++) {
            if (products[i].price > productwithmaxprice.price) {
                productwithmaxprice= products[i];
            }
        }
        return productwithmaxprice;
    }


    static Product[] load(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(fileName));
        Product[] products = new Product[countOfItems(fileName)];
        int count = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] elements = s.split(", ");
            Product product = new Product(Integer.parseInt(elements[0]),
                    elements[1],
                    Integer.parseInt(elements[2]),
                    Integer.parseInt(elements[3]));
            products[count] = product;
            count++;
        }
        return products;
    }

    static int countOfItems(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        return count;
    }

    static void add(Product product) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("products.txt", true));
        pw.println(product.id + ", " + product.name + ", " + product.price + ", " + product.count);
        pw.close();
    }

    static void SortirationbyPrice(Product[] products) throws FileNotFoundException {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length - 1; j++) {
                if (products[j + 1].price < products[j].price) {
                    Product product = products[j];
                    products[j] = products[j+1];
                    products[j+1] = product;
                }
            }
        }
    }
}
