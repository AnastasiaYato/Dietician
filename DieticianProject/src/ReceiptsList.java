/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.ArrayList;
import java.util.List;

public class ReceiptsList {
        public static List<ListOfIngredients> Load(List<List<Ingredient>> ingredients) { //create List of lists of ingredients
                List<ListOfIngredients> listOfIngredients = new ArrayList<>(  );
                for (List<Ingredient> ingredient : ingredients) {
                        listOfIngredients.add(new ListOfIngredients(ingredient));
                }
                return listOfIngredients;
        }
}
