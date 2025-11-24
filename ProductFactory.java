import java.util.Random;

/**
 *  ProductFactory
 *      Creates Product instances for all product types in the specs.
 *
 *  Note:
 *      Consumables (food/drink) are marked with discountEligible = true
 *      EXCEPT Alcohol. Alcohol + Cleaning Agents are restrictedUnderage.
 */
public class ProductFactory {

    private static final Random random = new Random();

  //helper function

    private static int pickIndex(int length) {
        return random.nextInt(length);
    }

   //Table or product maker (hence why its called factory)

    public static Product createFruit() {
        String[] names = {
            "Red Apple",
            "Clementine",
            "Green Grapes"
        };
        double[] prices = { 30.0, 28.0, 60.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "FRU",
            prices[i],
            true,   // eligible for discounts
            true,   // is a food so its consumable
            false,  
            false   
        );
    }

    public static Product createVegetable() {
        String[] names = {
            "Cabbage",
            "Lettuce",
            "Carrot"
        };
        double[] prices = { 40.0, 35.0, 50.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "VEG",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createMilk() {
        String[] names = {
            "Fresh Milk 1L",
            "Soy Milk 1L",
            "Almond Milk 1L"
        };
        double[] prices = { 80.0, 90.0, 110.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "MLK",
            prices[i],
            true,
            true,   // treat as food consumable for discount
            true,   // is a drink
            false
        );
    }

    public static Product createFrozenFood() {
        String[] names = {
            "Chicken Nuggets",
            "Tender Juicy Hotdog",
            "Tocino"
        };
        double[] prices = { 120.0, 95.0, 130.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "FRZ",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createCheese() {
        String[] names = {
            "Mozzarella Cheese",
            "Blue Cheese",
            "Cheddar Cheese"
        };
        double[] prices = { 150.0, 200.0, 130.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CHS",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createChicken() {
        String[] names = {
            "Chicken Thigh",
            "Chicken Breast",
            "Ground Chicken"
        };
        double[] prices = { 140.0, 150.0, 135.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CHK",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createBeef() {
        String[] names = {
            "Beef Rib Cut",
            "Beef loin Cut",
            "Ground Beef 500g"
        };
        double[] prices = { 260.0, 240.0, 220.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "BEF",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createSeafood() {
        String[] names = {
            "Fresh Tilapia",
            "Tuna 500g",
            "Squid Rings 500g"
        };
        double[] prices = { 150.0, 320.0, 260.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "SEA",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createBread() {
        String[] names = {
            "Baguette Loaf",
            "Butter Croissant",
            "Sesame Bagel"
        };
        double[] prices = { 70.0, 55.0, 45.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "BRD",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createCereal() {
        String[] names = {
            "Captain Cocobytes",
            "BannerBytes",
            "Algocrunch"
        };
        double[] prices = { 120.0, 110.0, 115.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CER",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createNoodles() {
        String[] names = {
            "Nissin Cup Noodles",
            "Lucky Me",
            "Samyang"
        };
        double[] prices = { 20.0, 60.0, 35.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "NDL",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createSnacks() {
        String[] names = {
            "Pringles",
            "Maple Cookies",
            "Oreos"
        };
        double[] prices = { 45.0, 60.0, 35.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "SNK",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createCannedGoods() {
        String[] names = {
            "Kumpletuna",
            "Corned Beef",
            "Canned Soup"
        };
        double[] prices = { 55.0, 35.0, 70.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CAN",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createCondiments() {
        String[] names = {
            "Iodized Salt 500g",
            "Black Pepper 50g",
            "Paprika Powder 50g"
        };
        double[] prices = { 25.0, 45.0, 50.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CON",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createEggs() {
        String[] names = {
            "White Eggs 12s",
            "Brown Eggs 24s",
            "Century Eggs 12s"
        };
        double[] prices = { 90.0, 70.0, 110.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "EGG",
            prices[i],
            true,
            true,
            false,
            false
        );
    }

    public static Product createSoftDrink() {
        String[] names = {
            "Cola 1.5L",
            "Sprite 1.5L",
            "7Up 1L"
        };
        double[] prices = { 70.0, 65.0, 55.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "SFT",
            prices[i],
            true,
            false,
            true,   // drink
            false
        );
    }

    public static Product createJuice() {
        String[] names = {
            "Real Leaf 1L",
            "C2 1L",
            "Jungle Juice 1L"
        };
        double[] prices = { 75.0, 80.0, 85.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "JUC",
            prices[i],
            true,
            false,
            true,
            false
        );
    }

    public static Product createAlcohol() {
        String[] names = {
            "Red Horse 330ml",
            "Vodka 700ml",
            "Smirnoff 360ml"
        };
        double[] prices = { 55.0, 350.0, 90.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "ALC",
            prices[i],
            false,  // no senior discount 
            false,
            true,
            true   // not for kids
        );
    }

    public static Product createCleaningAgent() {
        String[] names = {
            "Liquid Detergent 1L",
            "Bleach 1L",
            "Dishwashing Liquid 800ml"
        };
        double[] prices = { 90.0, 75.0, 70.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CLE",
            prices[i],
            false,  // not consumable
            false,
            false,
            true   // not safe for kids
        );
    }

    public static Product createHomeEssential() {
        String[] names = {
            "Broom",
            "Floor Mop",
            "Plunger"
        };
        double[] prices = { 80.0, 120.0, 100.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "HOM",
            prices[i],
            false,
            false,
            false,
            false
        );
    }

    public static Product createHairCare() {
        String[] names = {
            "Shampoo 400ml",
            "Conditioner 400ml",
            "Hair Wax 75g"
        };
        double[] prices = { 120.0, 125.0, 140.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "HAR",
            prices[i],
            false,
            false,
            false,
            false
        );
    }

    public static Product createBodyCare() {
        String[] names = {
            "Bath Soap Bar",
            "Body Wash 500ml",
            "Shower Gel 500ml"
        };
        double[] prices = { 40.0, 130.0, 135.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "BOD",
            prices[i],
            false,
            false,
            false,
            false
        );
    }

    public static Product createDentalCare() {
        String[] names = {
            "Toothpaste 150g",
            "Soft Toothbrush",
            "Dental Floss"
        };
        double[] prices = { 85.0, 60.0, 75.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "DEN",
            prices[i],
            false,
            false,
            false,
            false
        );
    }

    public static Product createClothes() {
        String[] names = {
            "T-Shirt",
            "Polo Shirt",
            "Jacket"
        };
        double[] prices = { 250.0, 300.0, 450.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "CLO",
            prices[i],
            false,
            false,
            false,
            false
        );
    }

    public static Product createStationery() {
        String[] names = {
            "A4 Bond Paper Ream",
            "Ballpoint Pen Pack",
            "Correction Tape"
        };
        double[] prices = { 180.0, 50.0, 25.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "STN",
            prices[i],
            false,
            false,
            false,
            false
        );
    }

    public static Product createPetFood() {
        String[] names = {
            "Cat Kibble 1kg",
            "Dog Kibble 1kg",
            "Bird Seed Mix 1kg"
        };
        double[] prices = { 220.0, 240.0, 200.0 };

        int i = pickIndex(names.length);
        return new GenericProduct(
            names[i],
            "PET",
            prices[i],
            true,   // treat as consumable for discount
            true,
            false,
            false
        );
    }
}
