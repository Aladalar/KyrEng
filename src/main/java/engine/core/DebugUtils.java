package engine.core;


import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.BROWN;
import static com.raylib.Colors.PINK;
import static com.raylib.Colors.RED;
import static com.raylib.Raylib.DrawCircle;
import static com.raylib.Raylib.DrawLine;
import static com.raylib.Raylib.DrawText;

import java.lang.reflect.Array;
import java.util.Arrays;

import engine.components.screen.ScreenRegion;

public class DebugUtils {

    /**
     * Generate overlaz with points for more accurate placement of graphic segment
     * @param gridSize convert percentage to pixels
     */
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

    public static void DrawCoord(int mouseX, int mouseY, int screenWidth, int screenHeight, ScreenRegion region){
        float percentX = mouseX / (float) screenWidth;
        float percentY = mouseY / (float) screenHeight;
        if(region != null){
            float[] local = region.toLocal(percentX, percentY);
            String label = String.format("(%.2f, %.2f)", local[0], local[1]);
            DrawText(label, (int)(screenWidth*0.03), (int)screenHeight-50, 40, BROWN);
            System.out.println(Arrays.toString(local));
        } else{
            String label = String.format("(%.2f, %.2f)", percentX, percentY);
            DrawText(label, (int)(screenWidth*0.8), (int)screenHeight-50, 40, RED);
        }
    }

    public static void DrawGridInRegion(ScreenRegion region, float gridSize) {
        int x0 = region.getPxx();
        int y0 = region.getPxy();
        int w  = region.getPxw();
        int h  = region.getPxh();

        int stepX = (int)(gridSize * w);
        int stepY = (int)(gridSize * h);

        int centerX = x0 + w / 2;
        int centerY = y0 + h / 2;

        for (int x = centerX + stepX; x < x0 + w; x += stepX)
            DrawLine(x, y0, x, y0 + h, BLACK);
        for (int x = centerX - stepX; x > x0; x -= stepX)
            DrawLine(x, y0, x, y0 + h, BLACK);

        for (int y = centerY + stepY; y < y0 + h; y += stepY)
            DrawLine(x0, y, x0 + w, y, BLACK);
        for (int y = centerY - stepY; y > y0; y -= stepY)
            DrawLine(x0, y, x0 + w, y, BLACK);

        DrawCircle(centerX, centerY, 5f, RED);
        DrawLine(centerX, y0, centerX, y0 + h, RED);
        DrawLine(x0, centerY, x0 + w, centerY, RED);
    }

    public static void DrawCoordInRegion(int mouseX, int mouseY, ScreenRegion region) {
    int x0 = region.getPxx();
    int y0 = region.getPxy();
    int w  = region.getPxw();
    int h  = region.getPxh();

    // kurzor je mimo daný blok → neřeš
    if (mouseX < x0 || mouseX > x0 + w || mouseY < y0 || mouseY > y0 + h)
        return;

    float percentX = (mouseX - x0) / (float) w;
    float percentY = (mouseY - y0) / (float) h;
    String label = String.format("[%s] (%.2f, %.2f)", region.getId(), percentX, percentY);

    DrawText(label, x0 + 5, y0 + h - 20, 18, PINK);
}

    
    
}
