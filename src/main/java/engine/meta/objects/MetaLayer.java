package engine.meta.objects;

import lombok.Data;
import lombok.NonNull;

@Data
public class MetaLayer {

    String name;
    int z;
    String file;
    
    public MetaLayer(String name, int z, @NonNull String file) {
        this.name = name;
        this.z = z;
        this.file = file;
    }
    
}
