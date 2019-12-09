package ClickerTest;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.graphics.Label;

public class ClickerDemo extends GraphicsApp {

    public static final int CANVAS_WIDTH = 1280;
    public static final int CANVAS_HEIGHT = 720;
    public static final Color BACKGROUND_COLOR = Colors.WHITE;
    public static final int LABEL_WIDTH = 70;
    public static final int LABEL_HEIGHT = 30;
    public static final String DEFAULT_LABEL_TEXT = "Klicks: ";

    private Label label;
    private int counter;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH,CANVAS_HEIGHT);
        counter = 0;
        initLabel();
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        label.draw();
    }

    private void initLabel() {
        label = new Label(CANVAS_WIDTH-LABEL_WIDTH,LABEL_HEIGHT,"",Colors.BLACK);
    }

    private void udpateCounter() {
        counter++;
        String newText = DEFAULT_LABEL_TEXT + counter;
        label.setText(newText);
    }

    /**
     * In dieser - geerbten - Method werden die Mausklicks abgefangen. Jeder Klick auf die Maustaste innerhalb des
     * Anwendungsfensters verursacht ein Ereignis, das von der Laufzeitumgebung registriert und an die GraphicApp weiter
     * gegeben wird. Der Mechanismus dafür ist bereits in der Elternklasse "GraphicsApp" implementiert, von der unserer
     * Anwendungen erben. Wir überschreiben diese Methode, um für unsere Anwendung eine besondere Reaktion auf die
     * Klicks zu definieren.
     */
    @Override
    public void onMousePressed(MousePressedEvent event) {
        // Bei jedem Klick  wird - über diese Methode - der Zähler (counter) inkrementiert und der Text im Label
        // aktualisiert.
        udpateCounter();
    }
}


