/*
 *  The Basket class
 *      Equipment that can hold up to 15 products
 */

public class Basket extends Equipment {

    private static final int BASKET_CAPACITY = 15;

    public Basket() {
        super("Basket", BASKET_CAPACITY);
    }
}
