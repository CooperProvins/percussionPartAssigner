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
        Part part1 = new Part(percussion1);
        Part part2 = new Part(percussion1);
        Part part3 = new Part(percussion2);
        Part timpaniPart = new Part(timpaniPage);
        Part marimbaPart = new Part(mallets);

        // initialize instruments
        Instrument windChimes1 = new Instrument(part1,"Wind Chimes 1",1,1,2);
        Instrument windChimes2 = new Instrument(part2, "Wind Chimes 2",4,3,4);
        Instrument windChimes3 = new Instrument(part3, "Wind Chimes 3",5,5,1);
        Instrument triangle = new Instrument(part3, "Triangle",1,1,3);
        Instrument timpani = new Instrument(timpaniPart, "Timpani",2,5,2);
        Instrument marimba = new Instrument(marimbaPart, "Marimba",3,4,1);

        System.out.println(vesuvius);
    }
}