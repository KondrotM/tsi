import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class PaintCalculator {

    // Area-to-paint ratio: 1m squared = 0.1L of paint.
    // https://www.diy.com/ideas-advice/calculators/wall-painting-calculator
    static float ratioPaintArea = 0.1F;

    // Standard UK window size
    // https://www.everest.co.uk/double-glazing-windows/standard-house-window-size/
    static float[] defaultWindowDims = {0.63F, 0.89F};

    // Standard UK door size
    // https://www.vibrantdoors.co.uk/internal-doors/advice/internal-door-sizing
    static float[] defaultDoorDims = {0.63F, 0.89F};

    static int getInputInt(Scanner scan, String inputMessage) {
        /**
        Helper function to get integer input from user
         @param scan System input method
         @param inputMessage Input prompt
         @return Desired integer
         **/
        int var;
        System.out.println(inputMessage);
        while (true) {
            try {
                var = scan.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("Please enter a whole number");
                scan.nextLine();
            }
        }
        return var;
    }

    static float getInputFloat(Scanner scan, String inputMessage) {
        /**
         Helper function to get float input from user
         @param scan System input method
         @param inputMessage Input prompt
         @return Desired float
         **/
        float var;
        System.out.println(inputMessage);
        while (true) {
            try {
                var = scan.nextFloat();
                break;
            } catch (InputMismatchException e){
                System.out.println("Please enter a number in meters.");
                scan.nextLine();
            }
        }
        return var;
    }

    public float calculatePaintVolume() {
        /**
         * A wizard to guide the user to configure the dimensions of each wall.
         * @return The float value of volume of paint needed
         */
        Scanner scan = new Scanner(in);

        int numberOfWalls = getInputInt(scan, "Enter number of walls you'd like to paint");
        ArrayList<Wall> walls = new ArrayList<>(numberOfWalls);

        for (int i = 0; i < numberOfWalls; i++) {

            ArrayList<Door> doors = new ArrayList<>();
            ArrayList<Window> windows = new ArrayList<>();

            System.out.println("--------------------");
            System.out.println("DETAILS OF WALL " + (i+1));
            System.out.println("--------------------");
            float wallWidth = getInputFloat(scan, "Input wall width (m)");
            System.out.println("--------------------");
            float wallHeight = getInputFloat(scan, "Input wall height (m)");
            System.out.println("--------------------");
            System.out.println("EXTRAS FOR WALL " + (i+1));
            System.out.println("--------------------");

            int numberOfWindows = getInputInt(scan, "How many windows does this wall have?");
            if (numberOfWindows > 0) {
                System.out.println("CHOOSE (1,2)");
                ArrayList options = new ArrayList();
                options.add(1); options.add(2);
                System.out.println("1. Use default window size");
                System.out.println("2. Configure");

                int input = getInputInt(scan, "");

                while (!options.contains(input)) {
                    System.out.println("Please enter 1 or 2");
                    input = getInputInt(scan, "");
                }

                if (input == 1) {
                    for (int j = 0; j < numberOfWindows; j++) {
                        Window w = new Window(defaultWindowDims[0], defaultWindowDims[1]);
                        windows.add(w);
                    }
                } else if (input == 2) {
                    for (int j = 0; j < numberOfWindows; j++) {
                        System.out.println("DIMS FOR WINDOW " + (j+1));
                        float w = getInputFloat(scan, "Window width (m)");
                        float h = getInputFloat(scan, "Window height (m)");
                        Window win = new Window(w, h);
                        windows.add(win);
                    }
                }

            }

            int numberOfDoors = getInputInt(scan, "How many doors does this wall have?");
            if (numberOfDoors > 0) {
                System.out.println("CHOOSE (1,2)");
                ArrayList options = new ArrayList();
                options.add(1); options.add(2);
                System.out.println("1. Use default wall size");
                System.out.println("2. Configure");

                int input = getInputInt(scan, "");
                while (!options.contains(input)) {
                    System.out.println("Please enter 1 or 2");
                    input = getInputInt(scan, "");
                }

                if (input == 1) {
                    for (int j = 0; j < numberOfDoors; j++) {
                        Door d = new Door(defaultDoorDims[0], defaultDoorDims[1]);
                        doors.add(d);
                    }
                } else if (input == 2) {
                    for (int j = 0; j < numberOfDoors; j++) {
                        System.out.println("DIMS FOR DOOR " + (j+1));
                        float w = getInputFloat(scan, "Door width (m)");
                        float h = getInputFloat(scan, "Door height (m)");
                        Door d = new Door(w, h);
                        doors.add(d);
                    }
                }
            }

            Wall w = new Wall(wallWidth, wallHeight, windows, doors);
            walls.add(w);
        }

        int coats = getInputInt(scan, "How many coats of paint would you like to apply?");

        float totalWallArea = 0;
        for (Wall w : walls) {
            totalWallArea += w.getArea();
        }

        float paint = totalWallArea * ratioPaintArea * coats;

        return paint;
    }
}
