package engine.managers;

import static com.raylib.Colors.BEIGE;
import static com.raylib.Colors.BLUE;
import static com.raylib.Colors.GREEN;
import static com.raylib.Colors.YELLOW;
import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import engine.components.scene.InventoryComponent;
import engine.components.scene.SceneComponent;
import engine.components.screen.ScreenRegion;
import lombok.Getter;

public class ScreenManager {

    @Getter
    List<ScreenRegion> regions = new ArrayList<>();   

    public ScreenManager() {
        loadRegions();
    }

    public void loadRegions(){
        regions.addAll(Arrays.asList(
        new ScreenRegion("main", 0.02f, 0.02f, 0.96f, 0.68f, BLUE, GetScreenHeight(), GetScreenWidth(), null),
        new ScreenRegion("menu", 0.02f, 0.72f, .23f, .26f, BEIGE, GetScreenHeight(), GetScreenWidth(), null),
        new ScreenRegion("medialon", .75f, .72f, .23f, .26f, GREEN, GetScreenHeight(), GetScreenWidth(), null),
        new ScreenRegion("inventory", .27f, .72f, .46f, .26f, YELLOW, GetScreenHeight(), GetScreenWidth(), new InventoryComponent())
            )
        );
    }

    public ScreenRegion getRegion(String id){
        return regions.stream().filter(region -> region.getId().equals(id)).findFirst().orElse(null);
    }



    public void UpdateComponents(){
        for (ScreenRegion region : regions) {
            SceneComponent c = region.getComponent();
            if (c != null && c.isActive()) {
                c.update();
            }
        }
    }

    public void drawRegions(){
        //System.out.println("Test Screen manager");
        regions.forEach(region -> region.draw());
    }
    
}
