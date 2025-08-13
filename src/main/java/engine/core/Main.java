package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import engine.components.screen.ScreenRegion;
import engine.managers.ScreenManager;

public class Main {

  public static boolean isDebug = true;
   static ScreenManager scm;
  public static void main(String[] args){
     
    InitWindow(1280,720,"Jaylib VSCode Demo");
    SetTargetFPS(60);
    scm = new ScreenManager();
    /*
     * Load once test
     */
    //System.out.println("Working dir: " + System.getProperty("user.dir"));
    //System.out.println(sm.toString());
    //System.out.println(am.toString());
 
    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(WHITE);
        if(IsKeyPressed(KEY_F1)){
          ToggleFullscreen();
        }
        if(IsKeyPressed(KEY_F2)){
          isDebug = !isDebug;
        }
        /*
         *  Update Test
         */
        
        if(isDebug){
          DebugUtils.DrawGrid(GetScreenWidth(), GetScreenHeight(), 0.01f);
        }
        scm.drawRegions();
        
        for (ScreenRegion region : scm.getRegions()) {
            if (region.contains(GetMouseX(), GetMouseY()) && isDebug) {
                DebugUtils.DrawCoord(GetMouseX(), GetMouseY(), GetScreenWidth(), GetScreenHeight(), region);
            }else {

              if (isDebug) DebugUtils.DrawCoord(GetMouseX(), GetMouseY(), GetScreenWidth(), GetScreenHeight(), null);
            } 
        }
        
        DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}