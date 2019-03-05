import java.awt.*;
import java.awt.geom.*;

/**
 * Ein Oval.
 * 
 * @author Tim Holtkoetter
 * @version 1.0
 */

public class Oval {
    private int durchmesser1;
    private int durchmesser2;
    private int positionX;
    private int positionY;
    private String farbe;
    private boolean istSichtbar;
    
    /**
     * Konstruktor, um ein Oval mit standard Werten zu erzeugen.
     */
    public Oval() {
        durchmesser1 = 30;
        durchmesser2 = 40;
        positionX = 20;
        positionY = 60;
        farbe = "blue";
        istSichtbar = false;
    }

    /**
     * Macht das Oval sichtbar.
     */
    public void macheSichtbar() {
        istSichtbar = true;
        zeichne();
    }
    
    /**
     * Macht das Oval unsichtbar.
     */
    public void macheUnsichtbar() {
        entferne();
        istSichtbar = false;
    }
    
    /**
     * Bewege das Oval ein paar Pixel nach rechts.
     */
    public void bewegeRechts() {
        bewegeHorizontal(20);
    }

    /**
     * Bewege das Oval ein paar Pixel nach links.
     */
    public void bewegeLinks() {
        bewegeHorizontal(-20);
    }

    /**
     * Bewege das Oval ein paar Pixel nach oben.
     */
    public void bewegeHoch() {
        bewegeVertikal(-20);
    }

    /**
     * Bewege das Oval ein paar Pixel nach unten.
     */
    public void bewegeRunter() {
        bewegeVertikal(20);
    }

    /**
     * Bewege das Oval eine bestimmte Distanz horizontal.
     */
    public void bewegeHorizontal(int distanz) {
        entferne();
        positionX += distanz;
        zeichne();
    }

    /**
     * Bewege das Oval eine bestimmte Distanz vertikal.
     */
    public void bewegeVertikal(int distanz) {
        entferne();
        positionY += distanz;
        zeichne();
    }

    /**
     * Bewege das Oval eine bestimmte Distanz horizontal (langsam).
     */
    public void bewegeHorizontalLangsam(int distanz) {
        int delta;

        if(distanz < 0) {
            delta = -1;
            distanz = -distanz;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distanz; i++) {
            positionX += delta;
            zeichne();
        }
    }

    /**
     * Bewege das Oval eine bestimmte Distanz vertikal (langsam).
     */
    public void bewegeVertikalLangsam(int distanz) {
        int delta;

        if(distanz < 0) {
            delta = -1;
            distanz = -distanz;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distanz; i++) {
            positionY += delta;
            zeichne();
        }
    }

    /**
     * Aendere die groe?e.
     */
    public void aendereGroesse(int nDurchmesser1, int nDurchmesser2) {
        entferne();
        durchmesser1 = nDurchmesser1;
        durchmesser2 = nDurchmesser2;
        zeichne();
    }

    /**
     * Andere die Farbe. Verfuegbare Farben: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void aendereFarbe(String neueFarbe) {
        farbe = neueFarbe;
        zeichne();
    }

    /**
     * Zeichne das Oval.
     */
    private void zeichne() {
        if(istSichtbar) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, farbe, new Ellipse2D.Double(positionX, positionY, durchmesser1, durchmesser2));
            canvas.wait(10);
        }
    }

    /**
     * Entferne das Oval.
     */
    private void entferne() {
        if(istSichtbar) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
