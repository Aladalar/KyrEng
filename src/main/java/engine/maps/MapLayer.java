package engine.maps;

import java.util.Map;

import lombok.Getter;

public class MapLayer {

    /** Id of map */
    @Getter
    public int id;
    /** Name of map */
    @Getter
    public String name;
    /**
     * Map containing layers
     * Integer - z-depth value
     * String name of map in /assets/scene/map-name/layer-name.png
     */
    @Getter
    public Map<Integer, String> layers;
    
    public MapLayer(int id, String name, Map<Integer, String> layers) {
        this.id = id;
        this.name = name;
        this.layers = layers;
    }

    
    
}
