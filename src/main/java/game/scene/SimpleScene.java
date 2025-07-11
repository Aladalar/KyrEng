    package game.scene;

    import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.DrawTexture;
import static com.raylib.Raylib.LoadTexture;

    import java.util.Map;

import com.raylib.Raylib.Texture;

import engine.maps.MapLayer;
import engine.maps.Scene;
import lombok.Getter;;

    public class SimpleScene extends Scene {

        @Getter
        private MapLayer layers;

        public SimpleScene() {
            super("test_scene", "assets/scene/test/test.json");
            
        }


        public void render(){
            for (Map.Entry<Integer, String> l: layers.getLayers().entrySet()) {
                
            Texture t = LoadTexture("assets/scene/test/" + l.getValue());
            DrawTexture(t, 0, 0, WHITE);
            }
        }
    }
