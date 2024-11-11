package model;

public abstract class Species {
    protected String name;
    protected String scientificName;

    //Constructor
    public Species(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    //Method abstract
    public abstract String getDetails();
}
