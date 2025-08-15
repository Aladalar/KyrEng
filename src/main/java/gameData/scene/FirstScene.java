package gameData.scene;

import java.util.Arrays;
import java.util.List;

import engine.components.scene.SceneMetaComponent;
import engine.meta.MetaEntity;
import engine.meta.MetaLayer;
import engine.meta.MetaScene;
import engine.meta.MetaSpawn;
import engine.meta.MetaTransition;
import engine.meta.MetaVFX;

public class FirstScene extends SceneMetaComponent{

    String id;
    
    public MetaScene loadScene(){

        MetaScene scene = new MetaScene("First scene", Arrays.asList(new MetaLayer("background", 0)), new MetaSpawn(.5f,.5f,true));
        id = scene.id;
        return scene;

    };
    public List<MetaEntity> loadEntities(){

        return null;

    };
    public List<MetaVFX> loadVFX(){

        return null;

    };
    public List<MetaTransition> loadTransitions(){

        return null;
        
    };
}
