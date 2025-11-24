public class GenericProduct extends Product {

    public GenericProduct(String productType, String serialPrefix,
                          double price, boolean discountEligible,
                          boolean foodConsumable, boolean drinkConsumable,
                          boolean restrictedUnderage) {
        super(productType, serialPrefix, price,
              discountEligible, foodConsumable,
              drinkConsumable, restrictedUnderage);
    }

    @Override
    public double getDiscountedPrice() {
        double discounted = price;

        // Basic discount rules (you can refine these later at checkout)
        if (discountEligible) {
            if (foodConsumable) {
                discounted *= 0.8;   // 20% off
            } else if (drinkConsumable) {
                discounted *= 0.9;   // 10% off
            }
        }

        return discounted;
    }
}
