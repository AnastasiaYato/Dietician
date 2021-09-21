/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MenuGeneration {
    public static void export(String path, WeekMenu week) throws IOException {
        File tmpFile = new File(path + "menu.txt");
        FileWriter fw = new FileWriter(tmpFile);
        fw.write("Menu");
        fw.write(System.lineSeparator( ));
        for (int i = 0; i < 7; i++) { //for each day
            String day = switch (i) {
                case 0 -> "Monday";
                case 1 -> "Tuesday";
                case 2 -> "Wednesday";
                case 3 -> "Thursday";
                case 4 -> "Friday";
                case 5 -> "Saturday ";
                case 6 -> "Sunday ";
                default -> "";
            };
            fw.write("Day of Week: " + day);
            fw.write(System.lineSeparator( ));
            for (int j = 0; j < 3; j++) //for each meal
            {
                String mealName = switch (j) {
                    case 0 -> "BreakFast";
                    case 1 -> "Lunch";
                    case 2 -> "Dinner";
                    default -> "";
                };
                DecimalFormat calFormat = new DecimalFormat( "#.##" );
                calFormat.setRoundingMode(RoundingMode.UP);
                double rounderCalories = (week.meals.get(i).mealsList.get(j).cal);
                fw.write("" + mealName + " calories = " + calFormat.format(rounderCalories));
                fw.write(" selected meal is " + week.meals.get(i).mealsList.get(j).name);
                fw.write(System.lineSeparator( ));
            }
        }
        fw.close( );
    }
}
