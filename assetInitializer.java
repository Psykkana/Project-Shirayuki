

/*
 *  The Asset Initializer Class
 *      Does things like initialize the map objects to be placed in the board
 * 
 */


public class assetInitializer {
    
    // For readabilities sake
    static final int floorOne = 1; 
    static final int floorTwo = 2;  

    // Objects and displays of the 1st Floor    
    public static void intializeFloorOne(Board board) {

       // Declare the products (this time with the product factory class)
        Product fruit1 = ProductFactory.createFruit(); 
        Product fruit2 = ProductFactory.createFruit();
        Product fruit3 = ProductFactory.createFruit();
        Product fruit4 = ProductFactory.createFruit();


        // Declare addresses for the displays (String floor, String grouping, int number)
        displayAddress table1013 = new displayAddress("GF", "Aisle Test", 1);
        tableDisplay table1013Tile = new tableDisplay(10, 13, floorOne, table1013);
        table1013Tile.addProduct(fruit1);  
        table1013Tile.addProduct(fruit2);
        table1013Tile.addProduct(fruit3); 
        table1013Tile.addProduct(fruit4);                                
        board.addObject(table1013Tile);

        // Stairs
        board.addObject(new stairTile(1, 15, floorOne, floorTwo));
        board.addObject(new stairTile(20, 15, floorOne, floorTwo));

        // The exit door
        board.addObject(new exitTile(10, 21, floorOne));
        // The entrance door
        board.addObject(new entranceTile(11, 21, floorOne));

        // Basket and Cart stations 
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
    }

    // Objects and displays of the 2nd Floor     
    public static void intializeFloorTwo(Board board) {
        
        // Stairs
        // NOTE: This thing plays merry hell on trying to transfer between
        // floors, MAKE SURE THE PLAYER SPAWNS 1 TILE AWAY FROM THE STAIRS WHEN
        // TRANSFERRING FLOORS
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

        // middle walls of the second floor
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

        
    }

}
