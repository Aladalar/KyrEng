package engine.meta;

import lombok.Data;

@Data
public class MetaTrack {
    
    String id, path;
    float volume, pitch;
    boolean isLoop;

}
