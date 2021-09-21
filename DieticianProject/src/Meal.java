/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.Objects;

public class Meal {
    String name;
    double cal;
    ListOfIngredients listOfIngredients;

    public Meal(String name, double cal, ListOfIngredients listOfIngredients) {
        this.name = name;
        this.cal = cal;
        this.listOfIngredients = listOfIngredients;
    }

    public Meal() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Meal meal = (Meal) o;
        return Double.compare(meal.cal, cal) == 0 &&
                Objects.equals(name, meal.name) &&
                Objects.equals(listOfIngredients, meal.listOfIngredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cal, listOfIngredients);
    }

    public double CheckPrice(){
        return listOfIngredients.CheckPrice();
    }
    public void Display(){
        System.out.println( name+" "+cal );
        listOfIngredients.Display();
    }
}
