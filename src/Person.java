public class Person {
    private String name;
    private int rhythm;
    private int technique;
    private int loudness;

    public Person(String name, int rhythm, int technique, int loudness){
        this.name = name;
        this.rhythm = rhythm;
        this.technique = technique;
        this.loudness = loudness;
    }

    @Override
    public String toString() {
        String returnString = "\n" + name + " (person)";
        returnString += "\n\trhythm = " + rhythm;
        returnString += "\n\ttechnique = " + technique;
        returnString += "\n\tloudness = " + loudness;
        return returnString;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLoudness() {
        return loudness;
    }
    public int getRhythm() {
        return rhythm;
    }
    public int getTechnique() {
        return technique;
    }
    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }
    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }
    public void setTechnique(int technique) {
        this.technique = technique;
    }
}
