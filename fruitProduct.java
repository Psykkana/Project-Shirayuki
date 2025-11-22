public class fruitProduct extends Product {

    public fruitProduct(String productType, String serialPrefix, double price, boolean discountEligible,
            boolean foodConsumable, boolean drinkConsumable, boolean restrictedUnderage) {
        super("Fruit", "FRU", price, true, true, false, false);
    }
    
    @Override
    public double getDiscountedPrice() {
        return price * 0.8;     // 20% discount
    }

}
