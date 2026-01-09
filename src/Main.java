import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Instrument windChimes1 = new Instrument("Wind Chimes 1",1,3,7);
        Instrument windChimes2 = new Instrument("Wind Chimes 2",4,6,9);
        Instrument windChimes3 = new Instrument("Wind Chimes 3",9,10,3);
        Instrument triangle = new Instrument("Triangle",2,2,3);
        Instrument timpani = new Instrument("Timpani",6,5,2);
        Instrument marimba = new Instrument("Marimba",9,6,2);

        windChimes1.addTouching(triangle);

        Page percussion1 = new Page("Percussion 1");
        Page percussion2 = new Page("Percussion 2");
        Page timpaniPage = new Page("Timpani");
        Page mallets = new Page("Mallets");

        Song vesuvius = new Song("Vesuvius");

        Person Cooper = new Person("Cooper",7,9,6);

        percussion1.addInstrument(windChimes1);
        percussion1.addInstrument(windChimes2);

        percussion2.addInstrument(windChimes3);
        percussion2.addInstrument(triangle);

        timpaniPage.addInstrument(timpani);

        mallets.addInstrument(marimba);

        vesuvius.addPage(percussion1);
        vesuvius.addPage(percussion2);
        vesuvius.addPage(timpaniPage);
        vesuvius.addPage(mallets);

        //System.out.println(vesuvius);
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>(List.of(
            new ArrayList<>(List.of(1.5, 2.5)),         // Row 0
            new ArrayList<>(List.of(10.0)),             // Row 1 (Jagged)
            new ArrayList<>(List.of(5.75, 8.25, 12.0))  // Row 2
        ));
        System.out.println(Song.matrixToString(matrix));
    }
}