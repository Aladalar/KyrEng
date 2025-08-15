package engine.meta;

import java.util.List;

import lombok.Data;

@Data
public class MetaScene {
    
    public String id;
    public List<MetaLayer> layers;
    public MetaSpawn spawn;
    
    public MetaScene(String id, List<MetaLayer> layers, MetaSpawn spawn) {
        this.id = id;
        this.layers = layers;
        this.spawn = spawn;
    }

    
}
