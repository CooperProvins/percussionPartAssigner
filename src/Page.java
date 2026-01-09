import java.util.ArrayList;

public class Page {
    private String name;
    private ArrayList<Instrument> instruments = new ArrayList<>();

    public Page(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        String returnString = "\n" + this.name + " (page)";
        for (Instrument instrument : this.instruments) {
            returnString += "\n\t" + instrument.getName() + " (instrument)";
            returnString += "\n\t\t rhythm = " + instrument.getRhythm();
            returnString += "\n\t\t technique = " + instrument.getTechnique();
            returnString += "\n\t\t loudness = " + instrument.getLoudness();
        }
        return returnString;
    }

    public Instrument findInstrument(String name){
        for (int i = 0; i < instruments.size(); i++){
            if (instruments.get(i).getName().equals(name)){
                return instruments.get(i);
            }
        }
        return null;
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }
    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}