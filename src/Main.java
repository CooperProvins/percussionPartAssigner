import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Instrument windChimes1 = new Instrument("Wind Chimes 1",1,1,2);
        Instrument windChimes2 = new Instrument("Wind Chimes 2",4,3,4);
        Instrument windChimes3 = new Instrument("Wind Chimes 3",5,5,1);
        Instrument triangle = new Instrument("Triangle",1,1,3);
        Instrument timpani = new Instrument("Timpani",2,5,2);
        Instrument marimba = new Instrument("Marimba",3,4,1);

        Page percussion1 = new Page("Percussion 1");
        Page percussion2 = new Page("Percussion 2");
        Page timpaniPage = new Page("Timpani");
        Page mallets = new Page("Mallets");

        Song vesuvius = new Song("Vesuvius");

        Person Cooper = new Person("Cooper",4,4,4);

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

        System.out.println(Cooper);
    }
}