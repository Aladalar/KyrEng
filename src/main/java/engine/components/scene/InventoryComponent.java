package engine.components.scene;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class InventoryComponent extends SceneComponent{
 
    @Getter
    String id = "InventoryComponent";
    List<InventorySlot> slots = new ArrayList<>();

    public InventoryComponent() {
        addSlots();
        isActive = true;
    }

    private void addSlots(){
        float pos;
        int xF;
        for(int x=0; x<5; x++){
            pos = (float) (0.1f + (.16f * x) + .08);
            xF = x+5;
            slots.add(new InventorySlot("slot_"+x, .3f, pos, null, this));
            slots.add(new InventorySlot("slot_"+xF, .7f, pos, null, this));
            //ystem.out.println("Adding slots: " + x );
        }
    }

    public void draw() {
        //System.out.println("TEST 1");
        for(InventorySlot slot : slots){
            slot.draw();
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void onClick(int localX, int localY) {
       
    }

    @Override
    public void onHover() {
       
    }
    
}
