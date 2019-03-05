import java.awt.*;
import java.awt.geom.*;

/**
 * Ein Rechteck.
 * 
 * @author Tim Holtkoetter
 * @version 1.0
 */

public class Rechteck {
    private int breite;
    private int hoehe;
    private int positionX;
    private int positionY;
    private String farbe;
    private boolean istSichtbar;
    
    /**
     * Konstruktor, um ein Rechteck mit standard Werten zu erzeugen.
     */
    public Rechteck() {
        breite = 30;
        hoehe = 40;
        positionX = 20;
        positionY = 60;
        farbe = "blue";
        istSichtbar = false;
    }

    /**
     * Macht das Rechteck sichtbar.
     */
    public void macheSichtbar() {
        istSichtbar = true;
        zeichne();
    }
    
    /**
     * Macht das Rechteck unsichtbar.
     */
    public void macheUnsichtbar() {
        entferne();
        istSichtbar = false;
    }
    
    /**
     * Bewege das Rechteck ein paar Pixel nach rechts.
     */
    public void bewegeRechts() {
        bewegeHorizontal(20);
    }

    /**
     * Bewege das Rechteck ein paar Pixel nach links.
     */
    public void bewegeLinks() {
        bewegeHorizontal(-20);
    }

    /**
     * Bewege das Rechteck ein paar Pixel nach oben.
     */
    public void bewegeHoch() {
        bewegeVertikal(-20);
    }

    /**
     * Bewege das Rechteck ein paar Pixel nach unten.
     */
    public void bewegeRunter() {
        bewegeVertikal(20);
    }

    /**
     * Bewege das Rechteck eine bestimmte Distanz horizontal.
     */
    public void bewegeHorizontal(int distanz) {
        entferne();
        positionX += distanz;
        zeichne();
    }

    /**
     * Bewege das Rechteck eine bestimmte Distanz vertikal.
     */
    public void bewegeVertikal(int distanz) {
        entferne();
        positionY += distanz;
        zeichne();
    }

    /**
     * Bewege das Rechteck eine bestimmte Distanz horizontal (langsam).
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
     * Bewege das Rechteck eine bestimmte Distanz vertikal (langsam).
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
    public void aendereGroesse(int nBreite, int nHoehe) {
        entferne();
        breite = nBreite;
        hoehe = nHoehe;
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
     * Zeichne das Rechteck.
     */
    private void zeichne() {
        if(istSichtbar) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, farbe, new Rectangle(positionX, positionY, breite, hoehe));
            canvas.wait(10);
        }
    }

    /**
     * Entferne das Rechteck.
     */
    private void entferne() {
        if(istSichtbar) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
