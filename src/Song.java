import java.util.ArrayList;

public class Song {
    private String name;
    private ArrayList<Page> pages = new ArrayList<>();

    public Song(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        String returnString = name + " (Song)";
        for (Page page : pages){
            returnString += "\n\t" + page.getName() + " (page)";
            for (Instrument instrument : page.getInstruments()){
                returnString += "\n\t\t" + instrument.getName() + " (instrument)";
                returnString += "\n\t\t\t rhythm = " + instrument.getRhythm();
                returnString += "\n\t\t\t technique = " + instrument.getTechnique();
                returnString += "\n\t\t\t loudness = " + instrument.getLoudness();
            }
        }
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
