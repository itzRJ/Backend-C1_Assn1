package fileHandler;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler
{
    /**
     * Reads the list of numbers from file name provided with path
     * @param aInFilePath File name with path
     * @return List of numbers(int)
     */
    public static List<Integer> readFile(String aInFilePath) {
        try
        {
            FileReader lFR = new FileReader(aInFilePath);
            BufferedReader lBr = new BufferedReader(lFR);
            return lBr.lines().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }
        catch (FileNotFoundException aInE)
        {
            throw new RuntimeException("Invalid path or file name" + aInE);
        }
    }

    /**
     * Creates a new file for output
     * @param aInFilePath Path and name for output file
     */
    public static void createOutputFile(String aInFilePath)
    {
        File lOutFile = new File(aInFilePath);
        try
        {
            if(lOutFile.createNewFile())
            {
                System.out.println("File created: " + lOutFile.getName());
            }
            else
            {
                System.out.println("File already exists. Deleting and creating again.");
                lOutFile.delete();
                createOutputFile(aInFilePath);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
