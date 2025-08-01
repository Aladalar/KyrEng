package engine.components.screen;

import com.raylib.Raylib;
import com.raylib.Raylib.Color;

import engine.core.DebugUtils;
import engine.core.Main;
import lombok.Data;

@Data
public class ScreenRegion {
    String id;
    float x,y,width,height;
    Color color;

    private int pxx, pxy, pxw, pxh; 
    
    public ScreenRegion(String id, float x, float y, float width, float height, Color color, int screenHeight,int screenWidth) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        recalculate(screenHeight, screenWidth);
    }

    public void draw(){
        Raylib.DrawRectangle(pxx, pxy, pxw, pxh, color);
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
    
}
