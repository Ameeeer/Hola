package Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        add(5, "Бублики", 15, 30);
        PrintWriter pw;
    }

    static void delete(int id) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("file1.txt"));
        int n = countOfitems();
        String[] products = new String[n];
        int i = 0;
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            products[i] = str;
            i++;
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream("products.txt"));
        for (int j = 0; j < n; j++) {
            String s = products[j];
            String[] elem = s.split(", ");
            if (Integer.parseInt(elem[0]) != id) {
                pw.println(s);
            }
        }
        pw.close();
    }


    static int countOfitems() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("file1.txt"));
        int count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        return count;
    }

    static void add(int id, String name, int price, int count) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("file1.txt", true));
        pw.println(id + ", " + name + ", " + price + ", " + countOfitems());
        pw.close();
    }

}

