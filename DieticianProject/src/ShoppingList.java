/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ShoppingList {
    static double estimatedValue;
    public static void export(String path, WeekMenu week) throws IOException {
        estimatedValue= Math.round(week.GetWorth());
        File tmpFile = new File(path+"shoppinglist.csv");
        FileWriter fw = new FileWriter(tmpFile);
        fw.write( "Estimated total value = "+estimatedValue);
        fw.write(System.lineSeparator());
        for(int i=0;i<7;i++){ //for each day
            for(int j=0;j<3;j++) //for each meal
            {
                    for (int y=0; y<week.meals.get(i).mealsList.get(j).listOfIngredients.ingredients.size();y++){ //for each ingredient in list
                        fw.write(System.lineSeparator());
                        fw.write( "Product name " +week.meals.get(i).mealsList.get(j).listOfIngredients.ingredients.get(y).product.getName() ); //print product name
                        fw.write(System.lineSeparator());
                        fw.write( "Quantity "+week.meals.get(i).mealsList.get(j).listOfIngredients.ingredients.get(y).getQuantity()); //get number of product's units needed
                        fw.write(System.lineSeparator());
                        DecimalFormat priceFormat = new DecimalFormat( "#.##" );
                        priceFormat.setRoundingMode(RoundingMode.UP);
                        double price=(week.meals.get(i).mealsList.get(j).listOfIngredients.ingredients.get(y).CheckPrice());//print price
                        fw.write( "Price "+priceFormat.format(price) );
                        fw.write(System.lineSeparator());
                    }
                fw.write("_________________");
            }
            fw.write(System.lineSeparator());
            fw.write("...................");
        }
        fw.close();

    }
}
