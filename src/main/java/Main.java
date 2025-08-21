
import static com.raylib.Colors.DARKGRAY;
import static com.raylib.Colors.DARKGREEN;
import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.BeginDrawing;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.CloseWindow;
import static com.raylib.Raylib.DrawText;
import static com.raylib.Raylib.DrawTexturePro;
import static com.raylib.Raylib.EndDrawing;
import static com.raylib.Raylib.GetCurrentMonitor;
import static com.raylib.Raylib.GetFPS;
import static com.raylib.Raylib.GetMonitorHeight;
import static com.raylib.Raylib.GetMonitorWidth;
import static com.raylib.Raylib.GetMouseX;
import static com.raylib.Raylib.GetMouseY;
import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;
import static com.raylib.Raylib.InitWindow;
import static com.raylib.Raylib.IsKeyPressed;
import static com.raylib.Raylib.IsWindowFullscreen;
import static com.raylib.Raylib.KEY_F1;
import static com.raylib.Raylib.KEY_F2;
import static com.raylib.Raylib.LoadTexture;
import static com.raylib.Raylib.SetTargetFPS;
import static com.raylib.Raylib.SetWindowSize;
import static com.raylib.Raylib.ToggleFullscreen;
import static com.raylib.Raylib.WindowShouldClose;

import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Texture;
import com.raylib.Raylib.Vector2;

import engine.DebugUtils;
import engine.screen.Screen;
import engine.screen.ScreenRegion;

public class Main {

  public static boolean isDebug = false;
  public static int w = 1280, h = 800;

  @SuppressWarnings("resource")
public static void main(String[] args){

    InitWindow(w,h,"KyrEngine restoration");
    SetTargetFPS(60);
    /* Variables and pre loading */

    Screen screen = new Screen();
    Texture t = LoadTexture("assets/test/Skeleton/maps/bottom.png");
    ScreenRegion r = screen.getRegion("main");
    Rectangle rt = new Rectangle().x(0).y(0).width(t.width()).height(t.height());
    Rectangle rec = new Rectangle().x(r.getX()).y(r.getY()).width(r.getW()).height(r.getH());
    Vector2 origin = new Vector2().x(0).y(0);

    /* ------------------------- */
    
    while (!WindowShouldClose()) {
      BeginDrawing();
      
      ClearBackground(DARKGRAY);
      buttonPressed();
      
      DrawTexturePro(t, rt, rec, origin, 0f, WHITE);
      
      
      
      if (isDebug){
          screen.renderRegions();
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