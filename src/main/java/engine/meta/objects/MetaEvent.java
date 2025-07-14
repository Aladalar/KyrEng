package engine.meta.objects;

import lombok.Data;

@Data
public class MetaEvent {
    String target;
    int posX,posY,width,height;
    
    public MetaEvent(String target, int posX, int posY, int width, int height) {
        this.target = target;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }  
}
