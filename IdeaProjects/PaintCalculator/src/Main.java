import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    /*
    A program created to calculate the paint needed to cover the walls in a house.
     */

    /*
    TODO:
    - [ ] Create cost calculator
    - [ ] Organise PaintCalculator into Factory classes
    - [ ] Round paint needed
    - [ ] Create a GUI
     */
    public static void main(String[] args) {
        PaintCalculator p = new PaintCalculator();

        float paint = p.calculatePaintVolume();

        final DecimalFormat df = new DecimalFormat("0.00");
        float roundedPaint = Float.parseFloat(df.format(paint));

        System.out.println("Paint needed: " + roundedPaint + "L of paint.");

    }

}
