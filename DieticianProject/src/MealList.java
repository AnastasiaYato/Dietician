/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.ArrayList;
import java.util.List;

public class MealList {
    public static ArrayList<Meal>  CreateMealList(List<ListOfIngredients> listOfMeals){
        ArrayList<Meal> meals = new ArrayList<Meal>(  );
        for(int i=0; i<listOfMeals.size();i++){
            meals.add(new Meal("Meal"+i,listOfMeals.get(i).getCalories(),listOfMeals.get(i)));
        }
        return meals;
    }
}
