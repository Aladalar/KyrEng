package engine.screen;

public class ScreenUtils {
    
    /**
     * Convert float into pixels for localiyation
     * @param pos - relative position of placement eg x/y axis
     * @param dimension - which dimension is related to x->width, y->height
     * @return calculated space in px
     */
    public static int convertToInt(float pos, float dimension){
        return (int)(Math.round(pos*dimension));
    }
}
