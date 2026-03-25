import java.util.ArrayList;

public class Song {
    private String name;
    private ArrayList<Page> pages = new ArrayList<>();

    // constructor

     /** 
      * constructor for Song class, takes in a name
      * @param name Name of the song
      */
    public Song(String name){
        this.name = name;
    }

    // special methods
    /**
     * creates optimal assignment of parts to people based on the fit matrix and prints the assignment to the console
     */
    public void assignParts(){
        HungarianAlgorithm set = new HungarianAlgorithm(Main.doubleDoubleArrayListToArray(this.fitMatrix()));
        int[] assignment = set.execute();
        for (int i = 0; i < Person.getPeople().size(); i++){
            Person person = Person.getPeople().get(i);
            System.out.print(person.getName() + " <-- " + this.getTotalParts().get(assignment[i]).getPage().getName());
            System.out.print(this.getTotalParts().get(assignment[i]).getPage().getParts().size() != 1 ? " {split}" : "");
            System.out.print("\n\t");
            for (int j = 0; j < this.getTotalParts().get(assignment[i]).getInstruments().size(); j++){
                System.out.print(this.getTotalParts().get(assignment[i]).getInstruments().get(j).getName());
                System.out.print(j == this.getTotalParts().get(assignment[i]).getInstruments().size() - 1 ? "" : ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /** 
     * creates matrix that represents the fit value with values normalized for each player and part index
     * @return ArrayList<ArrayList<Double>>
     */
    public ArrayList<ArrayList<Double>> fitMatrix(){
        ArrayList<ArrayList<Double>> returnArray = new ArrayList<>();
        ArrayList<Person> people = Person.getPeople();
        for (int i = 0; i < people.size(); i++) {
            returnArray.add(new ArrayList<>());
            for (Part part : getTotalParts()) {
                returnArray.get(i).add(people.get(i).calculateFit(part));
            }
        }
        double max = Double.NEGATIVE_INFINITY;
        for (ArrayList<Double> row : returnArray){
            for (Double value : row){
                max = Math.max(max, value);
            }
        }
        for (int i = 0; i < returnArray.size(); i++){
            for (int j = 0; j < returnArray.get(i).size(); j++){
                returnArray.get(i).set(j, returnArray.get(i).get(j)/max*10.0);
            }
        }
        return returnArray;
    }

    public void printFitMatrix(){
        Main.matrixPrint(this.fitMatrix(),this.getTotalPartsNames(),Person.getPeopleNames());
        System.out.println();
    }
    

    // utility methods

    /** 
     * @return String
     */
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

    public void print(){
        System.out.println(this.toString());
    }
    
    /** 
     * @return ArrayList<Part>
     */
    public ArrayList<Part> getTotalParts(){
        ArrayList<Part> totalParts = new ArrayList<>();
        for (Page page : pages){
            for (Part part : page.getParts()){
                totalParts.add(part);
            }
        }
        return totalParts;
    }
    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getTotalPartsNames(){
        ArrayList<String> totalPartsNames = new ArrayList<>();
        for (Page page : pages){
            for (Part part : page.getParts()){
                totalPartsNames.add(part.getName());
            }
        }
        return totalPartsNames;
    }
    /** 
     * @param name
     * @return Page
     */
    public Page findPage(String name){
        for (int i = 0; i < pages.size(); i++){
            if (pages.get(i).getName().equals(name)){
                return pages.get(i);
            }
        }
        return null;
    }

    /** 
     * @return String
     */
    public String getName() {
        return name;
    }
    /** 
     * @return ArrayList<Page>
     */
    public ArrayList<Page> getPages() {
        return pages;
    }
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /** 
     * @param pages
     */
    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
    /** 
     * @param page
     */
    public void addPage(Page page){
        this.pages.add(page);
    }
}
