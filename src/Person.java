import java.util.ArrayList;

public class Person {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;

    // Options are "Easy", "Best", and "Mix"
    public static String EasyorBestorMix = "Easy"; 
    
    private static ArrayList<Person> People = new ArrayList<>();
    private static double sharpness = 1.5;

    // constructor

     /** 
     * constructor for Person class, takes in name, rhythm, technique, and loudness and adds the person to the list of people
     * @param name name of the person
     * @param rhythm ability to play complex rhythms (snare)
     * @param technique ability to play difficult instruments (mallets, timpani)
     * @param loudness ability and willingness to play exposed parts (piano solo)
     */
    public Person(String name, int rhythm, int technique, int loudness){
        this.name = name;
        this.rhythm = rhythm;
        this.technique = technique;
        this.loudness = loudness;
        People.add(this);
    }

    // special methods

    /** 
     * calculates the "fit" of part with a person based on the person's stats and the part's stats. 
     * fit method depends on instance variable EasyorBestorMix
     * Easy fit method calculates fit with an exponential penalty for being above the person's skill level, prioritizing ease of the part
     * Best fit method calculates fit with an exponential penalty for being above or below the person's skill level
     * @param part part to compare stats with
     * @return double represents the goodness of fit. Lower is better.
     */
    public double calculateFit(Part part){
        if (this.EasyorBestorMix.equals("Easy")){
            return Math.pow(sharpness, part.getRhythm()-rhythm)+Math.pow(sharpness, part.getTechnique()-technique)+Math.pow(sharpness, part.getLoudness()-loudness);
        }
        else if (this.EasyorBestorMix.equals("Best")){
            return Math.pow(sharpness, Math.abs(part.getRhythm()-rhythm))+Math.pow(sharpness, Math.abs(part.getTechnique()-technique))+Math.pow(sharpness, Math.abs(part.getLoudness()-loudness))-3;
        }
        else if (this.EasyorBestorMix.equals("Mix")){
            return (Math.pow(sharpness, part.getRhythm()-rhythm)+Math.pow(sharpness, part.getTechnique()-technique)+Math.pow(sharpness, part.getLoudness()-loudness) + Math.pow(sharpness, Math.abs(part.getRhythm()-rhythm))+Math.pow(sharpness, Math.abs(part.getTechnique()-technique))+Math.pow(sharpness, Math.abs(part.getLoudness()-loudness))-3)/2.0;
        }
        return -1;
    }
    
    /** 
     * calculates the "fit" of instrument with a person based on the person's stats and the instrument's stats
     * returns a double representing the fit, with lower numbers being better fits
     * @param instrument instrument to compare stats with
     * @return double
     */
    public double calculateFit(Instrument instrument){
        if (this.EasyorBestorMix.equals("Easy")){
            return Math.pow(sharpness, instrument.getRhythm()-rhythm)+Math.pow(sharpness, instrument.getTechnique()-technique)+Math.pow(sharpness, instrument.getLoudness()-loudness);
        }
        else if (this.EasyorBestorMix.equals("Best")){
            return Math.pow(sharpness, Math.abs(instrument.getRhythm()-rhythm))+Math.pow(sharpness, Math.abs(instrument.getTechnique()-technique))+Math.pow(sharpness, Math.abs(instrument.getLoudness()-loudness));
        }
        else if (this.EasyorBestorMix.equals("Mix")){
            return Math.pow(sharpness, instrument.getRhythm()-rhythm)+Math.pow(sharpness, instrument.getTechnique()-technique)+Math.pow(sharpness, instrument.getLoudness()-loudness) + Math.pow(sharpness, Math.abs(instrument.getRhythm()-rhythm))+Math.pow(sharpness, Math.abs(instrument.getTechnique()-technique))+Math.pow(sharpness, Math.abs(instrument.getLoudness()-loudness));
        }
        return -1;    
    }

    // utility methods

    /** 
      * returns a string representation of all the people in the list of people, with their stats and names
      * organized with indentation to show hierarchy
      * @return String representation of all the people in the list of people
     */
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

    /** 
     * Prints the part information given by allToString() to the console
     * Essentially a wrapper for allToString() that prints the string instead of returning it
     */
    public static void printAll(){ 
        System.out.println(allToString());
    }

     /** 
     * Overrides toString to print out the person in a readable format
     * Prints info with indentation to show hierarchy
     * @return String
     */
    @Override
    public String toString() {
        String returnString = "\n" + name + " (person) {";
        returnString += "\n\trhythm = " + rhythm;
        returnString += "\n\ttechnique = " + technique;
        returnString += "\n\tloudness = " + loudness;
        returnString += "\n}";
        return returnString;
    }

    /** 
     * Prints the part information given by toString() to the console
     * Essentially a wrapper for toString() that prints the string instead of returning it
     */
    public void print(){
        System.out.println(this.toString());
    }

    
    /** 
     * @return ArrayList<String>
     */
    public static ArrayList<String> getPeopleNames(){
        ArrayList<String> returnArray = new ArrayList<>();
        for (Person person : People){
            returnArray.add(person.getName());
        }
        return returnArray;
    }
    /** 
     * @return ArrayList<Person>
     */
    public static ArrayList<Person> getPeople() {
        return People;
    }
    /** 
     * @param people
     */
    public static void setPeople(ArrayList<Person> people) {
        People = people;
    }
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /** 
     * @return int
     */
    public int getLoudness() {
        return loudness;
    }
    /** 
     * @return int
     */
    public int getRhythm() {
        return rhythm;
    }
    /** 
     * @return int
     */
    public int getTechnique() {
        return technique;
    }
    /** 
     * @param loudness
     */
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }
    /** 
     * @param rhythm
     */
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }
    /** 
     * @param easyorBestorMix
     */
    public static void setFitMethod(String easyorBestorMix) {
        if (!easyorBestorMix.equals("Easy") && !easyorBestorMix.equals("Best") && !easyorBestorMix.equals("Mix")){
            throw new IllegalArgumentException("Fit method must be 'Easy', 'Best', or 'Mix'");
        }
        EasyorBestorMix = easyorBestorMix;
    }
    /** 
     * @param sharpness
     */
    public static void setSharpness(double sharpness) {
        Person.sharpness = sharpness;
    }
    /** 
     * @return double
     */
    public static double getSharpness() {
        return sharpness;
    }
    /** 
     * @return String
     */
    public static String getEasyorBestorMix() {
        return EasyorBestorMix;
    }
    /** 
     * @return String
     */
    public static String getFitMethod() {
        return EasyorBestorMix;
    }
    /** 
     * @param technique
     */
    public void setTechnique(int technique) {
        this.technique = technique;
    }
}
