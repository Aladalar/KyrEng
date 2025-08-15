package engine.meta;

import lombok.Data;

@Data
public class MetaLayer {

    String id;
    int order;
    
    public MetaLayer(String id, int order) {
        this.id = id;
        this.order = order;
    }

    
}
