package engine.components.scene;

import static com.raylib.Colors.GRAY;
import static com.raylib.Colors.PURPLE;
import static com.raylib.Colors.RED;
import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.DrawCircle;
import static com.raylib.Raylib.DrawText;

import lombok.Data;

@Data
public class InventorySlot {

    String id;
    float x,y;
    Object cargo;
    SceneComponent component;

    public InventorySlot(String id, float x, float y, Object cargo, SceneComponent component) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.cargo = cargo;
        this.component = component;
    }

    public void draw(){
        //System.out.println("Drawing slot:" + id);
        int pixelX = (int)(component.getParentRegion().getPxx()) + component.getParentRegion().getPxx();
        int pixelY = (int)(component.getParentRegion().getPxy()) + component.getParentRegion().getPxy();
        DrawText(id.split("_")[1], pixelY, pixelX, 20, WHITE);
        DrawCircle(pixelY, pixelX, 5f, RED);
    }

    public void onClick(){

    }
}
