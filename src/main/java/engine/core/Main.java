package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import java.util.Map;

import game.scene.SimpleScene;

public class Main {

  public static boolean isDebug = true;
  public static void main(String[] args){
     
    InitWindow(800,450,"Jaylib VSCode Demo");
    SetTargetFPS(60);

     // Step 1: Create and load scene
        SimpleScene scene = new SimpleScene();
        scene.load();  // even if it's empty for now

   
    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(DARKGRAY);
        DrawCircle(400, 300, 50, RED);
        DrawRectangle(100, 100, 120, 60, BLUE);
        if (IsKeyPressed(KEY_SPACE)) {
          System.out.println("Spacebar pressed!");
          DrawText("Running in VSCode!",190,200,20, RED);
        }
         // Step 2: Draw map layers
            if (scene != null && scene.getSceneMap() != null) {
                Map<Integer, String> layers = scene.getSceneMap().getLayers();
                layers.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey()) // sort by z-depth
                    .forEach(entry -> {
                        String path = "assets/scene/test/" + entry.getValue();
                        if (FileExists(path)) {
                            Texture tex = LoadTexture(path);
                            DrawTexture(tex, 0, 0, WHITE);
                            if (isDebug) {
                                DrawText("Layer " + entry.getKey(), 10, entry.getKey() * 15, 10, YELLOW);
                            }
                        }
                    });
            }
          DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}