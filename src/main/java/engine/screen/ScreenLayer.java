package engine.screen;

import static com.raylib.Colors.GREEN;
import static com.raylib.Colors.RED;

import com.raylib.Raylib.Texture;

import lombok.Data;

@Data
public class ScreenLayer {
    
    String id;
    ScreenRegion region;
    int z;
    Texture render;
    String path;
    
    public ScreenLayer(String id, ScreenRegion region, int z, String path) {
        this.id = id;
        this.region = region;
        this.z = z;
        loadTexture();
    }

    public ScreenLayer(String id, ScreenRegion region, int z, Texture render) {
        this.id = id;
        this.region = region;
        this.z = z;
        this.render = render;
    }

    public Texture loadTexture(){
        return new Texture(GREEN);
    }
    
}
