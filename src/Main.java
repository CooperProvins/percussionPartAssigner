import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // initialize songs
        // Song name = new Song("Song Name");
        Song johnWilliams = new Song("John Williams in Conert");

        // initialize pages
        // Page name = new Page(song, "Page Name");
        Page percussion1 = new Page(johnWilliams, "Percussion 1");
        Page percussion2 = new Page(johnWilliams,"Percussion 2");
        Page timpaniPage = new Page(johnWilliams,"Timpani");
        Page mallets = new Page(johnWilliams,"Mallets");

        // initialize parts
        // Part name = new Part(page, "Part Name");
        Part part1 = new Part(percussion1, "Snare Drum");
        Part part2 = new Part(percussion1, "Bass Drum");
        Part part3 = new Part(percussion1, "Drumkit");
        Part part21 = new Part(percussion2, "Sus. Cym, Bikehorn");
        Part part22 = new Part(percussion2, "Crash Cym, Woodblock");
        Part part23 = new Part(percussion2, "Wind Chimes, Cowbells");
        Part timpaniPart = new Part(timpaniPage, "Timpani");
        Part mallets1 = new Part(mallets, "Chimes, Bells");
        Part mallets2 = new Part(mallets, "Xylo");

        // initialize instruments
        // Instrument name = new Instrument(part, "Instrument Name", rhythm, technique, loudness);
        //      rhythm is how complex the rhythms are
        //      technique is how difficult the instruments is to play
        //      loudness is how exposed the part is
        Instrument snareDrum = new Instrument(part1, "Snare Drum", 7, 4, 8);
        Instrument bassDrum = new Instrument(part2, "Bass Drum", 3, 2, 4);
        Instrument drumkit = new Instrument(part3, "Drumkit", 6, 9, 7);
        Instrument susCym = new Instrument(part21, "Sus. Cym", 2, 2, 3);
        Instrument bikeHorn = new Instrument(part21, "Bikehorn", 3, 1, 7);
        Instrument crashCym = new Instrument(part22, "Crash Cym", 2, 3, 7);
        Instrument woodBlk = new Instrument(part22, "Wood Block", 4, 2, 5);
        Instrument windChimes = new Instrument(part23, "Wind Chimes", 2, 3, 3);
        Instrument cowbell = new Instrument(part23, "Cowbells", 7, 3, 6);
        Instrument timpani = new Instrument(timpaniPart, "Timpani", 6, 9, 5);
        Instrument chimes = new Instrument(mallets1, "Chimes", 1, 3, 5);
        Instrument bells = new Instrument(mallets1, "Bells", 9, 8, 8);
        Instrument xylo = new Instrument(mallets2, "Xylo", 9, 8, 6);
    

        // initialize people
        // Person name = new Person("name", rhythm, technique, loudness);
        //      rhythm is ability to play complex rhythms (snare)
        //      technique is ability to play difficult instruments (mallets, timpani)
        //      loudness is ability and willingness to play exposed parts (piano solo)
        Person jack = new Person("Jack", 10, 10, 10);
        Person piper = new Person("Piper", 7, 7, 5);
        Person cooper = new Person("Cooper", 6, 8, 7);
        Person max = new Person("Max", 6, 8, 7);
        Person aster = new Person("Aster", 6, 8, 7);
        Person steven = new Person("Steven", 6, 8, 7);
        Person natalee = new Person("Natalee", 2, 2, 1);
        Person miles = new Person("Miles", 2, 2, 3);
        Person malakai = new Person("Malakai", 2, 2, 2);
        

        // set standards and parameters
        // fit method is Easy, Best, or Mix
        //      easy fits to make the parts easiest for each participant
        //      best fits to challenge each participant with parts that are close to their ability level
        //      mix is a combination of both, optimizing for both challenge and ease
        // sharpness amplifies the danger of being assigned a part above any of your skill levels
        Person.setFitMethod("Best");
        Person.setSharpness(2);
        
        // print matrix, assign parts
        System.out.println(johnWilliams);
        johnWilliams.printFitMatrix();
        johnWilliams.assignParts();
    }
    /** 
     * takes in a rectangular 2D ArrayList of doubles and converts it to a 2D array of doubles
     * @param list2D
     * @return double[][]
     */
    public static double[][] doubleDoubleArrayListToArray(ArrayList<ArrayList<Double>> list2D){
        if (list2D == null) return null;

        // Initialize the outer array with the number of rows (inner lists)
        double[][] array2D = new double[list2D.size()][];

        for (int i = 0; i < list2D.size(); i++) {
            ArrayList<Double> innerList = list2D.get(i);
            
            // Create a primitive array for the current row
            double[] innerArray = new double[innerList.size()];
            
            for (int j = 0; j < innerList.size(); j++) {
                // Java automatically unboxes Double objects to double primitives
                innerArray[j] = innerList.get(j);
            }
            
            // Assign the primitive row to the 2D array
            array2D[i] = innerArray;
        }

        return array2D;
    }
    /** 
     * Prints a chart to console displaying values in 2d arraylist with row and coloumn names
     * @param matrix
     * @param coloumnNames
     * @param rowNames
     */
    public static void matrixPrint(ArrayList<ArrayList<Double>> matrix, ArrayList<String> coloumnNames, ArrayList<String> rowNames){
        int spacing = 30;

        System.out.print(" ".repeat(spacing));
        for (String coloumnName : coloumnNames){
            System.out.printf("%-" + spacing + "s", coloumnName);
        }
        System.out.println();
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Double> row = matrix.get(i);
            System.out.print(rowNames.get(i)+" ".repeat(spacing-rowNames.get(i).length()));
            for (double coloumnElement : row) {
                System.out.printf("%-" + spacing + ".2f", coloumnElement);
            }
            System.out.println();
        }
    }
}