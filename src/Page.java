import java.util.ArrayList;

public class Page {
    private String name;
    private ArrayList<Part> parts = new ArrayList<>();

    public Page(Song song, String name){
        this.name = name;
        song.addPage(this);
    }

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
    public ArrayList<Part> getParts() {
        return parts;
    }
    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
    public void addPart(Part part){
        this.parts.add(part);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}