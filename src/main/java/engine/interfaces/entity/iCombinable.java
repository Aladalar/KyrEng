package engine.interfaces.entity;

public interface iCombinable {

    /**
     * Called when another item is combined with this one in the inventory.
     * For example: mixing potion ingredients, combining key halves.
     *
     * @param itemId ID of the item being combined
     */
    void onCombine(String itemId);

    /**
     * Called when this item is used on a world object (e.g., door, statue, NPC).
     * For example: using a key on a door or berry on potion table.
     *
     * @param objectId ID of the object being used on
     */
    void onUsing(String objectId);

    /**
     * Called when this item is consumed and removed from inventory.
     * For example: drinking a potion, which might return a flask.
     */
    void onConsume();
}
