/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DayMenu {
    public List<Meal> mealsList = new ArrayList<>( 3 ); //0 is Breakfast ...
    public double cal;
    public DayMenu(List<Meal> meals, double cal) {
        this.mealsList = meals;
        this.cal = cal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        if (!super.equals(o)) return false;
        DayMenu dayMenu = (DayMenu) o;
        return Double.compare(dayMenu.cal, cal) == 0 &&
                Objects.equals(mealsList, dayMenu.mealsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealsList, cal);
    }

    public DayMenu(){

    }
    public void Display(){
        for (Meal meal : mealsList) {
            meal.Display( );
        }
        System.out.println( cal );
    }
}
