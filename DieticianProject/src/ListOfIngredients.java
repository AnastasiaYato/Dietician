/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.*;
import java.util.*;

public class ListOfIngredients {
    List<Ingredient> ingredients;

    public ListOfIngredients(List<Ingredient> aI) {
        this.ingredients = aI;
    }

    public ListOfIngredients() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        ListOfIngredients that = (ListOfIngredients) o;
        return Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients);
    }

    public ListOfIngredients(String path, int id){
        this.ingredients=new ArrayList<>(  );
        File tmpFile = new File(path+"Export\\"+id+".txt");
        Scanner reading;
        try {
            reading = new Scanner(tmpFile);
            while (reading.hasNextLine( )) {
                String line = reading.nextLine( ); //splitting into rows by newline
                String[] values;
                values = line.trim().split(","); //splitting into columns by ","
                ingredients.add(new Ingredient(
                        new Product(
                                values[0],
                                Integer.parseInt(values[1]),
                                Double.parseDouble(values[2]),
                                values[3],
                                Double.parseDouble(values[4])
                        ),
                        Integer.parseInt(values[5])
                ));
            }
            reading.close( );
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        }
    }

    public void export(String path,int id) throws IOException {

            File tmpFile = new File(path+"Export\\"+id+".txt");
            FileWriter fw = new FileWriter(tmpFile);
        for (Ingredient ingredient : ingredients) {
            fw.write(
                    String.valueOf(ingredient.product.name)
                            + "," +
                            String.valueOf(ingredient.product.quantityInPack)
                            + "," +
                            String.valueOf(ingredient.product.cal)
                            + "," +
                            String.valueOf(ingredient.product.unit)
                            + "," +
                            String.valueOf(ingredient.product.price)
                            + "," +
                            String.valueOf(ingredient.quantity)
            );
            fw.write(System.lineSeparator( ));
        }
            fw.close();
        }
    public void import_(String path,boolean override,int id) {
        if(override){
            ingredients.clear();
        }
        else{
            this.ingredients=new ArrayList<>(  );
        }
        File tmpFile = new File(path+id+".txt");
        Scanner reading;
        try {
            reading = new Scanner(tmpFile);
            while (reading.hasNextLine( )) {
                String line = reading.nextLine( ); //splitting into rows by newline
                String[] values;
                values = line.trim().split(","); //splitting into columns by ","
                ingredients.add(new Ingredient(
                        new Product(
                                values[0],
                                Integer.parseInt(values[1]),
                                Double.parseDouble(values[2]),
                                values[3],
                                Double.parseDouble(values[4])
                        ),
                        Integer.parseInt(values[5])
                ));
            }
            reading.close( );
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        }
    }

    public void Display() {
        for (Ingredient ingredient : ingredients) {
            ingredient.Display( );
        }
    }
    public double CheckPrice(){
        double listPrice=0;
        for (Ingredient ingredient : ingredients) {
            listPrice += ingredient.CheckPrice( );
        }
        return listPrice;
    }
    public double getCalories() {
        double calories=0;
        for (Ingredient ingredient : ingredients) {
            calories += ingredient.getCalories( );
        }
        return calories;
    }
}

