import joinery.DataFrame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        try {
            DataFrame<Object> passengers_Informations = DataFrame.readCsv("src/main/resources/passengers_Informations.csv");
            DataFrame<Object> passengers_servived     = DataFrame.readCsv("src/main/resources/passengers_servived.csv");

            //Showing the dataFrames
            System.out.println("passengers information dataframe :\n" + passengers_Informations);
            System.out.println("Servived passengers dataframe :\n" + passengers_servived);


            //Joining two dataFrames
            System.out.println("To join the two data frames press Enter");
            System.in.read();
            System.out.println(passengers_Informations.join(passengers_servived));

            //Merging two dataFrames
            System.out.println("To merge the two data frames press Enter");
            System.in.read();
            System.out.println(passengers_Informations.merge(passengers_servived));

            //Add new column to a dataFrame
            System.out.println("To add new column to a dataFrame press Enter");
            System.in.read();
            List<Object> numbers = new ArrayList<>();
            int i = 1;
            for(Object z : passengers_Informations){
                numbers.add(i);
                i++;
            }
            System.out.println(passengers_Informations.add("new Column",numbers));

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
