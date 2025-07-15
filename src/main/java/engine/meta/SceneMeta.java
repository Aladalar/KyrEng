package engine.meta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import engine.meta.objects.MetaEntity;
import engine.meta.objects.MetaEvent;
import engine.meta.objects.MetaLayer;

public class SceneMeta {

    String path;
    String id;
    List<MetaLayer> layers;
    List<MetaEvent> transitions;
    List<MetaEvent> triggers;
    List<MetaEntity> entities;
    
    public SceneMeta(String path) {
        _construct(path);
    }

    public SceneMeta(String id, List<MetaLayer> layers, List<MetaEvent> transitions, List<MetaEvent> triggers, List<MetaEntity> entities) {
        this.id = id;
        this.layers = layers;
        this.transitions = transitions;
        this.triggers = triggers;
        this.entities = entities;
    }
    
    private void _construct(String path){
        try(FileReader fr = new FileReader(path)){
            SceneMeta gson = new Gson().fromJson(fr, SceneMeta.class);
            this.id = gson.id;
            this.layers = gson.layers;
            this.transitions = gson. transitions;
            this.triggers = gson.triggers;
            this.entities = gson.entities;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "SceneMeta [path=" + path + ", id=" + id + ", layers=" + layers + ", transitions=" + transitions
                + ", triggers=" + triggers + ", entities=" + entities + "]";
    }

    
    
}
