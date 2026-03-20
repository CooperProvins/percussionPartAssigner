import java.util.ArrayList;

public class Page {
    private String name;
    private ArrayList<Part> parts = new ArrayList<>();

    // constructor
    /** 
     * constructor for Page class, takes in a song and a name, adds the page to the song's list of pages
     * @param song Song the page belongs to
     * @param name Name of the page (e.g. "Percussion 1")
     */
    public Page(Song song, String name){
        this.name = name;
        song.addPage(this);
    }

    // special methods
    /** 
     * Adds a part to the page
     * @param part part to be added
     */
    public void addPart(Part part){
        this.parts.add(part);
    }

    // utility methods
    /** 
     * Overrides toString to print out the page in a readable format
     * Prints info with indentation to show hierarchy
     * @return String
     */
    @Override
    public String toString() {
        String returnString = this.name + " (page){";
        returnString += "\n\tParts = {";
        for (Part part : this.parts) {
            returnString += "\n\t\t" + part.getName() + " (part) = {";
            returnString += "\n\t\t\trhythm = " + part.getRhythm();
            returnString += "\n\t\t\ttechnique = " + part.getTechnique();
            returnString += "\n\t\t\tloudness = " + part.getLoudness();
            returnString += "\n\t\t\tinstruments = {";
            for (Instrument instrument : part.getInstruments()){
                returnString += "\n\t\t\t" + instrument.getName() + " (instrument) = {";
                returnString += "\n\t\t\t\t rhythm = " + instrument.getRhythm();
                returnString += "\n\t\t\t\t technique = " + instrument.getTechnique();
                returnString += "\n\t\t\t\t loudness = " + instrument.getLoudness();
                returnString += "\n\t\t\t}";
            }
            returnString += "\n\t\t}";
        }
        returnString += "\n\t}";
        return returnString;
    }

    /** 
     * Prints the page information given by toString() to the console
     * Essentially a wrapper for toString() that prints the string instead of returning it
     */
    public void print(){
        System.out.println(this.toString());
    }

    /** 
     * returns the parts owned by the page
     * @return ArrayList<Part> parts owned by the page
     */
    public ArrayList<Part> getParts() {
        return parts;
    }

    /** 
     * sets the parts owned by the page
     * @param parts parts now set to be owned by the page
     */
    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    /** 
     * sets the name of the page
     * @param name new name of the page
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * gets the name of the page
     * @return String current name of the page
     */
    public String getName() {
        return name;
    }
}