import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphPassengersData {

    //Graphing passengers ages method
    public static void graphPassengerAges(List<Passenger> listOfPassengers){
        List<Float>  Ages  = listOfPassengers.stream().map(Passenger::getAge) .limit(10).collect(Collectors.toList());
        List<String> names = listOfPassengers.stream().map(Passenger::getName).limit(10).collect(Collectors.toList());

        //Create the chart
        CategoryChart chart = new CategoryChartBuilder()
                .width(1024).height(768)
                .title("Ages")
                .xAxisTitle("Names").yAxisTitle("Age")
                .build();

        //Customize the chart
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);

        chart.addSeries ("Passenger's Ages", names, Ages);
        new SwingWrapper (chart).displayChart ();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Graphing passengers ages method
    public void graphPassengerClasses(List<Passenger> listOfPassengers){
        Map<String,Long> classes = listOfPassengers.stream().collect(Collectors.groupingBy(Passenger::getPclass,Collectors.counting()));

        //Create the chart
        PieChart chart = new PieChartBuilder()
                .width(1024).height(768)
                .title(getClass().getSimpleName ())
                .build();

        //Customize the chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);

        chart.addSeries ("First Class", classes.get ("1"));
        chart.addSeries ("Second Class", classes.get ("2"));
        chart.addSeries ("Third Class", classes.get ("3"));
        new SwingWrapper (chart).displayChart ();
    }
}
