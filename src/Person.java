import java.util.ArrayList;

public class Person {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;
    public static String EasyorBestorMix = "Easy"; 
    //Options are "Easy", "Best", and "Mix"
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
        String returnString = "\n" + name + " (person) {";
        returnString += "\n\trhythm = " + rhythm;
        returnString += "\n\ttechnique = " + technique;
        returnString += "\n\tloudness = " + loudness;
        returnString += "\n}";
        return returnString;
    }
    public static String allToString() {
        String returnString = "People {";
        for (Person person : Person.People){
            returnString += "\n\t" + person.name + " (person) {";
            returnString += "\n\t\trhythm = " + person.rhythm;
            returnString += "\n\t\ttechnique = " + person.technique;
            returnString += "\n\t\tloudness = " + person.loudness;
            returnString += "\n\t}";
        }
        
        return returnString;
    }
    public double calculateFit(Part part){
        if (this.EasyorBestorMix.equals("Easy")){
            return Math.pow(1.5, part.getRhythm()-rhythm)+Math.pow(1.5, part.getTechnique()-technique)+Math.pow(1.5, part.getLoudness()-loudness);
        }
        else if (this.EasyorBestorMix.equals("Best")){
            return Math.pow(1.5, Math.abs(part.getRhythm()-rhythm))+Math.pow(1.5, Math.abs(part.getTechnique()-technique))+Math.pow(1.5, Math.abs(part.getLoudness()-loudness));
        }
        else if (this.EasyorBestorMix.equals("Mix")){
            return Math.pow(1.5, part.getRhythm()-rhythm)+Math.pow(1.5, part.getTechnique()-technique)+Math.pow(1.5, part.getLoudness()-loudness) + Math.pow(1.5, Math.abs(part.getRhythm()-rhythm))+Math.pow(1.5, Math.abs(part.getTechnique()-technique))+Math.pow(1.5, Math.abs(part.getLoudness()-loudness));
        }
        return -1;
    }
    public double calculateFit(Instrument instrument){
        if (this.EasyorBestorMix.equals("Easy")){
            return Math.pow(1.5, instrument.getRhythm()-rhythm)+Math.pow(1.5, instrument.getTechnique()-technique)+Math.pow(1.5, instrument.getLoudness()-loudness);
        }
        else if (this.EasyorBestorMix.equals("Best")){
            return Math.pow(1.5, Math.abs(instrument.getRhythm()-rhythm))+Math.pow(1.5, Math.abs(instrument.getTechnique()-technique))+Math.pow(1.5, Math.abs(instrument.getLoudness()-loudness));
        }
        else if (this.EasyorBestorMix.equals("Mix")){
            return Math.pow(1.5, instrument.getRhythm()-rhythm)+Math.pow(1.5, instrument.getTechnique()-technique)+Math.pow(1.5, instrument.getLoudness()-loudness) + Math.pow(1.5, Math.abs(instrument.getRhythm()-rhythm))+Math.pow(1.5, Math.abs(instrument.getTechnique()-technique))+Math.pow(1.5, Math.abs(instrument.getLoudness()-loudness));
        }
        return -1;    }

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
    public static void setFitMethod(String easyorBestorMix) {
        if (!easyorBestorMix.equals("Easy") && !easyorBestorMix.equals("Best") && !easyorBestorMix.equals("Mix")){
            throw new IllegalArgumentException("Fit method must be 'Easy', 'Best', or 'Mix'");
        }
        EasyorBestorMix = easyorBestorMix;
    }
    public static String getFitMethod() {
        return EasyorBestorMix;
    }
    public void setTechnique(int technique) {
        this.technique = technique;
    }
}
