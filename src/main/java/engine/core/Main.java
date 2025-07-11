package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import game.scene.SimpleScene;

public class Main {

  public static boolean isDebug = true;
  public static void main(String[] args){
     
    InitWindow(800,450,"Jaylib VSCode Demo");
    SetTargetFPS(60);

     // Step 1: Create and load scene
        SimpleScene scene = new SimpleScene();
        scene.load();  // even if it's empty for now
        System.out.println("Working dir: " + System.getProperty("user.dir"));

   
    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(DARKGRAY);
        scene.render();

        DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}