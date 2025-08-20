package engine.screen;

import static com.raylib.Raylib.LoadTexture;

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
        loadTexture(path);
    }

    public ScreenLayer(String id, ScreenRegion region, int z, Texture render) {
        this.id = id;
        this.region = region;
        this.z = z;
        this.render = render;
    }

    public Texture loadTexture(String path){
        return LoadTexture(path);
    }
    
}
