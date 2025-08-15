package engine.meta;

import lombok.Data;

@Data
public class MetaSpawn {
    
    float x,y;
    boolean rotation;
    
    public MetaSpawn(float x, float y, boolean rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    
}
