package engine.interfaces.entity;

public interface iCollectable {

    /**
     * Whether the item can spoil (e.g. over time, between scenes)
     * Used by inventory or scene manager to handle spoil logic
     * 
     * @return true if the item is spoilable
     */
    boolean isSpoilable();

    /**
     * Called when item is added to inventory.
     * Can trigger visual, sound, or internal flag updates.
     */
    void onCollect();
}
