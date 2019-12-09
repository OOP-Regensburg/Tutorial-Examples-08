package DragDemo;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;

/**
 * Diese Klasse repräsentiert einen Kreis, der mit Hilfe von Mauseingaben über den Bildschirm gezogen werden kann.
 */

public class DraggableCircle {

    // Zum Zeichnen des Kreises besitz die Klasse eine entsprechende Instanzvariable
    private Circle circle;
    // In dieser Variable (true oder false) wird gespeichert, ob der Kreis aktuell von der Maus
    // ge-draggt wird (true) oder nicht (false).
    private boolean isDragged;

    public DraggableCircle(int xPos, int yPos, int width, Color color) {
        circle = new Circle(xPos, yPos, width, color);
        // Der Drag-Status wird inital gesetzt
        isDragged = false;
    }

    // Diese Methode prüft, ob die gegebenen Koordinaten innerhalb des Kreises liegen und gibt das Ergebnis
    // als boolean-Wert zurück.
    public boolean isClicked(int xPos, int yPos) {
        return circle.hitTest(xPos,yPos);
    }

    // Diese Methode aktiviert den Drag-Zustand: Positionsveränderungen werden akzeptiert
    public void startDragging() {
        isDragged = true;
    }

    // Diese Methode deaktiviert den Drag-Zustand: Positionsveränderungen werden nicht akzeptiert
    public void stopDragging() {
        isDragged = false;
    }

    // Diese Methode aktualisiert die Position den Kreises, falls der Drag-Zustand aktiviert wurde
    public void updatePosition(int newX, int newY) {
        if(isDragged == true) {
            circle.setPosition(newX, newY);
        }
    }

    // Zeichnen den Kreis an seiner aktuellen Position
    public void draw() {
        circle.draw();
    }

}
