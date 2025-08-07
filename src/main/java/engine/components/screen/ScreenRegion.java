package engine.components.screen;

import com.raylib.Raylib;
import com.raylib.Raylib.Color;
import engine.core.DebugUtils;
import engine.core.Main;
import engine.components.scene.SceneComponent;
import lombok.Data;

@Data
public class ScreenRegion {
    String id;
    float x,y,width,height;
    Color color;
    SceneComponent component;

    private int pxx, pxy, pxw, pxh; 
    
    public ScreenRegion(String id, float x, float y, float width, float height, Color color, int screenHeight,int screenWidth, SceneComponent component) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        recalculate(screenHeight, screenWidth);
        if(component != null){
            this.component = component;
            component.setParent(this);
        } else {
            this.component = null;
        }
    }

    public void draw(){
        Raylib.DrawRectangle(pxx, pxy, pxw, pxh, color);
        if (component != null && component.isActive()) {
            component.draw();
        }
        if(Main.isDebug){
            DebugUtils.DrawGridInRegion(this, .05f);
        }
    }

    protected void recalculate(int screenHeight,int screenWidth){
        pxx = (int)(x * screenWidth);  
        pxy = (int)(y * screenHeight); 
        pxw = (int)(width * screenWidth);
        pxh = (int)(height * screenHeight);
    }
    
    public boolean contains(int mouseX, int mouseY) {
    return (mouseX >= pxx && mouseX <= pxx + pxw &&
            mouseY >= pxy && mouseY <= pxy + pxh);
    }

    public float[] toLocal(float mx, float my) {
        float localX = (mx - pxx) / (float) pxw;
        float localY = (my - pxy) / (float) pxh;
        return new float[] {localX,localY};
    }

}
