public class Instrument {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;

    // constructor
    public Instrument(Part part, String name, int rhythm, int technique, int loudness){
        this.name = name;
        this.rhythm = rhythm;
        this.technique = technique;
        this.loudness = loudness;
        part.addInstrument(this);
    }

    // special methods

    // utility methods

    /** 
     * @return String
     */
    @Override
    public String toString() {
        String returnString = name + " (instrument){";
        returnString += "\n\t rhythm = " + rhythm;
        returnString += "\n\t technique = " + technique;
        returnString += "\n\t loudness = " + loudness;
        returnString += "\n}";
        return returnString;
    }

    /** 
     * @return String
     */
    public String getName() {
        return name;
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
    public int getRhythm() {
        return rhythm;
    }
    /** 
     * @return int
     */
    public int getLoudness() {
        return loudness;
    }
    /** 
     * @param loudness
     */
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }
    /** 
     * @param technique
     */
    public void setTechnique(int technique) {
        this.technique = technique;
    }
    /** 
     * @param rhythm
     */
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}