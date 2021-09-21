/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WeekMenu {
    List<DayMenu> meals = new ArrayList<>(7); //List for week, 0-Monday .. 6-sunday

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        if (!super.equals(o)) return false;
        WeekMenu weekMenu = (WeekMenu) o;
        return Objects.equals(meals, weekMenu.meals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meals);
    }

    public void export(String path) throws IOException {
        File tmpFile = new File(path+"Export\\"+"WeekMenu.txt");
        FileWriter fw = new FileWriter(tmpFile);
        for (int i = 0; i < 7; i++) { //for every day of week
            File file = new File(path+"Export\\"+i);
            file.mkdir(); // for Exporting files
            fw.write(String.valueOf(meals.get(i).cal) + ",");
            for (int j = 0; j < 3; j++) { //for every meal
                fw.write(meals.get(i).mealsList.get(j).name + ",");
                fw.write(String.valueOf(meals.get(i).mealsList.get(j).cal) + ",");
                meals.get(i).mealsList.get(j).listOfIngredients.export(path+"Export\\"+i+"\\",j);
            }
            fw.write("\r\n");
        }
        fw.close( );
    }

    public void import_(String path) {
        meals.clear();
        File tmpFile = new File(path+"Export\\"+"WeekMenu.txt");
        Scanner reading;
        try {
            reading = new Scanner(tmpFile);
            int i=0;
            while (reading.hasNext( )) {
                String line = reading.nextLine( );
                String[] values;
                values = line.split(",");
                meals.add(new DayMenu(  ));
                meals.get(i).cal= Double.parseDouble(values[0]);
                int x=1; //start from column no 1
                for(int j=0;j<3;j++){
                    ListOfIngredients tmpList = new ListOfIngredients("Export\\"+i+"\\",j);
                    meals.get(i).mealsList.add(new Meal(values[x],Double.parseDouble(values[x+1]),tmpList));
                    x+=2;
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        }

    }
    public double GetWorth(){
        double worth=0;
        for(int i =0;i<7;i++){
            for(int j=0;j<3;j++){
                worth+= meals.get(i).mealsList.get(j).CheckPrice();
            }
        }
        return worth;
    }
    public void Display(){
        for (DayMenu meal : meals) {
            meal.Display( );
        }
    }
}



