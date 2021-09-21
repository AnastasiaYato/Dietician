/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.ArrayList;
import java.util.List;

/** Creating a list of objects with constructors */

public class ReadProducts {
    public static List<Product> ConstructProductsList(List<List<String>> file){
        List<Product> products =new ArrayList<Product>(8781); //I initialized size to speed up the program for larger amounts of lines
        for(List<String> row: file) {//for each row
            products.add(new Product( //using lists of strings - I'm splitting and parsing data
                    row.get(0),//get first list column of current row that contains name
                    Integer.parseInt(row.get(1)), //class is designed like in pdf file listed, that's why in csv file...
                    Double.parseDouble(row.get(3)), //...first goes unit and then calories
                    row.get(2),
                    Double.parseDouble(row.get(4)))
            );
        }
        return products;
    }
}
/*
        //to load array and test it, debugging etc.
        products.forEach((temp)->{
            temp.Display();
        });
 */