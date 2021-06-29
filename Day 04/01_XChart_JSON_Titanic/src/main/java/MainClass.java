import java.io.IOException;
import java.util.List;

public class MainClass {
    public static void main(String[] args){
        List<Passenger> passengers = PassengersData.getPassengersList("src/main/resources/titanic_csv.json");
        GraphPassengersData.graphPassengerAges(passengers);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphPassengersData temp = new GraphPassengersData();
        temp.graphPassengerClasses(passengers);
    }
}
