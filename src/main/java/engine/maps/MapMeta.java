package engine.maps;

import java.io.FileReader;

import com.google.gson.Gson;

import engine.maps.meta.MapMetaJSON;
import lombok.Getter;

public class MapMeta {

    @Getter
    private final String sceneId;
    @Getter
    private final String mapMetaPath;
    @Getter
    public MapMetaJSON data;

    public MapMeta(String sceneId, String mapMetaPath) {
        this.sceneId = sceneId;
        this.mapMetaPath = mapMetaPath;
        getJson();
    }

    
    
    /**
     * Loading and checking if json is valid
     */
    private void getJson(){
        MapMetaJSON json = null;
        try (FileReader reader = new FileReader(mapMetaPath)) {
            System.out.println("Load test of file " + reader.toString());
            Gson gson = new Gson();
            json = gson.fromJson(reader, MapMetaJSON.class);
        } catch (Exception e) {
            System.err.println("Failed to load MapMeta JSON: " + e.getMessage());
        }
        if(json!=null && isValid(json.getSceneId())){
            data = json;
        }
    }

    public boolean isValid(String metaId){
        if (sceneId.equals(metaId)){
            return true;
        }
        return false;
    }
   
}
