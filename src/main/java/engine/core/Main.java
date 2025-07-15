package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import engine.enums.Paths;
import engine.meta.AudioMeta;
import engine.meta.SceneMeta;
public class Main {

  public static boolean isDebug = true;
  static SceneMeta sm = new SceneMeta(Paths.SCENE.getRelativePath("test.json"));
  static AudioMeta am = new AudioMeta(Paths.AUDIO.getRelativePath("test.json"));
  public static void main(String[] args){
     
    InitWindow(1280,720,"Jaylib VSCode Demo");
    SetTargetFPS(60);

    /*
     * Load once test
     */
    //System.out.println("Working dir: " + System.getProperty("user.dir"));
    //System.out.println(sm.toString());
    //System.out.println(am.toString());
    System.out.println("lastX: " + (int)(1.0f * GetScreenWidth()));
    System.out.println("lastY: " + (int)(1.0f * GetScreenHeight()));
    
    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(WHITE);
        if(IsKeyPressed(KEY_F1)){
          ToggleFullscreen();
        }
        /*
         *  Update Test
         */
        DebugUtils.DrawGrid(GetScreenWidth(), GetScreenHeight(), 0.03f);
        DebugUtils.DrawCoord(GetMouseX(), GetMouseY(), GetScreenWidth(), GetScreenHeight());
        DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}