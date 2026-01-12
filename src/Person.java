import java.util.ArrayList;

public class Person {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;
    private static ArrayList<Person> People = new ArrayList<>();

    public Person(String name, int rhythm, int technique, int loudness){
        this.name = name;
        this.rhythm = rhythm;
        this.technique = technique;
        this.loudness = loudness;
        People.add(this);
    }

    @Override
    public String toString() {
        String returnString = "\n" + name + " (person)";
        returnString += "\n\trhythm = " + rhythm;
        returnString += "\n\ttechnique = " + technique;
        returnString += "\n\tloudness = " + loudness;
        return returnString;
    }

    public double calculateFit(Part part){
        return Math.pow(1.5, part.getRhythm()-rhythm)+Math.pow(1.5, part.getTechnique()-technique)+Math.pow(1.5, part.getLoudness()-loudness);
    }
    public double calculateFit(Instrument instrument){
        return Math.pow(1.5, instrument.getRhythm()-rhythm)+Math.pow(1.5, instrument.getTechnique()-technique)+Math.pow(1.5, instrument.getLoudness()-loudness);
    }

    public static ArrayList<String> getPeopleNames(){
        ArrayList<String> returnArray = new ArrayList<>();
        for (Person person : People){
            returnArray.add(person.getName());
        }
        return returnArray;
    }
    public static ArrayList<Person> getPeople() {
        return People;
    }
    public static void setPeople(ArrayList<Person> people) {
        People = people;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLoudness() {
        return loudness;
    }
    public int getRhythm() {
        return rhythm;
    }
    public int getTechnique() {
        return technique;
    }
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }
    public void setTechnique(int technique) {
        this.technique = technique;
    }
}
