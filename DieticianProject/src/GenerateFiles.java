/**
 * @Author Anastazja Noemi Lisowska
 */
import java.io.File;
import java.io.IOException;

/** Generating files in directory */

public class GenerateFiles { //without this class I would end up with code repetition, overall I try to avoid as much code repetition as I can
    public static void Generate(String path,String name,boolean override) throws IOException{ //path and name allows us to create/load specific file at specific(custom) path boolean needed for first if
        File tmpFile = new File(path+name); //declaring and adding path for file creation
        if(override){
            tmpFile.createNewFile( );
            System.out.println("File overridden successfully in directory "  + tmpFile.getPath( ));
        }
        else { //else default file creation with try catch
            try {
                if (tmpFile.createNewFile( )) { //createNewFiles returns bool value, true v. for successful file creation and false v. if file exists
                    System.out.println("File created successfully in directory "  + tmpFile.getPath( ));
                } else {
                    System.out.println("File " + tmpFile.getPath( )+" already exists.");
                    System.out.println("Stopping the program...");
                    System.exit(0);
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace( ); //error msg
            }
        }
    }
}
