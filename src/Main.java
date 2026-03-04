import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // initialize songs
        // Song name = new Song("Song Name");
        Song vesuvius = new Song("Vesuvius");

        // initialize pages
        // Page name = new Page(song, "Page Name");
        Page percussion1 = new Page(vesuvius, "Percussion 1");
        Page percussion2 = new Page(vesuvius,"Percussion 2");
        Page timpaniPage = new Page(vesuvius,"Timpani");
        Page mallets = new Page(vesuvius,"Mallets");

        // initialize parts
        // Part name = new Part(page, "Part Name");
        Part part1 = new Part(percussion1, "Wind Chimes 1 [P1]");
        Part part2 = new Part(percussion1, "Wind Chimes 2 [P2]");
        Part part3 = new Part(percussion2, "Wind Chimes Triangle [P3]");
        Part timpaniPart = new Part(timpaniPage, "Timpani");
        Part malletsPart = new Part(mallets, "Mallets Part");

        // initialize instruments
        // Instrument name = new Instrument(part, "Instrument Name", rhythm, technique, loudness);
        //      rhythm is how complex the rhythms are
        //      technique is how difficult the instruments is to play
        //      loudness is how exposed the part is
        Instrument windChimes1 = new Instrument(part1,"Wind Chimes 1",4,2,3);
        Instrument windChimes2 = new Instrument(part2, "Wind Chimes 2",8,2,10);
        Instrument windChimes3 = new Instrument(part3, "Wind Chimes 3",9,2,1);
        Instrument triangle = new Instrument(part3, "Triangle",8,8,10);
        Instrument timpani = new Instrument(timpaniPart, "Timpani",2,5,2);
        Instrument marimba = new Instrument(malletsPart, "Marimba",3,8,5);
        Instrument glockenspiel = new Instrument(malletsPart, "Glockenspiel", 4,6,7);

        // initialize people
        // Person name = new Person("name", rhythm, technique, loudness);
        //      rhythm is ability to play complex rhythms (snare)
        //      technique is ability to play difficult instruments (mallets, timpani)
        //      loudness is ability and willingness to play exposed parts (piano solo)
        Person jack = new Person("Jack", 10, 10, 7);
        Person piper = new Person("Piper", 6, 8, 5);
        Person cooper = new Person("Cooper", 7, 7, 7);
        Person max = new Person("Max", 5, 8, 6);
        //Person aster = new Person("Aster", 4, 2, 3);
        //Person steven = new Person("Steven", 6, 8, 4);
        Person natalee = new Person("Natalee", 2, 2, 1);
        Person miles = new Person("Miles", 8, 4, 4);
        Person malakai = new Person("Malakai", 8, 4, 6);
        

        // set standards and parameters
        // fit method is Easy, Best, or Mix
        //      easy fits to make the parts easiest for each participant
        //      best fits to challenge each participant with parts that are close to their ability level
        //      mix is a combination of both, optimizing for both challenge and ease
        // sharpness amplifies the danger of being assigned a part above any of your skill levels
        Person.setFitMethod("Best");
        Person.setSharpness(1.3);
        
        // print matrix, assign parts
        Person.printAll();
        vesuvius.print();
        vesuvius.printFitMatrix();
        vesuvius.assignParts();
    }
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