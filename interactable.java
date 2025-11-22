/*
 *  The interactable interface
 *      For the tiles that use E to be interacted with
 *      NOT MEANT FOR TILES THAT ARE INTERACTED WITH ON STEP
 * 
 */

public interface interactable {
    void onInteract(Player player, Board board);
}
