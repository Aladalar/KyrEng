
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import engine.DebugUtils;
import engine.screen.Screen;

public class Main {

  public static boolean isDebug = true;
  public static int w = 1280, h = 800;
  public static void main(String[] args){

    InitWindow(w,h,"KyrEngine restoration");
    SetTargetFPS(60);
    /* Variables and pre loading */

    Screen screen = new Screen();


    /* ------------------------- */
    
    while (!WindowShouldClose()) {
      BeginDrawing();
      
      ClearBackground(DARKGRAY);
      screen.renderRegions();

      buttonPressed();


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