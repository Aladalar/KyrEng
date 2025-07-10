package engine.maps;

import java.util.List;
import java.util.Map;

import com.raylib.Raylib.Texture;

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
    
    public Scene(String sceneId, MapLayer sceneMap, List<Entity> entityList, MapMeta mapMeta,
            String mapMetaPath, boolean isActive) {
        this.sceneId = sceneId;
        this.sceneMap = sceneMap;
        this.entityList = entityList;
        this.mapMeta = mapMeta;
        this.mapMetaPath = mapMetaPath;
        this.isActive = isActive;
    }

    public abstract void load();
    public abstract void unload();
    public abstract List<Entity> getEntities();
    public abstract void getZSortedLayers();
    public abstract List<String> getEntryPoint();
    public abstract String getNavMap();
    public abstract String getPOIs();
    

}