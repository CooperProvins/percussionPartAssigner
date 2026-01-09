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
            returnString += "\n\t\trhythm = " + instrument.getRhythm();
            returnString += "\n\t\ttechnique = " + instrument.getTechnique();
            returnString += "\n\t\tloudness = " + instrument.getLoudness();
            if (instrument.getTouching().size()>0){
                returnString += "\n\t\ttouching (instruments) = {";
                for (int i = 0; i < instrument.getTouching().size(); i++){
                    returnString += "\n\t\t\t" + instrument.getTouching().get(i).getName() +((i==instrument.getTouching().size()-1) ? "" : ",");
                }
                returnString += "\n\t\t}";
            }
            else{
                returnString += "\n\t\ttouching (instruments) = {}";
            }
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