package engine.screen;

import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

import com.raylib.Raylib.Color;

import lombok.Data;

@Data
public class ScreenRegion {

    String id;
    int x,y,w,h;
    Color background;

    public ScreenRegion(String id, float x, float y, float w, float h, Color background) {
        this.id = id;
        this.x = ScreenUtils.convertToInt(x, GetScreenWidth());
        this.y = ScreenUtils.convertToInt(y, GetScreenHeight());
        this.w = ScreenUtils.convertToInt(w, GetScreenWidth());
        this.h = ScreenUtils.convertToInt(h, GetScreenHeight());
        this.background = background;
    }

    
}
