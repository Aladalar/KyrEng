package engine.components.scene;

import java.util.List;

public class InventoryComponent extends SceneComponent{

    List<InventorySlot> slots;

    

    public InventoryComponent(List<InventorySlot> slots) {
        this.slots = slots;
    }

    

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void onClick(int localX, int localY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onClick'");
    }

    @Override
    public void onHover() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onHover'");
    }
    
}
