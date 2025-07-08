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
        DrawCircle(400, 300, 50, RED);
        DrawRectangle(100, 100, 120, 60, BLUE);
        if (IsKeyPressed(KEY_SPACE)) {
          System.out.println("Spacebar pressed!");
          DrawText("Running in VSCode!",190,200,20, RED);
        }
          DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}