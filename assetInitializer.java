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

        // GROUND FLOOR AISLES

        // Aisle 1 – Canned Goods ONLY (Shelf)

        // Row 4
        createShelf(
            board,
            18, 4,
            floorOne,
            "Aisle 1",
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
            "Aisle 1",
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
            "Aisle 1",
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
            "Aisle 1",
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
            "Aisle 1",
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
            "Aisle 1",
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
            "Aisle 1",
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
            "Aisle 1",
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

          // Aisle 2 – Cereal

        // Row 4
        createShelf(
            board,
            14, 4,
            floorOne,
            "Aisle 2",
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
            "Aisle 2",
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
            "Aisle 2",
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
            "Aisle 2",
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
            "Aisle 2",
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
            "Aisle 2",
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
            "Aisle 2",
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
            "Aisle 2",
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
        // Aisle 3 – Fruits Section 

        createTable(
            board,
            10, 4,
            floorOne,
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 3",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 4",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 5",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 6",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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

        // Aisle 7 – Juice (Shelf)
        // x1 = 6, x2 = 7, y = 10..13

        // Row 10
        createShelf(
            board,
            6, 10,
            floorOne,
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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

        // Aisle 7 – Juice (Shelf)

        // Row 10
        createShelf(
            board,
            6, 10,
            floorOne,
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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
            "Aisle 7",
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

        // Aisle 8 – Fruits (Tables)

        // Row 10
        createTable(
            board,
            10, 10,
            floorOne,
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 8",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 9",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Aisle 10 – Snacks",
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
            "Chillers – Chicken",
            1,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            2, 1,
            floorOne,
            "Chillers – Chicken",
            2,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            3, 1,
            floorOne,
            "Chillers – Chicken",
            3,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            4, 1,
            floorOne,
            "Chillers – Chicken",
            4,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            5, 1,
            floorOne,
            "Chillers – Chicken",
            5,
            ProductFactory.createChicken(),
            ProductFactory.createChicken(),
            ProductFactory.createChicken()
        );

        createChilled(
            board,
            6, 1,
            floorOne,
            "Chillers – Chicken",
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
            "Chillers – Beef",
            1,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            9, 1,
            floorOne,
            "Chillers – Beef",
            2,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            10, 1,
            floorOne,
            "Chillers – Beef",
            3,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            11, 1,
            floorOne,
            "Chillers – Beef",
            4,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            12, 1,
            floorOne,
            "Chillers – Beef",
            5,
            ProductFactory.createBeef(),
            ProductFactory.createBeef(),
            ProductFactory.createBeef()
        );

        createChilled(
            board,
            13, 1,
            floorOne,
            "Chillers – Beef",
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
            "Chillers – Seafood",
            1,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            16, 1,
            floorOne,
            "Chillers – Seafood",
            2,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            17, 1,
            floorOne,
            "Chillers – Seafood",
            3,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            18, 1,
            floorOne,
            "Chillers – Seafood",
            4,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            19, 1,
            floorOne,
            "Chillers – Seafood",
            5,
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood(),
            ProductFactory.createSeafood()
        );

        createChilled(
            board,
            20, 1,
            floorOne,
            "Chillers – Seafood",
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

        // =======================
        // SECOND FLOOR DISPLAYS
        // =======================
        // TODO: Replace these placeholders with real 2F aisles from the spec

        createShelf(
            board,
            5, 5,
            floorTwo,
            "2F – Clothes & Stationery",
            1,
            ProductFactory.createClothes(),
            ProductFactory.createClothes(),
            ProductFactory.createStationery(),
            ProductFactory.createStationery(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createHairCare(),
            ProductFactory.createBodyCare()
        );

        createShelf(
            board,
            7, 5,
            floorTwo,
            "2F – Pet & Cleaning",
            2,
            ProductFactory.createPetFood(),
            ProductFactory.createPetFood(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createCleaningAgent(),
            ProductFactory.createBodyCare(),
            ProductFactory.createDentalCare(),
            ProductFactory.createHomeEssential(),
            ProductFactory.createStationery()
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
