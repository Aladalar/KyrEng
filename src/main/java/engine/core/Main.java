package engine.core;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import engine.components.screen.ScreenRegion;
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
    ScreenRegion game = new ScreenRegion("main", 0.02f, 0.02f, 0.96f, 0.68f, BLUE, GetScreenHeight(), GetScreenWidth());
    ScreenRegion menu = new ScreenRegion("menu", 0.02f, 0.72f, .23f, .26f, BEIGE, GetScreenHeight(), GetScreenWidth());
    ScreenRegion medailon = new ScreenRegion("medialon", .75f, .72f, .23f, .26f, GREEN, GetScreenHeight(), GetScreenWidth());
    ScreenRegion inventory = new ScreenRegion("inventory", .27f, .72f, .46f, .26f, YELLOW, GetScreenHeight(), GetScreenWidth());
    while (!WindowShouldClose()) {
      BeginDrawing();
        ClearBackground(WHITE);
        if(IsKeyPressed(KEY_F1)){
          ToggleFullscreen();
        }
        /*
         *  Update Test
         */
        DebugUtils.DrawGrid(GetScreenWidth(), GetScreenHeight(), 0.01f);
        game.draw();
        menu.draw();
        medailon.draw();
        inventory.draw();
        DebugUtils.DrawCoord(GetMouseX(), GetMouseY(), GetScreenWidth(), GetScreenHeight());
        
        DrawText("FPS: " + GetFPS(), 10, 10, 20, DARKGREEN);
      EndDrawing();
    }
    CloseWindow();
  }
}