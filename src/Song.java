import java.util.ArrayList;

public class Song {
    private String name;
    private ArrayList<Page> pages = new ArrayList<>();

    public Song(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        String returnString = name + " (Song){";
        returnString += "\n\tPages = {";
        for (Page page : pages){
            returnString += "\n\t\t" + page.getName() + " (page) = {";
            returnString += "\n\t\t\tParts = {";
            for (Part part : page.getParts()) {
                returnString += "\n\t\t\t\t" + part.getName() + " (part) = {";
                returnString += "\n\t\t\t\t\trhythm = " + part.getRhythm();
                returnString += "\n\t\t\t\t\ttechnique = " + part.getTechnique();
                returnString += "\n\t\t\t\t\tloudness = " + part.getLoudness();
                returnString += "\n\t\t\t\t\tinstruments = {";
                for (Instrument instrument : part.getInstruments()){
                    returnString += "\n\t\t\t\t\t" + instrument.getName() + " (instrument) = {";
                    returnString += "\n\t\t\t\t\t\t rhythm = " + instrument.getRhythm();
                    returnString += "\n\t\t\t\t\t\t technique = " + instrument.getTechnique();
                    returnString += "\n\t\t\t\t\t\t loudness = " + instrument.getLoudness();
                    returnString += "\n\t\t\t\t\t}";
                }
                returnString += "\n\t\t\t\t}";
            }
            returnString += "\n\t\t\t}";
            returnString += "\n\t\t}";
        }
        returnString += "\n\t}";
        return returnString;
    }

    public Page findPage(String name){
        for (int i = 0; i < pages.size(); i++){
            if (pages.get(i).getName().equals(name)){
                return pages.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Page> getPages() {
        return pages;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
    public void addPage(Page page){
        this.pages.add(page);
    }
}
