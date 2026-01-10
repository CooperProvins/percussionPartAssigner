import java.util.ArrayList;

public class Part {
    private int rhythm;
    private int technique;
    private int loudness;
    private int count;
    private ArrayList<Instrument> instruments = new ArrayList<>();

    public Part(Page page){
        rhythm = -1;
        technique = -1;
        loudness = -1;
        page.addPart(this);
        count = page.getParts().size();
    }

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

    public String getName(){
        return "Part " + count;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getTechnique() {
        return technique;
    }
    public int getLoudness() {
        return loudness;
    }
    public int getRhythm() {
        return rhythm;
    }
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }
    public void setTechnique(int technique) {
        this.technique = technique;
    }
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }
    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }
    public void addInstrument(Instrument instrument){
        this.instruments.add(instrument);
    }
}
