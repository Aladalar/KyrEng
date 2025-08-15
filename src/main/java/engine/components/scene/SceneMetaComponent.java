package engine.components.scene;

import java.util.Collections;
import java.util.List;

import engine.meta.MetaEntity;
import engine.meta.MetaScene;
import engine.meta.MetaTransition;
import engine.meta.MetaVFX;
import lombok.Data;

@Data
public abstract class SceneMetaComponent {

    String id;
    MetaScene scene;
    List<MetaEntity> entities;
    List<MetaVFX> vfx;
    List<MetaTransition> transitions;    

    public final void loadAll(){
        this.id = (id != null && !id.isEmpty()) ? id : "Unnamed scene";

        this.scene = loadScene();
        if (this.scene == null) {
         throw new IllegalStateException("loadScene() returned null");
        }

        List<MetaEntity> ents = loadEntities();
        this.entities = (ents != null) ? ents : Collections.emptyList();

        List<MetaVFX> vfxList = loadVFX();
        this.vfx = (vfxList != null) ? vfxList : Collections.emptyList();

        List<MetaTransition> transList = loadTransitions();
        this.transitions = (transList != null) ? transList : Collections.emptyList();

    }

    public abstract MetaScene loadScene();
    public abstract List<MetaEntity> loadEntities();
    public abstract List<MetaVFX> loadVFX();
    public abstract List<MetaTransition> loadTransitions();
}
