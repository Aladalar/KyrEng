package engine.components.scene;

import engine.components.screen.ScreenRegion;
import lombok.Data;

@Data
abstract public class SceneComponent {

    String id;
    boolean isActive = false;
    ScreenRegion parentRegion;    

    public abstract void draw();
    public abstract void update();
    public abstract void onClick(int localX, int localY);
    public abstract void onHover();
    public void toggleActive(){
        isActive = !isActive;
    }

    public void setParent(ScreenRegion region) {
        this.parentRegion = region;
    }
    @Override
    public String toString() {
        return "SceneComponent [id=" + id + ", isActive=" + isActive + "]";
    }

    
}
