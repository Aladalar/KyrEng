package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import engine.enums.Paths;
import engine.meta.SceneMeta;
public class Main {

  public static boolean isDebug = true;
  static SceneMeta sm = new SceneMeta(Paths.SCENE.getRelativePath("test.json"));
  public static void main(String[] args){
     
    InitWindow(800,450,"Jaylib VSCode Demo");
    SetTargetFPS(60);

    /*
     * Load once test
     */
    System.out.println("Working dir: " + System.getProperty("user.dir"));
    System.out.println(sm.toString());
    
    
    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(DARKGRAY);
        /*
         *  Update Test
         */
        DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}