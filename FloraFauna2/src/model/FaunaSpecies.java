package model;

public class FaunaSpecies extends Species {
    private EnumMigratory isMigratory;
    private double maxWeight;

    public FaunaSpecies(String name, String scientificName, EnumMigratory isMigratory, double maxWeight) {
        super(name, scientificName);
        this.isMigratory = isMigratory;
        this.maxWeight = maxWeight;
    }

    public void setIsMigratory(EnumMigratory isMigratory) {
        this.isMigratory = isMigratory;
    }
    
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    @Override
    public String toString() {
        return "FaunaSpecies{" +
               "name='" + name + '\'' +
               ", scientificName='" + scientificName + '\'' +
               ", isMigratory=" + isMigratory +
               ", maxWeight=" + maxWeight +".";
    }

    @Override
    public String getDetails() {
        return "Fauna Details: Migratory - " + this.isMigratory + ", Max Weight - " + this.maxWeight;
    }
}
