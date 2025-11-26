/*
 *  The Asset Initializer Class
 *      Does things like initialize the map objects to be placed in the board
 */

public class assetInitializer {
    
    // For readability's sake
    static final int floorOne = 1; 
    static final int floorTwo = 2;  

    // Objects and displays of the 1st Floor    
    public static void intializeFloorOne(Board board) {

        // =======================
        // CORE STRUCTURE (GF)
        // =======================

        // Stairs
        board.addObject(new stairTile(1, 15, floorOne, floorTwo));
        board.addObject(new stairTile(20, 15, floorOne, floorTwo));

        // The exit door
        board.addObject(new exitTile(10, 21, floorOne));
        // The entrance door
        board.addObject(new entranceTile(11, 21, floorOne));

        // Basket and Cart stations (per spec)
        board.addObject(new basketStationTile(1, 20, floorOne)); 
        board.addObject(new cartStationTile(20, 20, floorOne));    

        // The walls on the top side
        for (int x = 0; x <= 21; x++) {
            board.addObject(new wallTile(x, 0, floorOne));            
        }

        // The walls on the bottom side
        for (int x = 0; x <= 9; x++) {
            board.addObject(new wallTile(x, 21, floorOne));            
        }        
        for (int x = 12; x <= 21; x++) {
            board.addObject(new wallTile(x, 21, floorOne));            
        }

        // The walls on the left side
        for (int y = 1; y <= 21; y++) {
             board.addObject(new wallTile(0, y, floorOne));           
        }

        // The walls on the right side
        for (int y = 1; y <= 21; y++) {
             board.addObject(new wallTile(21, y, floorOne));           
        }

        // The walls between the checkout counters
        board.addObject(new wallTile(1, 18, floorOne));
        board.addObject(new wallTile(3, 18, floorOne));
        board.addObject(new wallTile(5, 18, floorOne));
        board.addObject(new wallTile(7, 18, floorOne));
        board.addObject(new wallTile(14, 18, floorOne));
        board.addObject(new wallTile(16, 18, floorOne));
        board.addObject(new wallTile(18, 18, floorOne));
        board.addObject(new wallTile(20, 18, floorOne));        

        // The middle walls
        board.addObject(new wallTile(10, 17, floorOne));
        board.addObject(new wallTile(11, 17, floorOne));
        board.addObject(new wallTile(10, 18, floorOne));
        board.addObject(new wallTile(11, 18, floorOne));

        //Product Searches on 1st floor
        board.addObject(new productSearchTile(8, 15, floorOne));
        board.addObject(new productSearchTile(13, 15, floorOne));

        // Checkout Counters - Left Side
        board.addObject(new checkoutStationTile(2, 18, floorOne));
        board.addObject(new checkoutStationTile(4, 18, floorOne));
        board.addObject(new checkoutStationTile(6, 18, floorOne));        
        board.addObject(new checkoutStationTile(8, 18, floorOne));

        // Checkout Counters - Right Side
        board.addObject(new checkoutStationTile(13, 18, floorOne));
        board.addObject(new checkoutStationTile(15, 18, floorOne));
        board.addObject(new checkoutStationTile(17, 18, floorOne));        
        board.addObject(new checkoutStationTile(19, 18, floorOne));

        // GROUND FLOOR AISLES (the products)

        createShelf(
            board,
            18, 4,
            floorOne,
            "Canned Goods",
            1,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        createShelf(
            board,
            19, 4,
            floorOne,
            "Canned Goods",
            2,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        // Row 5
        createShelf(
            board,
            18, 5,
            floorOne,
            "Canned Goods",
            3,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        createShelf(
            board,
            19, 5,
            floorOne,
            "Canned Goods",
            4,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        // Row 6
        createShelf(
            board,
            18, 6,
            floorOne,
            "Canned Goods",
            5,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        createShelf(
            board,
            19, 6,
            floorOne,
            "Canned Goods",
            6,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        // Row 7
        createShelf(
            board,
            18, 7,
            floorOne,
            "Canned Goods",
            7,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

        createShelf(
            board,
            19, 7,
            floorOne,
            "Canned Goods",
            8,
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods(),
            ProductFactory.createCannedGoods()
        );

          // Cereal – Cereal

        // Row 4
        createShelf(
            board,
            14, 4,
            floorOne,
            "Cereal",
            1,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        createShelf(
            board,
            15, 4,
            floorOne,
            "Cereal",
            2,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        // Row 5
        createShelf(
            board,
            14, 5,
            floorOne,
            "Cereal",
            3,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        createShelf(
            board,
            15, 5,
            floorOne,
            "Cereal",
            4,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        // Row 6
        createShelf(
            board,
            14, 6,
            floorOne,
            "Cereal",
            5,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        createShelf(
            board,
            15, 6,
            floorOne,
            "Cereal",
            6,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        // Row 7
        createShelf(
            board,
            14, 7,
            floorOne,
            "Cereal",
            7,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );

        createShelf(
            board,
            15, 7,
            floorOne,
            "Cereal",
            8,
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal(),
            ProductFactory.createCereal()
        );
        // Fruits – Fruits Section 

        createTable(
            board,
            10, 4,
            floorOne,
            "Fruits",
            1,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 4,
            floorOne,
            "Fruits",
            2,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Row 5
        createTable(
            board,
            10, 5,
            floorOne,
            "Fruits",
            3,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 5,
            floorOne,
            "Fruits",
            4,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Row 6
        createTable(
            board,
            10, 6,
            floorOne,
            "Fruits",
            5,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 6,
            floorOne,
            "Fruits",
            6,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Row 7
        createTable(
            board,
            10, 7,
            floorOne,
            "Fruits",
            7,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 7,
            floorOne,
            "Fruits",
            8,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Aisle 4 – Soft Drinks / Soda 
    
        createShelf(
            board,
            6, 4,
            floorOne,
            "Soda",
            1,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        createShelf(
            board,
            7, 4,
            floorOne,
            "Soda",
            2,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        // Row 5
        createShelf(
            board,
            6, 5,
            floorOne,
            "Soda",
            3,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        createShelf(
            board,
            7, 5,
            floorOne,
            "Soda",
            4,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        // Row 6
        createShelf(
            board,
            6, 6,
            floorOne,
            "Soda",
            5,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        createShelf(
            board,
            7, 6,
            floorOne,
            "Soda",
            6,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        // Row 7
        createShelf(
            board,
            6, 7,
            floorOne,
            "Soda",
            7,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        createShelf(
            board,
            7, 7,
            floorOne,
            "Soda",
            8,
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink(),
            ProductFactory.createSoftDrink()
        );

        // Aisle 5 – Alcohol (Shelf)

        // Row 4
        createShelf(
            board,
            2, 4,
            floorOne,
            "Alcohol",
            1,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        createShelf(
            board,
            3, 4,
            floorOne,
            "Alcohol",
            2,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        // Row 5
        createShelf(
            board,
            2, 5,
            floorOne,
            "Alcohol",
            3,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        createShelf(
            board,
            3, 5,
            floorOne,
            "Alcohol",
            4,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        // Row 6
        createShelf(
            board,
            2, 6,
            floorOne,
            "Alcohol",
            5,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        createShelf(
            board,
            3, 6,
            floorOne,
            "Alcohol",
            6,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        // Row 7
        createShelf(
            board,
            2, 7,
            floorOne,
            "Alcohol",
            7,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        createShelf(
            board,
            3, 7,
            floorOne,
            "Alcohol",
            8,
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol(),
            ProductFactory.createAlcohol()
        );

        // Aisle 6 – Condiments (Shelf)
        
        // Row 10
        createShelf(
            board,
            2, 10,
            floorOne,
            "Condiments",
            1,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        createShelf(
            board,
            3, 10,
            floorOne,
            "Condiments",
            2,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        // Row 11
        createShelf(
            board,
            2, 11,
            floorOne,
            "Condiments",
            3,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        createShelf(
            board,
            3, 11,
            floorOne,
            "Condiments",
            4,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        // Row 12
        createShelf(
            board,
            2, 12,
            floorOne,
            "Condiments",
            5,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        createShelf(
            board,
            3, 12,
            floorOne,
            "Condiments",
            6,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        // Row 13
        createShelf(
            board,
            2, 13,
            floorOne,
            "Condiments",
            7,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );

        createShelf(
            board,
            3, 13,
            floorOne,
            "Condiments",
            8,
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments(),
            ProductFactory.createCondiments()
        );
        // Aisle 7 – Juice (Shelf)

        // Row 10
        createShelf(
            board,
            6, 10,
            floorOne,
            "Juice",
            1,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        createShelf(
            board,
            7, 10,
            floorOne,
            "Juice",
            2,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        // Row 11
        createShelf(
            board,
            6, 11,
            floorOne,
            "Juice",
            3,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        createShelf(
            board,
            7, 11,
            floorOne,
            "Juice",
            4,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        // Row 12
        createShelf(
            board,
            6, 12,
            floorOne,
            "Juice",
            5,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        createShelf(
            board,
            7, 12,
            floorOne,
            "Juice",
            6,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        // Row 13
        createShelf(
            board,
            6, 13,
            floorOne,
            "Juice",
            7,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        createShelf(
            board,
            7, 13,
            floorOne,
            "Juice",
            8,
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice(),
            ProductFactory.createJuice()
        );

        // Fruits – Fruits (Tables)

        // Row 10
        createTable(
            board,
            10, 10,
            floorOne,
            "Fruits",
            1,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 10,
            floorOne,
            "Fruits",
            2,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Row 11
        createTable(
            board,
            10, 11,
            floorOne,
            "Fruits",
            3,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 11,
            floorOne,
            "Fruits",
            4,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Row 12
        createTable(
            board,
            10, 12,
            floorOne,
            "Fruits",
            5,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 12,
            floorOne,
            "Fruits",
            6,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Row 13
        createTable(
            board,
            10, 13,
            floorOne,
            "Fruits",
            7,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        createTable(
            board,
            11, 13,
            floorOne,
            "Fruits",
            8,
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit(),
            ProductFactory.createFruit()
        );

        // Aisle 9 – Noodles (Shelf)


        // Row 10
        createShelf(
            board,
            14, 10,
            floorOne,
            "Noodles",
            1,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        createShelf(
            board,
            15, 10,
            floorOne,
            "Noodles",
            2,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        // Row 11
        createShelf(
            board,
            14, 11,
            floorOne,
            "Noodles",
            3,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        createShelf(
            board,
            15, 11,
            floorOne,
            "Noodles",
            4,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        // Row 12
        createShelf(
            board,
            14, 12,
            floorOne,
            "Noodles",
            5,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        createShelf(
            board,
            15, 12,
            floorOne,
            "Noodles",
            6,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        // Row 13
        createShelf(
            board,
            14, 13,
            floorOne,
            "Noodles",
            7,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        createShelf(
            board,
            15, 13,
            floorOne,
            "Noodles",
            8,
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles(),
            ProductFactory.createNoodles()
        );

        // Aisle 10 – Snacks (Shelf)

        // Row 10
        createShelf(
            board,
            18, 10,
            floorOne,
            "Snacks",
            1,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        createShelf(
            board,
            19, 10,
            floorOne,
            "Snacks",
            2,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        // Row 11
        createShelf(
            board,
            18, 11,
            floorOne,
            "Snacks",
            3,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        createShelf(
            board,
            19, 11,
            floorOne,
            "Snacks",
            4,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        // Row 12
        createShelf(
            board,
            18, 12,
            floorOne,
            "Snacks",
            5,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        createShelf(
            board,
            19, 12,
            floorOne,
            "Snacks",
            6,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        // Row 13
        createShelf(
            board,
            18, 13,
            floorOne,
            "Snacks",
            7,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        createShelf(
            board,
            19, 13,
            floorOne,
            "Snacks",
            8,
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks(),
            ProductFactory.createSnacks()
        );

        // Chillers Row – Chicken (Chilled Counters)

        createChilled(
            board,
            1, 1,
            floorOne,
            "Chicken",
            1,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            2, 1,
            floorOne,
            "Chicken",
            2,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            3, 1,
            floorOne,
            "Chicken",
            3,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            4, 1,
            floorOne,
            "Chicken",
            4,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            5, 1,
            floorOne,
            "Chicken",
            5,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            6, 1,
            floorOne,
            "Chicken",
            6,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        // Chillers Row – Beef (Chilled Counters)

        createChilled(
            board,
            8, 1,
            floorOne,
            "Beef",
            1,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            9, 1,
            floorOne,
            "Beef",
            2,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            10, 1,
            floorOne,
            "Beef",
            3,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            11, 1,
            floorOne,
            "Beef",
            4,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            12, 1,
            floorOne,
            "Beef",
            5,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            13, 1,
            floorOne,
            "Beef",
            6,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        // Chillers Row – Seafood (Chilled Counters) (the very top)

        createChilled(
            board,
            15, 1,
            floorOne,
            "Seafood",
            1,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            16, 1,
            floorOne,
            "Seafood",
            2,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            17, 1,
            floorOne,
            "Seafood",
            3,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            18, 1,
            floorOne,
            "Seafood",
            4,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            19, 1,
            floorOne,
            "Seafood",
            5,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            20, 1,
            floorOne,
            "Seafood",
            6,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

    }

        // Objects and displays of the 2nd Floor     
    public static void intializeFloorTwo(Board board) {
        
        // Stairs
        board.addObject(new stairTile(1, 15, floorTwo, floorOne));
        board.addObject(new stairTile(20, 15, floorTwo, floorOne));    

        // The walls on the top side
        for (int x = 0; x <= 21; x++) {
            board.addObject(new wallTile(x, 0, floorTwo));            
        }

        // The walls on the bottom side
        for (int x = 0; x <= 21; x++) {
            board.addObject(new wallTile(x, 21, floorTwo));            
        }        

        // The walls on the left side
        for (int y = 1; y <= 21; y++) {
            board.addObject(new wallTile(0, y, floorTwo));           
        }

        // The walls on the right side
        for (int y = 1; y <= 21; y++) {
            board.addObject(new wallTile(21, y, floorTwo));           
        }    

        // Middle walls of the second floor
        board.addObject(new wallTile(4, 16, floorTwo));   
        board.addObject(new wallTile(4, 17, floorTwo));
        board.addObject(new wallTile(5, 16, floorTwo));
        board.addObject(new wallTile(5, 17, floorTwo));  
        
        board.addObject(new wallTile(10, 16, floorTwo));   
        board.addObject(new wallTile(10, 17, floorTwo));
        board.addObject(new wallTile(11, 16, floorTwo));
        board.addObject(new wallTile(11, 17, floorTwo)); 
        
        board.addObject(new wallTile(16, 16, floorTwo));   
        board.addObject(new wallTile(16, 17, floorTwo));
        board.addObject(new wallTile(17, 16, floorTwo));
        board.addObject(new wallTile(17, 17, floorTwo)); 

        //Product search for Second floor

        board.addObject(new productSearchTile(1, 20, floorTwo));
        board.addObject(new productSearchTile(20, 20, floorTwo));
        // SECOND FLOOR AISLES
        createShelf(
            board,
            18, 4,
            floorTwo,
            "2F - Home Essentials",
            1,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        createShelf(
            board,
            19, 4,
            floorTwo,
            "2F - Home Essentials",
            2,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        // Row 5
        createShelf(
            board,
            18, 5,
            floorTwo,
            "2F - Home Essentials",
            3,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        createShelf(
            board,
            19, 5,
            floorTwo,
            "2F - Home Essentials",
            4,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        // Row 6
        createShelf(
            board,
            18, 6,
            floorTwo,
            "2F - Home Essentials",
            5,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        createShelf(
            board,
            19, 6,
            floorTwo,
            "2F - Home Essentials",
            6,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        // Row 7
        createShelf(
            board,
            18, 7,
            floorTwo,
            "2F - Home Essentials",
            7,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        createShelf(
            board,
            19, 7,
            floorTwo,
            "2F - Home Essentials",
            8,
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential()
        );

        // x14–15: Cleaning Agents (Shelf)

        // Row 4
        createShelf(
            board,
            14, 4,
            floorTwo,
            "2F - Cleaning Agents",
            1,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        createShelf(
            board,
            15, 4,
            floorTwo,
            "2F - Cleaning Agents",
            2,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        // Row 5
        createShelf(
            board,
            14, 5,
            floorTwo,
            "2F - Cleaning Agents",
            3,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        createShelf(
            board,
            15, 5,
            floorTwo,
            "2F –-Cleaning Agents",
            4,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        // Row 6
        createShelf(
            board,
            14, 6,
            floorTwo,
            "2F - Cleaning Agents",
            5,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        createShelf(
            board,
            15, 6,
            floorTwo,
            "2F - Cleaning Agents",
            6,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        // Row 7
        createShelf(
            board,
            14, 7,
            floorTwo,
            "2F - Cleaning Agents",
            7,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        createShelf(
            board,
            15, 7,
            floorTwo,
            "2F - Cleaning Agents",
            8,
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent()
        );

        // x10–11: Vegetables (Tables)

        // Row 4
        createTable(
            board,
            10, 4,
            floorTwo,
            "2F - Vegetables",
            1,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 4,
            floorTwo,
            "2F - Vegetables",
            2,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // Row 5
        createTable(
            board,
            10, 5,
            floorTwo,
            "2F - Vegetables",
            3,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 5,
            floorTwo,
            "2F - Vegetables",
            4,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // Row 6
        createTable(
            board,
            10, 6,
            floorTwo,
            "2F - Vegetables",
            5,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 6,
            floorTwo,
            "2F - Vegetables",
            6,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // Row 7
        createTable(
            board,
            10, 7,
            floorTwo,
            "2F - Vegetables",
            7,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 7,
            floorTwo,
            "2F - Vegetables",
            8,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // x6–7: Clothes (Shelf)

        // Row 4
        createShelf(
            board,
            6, 4,
            floorTwo,
            "2F - Clothes",
            1,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        createShelf(
            board,
            7, 4,
            floorTwo,
            "2F - Clothes",
            2,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        // Row 5
        createShelf(
            board,
            6, 5,
            floorTwo,
            "2F - Clothes",
            3,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        createShelf(
            board,
            7, 5,
            floorTwo,
            "2F - Clothes",
            4,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        // Row 6
        createShelf(
            board,
            6, 6,
            floorTwo,
            "2F - Clothes",
            5,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        createShelf(
            board,
            7, 6,
            floorTwo,
            "2F - Clothes",
            6,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        // Row 7
        createShelf(
            board,
            6, 7,
            floorTwo,
            "2F - Clothes",
            7,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        createShelf(
            board,
            7, 7,
            floorTwo,
            "2F - Clothes",
            8,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createClothes()
        );

        // x2–3: Pet Foods (Shelf)

        // Row 4
        createShelf(
            board,
            2, 4,
            floorTwo,
            "2F - Pet Foods",
            1,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        createShelf(
            board,
            3, 4,
            floorTwo,
            "2F - Pet Foods",
            2,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        // Row 5
        createShelf(
            board,
            2, 5,
            floorTwo,
            "2F - Pet Foods",
            3,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        createShelf(
            board,
            3, 5,
            floorTwo,
            "2F - Pet Foods",
            4,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        // Row 6
        createShelf(
            board,
            2, 6,
            floorTwo,
            "2F - Pet Foods",
            5,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        createShelf(
            board,
            3, 6,
            floorTwo,
            "2F - Pet Foods",
            6,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        // Row 7
        createShelf(
            board,
            2, 7,
            floorTwo,
            "2F - Pet Foods",
            7,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        createShelf(
            board,
            3, 7,
            floorTwo,
            "2F - Pet Foods",
            8,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood()
        );

        // -----------------------
        // BOTTOM ROW: y = 10..13
        // -----------------------

        // x18–19: Body Care (Shelf)

        // Row 10
        createShelf(
            board,
            18, 10,
            floorTwo,
            "2F - Body Care",
            1,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        createShelf(
            board,
            19, 10,
            floorTwo,
            "2F - Body Care",
            2,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        // Row 11
        createShelf(
            board,
            18, 11,
            floorTwo,
            "2F - Body Care",
            3,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        createShelf(
            board,
            19, 11,
            floorTwo,
            "2F - Body Care",
            4,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        // Row 12
        createShelf(
            board,
            18, 12,
            floorTwo,
            "2F - Body Care",
            5,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        createShelf(
            board,
            19, 12,
            floorTwo,
            "2F - Body Care",
            6,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        // Row 13
        createShelf(
            board,
            18, 13,
            floorTwo,
            "2F - Body Care",
            7,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        createShelf(
            board,
            19, 13,
            floorTwo,
            "2F - Body Care",
            8,
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare(),
            ProductFactory.createBodyCare()
        );

        // x14–15: Hair Care (Shelf)

        // Row 10
        createShelf(
            board,
            14, 10,
            floorTwo,
            "2F - Hair Care",
            1,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        createShelf(
            board,
            15, 10,
            floorTwo,
            "2F - Hair Care",
            2,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        // Row 11
        createShelf(
            board,
            14, 11,
            floorTwo,
            "2F - Hair Care",
            3,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        createShelf(
            board,
            15, 11,
            floorTwo,
            "2F - Hair Care",
            4,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        // Row 12
        createShelf(
            board,
            14, 12,
            floorTwo,
            "2F - Hair Care",
            5,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        createShelf(
            board,
            15, 12,
            floorTwo,
            "2F - Hair Care",
            6,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        // Row 13
        createShelf(
            board,
            14, 13,
            floorTwo,
            "2F - Hair Care",
            7,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        createShelf(
            board,
            15, 13,
            floorTwo,
            "2F - Hair Care",
            8,
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare(),
            ProductFactory.createHairCare()
        );

        // x10–11: Vegetables again (Tables)

        // Row 10
        createTable(
            board,
            10, 10,
            floorTwo,
            "2F - Vegetables (Lower)",
            9,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 10,
            floorTwo,
            "2F - Vegetables (Lower)",
            10,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // Row 11
        createTable(
            board,
            10, 11,
            floorTwo,
            "2F - Vegetables (Lower)",
            11,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 11,
            floorTwo,
            "2F - Vegetables (Lower)",
            12,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // Row 12
        createTable(
            board,
            10, 12,
            floorTwo,
            "2F - Vegetables (Lower)",
            13,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 12,
            floorTwo,
            "2F - Vegetables (Lower)",
            14,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // Row 13
        createTable(
            board,
            10, 13,
            floorTwo,
            "2F - Vegetables (Lower)",
            15,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        createTable(
            board,
            11, 13,
            floorTwo,
            "2F - Vegetables (Lower)",
            16,
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable(),
            ProductFactory.createVegetable()
        );

        // x6–7: Dental Care (Shelf)

        // Row 10
        createShelf(
            board,
            6, 10,
            floorTwo,
            "2F - Dental Care",
            1,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        createShelf(
            board,
            7, 10,
            floorTwo,
            "2F - Dental Care",
            2,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        // Row 11
        createShelf(
            board,
            6, 11,
            floorTwo,
            "2F - Dental Care",
            3,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        createShelf(
            board,
            7, 11,
            floorTwo,
            "2F - Dental Care",
            4,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        // Row 12
        createShelf(
            board,
            6, 12,
            floorTwo,
            "2F - Dental Care",
            5,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        createShelf(
            board,
            7, 12,
            floorTwo,
            "2F - Dental Care",
            6,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        // Row 13
        createShelf(
            board,
            6, 13,
            floorTwo,
            "2F - Dental Care",
            7,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        createShelf(
            board,
            7, 13,
            floorTwo,
            "2F - Dental Care",
            8,
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createDentalCare()
        );

        // x2–3: Stationery (Shelf)

        // Row 10
        createShelf(
            board,
            2, 10,
            floorTwo,
            "2F - Stationery",
            1,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        createShelf(
            board,
            3, 10,
            floorTwo,
            "2F - Stationery",
            2,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        // Row 11
        createShelf(
            board,
            2, 11,
            floorTwo,
            "2F - Stationery",
            3,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        createShelf(
            board,
            3, 11,
            floorTwo,
            "2F - Stationery",
            4,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        // Row 12
        createShelf(
            board,
            2, 12,
            floorTwo,
            "2F - Stationery",
            5,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        createShelf(
            board,
            3, 12,
            floorTwo,
            "2F - Stationery",
            6,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        // Row 13
        createShelf(
            board,
            2, 13,
            floorTwo,
            "2F - Stationery",
            7,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );

        createShelf(
            board,
            3, 13,
            floorTwo,
            "2F - Stationery",
            8,
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery()
        );


        // Basket station at (1, 1)
        board.addObject(new basketStationTile(1, 1, floorTwo));
        board.addObject(new cartStationTile(20, 1, floorTwo));

        
        createFridge(
            board,
            3, 1,
            floorTwo,
            "2F - Milk",
            1,
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk()
        );

        createFridge(
            board,
            4, 1,
            floorTwo,
            "2F - Milk",
            2,
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk()
        );

        createFridge(
            board,
            5, 1,
            floorTwo,
            "2F - Milk",
            3,
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk()
        );

        createFridge(
            board,
            6, 1,
            floorTwo,
            "2F - Milk",
            4,
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk(),
            ProductFactory.createMilk()
        );

        createFridge(
            board,
            9, 1,
            floorTwo,
            "2F - Frozen Food",
            1,
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood()
        );

        createFridge(
            board,
            10, 1,
            floorTwo,
            "2F - Frozen Food",
            2,
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood()
        );

        createFridge(
            board,
            11, 1,
            floorTwo,
            "2F - Frozen Food",
            3,
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood()
        );

        createFridge(
            board,
            12, 1,
            floorTwo,
            "2F - Frozen Food",
            4,
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood(),
            ProductFactory.createFrozenFood()
        );

        // Cheese – Refrigerators 

        createFridge(
            board,
            15, 1,
            floorTwo,
            "2F - Cheese",
            1,
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese()
        );

        createFridge(
            board,
            16, 1,
            floorTwo,
            "2F - Cheese",
            2,
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese()
        );

        createFridge(
            board,
            17, 1,
            floorTwo,
            "2F - Cheese",
            3,
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese()
        );

        createFridge(
            board,
            18, 1,
            floorTwo,
            "2F - Cheese",
            4,
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese(),
            ProductFactory.createCheese()
        );

        createTable(
            board,
            3, 20,
            floorTwo,
            "2F - Bread",
            1,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            4, 20,
            floorTwo,
            "2F - Bread",
            2,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            5, 20,
            floorTwo,
            "2F - Bread",
            3,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            6, 20,
            floorTwo,
            "2F - Bread",
            4,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            7, 20,
            floorTwo,
            "2F - Bread",
            5,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        // -------------------------
        // Eggs – Tables (x 9..12, y = 20)
        // -------------------------

        createTable(
            board,
            9, 20,
            floorTwo,
            "2F - Eggs",
            1,
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs()
        );

        createTable(
            board,
            10, 20,
            floorTwo,
            "2F - Eggs",
            2,
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs()
        );

        createTable(
            board,
            11, 20,
            floorTwo,
            "2F - Eggs",
            3,
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs()
        );

        createTable(
            board,
            12, 20,
            floorTwo,
            "2F - Eggs",
            4,
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs(),
            ProductFactory.createEggs()
        );

        createTable(
            board,
            14, 20,
            floorTwo,
            "2F - Bread",
            6,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            15, 20,
            floorTwo,
            "2F - Bread",
            7,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            16, 20,
            floorTwo,
            "2F - Bread",
            8,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            17, 20,
            floorTwo,
            "2F - Bread",
            9,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        createTable(
            board,
            18, 20,
            floorTwo,
            "2F - Bread",
            10,
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread(),
            ProductFactory.createBread()
        );

        }


    // =======================
    // HELPER METHODS
    // =======================

    // Create a table display at given coordinates with N products
    private static tableDisplay createTable(Board board, int x, int y, int floor,
                                            String grouping, int number,
                                            Product... productsToAdd) {
        displayAddress addr = new displayAddress(
            floor == 1 ? "GF" : "2F",
            grouping,
            number
        );
        tableDisplay t = new tableDisplay(x, y, floor, addr);
        for (Product p : productsToAdd) {
            t.addProduct(p);
        }
        board.addObject(t);
        return t;
    }

    private static shelfDisplay createShelf(Board board, int x, int y, int floor,
                                            String grouping, int number,
                                            Product... productsToAdd) {
        displayAddress addr = new displayAddress(
            floor == 1 ? "GF" : "2F",
            grouping,
            number
        );
        shelfDisplay s = new shelfDisplay(x, y, floor, addr);
        for (Product p : productsToAdd) {
            s.addProduct(p);
        }
        board.addObject(s);
        return s;
    }

    private static fridgeDisplay createFridge(Board board, int x, int y, int floor, //this will be for second floor
                                              String grouping, int number,
                                              Product... productsToAdd) { 
        displayAddress addr = new displayAddress(
            floor == 1 ? "GF" : "2F",
            grouping,
            number
        );
        fridgeDisplay f = new fridgeDisplay(x, y, floor, addr);
        for (Product p : productsToAdd) {
            f.addProduct(p);
        }
        board.addObject(f);
        return f;
    }

    private static chilledDisplay createChilled(Board board, int x, int y, int floor,
                                                String grouping, int number,
                                                Product... productsToAdd) {
        displayAddress addr = new displayAddress(
            floor == 1 ? "GF" : "2F",
            grouping,
            number
        );
        chilledDisplay c = new chilledDisplay(x, y, floor, addr);
        for (Product p : productsToAdd) {
            c.addProduct(p);
        }
        board.addObject(c);
        return c;
    }
}
