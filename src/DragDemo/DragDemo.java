package DragDemo;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.MouseDraggedEvent;
import de.ur.mi.oop.events.MouseMovedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.events.MouseReleasedEvent;

public class DragDemo extends GraphicsApp {

    public static final int CANVAS_WIDTH = 1280;
    public static final int CANVAS_HEIGHT = 720;
    public static final Color BACKGROUND_COLOR = Colors.WHITE;
    private static final int CIRCLE_WIDTH = 50;
    private static final Color CIRCLE_COLOR = Colors.RED;

    private DraggableCircle circle;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        // Hier wird der Kreis initialisiert, der über das Abfangen der verschiedenen Maus-Events gesteuert wird.
        circle = new DraggableCircle(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, CIRCLE_WIDTH, CIRCLE_COLOR);
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        circle.draw();
    }

    // Wenn die Maustaste herunter gedrückt wird, wird versucht, den Drag-Modus der Kreises zu aktivieren
    @Override
    public void onMousePressed(MousePressedEvent event) {
        // Falls der Mausklick bzw. dessen Koordinanten im Kreis lagen, wird der Drag-Modus aktiviert
        if(circle.isClicked(event.getXPos(), event.getYPos())) {
            circle.startDragging();
        }
    }

    // Wenn die Maustaste losgelassen wird, wird der Drag-Modus des Kreises deaktiviert
    @Override
    public void onMouseReleased(MouseReleasedEvent event) {
        circle.stopDragging();
    }

    // Wenn die Maus bei gedrückter Taste bewegt wird, wird die Mausposition zur Aktualisierung des Kreises verwendet
    @Override
    public void onMouseDragged(MouseDraggedEvent event) {
        // Die aktuellen Mauskoordinaten werden an den Kreis weitergeben - in Abhängigkeit von dessen Status (isDragged)
        // wird dessen Position entweder aktualisiert oder bleibt gleich.
        circle.updatePosition(event.getXPos(), event.getYPos());
    }
}
