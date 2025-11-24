/*
 *  The Cart class
 *      Equipment that can hold up to 30 products
 */

public class Cart extends Equipment {

    private static final int CART_CAPACITY = 30;

    public Cart() {
        super("Cart", CART_CAPACITY);
    }
}
