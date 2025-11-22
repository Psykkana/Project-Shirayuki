
/*
 *  The displayAddress class
 *      To be used for the displayTile to designate its locations
 *      To have an "Address" data type field
 */

public class displayAddress {
    
    private String floor;       // Ground Floor (GF) or Second Floor (2F)
    private String grouping;    // Aisle
    private int number;         // Shelf 1, Shelf 2, Shelf 3

    public displayAddress(String floor, String grouping, int number) {
        this.floor = floor;
        this.grouping = grouping;
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public String getGrouping() {
        return grouping;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return floor + ", " + grouping + ", " + number;
    }

}
