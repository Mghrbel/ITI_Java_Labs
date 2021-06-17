package pyramids_median_quartile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class MedianCalculaion {
    public static Map<Double , List<Pyramid>> getMedian (List<Pyramid> myList){
        List<Pyramid> sortedList = myList.stream().sorted(Comparator.comparing(Pyramid::getHeight)).collect(toList());
        double medianHeight;
        List<Pyramid> medianPyramids = new ArrayList<>();
        Map<Double,List<Pyramid>> medianHeightPyramids = new HashMap<>();
        //In case of even sized list
        if (sortedList.size() %2 == 0){
            int medianIndex1 = myList.size()/2 ;
            int medianIndex2 = (myList.size()/2) -1 ;
            medianHeight = (sortedList.get(medianIndex1).getHeight() + sortedList.get(medianIndex2).getHeight()) /2;
            medianPyramids.add(sortedList.get(medianIndex1));
            medianPyramids.add(sortedList.get(medianIndex2));
        }
        //In case of odd sized list
        else{
            medianHeight = sortedList.get((sortedList.size()/2)-1/2).getHeight() ;
            medianPyramids.add(myList.get((sortedList.size()/2)-1/2));
        }
        medianHeightPyramids.put(medianHeight , medianPyramids);
        return medianHeightPyramids;
    }
}
