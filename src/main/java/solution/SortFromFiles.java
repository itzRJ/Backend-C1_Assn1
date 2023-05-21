package solution;

import fileHandler.FileHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFromFiles {
    public static void sort() throws IOException
    {
        String inputPath1 = "src/main/resources/inputFiles/inputF1";
        String inputPath2 = "src/main/resources/inputFiles/inputF2";
        List<Integer> list1 = FileHandler.readFile(inputPath1);
        List<Integer> list2 = FileHandler.readFile(inputPath2);

        List<Integer> outputList = new ArrayList<>(list1);
        outputList.addAll(list2);
        Collections.sort(outputList);

        String outputPath = "src/main/resources/outputFiles/Output.txt";
        FileHandler.createOutputFile(outputPath);
        BufferedWriter lFW = new BufferedWriter(new FileWriter(outputPath));
        try {
            for (Integer number : outputList)
            {
                lFW.write(number.toString());
                lFW.newLine();
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception in writing file: " + e);
        }
        lFW.close();
    }
}
