package engine.interfaces.entity;

public interface iInteractable {
    
    /** Called when mouse is over the object (e.g., to show name or highlight) */
    void onMouseHover();

    /** Called when clicked without inventory item */
    void onInteraction(); 
    
    boolean isInteractible();

    /**
     * Called when player uses another item or object on this
     * @param sourceId ID of item or object being used
     */
    void onCombination(String sourceId);

}
