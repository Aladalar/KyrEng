package engine.meta.objects;

import lombok.Data;

@Data
public class MetaEntity {
    
    String id,type;
    int x,y;
    
    public MetaEntity(String id, String type, int x, int y) {
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
    }
}
