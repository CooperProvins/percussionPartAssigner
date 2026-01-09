import java.util.ArrayList;

public class Instrument {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;
    private ArrayList<Instrument> touching = new ArrayList<>();

    public Instrument(String name, int rhythm, int technique, int loudness){
        this.name = name;
        this.rhythm = rhythm;
        this.technique = technique;
        this.loudness = loudness;
    }

    @Override
    public String toString() {
        String returnString = "\n" + name + " (instrument)";
        returnString += "\n\t rhythm = " + rhythm;
        returnString += "\n\t technique = " + technique;
        returnString += "\n\t loudness = " + loudness;
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
    public ArrayList<Instrument> getTouching() {
        return touching;
    }
    public void setTouching(ArrayList<Instrument> touching) {
        this.touching = touching;
    }
    public void addTouching(Instrument touched) {
        this.touching.add(touched);
    }
    private void gettingTouched(Instrument toucher){
        this.touching.add(toucher);
    }
    public void setName(String name) {
        this.name = name;
    }
}