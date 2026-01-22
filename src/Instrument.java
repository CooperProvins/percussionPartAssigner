public class Instrument {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;

    public Instrument(Part part, String name, int rhythm, int technique, int loudness){
        this.name = name;
        this.rhythm = rhythm;
        this.technique = technique;
        this.loudness = loudness;
        part.addInstrument(this);
    }

    @Override
    public String toString() {
        String returnString = name + " (instrument){";
        returnString += "\n\t rhythm = " + rhythm;
        returnString += "\n\t technique = " + technique;
        returnString += "\n\t loudness = " + loudness;
        returnString += "\n}";
        return returnString;
    }

    public String getName() {
        return name;
    }
    public int getTechnique() {
        return technique;
    }
    public int getRhythm() {
        return rhythm;
    }
    public int getLoudness() {
        return loudness;
    }
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }
    public void setTechnique(int technique) {
        this.technique = technique;
    }
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }
    public void setName(String name) {
        this.name = name;
    }
}