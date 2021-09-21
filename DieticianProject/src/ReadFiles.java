/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/** Reading files */

public class ReadFiles {
    /** Loading file's data */
    public static List<List<String>> ReadFile(String path, String name)  {
        File tmpFile = new File(path+name);
        List<List<String>> data = new ArrayList<>(); //creating a 2d array. It's just a List containing a lists of strings, it makes my life easier later with objects creation thanks to splitting
        Scanner reading; //bufferedreader would be better I think
        try{
            reading = new Scanner(tmpFile);
            if(name.equals("products.csv")){
                reading.nextLine(); //skip first line of csv file
            }
            while(reading.hasNext()){
                String line= reading.nextLine(); //splitting into rows by newline
                String[] values;
                /** Splitting */
                if (name.equals("recipes.txt")){
                    values = line.trim().split("(:)|(,)"); //splitting into columns by "," and : in case of txt file
                }
                else{
                    values = line.trim().split(", "); //splitting into columns by "," in case of csv file
                }
                data.add(Arrays.asList(values)); //loading into 2d array our line
            }
            /** How it works:
             * now for each row I have a list of products and their quantity, it will be easier for me to split each String column into parts
             * that I can use as arguments in constructors while creating object...
             * each row contains a list of Strings, each String consists of quantity and product
             */
            reading.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace( );
        }
        return (data);
    }

}