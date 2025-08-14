package engine.meta;

import java.util.List;

import lombok.Data;

@Data
public class MetaAudio {

    List<MetaTrack> tracks;
    MetaTrack activeBackground;
    MetaTrack activeForeground;    
    
}
