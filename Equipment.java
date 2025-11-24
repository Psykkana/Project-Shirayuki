import java.util.ArrayList;

/*
 *  The Equipment superclass
 *      Represents baskets and carts carried by the shopper
 *      Each equipment has a name, capacity, and list of products
 */

public abstract class Equipment {

    protected String name;
    protected int capacity;
    protected ArrayList<Product> products;

    public Equipment(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return products.size();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean isFull() {
        return products.size() >= capacity;
    }

    // Try to add a product; returns true if successful
    public boolean addProduct(Product p) {
        if (isFull()) {
            return false;
        }
        products.add(p);
        return true;
    }

    public boolean removeProduct(Product p) {
        return products.remove(p);
    }

    public void clear() {
        products.clear();
    }
}
