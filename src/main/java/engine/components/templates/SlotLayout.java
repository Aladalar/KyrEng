package engine.components.templates;

import engine.components.screen.ScreenRegion;

public class SlotLayout {
    // grid + params (tweak anytime, then call update)
    int cols = 6, rows = 2;
    float margin = 0.10f;   // 10% gutters
    float packX  = 0.75f;   // 1.0=no pack, <1 squeezes horizontally
    float rectFillX = 0.60f; // rectangle width relative to cell
    float rectFillY = 0.90f; // rectangle height relative to cell

    // cached from region
    int originX, originY, innerW, innerH, cellW, cellH;
    public int rectW, rectH;

    // per-slot centers and rect positions (12 slots)
    public int[] cx = new int[12], cy = new int[12];
    public int[] rx = new int[12];
    public int[] ry = new int[12];

    // call whenever region or params change
    public void update(ScreenRegion r) {
        int rw = r.getPxw(), rh = r.getPxh();

        innerW = (int)(rw * (1f - 2f * margin));
        innerH = (int)(rh * (1f - 2f * margin));
        originX = r.getPxx() + (int)(rw * margin);
        originY = r.getPxy() + (int)(rh * margin);

        cellW = innerW / cols;
        cellH = innerH / rows;

        rectW = (int)(cellW * rectFillX);
        rectH = (int)(cellH * rectFillY);
        if ((rectW & 1) != 0) rectW++;
        if ((rectH & 1) != 0) rectH++;

        int innerCenterX = originX + innerW / 2;

        int k = 0;
        for (int row = 0; row < rows; row++) {
            int cyBase = originY + row * cellH + cellH / 2;
            for (int col = 0; col < cols; col++, k++) {
                int cxBase = originX + col * cellW + cellW / 2;
                int packedCX = innerCenterX + (int)((cxBase - innerCenterX) * packX);

                cx[k] = packedCX;
                cy[k] = cyBase;

                rx[k] = packedCX - rectW / 2;
                ry[k] = cyBase   - rectH / 2;
            }
        }
    }
}