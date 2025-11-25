import java.util.Random;
import java.util.ArrayList;

/*
 *  The Product Superclass
 *
 */

public abstract class Product {

    protected String productType;   // Name
    protected String serialID;  // 3 Letters + 5 Digits
    protected double price;

    // For + 60 discount for edible/drinkables (excludes alcohol)
    protected boolean discountEligible;
    protected boolean foodConsumable;   // 20% discount
    protected boolean drinkConsumable;  // 10% discount

    // Under 18 cannot get alcohol and cleaning agents
    protected boolean restrictedUnderage;

    // For random generation
    private static Random random = new Random();

    public Product(String productType, String serialPrefix,
                    double price, boolean discountEligible, 
                    boolean foodConsumable, boolean drinkConsumable, 
                    boolean restrictedUnderage) {
        this.productType = productType;
        this.serialID = generateSerialID(serialPrefix);
        this.price = price;
        this.discountEligible = discountEligible;
        this.foodConsumable = foodConsumable;
        this.drinkConsumable = drinkConsumable;
        this.restrictedUnderage = restrictedUnderage;
    }

    // Generates unqiue ID
    protected String generateSerialID(String prefix) {
        String serialNumber = "";

        // Local list of used digits
        ArrayList<Integer> usedNums = new ArrayList<>(); 

        // Generate numbers 0-9
        for (int digit = 1; digit <= 5; digit++) {

            int chosenNum;

            do {
                chosenNum = random.nextInt(10);
            } while (usedNums.contains(chosenNum));

            serialNumber += chosenNum;
            usedNums.add(chosenNum);
        }
        return prefix + serialNumber;
    }

    // Getters are public so they can be used by other classes
    // like displayTiles
    public String getProductType() {
        return productType;
    }

    public String getSerialID() {
        return serialID;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountEligible() {
        return discountEligible;
    }

    public boolean isRestrictedUnderage() {
        return restrictedUnderage;
    }


    public void getIcon() {
    }

    // For subclasses to use to apply specific discounts
    public abstract double getDiscountedPrice();
}