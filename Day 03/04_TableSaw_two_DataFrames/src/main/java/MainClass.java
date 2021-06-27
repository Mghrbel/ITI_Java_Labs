import tech.tablesaw.api.Table;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        try {
            Table passengersInformation = Table.read().csv("src/main/resources/passengers_Information.csv");
            Table survivedPassengers = Table.read().csv("src/main/resources/passengers_survived.csv");

            //Showing the two tables
            System.out.println("Passengers information table :\n" + passengersInformation);
            System.out.println("Survived passengers table :\n" + survivedPassengers);

            //Joining two tables
            System.out.println("To join the two tables press Enter");
            System.in.read();
            System.out.println(passengersInformation.joinOn("name").fullOuter(survivedPassengers));

            //Concatenating two tables
            System.out.println("To concatenate the two tables press Enter");
            System.in.read();
            System.out.println(passengersInformation.concat(survivedPassengers.retainColumns("ticket", "survived")));

        }catch(IOException x){
            System.out.println("File not found");
        }
    }
}
