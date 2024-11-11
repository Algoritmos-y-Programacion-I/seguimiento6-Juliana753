package ui;

import model.SpeciesController;
import model.SpeciesType;
import model.EnumFlower;
import model.EnumFruit;
import model.EnumMigratory;
import java.util.Scanner;

public class SpeciesExecutable {
    private Scanner reader;
    private SpeciesController speciesController;

    public static void main(String[] args) {
        SpeciesExecutable executable = new SpeciesExecutable();
        executable.run();
    }

    public SpeciesExecutable() {
        this.reader = new Scanner(System.in);
        this.speciesController = new SpeciesController();
    }

    private void run() {
        System.out.println("Welcome to the Icesi Species Management System");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Register a Species");
            System.out.println("2. Edit a Species");
            System.out.println("3. Delete a Species");
            System.out.println("4. List all Species");
            System.out.println("0. Exit");

            int choice = reader.nextInt();
            reader.nextLine();  

            switch (choice) {
                case 1:
                    registerSpecies();
                    break;
                case 2:
                    editSpecies();
                    break;
                case 3:
                    deleteSpecies();
                    break;
                case 4:
                    listSpecies();
                    break;
                case 0:
                    exit = true;
                    System.out.println("thanks for using the system :)");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }

    private void registerSpecies() {
        System.out.println("Enter species name:");
        String name = reader.nextLine();
        System.out.println("Enter scientific name:");
        String scientificName = reader.nextLine();
        System.out.println("Enter type (1 for Flora, 2 for Fauna):");
        int typeInput = reader.nextInt();
        SpeciesType type;
    
        if (typeInput == 1) {
            type = SpeciesType.LAND_FLORA;
        } else {
            type = SpeciesType.BIRD;
        }
    
        if (typeInput == 1) { 
            System.out.println("Does it have flowers? (1 for yes, 0 for no)");
            int flowerInput = reader.nextInt();
            EnumFlower flower;
            if (flowerInput == 1) {
                flower = EnumFlower.IT_HAS_FLOWERS;
            } else {
                flower = EnumFlower.IT_DOESNT_HAVE_FLOWERS;
            }
    
            System.out.println("Does it have fruits? (1 for yes, 0 for no)");
            int fruitInput = reader.nextInt();
            EnumFruit fruit;
            if (fruitInput == 1) {
                fruit = EnumFruit.IT_HAS_FRUITS;
            } else {
                fruit = EnumFruit.IT_DOESNT_HAVE_FRUITS;
            }
    
            System.out.println("Enter maximum height:");
            double maxHeight = reader.nextDouble();
            speciesController.registerSpecies(name, scientificName, type, flower, fruit, maxHeight, null, 0);
        } else { 
            System.out.println("Is it migratory? (1 for yes, 0 for no)");
            int migratoryInput = reader.nextInt();
            reader.nextLine();
            EnumMigratory migratory;
            if (migratoryInput == 1) {
                migratory = EnumMigratory.IT_IS_MIGRATORY;
            } else {
                migratory = EnumMigratory.IT_IS_NOT_MIGRATORY;
            }
    
            System.out.println("Enter maximum weight:");
            double maxWeight = reader.nextDouble();
            reader.nextLine(); 
            speciesController.registerSpecies(name, scientificName, type, null, null, 0, migratory, maxWeight);
        }
        System.out.println("Species registered successfully.");
    }
    

    private void editSpecies() {
        System.out.println("Enter the index of the species to edit:");
        int index = reader.nextInt() - 1;
        reader.nextLine();  
    
        System.out.println("Is it Flora (1) or Fauna (2)?");
        int type = reader.nextInt();
        reader.nextLine();  
    
        if (type == 1) { 
            System.out.println("Has Flowers (1 for yes, 0 for no):");
            int flowerInput = reader.nextInt();
            reader.nextLine();  
            EnumFlower flower;
            if (flowerInput == 1) {//It's Flower
                flower = EnumFlower.IT_HAS_FLOWERS;
            } else {
                flower = EnumFlower.IT_DOESNT_HAVE_FLOWERS;
            }
    
            System.out.println("Has Fruits (1 for yes, 0 for no):");
            int fruitInput = reader.nextInt();
            reader.nextLine();  
            EnumFruit fruit;
            if (fruitInput == 1) {
                fruit = EnumFruit.IT_HAS_FRUITS;
            } else {
                fruit = EnumFruit.IT_DOESNT_HAVE_FRUITS;
            }
    
            System.out.println("Max Height:");
            double maxHeight = reader.nextDouble();
            reader.nextLine();  
    
            speciesController.editSpecies(index, SpeciesType.LAND_FLORA, flower, fruit, maxHeight, null, 0);
        } else {//It's Fauna
            System.out.println("Is Migratory (1 for yes, 0 for no):");
            int migratoryInput = reader.nextInt();
            reader.nextLine(); 
            EnumMigratory migratory;
            if (migratoryInput == 1) {
                migratory = EnumMigratory.IT_IS_MIGRATORY;
            } else {
                migratory = EnumMigratory.IT_IS_NOT_MIGRATORY;
            }
    
            System.out.println("Max Weight:");
            double maxWeight = reader.nextDouble();
            reader.nextLine();  
    
            speciesController.editSpecies(index, SpeciesType.BIRD, null, null, 0, migratory, maxWeight);
        }
    
        System.out.println("Species updated successfully.");
    }
    

    private void deleteSpecies() {
        System.out.println("Enter the index of the species to delete:");
        int index = reader.nextInt() - 1;//adjust the index to the array
        if (speciesController.deleteSpecies(index)) {
            System.out.println("Species deleted successfully.");
        } else {
            System.out.println("Failed to delete species.");
        }
    }

    private void listSpecies() {
        System.out.println("Registered Species:");
        System.out.println(speciesController.showSpeciesList());
    }
}
