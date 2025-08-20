package engine.screen;

import static com.raylib.Colors.RED;
import static com.raylib.Raylib.DrawRectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Screen {
    
    List<ScreenRegion> regions = new ArrayList<>();
    List<ScreenLayer> back = new ArrayList<>();
    List<ScreenLayer> front = new ArrayList<>();
    List<ScreenLayer> entity = new ArrayList<>();

    public Screen(){
        addRegions();
    }

    public void addRegions(){
        regions.addAll(Arrays.asList(
            new ScreenRegion("main", 0.02f, 0.02f, 0.96f, 0.68f, RED),
            new ScreenRegion("menu", 0.02f, 0.72f, 0.23f, 0.26f, RED),
            new ScreenRegion("amulet", 0.75f, 0.72f, 0.23f, 0.26f, RED),
            new ScreenRegion("inv", 0.27f, 0.72f, 0.46f, 0.26f, RED)
        ));
    }

    public void addBackground(){
        back.addAll(Arrays.asList(
            new ScreenLayer("test", getRegion("main"), 0, "/assets/test/Skeleton/sprites/Skeleton Walk.png")
        ));
    }

    public void renderRegions(){
        for(ScreenRegion r : regions){
            DrawRectangle(r.x, r.y, r.w, r.h, r.background);
        }
    }

    public void renderBackground(){
        for(ScreenLayer l : back){

        }
    }

    public ScreenRegion getRegion(String name){
        return regions.stream().filter(region -> region.getId().equals(name)).findFirst().orElse(null);
    }
}
