package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {

  public static boolean isDebug = true;
  public static void main(String[] args){
     
    InitWindow(800,450,"Jaylib VSCode Demo");
    SetTargetFPS(60);

    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(DARKGRAY);

        DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}