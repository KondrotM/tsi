import java.util.InputMismatchException;
import java.util.Scanner;
public class PaintCalculator {

    // Area-to-paint ratio: 1m squared = 0.1L of paint.
    // https://www.diy.com/ideas-advice/calculators/wall-painting-calculator
    static float ratioPaintArea = 0.1F;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Input wall width (m)");
        float width = scan.nextFloat();

        System.out.println("Input wall height (m)");
        float height = scan.nextFloat();

        int coats;
        System.out.println("How many coats of paint would you like to apply?");
        while (true) {
            if (scan.hasNextInt()) {
                coats = scan.nextInt();
                break;
            } else {
                scan.nextLine();
                System.out.println("Please enter a whole number");
            }
        }

        Wall w = new Wall(width,height);
        float area = w.calculateArea();

        float paint = area * ratioPaintArea * coats;

        System.out.println("Paint needed: " + paint + "L of paint.");
    }
}
