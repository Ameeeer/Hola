package Java;

public class Product {
    int id;
    String name;
    int price;
    int count;

    boolean existsOnStock() {
        return count > 0;
    }

    public Product(int id, String name, int price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }
}