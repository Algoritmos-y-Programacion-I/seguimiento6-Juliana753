package model;

public class FloraSpecies extends Species {
    private EnumFlower hasFlowers;
    private EnumFruit hasFruits;
    private double maxHeight; //Atribution

    //Constructor
    public FloraSpecies(String name, String scientificName, EnumFlower hasFlowers, EnumFruit hasFruits, double maxHeight) {
        super(name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }
    public void setHasFlowers(EnumFlower hasFlowers) {
        this.hasFlowers = hasFlowers;
    }
    
    public void setHasFruits(EnumFruit hasFruits) {
        this.hasFruits = hasFruits;
    }
    
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }
    
    @Override
    public String toString() {
        return "FloraSpecies{" +
               "name='" + name + '\'' +
               ", scientificName='" + scientificName + '\'' +
               ", hasFlowers=" + hasFlowers +
               ", hasFruits=" + hasFruits +
               ", maxHeight=" + maxHeight +
               '}';
    }
    @Override
    public String getDetails() {
        return "Flora Details: Flowers - " + this.hasFlowers + ", Fruits - " + this.hasFruits + ", Max Height - " + this.maxHeight;
    }
}