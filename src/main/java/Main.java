
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import engine.DebugUtils;

public class Main {

  public static boolean isDebug = true;
  public static int w = 1024, h = 640;
  public static void main(String[] args){

    InitWindow(w,h,"KyrEngine restoration");
    SetTargetFPS(60);

    while (!WindowShouldClose()) {
      BeginDrawing();
      buttonPressed();

        ClearBackground(DARKGRAY);

        if (isDebug){
          DebugUtils.DrawGrid(GetScreenWidth(), GetScreenHeight(), .01f);
          DebugUtils.DrawCoord(GetMouseX(), GetMouseY(), GetScreenWidth(), GetScreenHeight());
          DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
        }
      EndDrawing();
    }
    CloseWindow();
  }

  static void buttonPressed(){
    if (IsKeyPressed(KEY_F1)){
      ToggleFullscreen();
      if (IsWindowFullscreen()) {
        int m = GetCurrentMonitor();
        SetWindowSize(GetMonitorWidth(m), GetMonitorHeight(m)); // fill monitor
      }else {
        SetWindowSize(w, h);
      }
    }
    if (IsKeyPressed(KEY_F2)){
      isDebug = !isDebug;
    }
  }
}