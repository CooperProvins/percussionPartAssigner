import java.util.ArrayList;

public class Part {
    private int rhythm;
    private int technique;
    private int loudness;
    private String name;
    private Page page;
    private ArrayList<Instrument> instruments = new ArrayList<>();

    // constructor
    
    /** 
     * constructor for Page class, takes in a song and a name, adds the page to the song's list of pages
     * @param page Song the page belongs to
     * @param name Name of the part (e.g. "High Mallets")
     */
    public Part(Page page, String name){
        rhythm = -1;
        technique = -1;
        loudness = -1;
        this.name = name;
        page.addPart(this);
        this.page = page;
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
    
    /** getter for technique field
     * @return int representation of technique (1-10)
     */
    public int getTechnique() {
        return technique;
    }

    /** getter for loudness field
     * @return int representation of loudness (1-10)
     */
    public int getLoudness() {
        return loudness;
    }

    /** getter for rhythm field
     * @return int representation of rhythm (1-10)
     */
    public int getRhythm() {
        return rhythm;
    }

    /** Getter for arrayList of instruments the part owns
     * @return ArrayList<Instrument> list of instruments the part owns
     */
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    /** setter for technique field
     * @param technique new int representation of technique (1-10)
     */
    public void setTechnique(int technique) {
        this.technique = technique;
    }

    /** setter for loudness field
     * @param loudness new int representation of loudness (1-10)
     */
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }

    /** setter for rhythm field
     * @param rhythm new int representation of rhythm (1-10)
     */
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }

    /** setter for arrayList of instruments the part owns
     * private because if used in main it will seriously mess up the inheritance hierarchy
     * @param instruments ArrayList<Instrument> list of instruments the part owns
     */
    private void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
        calculateStats();
    }
}