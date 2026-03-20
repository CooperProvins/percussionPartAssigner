import java.util.ArrayList;

public class Part {
    private int rhythm;
    private int technique;
    private int loudness;
    private int count;
    private String name;
    private Page page;
    private ArrayList<Instrument> instruments = new ArrayList<>();

    // constructor
    public Part(Page page, String name){
        rhythm = -1;
        technique = -1;
        loudness = -1;
        this.name = name;
        page.addPart(this);
        this.page = page;
        count = page.getParts().size();
    }

    // special methods
    /** 
     * Adds an instrument to the part and updates the part's stats based on the stats of the instrument it owns
     * @param instrument instrument to be added
     */
    public void addInstrument(Instrument instrument){
        this.instruments.add(instrument);
        calculateStats();
    }
    /** 
     * Calculates the stats of the part based on the stats of the instruments it owns
     * Sets the part's rhythm, technique, and loudness to be the maximum of the respective stats of the instruments it owns
     */
    private void calculateStats(){
        int rhythmMax = instruments.get(0).getRhythm();
        int techniqueMax = instruments.get(0).getTechnique();
        int loudnessMax = instruments.get(0).getLoudness();
        for (Instrument instrument : instruments){
            rhythmMax = Math.max(instrument.getRhythm(),rhythmMax);
            techniqueMax = Math.max(instrument.getTechnique(),techniqueMax);
            loudnessMax = Math.max(instrument.getLoudness(),loudnessMax);
        }
        this.rhythm = rhythmMax;
        this.technique = techniqueMax;
        this.loudness = loudnessMax;
    }

    // utility methods
    /** 
     * Overrides toString to print out the part in a readable format
     * Prints info with indentation to show hierarchy
     * @return String
     */
    @Override
    public String toString() {
        String returnString = this.getName() + " (part){";
        returnString += "\n\trhythm = " + rhythm;
        returnString += "\n\ttechnique = " + technique;
        returnString += "\n\tloudness = " + loudness;
        returnString += "\n\tinstruments = {";
        for (Instrument instrument : instruments){
            returnString += "\n\t\t" + instrument.getName() + " (instrument) = {";
            returnString += "\n\t\t\t rhythm = " + instrument.getRhythm();
            returnString += "\n\t\t\t technique = " + instrument.getTechnique();
            returnString += "\n\t\t\t loudness = " + instrument.getLoudness();
            returnString += "\n\t\t}";
        }
        returnString += "\n\t}";
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
     * gets name of part
     * @return String current name of the part
     */
    public String getName(){
        return name;
    }

    /** 
     * sets name of part
      * @param name new name of the part
      */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * gets the page the part belongs to
     * @return Page the page the part currently belongs to
     */
    public Page getPage() {
        return page;
    }
    
    /** 
     * sets the page the part belongs to
     * removes the part from the old page's list of parts and adds it to the new page's list of parts
     * @param page new page the part belongs to
     */
    public void setPage(Page myPage) {
        this.page.getParts().remove(this);
        myPage.addPart(this);
        this.page = myPage;
    }
    
    /** 
     * @return int
     */
    public int getCount() {
        return count;
    }
    /** 
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }
    /** 
     * @return int
     */
    public int getTechnique() {
        return technique;
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
     * @return ArrayList<Instrument>
     */
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }
    /** 
     * @param technique
     */
    public void setTechnique(int technique) {
        this.technique = technique;
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
     * @param instruments
     */
    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }
}