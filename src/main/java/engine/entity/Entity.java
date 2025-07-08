package engine.entity;

import com.raylib.Raylib.Vector2;

import lombok.Getter;
import lombok.Setter;

public abstract class Entity {
    @Getter @Setter
    protected String id;
    @Getter @Setter
    protected Vector2 pos;
    @Getter @Setter
    protected int zdepth;
    @Getter @Setter
    protected boolean isVisible = true;
    @Getter @Setter
    protected boolean isActive =  true;

    public Entity(String id, Vector2 pos, int zdepth, boolean isVisible, boolean isActive) {
        this.id = id;
        this.pos = pos;
        this.zdepth = zdepth;
        this.isVisible = isVisible;
        this.isActive = isActive;
    }

    public Entity(String id, Vector2 pos, boolean isVisible, boolean isActive) {
        this.id = id;
        this.pos = pos;
        this.isVisible = isVisible;
        this.isActive = isActive;
    }

    public Entity(String id, Vector2 pos) {
        this.id = id;
        this.pos = pos;
    }

    abstract void update(float deltaTime);
    abstract void render();
    

}
