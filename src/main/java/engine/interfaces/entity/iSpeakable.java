package engine.interfaces.entity;

public interface iSpeakable {
    
    /** Used while conversing */
    void onSpeak();

    /** used while commenting and item/object*/
    void onComment();
}
