package engine.components.scene;

import engine.components.screen.ScreenRegion;
import lombok.Data;

@Data
abstract public class SceneComponent {

    boolean isActive = false;
    ScreenRegion parent;    

    public abstract void draw();
    public abstract void update();
    public abstract void onClick(int localX, int localY);
    public abstract void onHover();
    public void toggleActive(){
        isActive = !isActive;
    }

    public void setParent(ScreenRegion region) {
        this.parent = region;
    }
}
