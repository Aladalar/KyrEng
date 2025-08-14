package engine.components.scene;

import java.util.List;

import com.google.gson.Gson;

import engine.meta.MetaAudio;
import engine.meta.MetaEntity;
import engine.meta.MetaPaths;
import engine.meta.MetaScene;
import engine.meta.MetaTransition;
import engine.meta.MetaVFX;
import lombok.Data;

@Data
public class SceneMetaComponent {

    MetaScene scene;
    List<MetaEntity> entities;
    MetaAudio audio;
    MetaVFX vfx;
    List<MetaTransition> transitions;    

    public SceneMetaComponent(String name){
        load(name);
    }
    
    public SceneMetaComponent load(String sceneName){

        MetaPaths path = new MetaPaths();
        Gson gson = new Gson();


        return null;
    }

    private boolean validateScene(){

        if(scene == null){
            throw new IllegalStateException("Scene meta of "+ scene.toString() +" is not valid or have problems in its structure!");
        }
        if (scene.id == null && scene.id.trim().isEmpty()){
            throw new IllegalStateException("Scene ID in "+scene.toString()+" has mission or incorrect");
        }
        if (scene.layers == null && scene.layers.isEmpty()){
            throw new IllegalStateException("Scene layers in "+scene.toString()+" are  mission or incorrect");
        }
        return true; 
    }

}