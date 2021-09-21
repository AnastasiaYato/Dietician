/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.List;
import java.util.Random;

/** Generate DayMenu object with random meals */

public class GenerateMeals {
    public static DayMenu Create(List<Meal> meals){
        DayMenu finalDayMenu= new DayMenu(); //final DayMenu object
        Random rand = new Random();
        while(true){
            DayMenu tmpDayMenu= new DayMenu(); //Tmp DayMenu object to work on
            for(int i=0;i<3;i++){ //get 3 random meals and create DayMenu out of them
                int randIndex = rand.nextInt(meals.size());
                Meal genMeal = meals.get(randIndex);
                tmpDayMenu.cal+=genMeal.cal;
                tmpDayMenu.mealsList.add(genMeal);
                meals.remove(randIndex); //we have so many meals so let's not pick one we already have again in the same day
            }
            if(tmpDayMenu.cal<2200&&tmpDayMenu.cal>1800){ //2000 +/- 10%
                finalDayMenu=tmpDayMenu;
                break; //exit loop if we found 3 good meals
            }
        }
        return finalDayMenu;
    }
}
