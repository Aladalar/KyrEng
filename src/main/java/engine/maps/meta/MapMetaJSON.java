package engine.maps.meta;

import java.util.Map;

import lombok.Data;

@Data
public class MapMetaJSON {
    private String sceneId;
    private String navmesh;
    private Map<Integer, String> layers;
    /*rivate Map<String, POIData> poi;*/
}
