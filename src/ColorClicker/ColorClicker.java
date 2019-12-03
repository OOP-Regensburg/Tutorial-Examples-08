package ColorClicker;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

public class ColorClicker extends GraphicsApp {

    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 800;
    public static final Color BACKGROUND_COLOR = Colors.WHITE;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH,CANVAS_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
    }
}


