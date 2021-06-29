import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PassengersData {
    public static List<Passenger> getPassengersList (String path){
        List<Passenger> passengersList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try( InputStream inputFile = new FileInputStream(path)){

            passengersList = mapper.readValue(inputFile , new TypeReference<List<Passenger>>(){});
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch(IOException ee){
            System.out.println("File not found 1");
        }
        return passengersList;
    }
}
