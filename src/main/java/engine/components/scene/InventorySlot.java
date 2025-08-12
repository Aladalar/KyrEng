package engine.components.scene;

import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.RED;
import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.DrawCircle;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;
import static com.raylib.Raylib.MeasureText;

import engine.components.screen.ScreenRegion;
import engine.components.templates.SlotLayout;
import engine.core.Main;
import lombok.Data;

@Data
public class InventorySlot {

    String id;
    int i;
    float x,y;
    Object cargo;
    InventoryComponent component;

    public InventorySlot(String id, float x, float y, Object cargo, InventoryComponent component) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.cargo = cargo;
        this.component = component;
        this.i = Integer.parseInt(id.split("_")[1]);
        }

    public void draw(SlotLayout sl){

        if (i < 0 || i >= sl.cx.length) {
            System.out.println("InventorySlot out of range: id=" + id + " i=" + i + " len=" + sl.cx.length);
            return;
        }
        
        DrawRectangle(sl.rx[i], sl.ry[i], sl.rectW, sl.rectH, BLACK);

        if(Main.isDebug){
            // dot centered in its cell
            DrawCircle(sl.cx[i], sl.cy[i], 5f, RED);

            // keep the number readable (don’t center it)
            String label = id.split("_")[1];            // cache this once elsewhere
            int fontSize = 20;
            DrawText(label, sl.cx[i] + 8, sl.cy[i] + 8, fontSize, WHITE); // small offset from dot
        }
    }

    public void onClick(){
        ScreenRegion region = component.getParentRegion();
        System.out.println("Debug:\nParent "+ region.toString()+"\nX: "+ region.getPxx()+"\nY: "+region.getPxy()+"H: "+region.getPxh()+"\nW: "+region.getPxw());
 
    }
}
