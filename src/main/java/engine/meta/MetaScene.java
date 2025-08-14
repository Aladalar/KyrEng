package engine.meta;

import java.util.List;

import lombok.Data;

@Data
public class MetaScene {
    
    public String id;
    public List<MetaLayer> layers;
    public MetaSpawn spawn;
}
