package engine.components.scene;

import java.util.ArrayList;
import java.util.List;

import engine.components.templates.SlotLayout;
import lombok.Getter;

public class InventoryComponent extends SceneComponent{
 
    @Getter
    String id = "InventoryComponent";
    List<InventorySlot> slots = new ArrayList<>();
    SlotLayout layout = new SlotLayout();

    public InventoryComponent() {
        isActive = true;
    }

    private void addSlots(){
        int cols = 6, rows = 2;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int i = row * cols + col;                   
                float nx = (col + 0.5f) / cols;            
                float ny = (row + 0.5f) / rows;
                slots.add(new InventorySlot("slot_" + i, nx, ny, null, this));
            }
        }
    }

    public void init() {
        addSlots();
        layout.update(this.getParentRegion());
    }
    
    public void draw() {
        for(InventorySlot slot : slots){
            slot.draw(layout);
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
