/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.File;
import java.io.IOException;
import java.util.List;

/** Files generation
 * Heart and core of my app
 */

public class GenerateMainFiles { //to avoid code repeating
    public static void Go(String argm, String path) throws IOException {
        if (argm == null) { //if we want to create new files
            /** Generate files */
            GenerateFiles.Generate(path, "menu.txt", false); //name for output file
            GenerateFiles.Generate(path, "shoppinglist.csv", false);
        } else { /** override existing files */
            GenerateFiles.Generate(path, "menu.txt", true); //override for file overriding
            GenerateFiles.Generate(path, "shoppinglist.csv", true);
        }
        File tmpFile = new File(path+"Export");
        tmpFile.mkdir(); // for Exporting files
        System.out.println("Generation Successful!");

        /** I/O operations
         * Load data from files to lists of lists / 2d array
         */
        List<List<String>> products = ReadFiles.ReadFile(path, "products.csv"); //read file to list
        List<List<String>> recipes = ReadFiles.ReadFile(path, "recipes.txt");
        System.out.println("Loading files Successful!");

        /** Create arrays of objects from lists' data */
        List<Product> listOfProducts = ReadProducts.ConstructProductsList(products); //convert list to object list, Products only
        System.out.println("Created array array of Product objects.");

        /** Create list of lists of Ingredient objects */
        List<List<Ingredient>> listOfIngredients = ReadIngredients.ReadFromMeals(recipes, listOfProducts); // Ingredients only
        System.out.println("Created array list of Ingredient objects.");

        /** Create list of receipts */
        List<ListOfIngredients> listOfReceipts = ReceiptsList.Load(listOfIngredients); //lists of Ingredients are now rows in List of Ingredients as receipts
        System.out.println("Created List of Receipts.");

        /** Create list of meals */
        List<Meal> meals = MealList.CreateMealList(listOfReceipts);
        System.out.println("Created List of Meals.");

        /** Generate Week of DayMenu objects */
        WeekMenu week = new WeekMenu();
        for(int i=0;i<7;i++) {
            week.meals.add(GenerateMeals.Create(meals)); //Generating a 3 meals for each day
        }
        System.out.println("Generated week menu.");

        /** Write to files */
        System.out.println("Saving to files...");
        MenuGeneration.export(path,week);
        ShoppingList.export(path, week);
        System.out.println("Ready!");
    }
}
