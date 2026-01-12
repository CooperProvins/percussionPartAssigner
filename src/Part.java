import java.util.ArrayList;

public class Part {
    private int rhythm;
    private int technique;
    private int loudness;
    private int count;
    private String name;
    private ArrayList<Instrument> instruments = new ArrayList<>();

    public Part(Page page, String name){
        rhythm = -1;
        technique = -1;
        loudness = -1;
        this.name = name;
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

    public ArrayList<String> getPartNames(ArrayList<Part> parts){
        ArrayList<String> returnArray = new ArrayList<>();
        for (Part part : parts){
            returnArray.add(part.getName());
        }
        return returnArray;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        calculateStats();
    }
    private void calculateStats(){
        int rhythmMax = instruments.get(0).getRhythm();
        int techniqueMax = instruments.get(0).getTechnique();
        int loudnessMax = instruments.get(0).getLoudness();
        for (Instrument instrument : instruments){
            if (instrument.getRhythm()>rhythmMax){
                rhythmMax = instrument.getRhythm();
            }
            if (instrument.getTechnique()>techniqueMax){
                techniqueMax = instrument.getTechnique();
            }
            if (instrument.getLoudness()>loudnessMax){
                loudnessMax = instrument.getLoudness();
            }
        }
        this.rhythm = rhythmMax;
        this.technique = techniqueMax;
        this.loudness = loudnessMax;
    }
}
