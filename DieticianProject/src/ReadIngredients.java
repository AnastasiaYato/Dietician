/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.*;

/** Creating a list of ingredients */

public class ReadIngredients {
    public static List<List<Ingredient>> ReadFromMeals(List<List<String>> file, List<Product> products) {
        List<List<Ingredient>> ingredients = new ArrayList<>(15810); //I initialized size to speed up the program for larger amounts of lines

        for (List<String> row : file) {
            List<Ingredient> values=new ArrayList<>(  );
            int columnNo = 0;
            for (String column : row) {
                String name = row.get(columnNo).trim( );
                if (name.contains("s")) {
                    name = name.replace("s", "");
                }
                if (!name.contains("meal")) {
                    String[] parts = name.split(" ", 2);
                    String number = parts[0];
                    String finalName = parts[1];
                    String[] partsOfFinalName = finalName.split("t",2); //because ingredients are listed from 0 to ... we can easily and fast access certain with index
                    String id = partsOfFinalName[1];
                    values.add(new Ingredient(
                                    products.get(Integer.parseInt(id)), //find matching object from product objects array
                                    Integer.parseInt(number)
                            )
                    );
                }
                columnNo++;
            }
            ingredients.add(values);
        }
        return ingredients;
    }
}