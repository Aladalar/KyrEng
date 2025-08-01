package engine.components;

import engine.components.screen.ScreenRegion;

//Discarded concept for now
public class SceneComponent {

    boolean isActive = false;
    ScreenRegion region; 
    

    public void Draw(){

    }

    public void Update(){

    }

    public void toggleActive(){
        isActive = !isActive;
    }
}
