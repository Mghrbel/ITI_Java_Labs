package pyramids_median_quartile;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class Pyramids_median_quartile {

    public static void main(String[] args) {
        PyramidCSVDAO py = new PyramidCSVDAO("F:\\AI\\06- Java development\\pyramids.csv");
        List<Pyramid> pyramids = py.readPyramidFromCSV();
      
        
        //median calculation
        Map<Double,List<Pyramid>> myMedianPyramids = MedianCalculaion.getMedian(pyramids);
        System.out.println("Median height = " + myMedianPyramids.keySet() + " || median pyramids : " + myMedianPyramids.values());        
        
        
        List<Pyramid> sortedList = pyramids.stream().sorted(Comparator.comparing(Pyramid::getHeight)).collect(toList());
        //Lower quartile calculations
        Map<Double,List<Pyramid>> myLowerQuartilePyramids;
        List<Pyramid> lowerQuartileList;
        if (sortedList.size() %2 == 0){
            lowerQuartileList = sortedList.subList(0, (sortedList.size()/2)-1);
            myLowerQuartilePyramids = MedianCalculaion.getMedian(lowerQuartileList);
        }else{
            lowerQuartileList = sortedList.subList(0, (sortedList.size()/2)-1/2);
            myLowerQuartilePyramids = MedianCalculaion.getMedian(lowerQuartileList);
        }
        System.out.println("Lower Quartile height = " + myLowerQuartilePyramids.keySet() + " || Lower Quartile pyramids : " + myLowerQuartilePyramids.values());  
       
        
         //Highrt quartile calculations
        Map<Double,List<Pyramid>> myHigherQuartilePyramids;
        List<Pyramid> HigherQuartileList;
        if (sortedList.size() %2 == 0){
            HigherQuartileList = sortedList.subList((sortedList.size()/2)+1 , sortedList.size());
            myHigherQuartilePyramids = MedianCalculaion.getMedian(HigherQuartileList);
        }else{
            HigherQuartileList = sortedList.subList((sortedList.size()/2)+1/2 , sortedList.size());
            myHigherQuartilePyramids = MedianCalculaion.getMedian(HigherQuartileList);
        }
        System.out.println("Higher Quartile height = " + myHigherQuartilePyramids.keySet() + " || Higher Quartile pyramids : " + myHigherQuartilePyramids.values());       
     }    
}
