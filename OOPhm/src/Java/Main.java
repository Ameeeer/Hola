package Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    final static String FILENAME = "products.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Product p = new Product(77, "Бублики", 21, 8);
        Product p1 = new Product(21, "dfgsdfg", 11, 8);
        Product[] prs = new Product[2];
        prs[0] = p;
        prs[1] = p1;

        Product[] products = load(FILENAME);
        printProducts(products);
        System.out.println();
        System.out.println();
        getById(2);
        getMostExpensiveProduct();
    }


    /**
     * Выводит на консоль информацию о содержимом массива продуктов
     *
     * @param products продукты, которые будут распечатаны
     */
    static void printProducts(Product[] products) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILENAME));
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] elem = s.split(", ");
            System.out.println(elem[0] + ", " + elem[1] + ", " + elem[2] + ", " + elem[3]);
        }
    }


    /**
     * Возвращает Product по его id
     *
     * @param id идентификатор нужного продукта
     */
    static Product getById(int id) throws FileNotFoundException {
        Product[] products = load(FILENAME);
        Scanner scanner = new Scanner(new FileInputStream(FILENAME));
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] elem = s.split(", ");
            if (Integer.parseInt(elem[0]) == id) {
                System.out.println(elem[0] + ", " + elem[1] + ", " + elem[2] + ", " + elem[3]);
            }
        }
        return null;
    }

    /**
     * Возвращает самый дорогой Product, имеющийся на складе
     *
     * @return
     */
    static Product getMostExpensiveProduct() throws FileNotFoundException {
        Product[] products = load(FILENAME);
        Scanner scanner = new Scanner(new FileInputStream(FILENAME));
        Scanner scanner1 = new Scanner(new FileInputStream(FILENAME));
        int maxprice = 0;
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] elem = s.split(", ");
            if (Integer.parseInt(elem[2]) > maxprice){
                maxprice = Integer.parseInt(elem[2]);
            }
        }
        while (scanner1.hasNextLine()){
            String s1 = scanner1.nextLine();
            String[] elem2 = s1.split(", ");
            if (Integer.parseInt(elem2[2]) == maxprice){
                System.out.println(elem2[0] + ", " + elem2[1] + ", " + elem2[2] + ", " + elem2[3]);
            }
        }

        return null ;
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
}
