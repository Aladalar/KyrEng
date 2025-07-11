package engine.maps;

import java.util.List;

import engine.entity.Entity;
import lombok.Getter;
import lombok.Setter;

abstract public class Scene {

    @Getter @Setter
    String sceneId;
    @Getter @Setter
    MapLayer sceneMap;
    @Getter @Setter
    List<Entity> entityList;
    @Getter @Setter
    MapMeta mapMeta;
    @Getter @Setter
    String mapMetaPath;
    @Getter @Setter
    boolean isActive;
    
    public Scene(String sceneId, String mapMetaPath) {
        this.sceneId = sceneId;
        this.mapMetaPath = mapMetaPath;
        mapMeta = getMeta();
        if(mapMeta == null){
            new Exception(sceneId + " dont have correct mapMetaPath, it have " + mapMetaPath);
        }
    }



    private MapMeta getMeta(){
        return new MapMeta(sceneId, mapMetaPath);
    }

    public void load(){};
    public void unload(){};
    public List<Entity> getEntities(){return null;};
    public void getZSortedLayers(){};
    public List<String> getEntryPoint(){return null;};
    public String getNavMap(){return null;};
    public String getPOIs(){return null;};
    

}