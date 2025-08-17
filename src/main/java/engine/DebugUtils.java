package engine;

import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.RED;
import static com.raylib.Raylib.DrawCircle;
import static com.raylib.Raylib.DrawLine;
import static com.raylib.Raylib.DrawText;

public class DebugUtils {
    


    public static void DrawGrid(int screenWidth, int screenHeight, float gridSize){

        float centerX = screenWidth / 2;
        float centerY = screenHeight / 2;
        int stepX = (int)(gridSize * screenWidth);
        int stepY = (int)(gridSize * screenHeight);
 
        for (int x = (int) (centerX + stepX); x < screenWidth; x += stepX) {
            DrawLine(x, 0, x, screenHeight, BLACK);
        }
        for (int x = (int) (centerX - stepX); x > 0; x -= stepX) {
            DrawLine(x, 0, x, screenHeight, BLACK);
        }
        for (int y = (int) (centerY + stepY); y < screenHeight; y += stepY) {
            DrawLine(0, y, screenWidth, y, BLACK);
        }
        for (int y = (int) (centerY - stepY); y > 0; y -= stepY) {
            DrawLine(0, y, screenWidth, y, BLACK);
        }
        DrawCircle((int)centerX, (int)centerY, 5f, RED);
        DrawLine((int)centerX, 0, (int)centerX, screenHeight, RED);
        DrawLine(0, (int) centerY, screenWidth, (int)centerY, RED);

        DrawLine((int)centerX/2, 0, (int)centerX/2, screenHeight, RED);
        DrawLine(0, (int) centerY/2, screenWidth, (int)centerY/2, RED);
        
        DrawLine((int) (centerX*1.5f), 0, (int)(centerX*1.5f), screenHeight, RED);
        DrawLine(0, (int) (centerY*1.5), screenWidth, (int)(centerY*1.5), RED);
    }

    public static void DrawCoord(int mouseX, int mouseY, int screenWidth, int screenHeight){
        float percentX = mouseX / (float) screenWidth;
        float percentY = mouseY / (float) screenHeight;
        String label = String.format("(%.2f, %.2f)", percentX, percentY);
        DrawText(label, (int)(screenWidth*0.8), (int)screenHeight-50, 40, RED);
    }

}
