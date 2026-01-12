import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // initialize songs
        Song vesuvius = new Song("Vesuvius");

        // initialize pages
        Page percussion1 = new Page(vesuvius, "Percussion 1");
        Page percussion2 = new Page(vesuvius,"Percussion 2");
        Page timpaniPage = new Page(vesuvius,"Timpani");
        Page mallets = new Page(vesuvius,"Mallets");

        // initialize parts
        Part part1 = new Part(percussion1, "Wind Chimes 1");
        Part part2 = new Part(percussion1, "Wind Chimes 2");
        Part part3 = new Part(percussion2, "Wind Chimes Triangle");
        Part timpaniPart = new Part(timpaniPage, "Timpani");
        Part malletsPart = new Part(mallets, "Mallets Part");

        // initialize instruments
        Instrument windChimes1 = new Instrument(part1,"Wind Chimes 1",4,2,3);
        Instrument windChimes2 = new Instrument(part2, "Wind Chimes 2",8,2,10);
        Instrument windChimes3 = new Instrument(part3, "Wind Chimes 3",9,2,1);
        Instrument triangle = new Instrument(part3, "Triangle",8,8,10);
        Instrument timpani = new Instrument(timpaniPart, "Timpani",2,5,2);
        Instrument marimba = new Instrument(malletsPart, "Marimba",3,8,5);
        Instrument glockenspiel = new Instrument(malletsPart, "Glockenspiel", 4,6,7);

        // initialize people
        Person jack = new Person("Jack", 10, 10, 10);
        Person cooper = new Person("Cooper", 6, 8, 7);
        Person natalee = new Person("Natalee", 2, 2, 1);
        Person piper = new Person("Piper", 7, 7, 5);

        matrixPrint(vesuvius.fitMatrix(),vesuvius.getTotalPartsNames(),Person.getPeopleNames());
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