package model;

public class SpeciesController {
    private Species[] species = new Species[80];

    public SpeciesController() {
    }

    public boolean registerSpecies(String name, String scientificName, SpeciesType type, EnumFlower flower, EnumFruit fruit, double maxHeight, EnumMigratory migratory, double maxWeight) {
        Species newSpecies = createSpecies(name, scientificName, type, flower, fruit, maxHeight, migratory, maxWeight);
        if (newSpecies == null) {
            return false;  // Indicate error creating new species
        }

        for (int i = 0; i < this.species.length; ++i) {
            if (this.species[i] == null) {
                this.species[i] = newSpecies;
                return true;
            }
        }
        return false;//will be false if the array is full 
    }

    private Species createSpecies(String name, String scientificName, SpeciesType type, EnumFlower flower, EnumFruit fruit, double maxHeight, EnumMigratory migratory, double maxWeight) {
        switch (type) {
            case LAND_FLORA:
            case AQUATIC_FLORA:
                return new FloraSpecies(name, scientificName, flower, fruit, maxHeight);
            case BIRD:
            case MAMMAL:
            case AQUATIC_FAUNA:
                return new FaunaSpecies(name, scientificName, migratory, maxWeight);
            default:
                return null;
        }
    }

    public boolean editSpecies(int index, SpeciesType type, EnumFlower flower, EnumFruit fruit, double maxHeight, EnumMigratory migratory, double maxWeight) {
        if (index >= 0 && index < species.length && species[index] != null) {
            Species sp = species[index];

            if (sp instanceof FloraSpecies) {
                FloraSpecies flora = (FloraSpecies) sp;
                flora.setHasFlowers(flower);
                flora.setHasFruits(fruit);
                flora.setMaxHeight(maxHeight);
            } else if (sp instanceof FaunaSpecies) {
                FaunaSpecies fauna = (FaunaSpecies) sp;
                fauna.setIsMigratory(migratory);
                fauna.setMaxWeight(maxWeight);
            }
            return true;
        }
        return false;
    } 

    public boolean deleteSpecies(int index) {
        if (index >= 0 && index < this.species.length && this.species[index] != null) {
            this.species[index] = null;
            return true;
        }
        return false;
    }

    public String showSpeciesList() {
        String msg = "";
        for (int i = 0; i < this.species.length; ++i) {
            if (this.species[i] != null) {
                msg += "\n" + (i + 1) + ". " + this.species[i].toString();
            }
        }
        return msg;
    }
    
}
