/**
 * @Author Anastazja Noemi Lisowska
 */

import java.io.IOException;
import java.io.File;

/**
 * Main class
 * handles commands
 */
public class Dietician {
    public static void main(String[] args) throws IOException {
        /** Creating and declaring directory for files */
        String path = ""; //by default it will generate a file in working directory
        boolean skip = false;//for skipping default file generation
        /** Arguments */
        if (args.length > 0) { //for multiple commands
            for (int i = 0; i < args.length; i++) {
                String pick = args[i]; //going through arguments
                if (pick.startsWith("-d") || pick.startsWith("--workdir")) { //for custom path argument
                    path = (pick.substring(pick.lastIndexOf("=") + 1)); //goes for the directory after =
                    File file = new File(path);
                    file.mkdir(); //creating a directory if it does not exists
                } else {
                    switch (pick) { //switch case for arguments
                        case "-o", "--override" -> {
                            System.out.println("Overriding files..."); //debug
                            GenerateMainFiles.Go(pick, path); //passing current argument to Generate function to override
                            skip = true; //skip default file generation
                        }
                        case "-a","--author" -> System.out.println("by Anastazja Noemi Lisowska");
                        case "-h","--help" -> System.out.println( "custom path end with \\"+"\n"+"Example: -d=C:\\Test\\" );
                        default -> System.out.println("Unknown command"); //debug
                    }
                }
            }
        }
        /** Generate files by default */
        if (!skip) {//by default launching app will generate a file after arguments unless file was set to be overridden

            System.out.println("Generating files..."); //debug
            GenerateMainFiles.Go(null, path); //nothing to pass
        }
        System.out.println("Operation finished"); //debug
    }

}

